package dev.picco.portfolio.project.controllers;

import dev.picco.portfolio.project.controllers.requests.CreateProjectRequest;
import dev.picco.portfolio.project.controllers.responses.CreateProjectResponse;
import dev.picco.portfolio.project.services.CreateProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "project")
public class CreateProjectController {

	private final CreateProjectService createProjectService;

	@PostMapping("/v1/project")
	public ResponseEntity<CreateProjectResponse> execute(@RequestBody @Valid @NotNull final CreateProjectRequest request){

		var response = createProjectService.execute(request);

		return ResponseEntity.status(201).body(response);
	}
}
