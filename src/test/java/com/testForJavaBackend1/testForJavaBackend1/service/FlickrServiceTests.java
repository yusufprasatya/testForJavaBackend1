package com.testForJavaBackend1.testForJavaBackend1.service;

import com.testForJavaBackend1.testForJavaBackend1.dto.FlickrDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.TagsDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class FlickrServiceTests {

    @Autowired
    private FlickrService flickrService;

    @Test
    @DisplayName("Photos should not be empty")
    void findAllPhotos(){
        List<FlickrDto> allPhotos = flickrService.findAllPhotos();
        Assertions.assertNotNull(allPhotos);
    }

    @Test
    @DisplayName("Galeries should not be empty")
    void findAllPhotosByTags(){
        TagsDto tagsDto = new TagsDto();
        tagsDto.setTags(List.of("car","animal","fruit"));
        List<FlickrDto> allPhotos = flickrService.findAllPhotosByTags(tagsDto);
        Assertions.assertNotNull(allPhotos);
    }
}
