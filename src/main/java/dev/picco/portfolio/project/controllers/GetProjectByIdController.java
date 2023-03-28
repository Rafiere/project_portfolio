package dev.picco.portfolio.project.controllers;

import dev.picco.portfolio.project.controllers.responses.GetProjectByIdResponse;
import dev.picco.portfolio.project.services.GetProjectByIdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "project")
public class GetProjectByIdController {

	private final GetProjectByIdService getProjectByIdService;

	@GetMapping("/v1/project/{projectId}")
	public ResponseEntity<GetProjectByIdResponse> execute(@PathVariable final Long projectId){

		var response = getProjectByIdService.execute(projectId);

		return ResponseEntity.ok(response);
	}
}
