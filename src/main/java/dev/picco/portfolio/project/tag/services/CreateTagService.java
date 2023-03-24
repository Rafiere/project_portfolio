package dev.picco.portfolio.project.tag.services;

import dev.picco.portfolio.project.tag.controllers.requests.CreateTagRequest;
import dev.picco.portfolio.project.tag.controllers.responses.CreateTagResponse;
import dev.picco.portfolio.project.tag.domain.Tag;
import dev.picco.portfolio.project.tag.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CreateTagService {

	private final TagRepository tagRepository;

	public CreateTagResponse execute(final CreateTagRequest request) {

		Tag createdTag = Tag.of(request.name(), request.color());

		Tag savedTag = tagRepository.save(createdTag);

		return CreateTagResponse.of(savedTag.getId(), savedTag.getName(), savedTag.getBackgroundColor());
	}
}
