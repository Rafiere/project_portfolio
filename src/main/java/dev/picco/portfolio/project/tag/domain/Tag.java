package dev.picco.portfolio.project.tag.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class Tag {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String backgroundColor;

	private Tag(final String name, final String backgroundColor){
		this.name = name;
		this.backgroundColor = backgroundColor;
	}

	public static Tag of(final String name, final String backgroundColor){
		return new Tag(name, backgroundColor);
	}
}
