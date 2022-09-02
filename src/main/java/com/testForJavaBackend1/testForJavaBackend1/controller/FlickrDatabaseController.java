package com.testForJavaBackend1.testForJavaBackend1.controller;

import com.testForJavaBackend1.testForJavaBackend1.dto.FlickrDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.ResponseDto;
import com.testForJavaBackend1.testForJavaBackend1.service.FlickrService;
import com.testForJavaBackend1.testForJavaBackend1.util.DtoUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Flickr Database")
@RestController
@RequestMapping("/api/v1/photos/database")
public class FlickrDatabaseController {

    @Autowired
    private FlickrService flickrService;

    @PostMapping
    public ResponseEntity<ResponseDto<Boolean>> createDataFromFlickr(Boolean status){
        try {
            ResponseDto<Boolean> response =
                    DtoUtil.responseDtoSuccess(flickrService.createDataFromFlickr(status));
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDto<Boolean> response =
                    DtoUtil.responseDtoFailed(null, e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
