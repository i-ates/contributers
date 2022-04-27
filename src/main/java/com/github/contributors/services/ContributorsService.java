package com.github.contributors.services;

import com.github.contributors.clients.GithubApi.GithubApiClient;
import com.github.contributors.clients.GithubApi.models.Contributors;
import com.github.contributors.clients.GithubApi.models.User;
import com.github.contributors.controllers.dto.ContributorsDTO;
import com.github.contributors.services.interfaces.IContributorsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContributorsService implements IContributorsService {
    GithubApiClient githubApiClient;

    public ContributorsService(){
        githubApiClient = new GithubApiClient();
    }

    public List<ContributorsDTO> get10Contributers(String organization, String repository){
        List<Contributors> contributorsList = githubApiClient.get10Contributors(organization, repository);
        List<ContributorsDTO> contributorsDTOList = new ArrayList<>();

        for (Contributors contributors : contributorsList) {
            User user = githubApiClient.getUser(contributors.getLogin());
            contributorsDTOList.add(generateContributorResponse(user,contributors, repository));
        }
        return  contributorsDTOList;
    }

    private ContributorsDTO generateContributorResponse(User user, Contributors contributors, String repository){
        ContributorsDTO contributorsDTO = new ContributorsDTO();

        contributorsDTO.setUser(user.getLogin());
        contributorsDTO.setCompany(user.getCompany());
        contributorsDTO.setLocation(user.getLocation());
        contributorsDTO.setRepo(repository);
        contributorsDTO.setContributions(contributors.getContributions());

        return contributorsDTO;
    }
}
