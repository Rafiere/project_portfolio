package dev.picco.portfolio.project.controllers.requests;

import dev.picco.portfolio.project.domain.enums.UrlType;
import jakarta.validation.constraints.NotBlank;

public record CreateProjectUrlRequest(@NotBlank String url, @NotBlank String urlDescription, @NotBlank UrlType urlType) {


}
