package com.testForJavaBackend1.testForJavaBackend1.service.impl;

import com.testForJavaBackend1.testForJavaBackend1.dto.FlickrDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.TagsDto;
import com.testForJavaBackend1.testForJavaBackend1.service.FlickrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class FlickrServiceImpl implements FlickrService {

    private static final int DEFAULT_TIMEOUT = 30000;

    @Autowired
    private WebClient webClient;

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

        System.err.println(tagsSeparatedByComma);
        return webClient.get().uri("?tags="+tagsSeparatedByComma)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(FlickrDto.class)
                .collectList()
                .block();
    }

    @Override
    public Boolean createDataFromFlickr(Boolean status) {
        if (!status){
            return false;
        }

        List<FlickrDto> allPhotos = findAllPhotos();
        for (FlickrDto detailphotos: allPhotos) {
            detailphotos.getItems().get(0).getAuthor();
            detailphotos.getItems().get(0).getAuthorId();
            detailphotos.getItems().get(0).getDateTaken();
            detailphotos.getItems().get(0).getDescription();
            detailphotos.getItems().get(0).getLink();
            detailphotos.getItems().get(0).getMedia();
            detailphotos.getItems().get(0).getPublished();
            detailphotos.getItems().get(0).getTags();
            detailphotos.getItems().get(0).getTitle();
        }
        return null;
    }
}
