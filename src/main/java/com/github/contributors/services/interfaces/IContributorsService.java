package com.github.contributors.services.interfaces;

import com.github.contributors.clients.GithubApi.models.Contributors;
import com.github.contributors.controllers.dto.ContributorsDTO;

import java.util.List;

public interface IContributorsService {
    List<ContributorsDTO> get10Contributers(String organization, String repository);
}
