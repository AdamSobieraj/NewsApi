package com.example.newsfinder.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.example.newsfinder.readWriteCSV.OpenCSVWrite.wtriteWithOpenCSV;

@Slf4j
@Component
@RequiredArgsConstructor
public class NewsApiService {

    NewsApiClient newsApiClient = new NewsApiClient("0d55e5edf40e468d8bb5cffdb8836415");

    public void sendRequestForData(String category, String country) {

        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .country(country)
                        .category(category)
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        try {
                            wtriteWithOpenCSV(response.getArticles());
                        } catch (IOException e) {
                            log.error(e.getMessage());
                        }
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        log.error(throwable.getMessage());
                    }
                }
        );

    }

}
