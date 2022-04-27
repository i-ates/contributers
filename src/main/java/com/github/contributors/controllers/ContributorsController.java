package com.github.contributors.controllers;

import com.github.contributors.clients.GithubApi.models.Contributors;
import com.github.contributors.controllers.dto.ContributorsDTO;
import com.github.contributors.controllers.interfaces.IContributorsController;
import com.github.contributors.services.ContributorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contributers")
public class ContributorsController implements IContributorsController {
    @Autowired
    private ContributorsService contributorsService;

    @GetMapping("/top10/{organization}/{repository}")
    public  List<ContributorsDTO> getTop10Contributers(@PathVariable String organization, @PathVariable String repository){
        return contributorsService.get10Contributers(organization, repository);
    }
}
