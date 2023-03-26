package dev.picco.portfolio.project.controllers.responses;

import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;

import java.util.List;

public record CreateProjectResponse(Long id, String name, String description, List<GetTagByIdResponse> tagResponses, GetProjectInfoByIdResponse projectInfoResponse) {

}
