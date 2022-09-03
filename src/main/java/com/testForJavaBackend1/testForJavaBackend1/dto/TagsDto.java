package com.testForJavaBackend1.testForJavaBackend1.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
public class TagsDto {
    private List<String> tags;
}
