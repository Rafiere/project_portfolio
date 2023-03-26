package dev.picco.portfolio.tag.controllers;

import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;
import dev.picco.portfolio.tag.services.GetAllTagsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllTagsController {

	private final GetAllTagsService getAllTagsService;

	@GetMapping("/v1/tags")
	public ResponseEntity<List<GetTagByIdResponse>> execute(){

		var response = getAllTagsService.execute();

		return ResponseEntity.ok(response);
	}
}
