package dev.picco.portfolio.tag.controllers.responses;

public record GetTagByIdResponse(Long tagId, String tagName, String tagColor) {

	public static GetTagByIdResponse of(final Long tagId, final String tagName, final String tagColor){
		return new GetTagByIdResponse(tagId, tagName, tagColor);
	}
}
