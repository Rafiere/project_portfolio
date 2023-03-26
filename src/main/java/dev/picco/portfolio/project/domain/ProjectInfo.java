package dev.picco.portfolio.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class ProjectInfo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	private String imageUrl;

	@OneToMany
	private List<ProjectUrl> projectUrls;

	private ProjectInfo(final String imageUrl, final List<ProjectUrl> projectUrls){
		this.imageUrl = imageUrl;
		this.projectUrls = projectUrls;
	}

	public static ProjectInfo of(final String imageUrl, final List<ProjectUrl> projectUrls){
		return new ProjectInfo(imageUrl, projectUrls);
	}

}
