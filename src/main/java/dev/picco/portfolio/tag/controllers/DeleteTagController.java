package dev.picco.portfolio.tag.controllers;

import dev.picco.portfolio.tag.services.DeleteTagService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "tag")
public class DeleteTagController {

	private final DeleteTagService deleteTagService;

	@DeleteMapping("/v1/tag/{tagId}")
	public ResponseEntity<Void> execute(@NotNull @PathVariable final Long tagId){

		deleteTagService.execute(tagId);

		return ResponseEntity.noContent().build();
	}
}
