package dev.picco.portfolio.personal.controllers.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdatePersonalInfoRequest(@NotBlank String firstName, @NotBlank String lastName, @NotBlank String description, @NotBlank String urlPhoto, @NotNull UpdateSocialMediaRequest updateSocialMediaRequest) {

	public String getPersonalBlogUrl(){
		return this.updateSocialMediaRequest.personalBlogUrl();
	}

	public String getLinkedinUrl(){
		return this.updateSocialMediaRequest.linkedinUrl();
	}

	public String getGithubUrl(){
		return this.updateSocialMediaRequest.githubUrl();
	}
}
