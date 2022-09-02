package com.testForJavaBackend1.testForJavaBackend1.controller;

import com.testForJavaBackend1.testForJavaBackend1.dto.FlickrDto;
import com.testForJavaBackend1.testForJavaBackend1.dto.ResponseDto;
import com.testForJavaBackend1.testForJavaBackend1.util.DtoUtil;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "Flickr")
@RestController
@RequestMapping("/api/v1/photos")
public class FlickrController {

    @GetMapping
    public ResponseEntity<ResponseDto<List<FlickrDto>>> findAllPhotos(){
        try {
            ResponseDto<List<FlickrDto>> response =
                    DtoUtil.responseDtoSuccess(flickrService.findAll());
            return new ResponseEntity<>(response, HttpStatus.OK);
        }catch (Exception e){
            ResponseDto<List<FlickrDto>> response =
                    DtoUtil.responseDtoFailed(null, e.getMessage(), HttpStatus.BAD_REQUEST);
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }
}
