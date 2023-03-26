package dev.picco.portfolio.personal.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class SocialMedia {

	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY) Long id;

	private String personalBlogUrl;

	private String linkedinUrl;

	private String githubUrl;

	private SocialMedia(final String personalBlogUrl, final String linkedInUrl, final String githubUrl){
		this.personalBlogUrl = personalBlogUrl;
		this.linkedinUrl = linkedInUrl;
		this.githubUrl = githubUrl;
	}

	public static SocialMedia of(final String personalBlogUrl, final String linkedinUrl, final String githubUrl){
		return new SocialMedia(personalBlogUrl, linkedinUrl, githubUrl);
	}

	public SocialMedia update(final String personalBlogUrl, final String linkedinUrl, final String githubUrl){
		if(personalBlogUrl != null){
			this.personalBlogUrl = personalBlogUrl;
		}

		if(linkedinUrl != null){
			this.linkedinUrl = linkedinUrl;
		}

		if(githubUrl != null){
			this.githubUrl = githubUrl;
		}

		return this;
	}
}
