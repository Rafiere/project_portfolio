package dev.picco.portfolio.personal.controllers;

import dev.picco.portfolio.personal.controllers.requests.UpdatePersonalInfoRequest;
import dev.picco.portfolio.personal.controllers.responses.UpdatePersonalInfoResponse;
import dev.picco.portfolio.personal.services.UpdatePersonalInfoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "personal-info")
public class UpdatePersonalInfoController {

	private final UpdatePersonalInfoService updatePersonalInfoService;

	@PatchMapping("/v1/personal-info")
	public ResponseEntity<UpdatePersonalInfoResponse> execute(@Valid @NotNull @RequestBody UpdatePersonalInfoRequest request){

		var response = updatePersonalInfoService.execute(request);

		return ResponseEntity.status(201).body(response);
	}
}
