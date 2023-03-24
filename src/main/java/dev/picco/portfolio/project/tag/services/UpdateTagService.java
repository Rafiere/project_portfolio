package dev.picco.portfolio.project.tag.services;

import dev.picco.portfolio.project.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.project.tag.controllers.responses.CreateTagResponse;
import dev.picco.portfolio.project.tag.domain.Tag;
import dev.picco.portfolio.project.tag.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@RequiredArgsConstructor
public class UpdateTagService {

	private final TagRepository tagRepository;

	public CreateTagResponse execute(final Long tagId, final CreateTagRequest request) {

		Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new IllegalArgumentException("A tag with ID " + tagId + " does not exist."));

		tag.update(request.name(), request.color());

		return CreateTagResponse.of(tag.getId(), tag.getName(), tag.getBackgroundColor());
	}
}
