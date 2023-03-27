package dev.picco.portfolio.project.domain;

import dev.picco.portfolio.tag.domain.Tag;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
public class Project {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	private String name;

	private String description;

	@OneToMany
	private List<Tag> tags;

	@OneToOne
	private ProjectInfo projectInfo;

	private Project(final String name, final String description, final List<Tag> tags, final ProjectInfo projectInfo){
		this.name = name;
		this.description = description;
		this.tags = tags;
		this.projectInfo = projectInfo;
	}

	public static Project of(final String name, final String description, final List<Tag> tags, final ProjectInfo projectInfo){
		return new Project(name, description, tags, projectInfo);
	}

	public Project update(final String newName, final String newDescription, final List<Tag> newTags, final ProjectInfo newProjectInfo){
		if(newName != null){
			this.name = newName;
		}

		if(newDescription != null){
			this.description = newDescription;
		}

		if(newTags != null){
			this.tags = newTags;
		}

		if(newProjectInfo != null){
			this.projectInfo = newProjectInfo;
		}

		return this;
	}
}
