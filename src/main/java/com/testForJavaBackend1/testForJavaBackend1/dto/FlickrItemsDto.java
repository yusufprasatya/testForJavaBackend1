package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
public class FlickrItemsDto {
    private UUID id;
    private String title;
    private String link;
    private Map<String, Object> media;
    private String date_taken;
    private String description;
    private String published;
    private String author;
    private String author_id;
    private String tags;
}
