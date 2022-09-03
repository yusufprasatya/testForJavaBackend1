package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Data
@NoArgsConstructor
public class FlickrResponseDto {
    private UUID id;
    private String title;
    private String link;
    private String[] media;
    private String date_taken;
    private String description;
    private String published;
    private String author;
    private String author_id;
    private String tags;
}