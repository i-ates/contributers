package com.github.contributors.clients.GithubApi;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.contributors.clients.GithubApi.interfaces.IGithubApiClient;
import com.github.contributors.clients.GithubApi.models.Contributors;
import com.github.contributors.clients.GithubApi.models.User;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

public class GithubApiClient  implements IGithubApiClient {
    private final String server = "https://api.github.com";
    private final RestTemplate rest;
    private final HttpHeaders headers;
    private HttpStatus status;

    public GithubApiClient() {
        this.rest = new RestTemplate();
        this.headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        headers.add("Accept", "*/*");
    }

    public List<Contributors> get10Contributors(String Organization, String repository) {
        String Url = "/repos/" + Organization + "/"+ repository + "/contributors";
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + Url, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());

        try {

            ObjectMapper objectMapper =
                    new ObjectMapper();

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            JavaType type = objectMapper.getTypeFactory().constructParametrizedType(List.class, List.class, Contributors.class);
            List<Contributors> t2 = objectMapper.readValue(responseEntity.getBody(),type);

            return t2.stream().limit(10).collect(Collectors.toList());

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public User getUser(String userID){
        String Url = "/users/" + userID;
        HttpEntity<String> requestEntity = new HttpEntity<String>("", headers);
        ResponseEntity<String> responseEntity = rest.exchange(server + Url, HttpMethod.GET, requestEntity, String.class);
        this.setStatus(responseEntity.getStatusCode());

        try {

            ObjectMapper objectMapper =
                    new ObjectMapper();

            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
            User t2 = objectMapper.readValue(responseEntity.getBody(),User.class);

            return t2;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }


}

