package com.github.contributors.controllers.interfaces;

import com.github.contributors.clients.GithubApi.models.Contributors;
import com.github.contributors.controllers.dto.ContributorsDTO;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IContributorsController {
    List<ContributorsDTO> getTop10Contributers(@PathVariable String organization, @PathVariable String repository);
}
