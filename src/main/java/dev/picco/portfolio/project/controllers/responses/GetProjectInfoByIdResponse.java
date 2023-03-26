package dev.picco.portfolio.project.controllers.responses;

import java.util.List;

public record GetProjectInfoByIdResponse(Long id, String imageUrl, List<GetProjectUrlByIdResponse> projectUrlsResponses) {

	public static GetProjectInfoByIdResponse of(final Long id, final String imageUrl, final List<GetProjectUrlByIdResponse> projectUrlsResponses){
		return new GetProjectInfoByIdResponse(id, imageUrl, projectUrlsResponses);
	}
}
