package dev.picco.portfolio.tag.controllers;

import dev.picco.portfolio.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.tag.controllers.responses.CreateTagResponse;
import dev.picco.portfolio.tag.services.UpdateTagService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "tag")
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
