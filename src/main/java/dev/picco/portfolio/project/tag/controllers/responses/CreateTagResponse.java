package dev.picco.portfolio.project.tag.controllers.responses;

public record CreateTagResponse(Long tagId, String tagName) {

	public static CreateTagResponse of(final Long tagId, final String tagName){
		return new CreateTagResponse(tagId, tagName);
	}
}
