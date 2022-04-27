package com.github.contributors.clients.GithubApi.interfaces;

import com.github.contributors.clients.GithubApi.models.Contributors;
import com.github.contributors.clients.GithubApi.models.User;

import java.util.List;

public interface IGithubApiClient {
    List<Contributors> get10Contributors(String organization, String repository);
    User getUser(String userID);
}
