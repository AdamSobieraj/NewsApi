package com.example.newsfinder.integration;

import com.example.newsfinder.service.NewsApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
@RequestMapping("/v1/newsFinder")
@RequiredArgsConstructor
public class NewsFinderController {

    private final NewsApiService newsApiService;

    @ApiOperation(value = "Collect data")
    @GetMapping("/news/{country}/{category}")
    public ResponseEntity<?> findNews (
            @ApiParam(required = true, name = "country", example = "pl") @PathVariable(value = "country" ) String country,
            @ApiParam(required = true, name = "category", example = "business") @PathVariable(value = "category" )String category
    ) {
        newsApiService.sendRequestForData(category, country);
        return ResponseEntity.accepted().build();
    }

}
