package dev.picco.portfolio.project.controllers;

import dev.picco.portfolio.project.services.DeleteProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DeleteProjectController {

	private final DeleteProjectService deleteProjectService;

	@DeleteMapping("/v1/project/{projectId}")
	public ResponseEntity<Void> execute(@PathVariable final Long projectId){

		deleteProjectService.execute(projectId);

		return ResponseEntity.status(204).build();
	}
}
