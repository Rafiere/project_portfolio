package dev.picco.portfolio.project.tag.services;

import dev.picco.portfolio.project.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.project.tag.controllers.responses.CreateTagResponse;

public class CreateTagService {

	public CreateTagResponse execute(CreateTagRequest request) {

		return CreateTagResponse.of(1L, "teste");
	}
}
