package com.github.contributors.clients.GithubApi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    @JsonProperty("login")
    private String login;
    @JsonProperty("location")
    private String location;
    @JsonProperty("company")
    private String company;

    public String getLogin() {
        return login;
    }

    public String getLocation() {
        return location;
    }

    public String getCompany() {
        return company;
    }
}
