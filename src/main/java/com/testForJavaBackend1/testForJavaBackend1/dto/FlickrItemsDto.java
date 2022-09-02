package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class FlickrItemsDto {
    private String title;
    private String link;
    private Map<String, String> media;
    private String dateTaken;
    private String description;
    private String published;
    private String author;
    private String authorId;
    private String tags;
}
