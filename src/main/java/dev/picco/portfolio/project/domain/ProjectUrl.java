package dev.picco.portfolio.project.domain;

import dev.picco.portfolio.project.domain.enums.UrlType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class ProjectUrl {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	private String url;

	private String urlDescription;

	@Enumerated(EnumType.STRING)
	private UrlType urlType;

	private ProjectUrl(final String url, final String urlDescription, final UrlType urlType){
		this.url = url;
		this.urlDescription = urlDescription;
		this.urlType = urlType;
	}

	public static ProjectUrl of(final String url, final String urlDescription, final UrlType urlType){
		return new ProjectUrl(url, urlDescription, urlType);
	}
}
