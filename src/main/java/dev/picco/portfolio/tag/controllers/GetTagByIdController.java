package dev.picco.portfolio.tag.controllers;

import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;
import dev.picco.portfolio.tag.services.GetTagByIdService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "tag")
public class GetTagByIdController {

	private final GetTagByIdService getTagByIdService;

	@GetMapping("/tag/{tagId}")
	public ResponseEntity<GetTagByIdResponse> execute(@NotNull @PathVariable final Long tagId){

		var response = getTagByIdService.execute(tagId);

		return ResponseEntity.ok(response);
	}
}
