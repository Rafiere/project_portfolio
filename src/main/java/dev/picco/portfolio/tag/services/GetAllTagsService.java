package dev.picco.portfolio.tag.services;

import dev.picco.portfolio.tag.controllers.responses.GetTagByIdResponse;
import dev.picco.portfolio.tag.domain.Tag;
import dev.picco.portfolio.tag.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTagsService {

	private final TagRepository tagRepository;

	public List<GetTagByIdResponse> execute() {

		List<Tag> tags = tagRepository.findAll();

		return tags.stream()
		           .map(tag -> GetTagByIdResponse.of(tag.getId(), tag.getName(), tag.getBackgroundColor()))
		           .toList();
	}
}
