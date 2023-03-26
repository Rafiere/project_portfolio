package dev.picco.portfolio.project.controllers.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record CreateProjectRequest(@NotBlank String name, @NotBlank String description, List<Long> tagsIds, @NotNull CreateProjectInfoRequest createProjectInfoRequest) {


	public List<CreateProjectUrlRequest> getProjectUrlsRequests(){
		return this.createProjectInfoRequest.projectUrlsRequests();
	}

	public String getProjectImageUrl(){
		return createProjectInfoRequest.imageUrl();
	}
}
