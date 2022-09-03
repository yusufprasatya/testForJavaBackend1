package com.testForJavaBackend1.testForJavaBackend1.service.impl;

import com.testForJavaBackend1.testForJavaBackend1.dto.*;
import com.testForJavaBackend1.testForJavaBackend1.entity.Galery;
import com.testForJavaBackend1.testForJavaBackend1.repository.FlickrRepository;
import com.testForJavaBackend1.testForJavaBackend1.service.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlickrServiceImpl implements FlickrService {

    private static final int DEFAULT_TIMEOUT = 30000;

    @Autowired
    private WebClient webClient;

    @Autowired
    private FlickrRepository flickrRepository;

    @Override
    public List<FlickrDto> findAllPhotos() {
        return webClient.get().uri("")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(FlickrDto.class)
                .collectList()
                .block();
    }

    @Override
    public List<FlickrDto> findAllPhotosByTags(TagsDto tags) {

        // Convert list tags to comma separated string.
        String tagsSeparatedByComma = String.join(",", tags.getTags());

        return webClient.get().uri("?tags="+tagsSeparatedByComma)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(FlickrDto.class)
                .collectList()
                .block();
    }

    @Override
    public Boolean createDataFromFlickr(Boolean status, TagsDto tags) {
        if (!status && tags.getTags().isEmpty()){
            return false;
        }

        List<FlickrItemsDto> items = findAllPhotosByTags(tags).get(0).getItems();
        List<Galery> galeries = new ArrayList<>();
        int i = 0;

        for (FlickrItemsDto detailphotos: items) {
            Galery galery = new Galery();
            galery.setAuthor(detailphotos.getAuthor());
            galery.setAuthor_id(detailphotos.getAuthor_id());
            galery.setDate_taken(detailphotos.getDate_taken());
            galery.setDescription(detailphotos.getDescription());
            galery.setLink(detailphotos.getLink());
            galery.setMedia(detailphotos.getMedia().values().toArray(String[]::new));
            galery.setPublished(detailphotos.getPublished());
            galery.setTags(detailphotos.getTags().split(","));
            galery.setTitle(detailphotos.getTitle());
            galeries.add(galery);
        }

        List<Galery> saveGaleries = this.flickrRepository.saveAll(galeries);
        if (saveGaleries.isEmpty()) return false;
        return true;
    }

    @Override
    public PaginatedGaleriesResponse findAllGaleries(Integer page, Integer size) {
        Pageable paging = PageRequest.of(page, size);
        Page<Galery> galeriesPaging = this.flickrRepository.findAll(paging);
        List<FlickrResponseDto> flickrResponseDtos = new ArrayList<>();

        for (Galery detailPhoto: galeriesPaging) {
            FlickrResponseDto flickrResponseDto = new FlickrResponseDto();
            flickrResponseDto.setId(detailPhoto.getId());
            flickrResponseDto.setTitle(detailPhoto.getTitle());
            flickrResponseDto.setPublished(detailPhoto.getPublished());
            flickrResponseDto.setTags(Arrays.stream(detailPhoto.getTags()).sequential().collect(Collectors.joining()));
            flickrResponseDto.setLink(detailPhoto.getLink());
            flickrResponseDto.setDescription(detailPhoto.getDescription());
            flickrResponseDto.setAuthor(detailPhoto.getAuthor());
            flickrResponseDto.setAuthor_id(detailPhoto.getAuthor_id());
            flickrResponseDto.setDate_taken(detailPhoto.getDate_taken());
            flickrResponseDto.setMedia(detailPhoto.getMedia());
            flickrResponseDtos.add(flickrResponseDto);
        }

        return PaginatedGaleriesResponse.builder()
                .numberOfItems(galeriesPaging.getTotalElements())
                .numberOfPages(galeriesPaging.getTotalPages())
                .flickrItems(flickrResponseDtos)
                .build();
    }
}
