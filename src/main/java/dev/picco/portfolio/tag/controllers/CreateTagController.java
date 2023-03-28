package dev.picco.portfolio.tag.controllers;

import dev.picco.portfolio.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.tag.controllers.responses.CreateTagResponse;
import dev.picco.portfolio.tag.services.CreateTagService;
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
@Tag(name = "tag")
public class CreateTagController {

	private final CreateTagService createTagService;

	@PostMapping("/v1/tag")
	public ResponseEntity<CreateTagResponse> execute(@Valid @NotNull @RequestBody final CreateTagRequest request){

		var response = createTagService.execute(request);

		return ResponseEntity.status(201).body(response);
	}
}
