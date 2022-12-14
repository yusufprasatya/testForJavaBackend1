package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class FlickrDto {
    private String title;
    private String link;
    private String description;
    private String modified;
    private String generator;
    private List<FlickrItemsDto> items;
}
