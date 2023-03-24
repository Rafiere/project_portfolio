package dev.picco.portfolio.project.tag.controllers.responses;

public record CreateTagResponse(Long tagId, String tagName, String tagColor) {

	public static CreateTagResponse of(final Long tagId, final String tagName, final String tagColor){
		return new CreateTagResponse(tagId, tagName, tagColor);
	}
}
