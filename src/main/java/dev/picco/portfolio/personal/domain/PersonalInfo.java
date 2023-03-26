package dev.picco.portfolio.personal.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class PersonalInfo {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

	private String firstName;

	private String lastName;

	private String description;

	private String urlPhoto;

	@OneToOne private SocialMedia socialMedia;

	private PersonalInfo(final String firstName,
	                     final String lastName,
	                     final String description,
	                     final String urlPhoto,
	                     final SocialMedia socialMedia) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.description = description;
		this.urlPhoto = urlPhoto;
		this.socialMedia = socialMedia;
	}

	public static PersonalInfo of(final String firstName,
	                              final String lastName,
	                              final String description,
	                              final String urlPhoto,
	                              final SocialMedia socialMedia) {

		return new PersonalInfo(firstName, lastName, description, urlPhoto, socialMedia);
	}

	public Long getSocialMediaId() {

		return this.socialMedia.id;
	}

	public String getPersonalBlogUrl() {

		return this.socialMedia.getPersonalBlogUrl();
	}

	public String getLinkedinUrl() {

		return this.socialMedia.getLinkedinUrl();
	}

	public String getGithubUrl() {

		return this.socialMedia.getGithubUrl();
	}

	public PersonalInfo update(final String firstName,
	                           final String lastName,
	                           final String description,
	                           final String urlPhoto,
	                           final SocialMedia socialMedia) {

		if (firstName !=
		    null) {
			this.firstName = firstName;
		}

		if (lastName !=
		    null) {
			this.lastName = lastName;
		}

		if (description !=
		    null) {
			this.description = description;
		}

		if (urlPhoto !=
		    null) {
			this.urlPhoto = urlPhoto;
		}

		if (this.socialMedia !=
		    null) {
			this.socialMedia = socialMedia.update(socialMedia.getPersonalBlogUrl(),
			                   socialMedia.getLinkedinUrl(),
			                   socialMedia.getGithubUrl());
		}

		return this;
	}
}
