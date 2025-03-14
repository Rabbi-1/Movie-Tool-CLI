package com.example.movietool.service;

import com.example.movietool.models.RequestAPIModel;
import com.example.movietool.models.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class getTitleService {
    public RestTemplate restTemplate = new RestTemplate();
    @Value("${spring.TMDB.apiKey}")
    private String apiKey;


     private final String baseUrl = "https://api.themoviedb.org/3/";
    private ResponseEntity<RequestAPIModel> apiResponse(String requestUrl) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + apiKey);
        headers.set("accept", "application/json");
        HttpEntity<String> headerEntity = new HttpEntity<>(headers);
        String url = baseUrl + requestUrl + "?api_key=" + apiKey;
        return restTemplate.exchange(url, HttpMethod.GET, headerEntity, RequestAPIModel.class);
    }
    public void printApiResponse(ResponseEntity<RequestAPIModel> responseEntityFromApi) {
        if(responseEntityFromApi.getBody() != null && responseEntityFromApi.getBody().getAllResults() != null) {
            if (responseEntityFromApi.getBody().getAllResults() != null && !responseEntityFromApi.getBody().getAllResults().isEmpty()) {
                for (Result result : responseEntityFromApi.getBody().getAllResults()) {
                    System.out.println(result.getMovietitle());
                }
            } else {
                System.out.println("Server did not respond 401");
            }
        } else {
            System.out.println("Response body is empty");
        }
    }

    public List<String> setDataTime(int plusDays, int minusDays) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dayBefore = now.minusDays(minusDays);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String nowFormatted = now.format(formatter);
        String dayBeforeFormatted = dayBefore.format(formatter);
        return new ArrayList<>(Arrays.asList(dayBeforeFormatted, dayBeforeFormatted, nowFormatted));
    }

    public void getPopularTitle() {
        String url = "movie/popular?api_key=" + apiKey + "&language=en-US&page=1";

        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        printApiResponse(responseEntity);
    }

    public void getNowPlayingTitle() {
        String maxDate = setDataTime(0, 0).get(2);  // Get today's date
        String minDate = setDataTime(0, 10).get(1); // Get date 10 days ago

        String url = "discover/movie?api_key=" + apiKey +
                "&include_adult=false&include_video=false&language=en-US&page=1" +
                "&sort_by=popularity.desc&with_release_type=2|3" +
                "&release_date.gte=" + minDate + "&release_date.lte=" + maxDate;

        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        printApiResponse(responseEntity);
    }



    public void getTopRatedTitle() {

        String url = "movie/top_rated?api_key=" + apiKey +
                "&include_adult=false&include_video=false&language=en-US&page=1" +
                "&sort_by=vote_average.desc&without_genres=99,10755&vote_count.gte=200";

        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        printApiResponse(responseEntity);
    }


    public void getUpcomingTitle() {
        String maxDate = setDataTime(90, 0).getFirst(); // Get date 90 days from now
        String minDate = setDataTime(30, 0).getFirst(); // Get date 30 days from now

        String url = "discover/movie?api_key=" + apiKey +
                "&include_adult=false&include_video=false&language=en-US&page=1" +
                "&sort_by=popularity.desc&with_release_type=2|3" +
                "&release_date.gte=" + minDate + "&release_date.lte=" + maxDate;

        ResponseEntity<RequestAPIModel> responseEntity = apiResponse(url);
        printApiResponse(responseEntity);
    }


}