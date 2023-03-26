package dev.picco.portfolio.personal.controllers.responses;

public record UpdatePersonalInfoResponse(Long id, String firstName, String lastName, String description, String urlPhoto, UpdateSocialMediaResponse updateSocialMediaResponse) {

}
