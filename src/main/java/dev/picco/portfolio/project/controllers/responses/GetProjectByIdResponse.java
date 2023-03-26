package dev.picco.portfolio.project.controllers.responses;

import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;

import java.util.List;

public record GetProjectByIdResponse(Long id, String name, String description, List<GetTagByIdResponse> tagResponses, GetProjectInfoByIdResponse projectInfoResponse) {

	public static GetProjectByIdResponse of(final Long id, final String name, final String description, final List<GetTagByIdResponse> tagResponses, final GetProjectInfoByIdResponse projectInfoResponse){
		return new GetProjectByIdResponse(id, name, description, tagResponses, projectInfoResponse);
	}
}
