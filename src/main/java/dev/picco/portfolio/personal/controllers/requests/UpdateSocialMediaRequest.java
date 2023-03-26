package dev.picco.portfolio.personal.controllers.requests;

import jakarta.validation.constraints.NotBlank;

public record UpdateSocialMediaRequest(@NotBlank String personalBlogUrl, @NotBlank String linkedinUrl, @NotBlank String githubUrl) {

}
