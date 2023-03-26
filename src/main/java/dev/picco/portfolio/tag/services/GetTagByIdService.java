package dev.picco.portfolio.tag.services;

import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;
import dev.picco.portfolio.tag.domain.Tag;
import dev.picco.portfolio.tag.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTagByIdService {

	private final TagRepository tagRepository;

	public GetTagByIdResponse execute(final Long tagId) {

		Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new IllegalArgumentException("A tag with ID " + tagId + " does not exist."));

		return GetTagByIdResponse.of(tag.getId(), tag.getName(), tag.getBackgroundColor());
	}
}
