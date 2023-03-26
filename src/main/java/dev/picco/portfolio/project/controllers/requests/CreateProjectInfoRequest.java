package dev.picco.portfolio.project.controllers.requests;

import jakarta.validation.constraints.NotBlank;

import java.util.List;

public record CreateProjectInfoRequest(@NotBlank String imageUrl, List<CreateProjectUrlRequest> projectUrlsRequests) {

}
