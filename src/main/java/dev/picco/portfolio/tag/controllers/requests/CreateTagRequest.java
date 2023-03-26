package dev.picco.portfolio.tag.controllers.requests;

import jakarta.validation.constraints.NotBlank;

public record CreateTagRequest(@NotBlank String name, @NotBlank String color) {

}
