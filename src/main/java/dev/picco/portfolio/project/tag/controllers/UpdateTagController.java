package dev.picco.portfolio.project.tag.controllers;

import dev.picco.portfolio.project.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.project.tag.controllers.responses.CreateTagResponse;
import dev.picco.portfolio.project.tag.services.UpdateTagService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UpdateTagController {

	private final UpdateTagService updateTagService;

	@PatchMapping("/v1/tag/{tagId}")
	public ResponseEntity<CreateTagResponse> execute(@PathVariable @NotBlank final Long tagId,
	                                                 @Valid @RequestBody @NotNull final CreateTagRequest request) {

		var response = updateTagService.execute(tagId, request);

		return ResponseEntity.status(201)
		                     .body(response);
	}
}
