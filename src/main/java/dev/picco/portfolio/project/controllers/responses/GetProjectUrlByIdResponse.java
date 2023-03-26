package dev.picco.portfolio.project.controllers.responses;

import dev.picco.portfolio.project.domain.enums.UrlType;

public record GetProjectUrlByIdResponse(Long id, String url, String urlDescription, UrlType urlType) {

	public static GetProjectUrlByIdResponse of(final Long id, final String url, final String urlDescription, final UrlType urlType){
		return new GetProjectUrlByIdResponse(id, url, urlDescription, urlType);
	}

}
