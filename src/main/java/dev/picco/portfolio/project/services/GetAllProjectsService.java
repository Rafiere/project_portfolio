package dev.picco.portfolio.project.services;

import dev.picco.portfolio.project.controllers.responses.GetProjectByIdResponse;
import dev.picco.portfolio.project.controllers.responses.GetProjectInfoByIdResponse;
import dev.picco.portfolio.project.controllers.responses.GetProjectUrlByIdResponse;
import dev.picco.portfolio.project.domain.Project;
import dev.picco.portfolio.project.repositories.ProjectRepository;
import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllProjectsService {

	private final ProjectRepository projectRepository;

	public List<GetProjectByIdResponse> execute() {

		List<Project> allProjects = projectRepository.findAll();

		return allProjects.stream()
		                  .map(project -> GetProjectByIdResponse.of(project.getId(),
		                                                            project.getName(),
		                                                            project.getDescription(),
		                                                            getProjectTagsResponses(project),
		                                                            getProjectInfoResponse(project)))
		                  .toList();
	}

	private static List<GetTagByIdResponse> getProjectTagsResponses(final Project project) {

		return project.getTags()
		              .stream()
		              .map(projectTag -> GetTagByIdResponse.of(projectTag.getId(),
		                                                       projectTag.getName(),
		                                                       projectTag.getBackgroundColor()))
		              .toList();
	}

	private static GetProjectInfoByIdResponse getProjectInfoResponse(final Project project) {

		return GetProjectInfoByIdResponse.of(project.getProjectInfo()
		                                            .getId(),
		                                     project.getProjectInfo()
		                                            .getImageUrl(),
		                                     getProjectUrlsResponses(project));
	}

	private static List<GetProjectUrlByIdResponse> getProjectUrlsResponses(final Project project) {

		return project.getProjectInfo()
		              .getProjectUrls()
		              .stream()
		              .map(projectUrl -> GetProjectUrlByIdResponse.of(projectUrl.getId(),
		                                                              projectUrl.getUrl(),
		                                                              projectUrl.getUrlDescription(),
		                                                              projectUrl.getUrlType()))
		              .toList();
	}
}
