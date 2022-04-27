package com.github.contributors.clients.GithubApi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContributorsList {
    @JsonProperty("")
    private List<Contributors> contributorsList;

    public List<Contributors> getContributorsList() {
        return contributorsList;
    }

}
