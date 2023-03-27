package dev.picco.portfolio.project.controllers;

import dev.picco.portfolio.project.controllers.requests.CreateProjectRequest;
import dev.picco.portfolio.project.controllers.responses.CreateProjectResponse;
import dev.picco.portfolio.project.services.UpdateProjectService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateProjectController {

	private final UpdateProjectService updateProjectService;

	@PatchMapping("/v1/project/{projectId}")
	public ResponseEntity<CreateProjectResponse> execute(@PathVariable @NotNull Long projectId,
	                                                     @Valid @RequestBody CreateProjectRequest request) {

		var response = updateProjectService.execute(projectId, request);

		return ResponseEntity.status(201).body(response);
	}
}
