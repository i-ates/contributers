package com.github.contributors.clients.GithubApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)

public class Contributors {
    @JsonProperty("login")
    private String login;
    @JsonProperty("contributions")
    private int contributions;

    public Contributors(){

    }

    public String getLogin() {
        return login;
    }

    public int getContributions() {
        return contributions;
    }
}
