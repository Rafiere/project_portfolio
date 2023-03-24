package dev.picco.portfolio.project.tag.controllers;

import dev.picco.portfolio.project.tag.controllers.responses.GetTagByIdResponse;
import dev.picco.portfolio.project.tag.services.GetAllTagsForAnUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GetAllTagsForAnUserController {

	private final GetAllTagsForAnUserService getAllTagsForAnUserService;

	@GetMapping("/v1/tags")
	public ResponseEntity<List<GetTagByIdResponse>> execute(){

		var response = getAllTagsForAnUserService.execute();

		return ResponseEntity.ok(response);
	}
}
