package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class PaginatedGaleriesResponse {
    private Long numberOfItems;
    private int numberOfPages;
    private List<FlickrResponseDto> flickrItems;

}
