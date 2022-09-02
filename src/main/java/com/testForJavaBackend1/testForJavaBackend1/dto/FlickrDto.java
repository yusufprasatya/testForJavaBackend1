package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FlickrDto {
    private String title;
    private String link;
    private List<String> media;
    private String dateTaken;
    private String description;
    private String published;
    private String author;
    private String authorId;
    private String tags;
}
