package com.testForJavaBackend1.testForJavaBackend1.service;

import com.testForJavaBackend1.testForJavaBackend1.dto.FlickrDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.FlickrItemsDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.PaginatedGaleriesResponse;
import com.testForJavaBackend1.testForJavaBackend1.dto.TagsDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FlickrService {
     List<FlickrDto> findAllPhotos();
     List<FlickrDto> findAllPhotosByTags(TagsDto tags);
     Boolean createDataFromFlickr(Boolean status, TagsDto tags);
     PaginatedGaleriesResponse findAllGaleries(Integer page, Integer size);
}
