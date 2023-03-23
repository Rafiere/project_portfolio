package dev.picco.portfolio.project.tag.controllers;

import dev.picco.portfolio.project.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.project.tag.controllers.responses.CreateTagResponse;
import dev.picco.portfolio.project.tag.services.CreateTagService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CreateTagController {

	private final CreateTagService createTagService;

	@PostMapping("/v1/tag")
	public ResponseEntity<CreateTagResponse> execute(@Valid @NotNull @RequestBody CreateTagRequest request){

		var response = createTagService.execute(request);

		return ResponseEntity.status(201).body(response);
	}
}
