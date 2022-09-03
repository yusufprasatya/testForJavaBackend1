package com.testForJavaBackend1.testForJavaBackend1.controller;

import com.testForJavaBackend1.testForJavaBackend1.dto.PaginatedGaleriesResponse;
import com.testForJavaBackend1.testForJavaBackend1.dto.ResponseDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.TagsDto;
import com.testForJavaBackend1.testForJavaBackend1.service.FlickrService;
import com.testForJavaBackend1.testForJavaBackend1.util.DtoUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(tags = "Flickr Database")
@RestController
@RequestMapping("/api/v1/photos/database")
public class FlickrDatabaseController {

    @Autowired
    private FlickrService flickrService;

    @PostMapping
    public ResponseEntity<ResponseDto<Boolean>> createDataFromFlickr(Boolean save, TagsDto tags){
        try {
            ResponseDto<Boolean> response =
                    DtoUtil.responseDtoSuccess(flickrService.createDataFromFlickr(save, tags));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDto<Boolean> response =
                    DtoUtil.responseDtoFailed(null, e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDto<PaginatedGaleriesResponse>> findAllFlickrFromDatabase(@PageableDefault(size = 10) @RequestParam Integer page, @RequestParam Integer size){
        try {
            ResponseDto<PaginatedGaleriesResponse> response =
                    DtoUtil.responseDtoSuccess(flickrService.findAllGaleries(page, size));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDto<PaginatedGaleriesResponse> response =
                    DtoUtil.responseDtoFailed(null, e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
