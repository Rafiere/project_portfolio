package dev.picco.portfolio.personal.services;

import dev.picco.portfolio.personal.controllers.requests.UpdatePersonalInfoRequest;
import dev.picco.portfolio.personal.controllers.responses.UpdatePersonalInfoResponse;
import dev.picco.portfolio.personal.controllers.responses.UpdateSocialMediaResponse;
import dev.picco.portfolio.personal.domain.PersonalInfo;
import dev.picco.portfolio.personal.domain.SocialMedia;
import dev.picco.portfolio.personal.repositories.PersonalInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UpdatePersonalInfoService {

	private final PersonalInfoRepository personalInfoRepository;

	public UpdatePersonalInfoResponse execute(final UpdatePersonalInfoRequest request) {

		Optional<PersonalInfo> personalInfo = personalInfoRepository.findFirstPersonalInfo();

		if (personalInfo.isPresent()) {
			PersonalInfo updatedPersonalInfo = updatePersonalInfo(personalInfo.get(), request);
			return generateResponse(updatedPersonalInfo);
		}

		PersonalInfo createdPersonalInfo = createAndSaveFirstPersonalInfo(request);
		return generateResponse(createdPersonalInfo);
	}

	private PersonalInfo updatePersonalInfo(final PersonalInfo personalInfo, final UpdatePersonalInfoRequest request) {

		SocialMedia requestSocialMedia = SocialMedia.of(request.getPersonalBlogUrl(), request.getLinkedinUrl(), request.getGithubUrl());

		return personalInfo.update(request.firstName(), request.lastName(), request.description(), request.urlPhoto(), requestSocialMedia);
	}

	private PersonalInfo createAndSaveFirstPersonalInfo(final UpdatePersonalInfoRequest request) {

		SocialMedia firstSocialMedia = SocialMedia.of(request.getPersonalBlogUrl(), request.getLinkedinUrl(), request.getGithubUrl());

		PersonalInfo firstPersonalInfo = PersonalInfo.of(request.firstName(),
		                                                 request.lastName(),
		                                                 request.description(),
		                                                 request.urlPhoto(),
		                                                 firstSocialMedia);

		return personalInfoRepository.save(firstPersonalInfo);
	}

	private UpdatePersonalInfoResponse generateResponse(final PersonalInfo savedPersonalInfo) {

		UpdateSocialMediaResponse updateSocialMediaResponse =
				new UpdateSocialMediaResponse(savedPersonalInfo.getSocialMediaId(),
				                              savedPersonalInfo.getPersonalBlogUrl(),
				                              savedPersonalInfo.getLinkedinUrl(),
				                              savedPersonalInfo.getGithubUrl());

		return new UpdatePersonalInfoResponse(savedPersonalInfo.getId(),
		                                      savedPersonalInfo.getFirstName(),
		                                      savedPersonalInfo.getLastName(),
		                                      savedPersonalInfo.getDescription(),
		                                      savedPersonalInfo.getUrlPhoto(),
		                                      updateSocialMediaResponse);
	}

}
