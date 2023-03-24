package dev.picco.portfolio.project.tag.services;

import dev.picco.portfolio.project.tag.controllers.responses.GetTagByIdResponse;
import dev.picco.portfolio.project.tag.domain.Tag;
import dev.picco.portfolio.project.tag.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTagsForAnUserService {

	private final TagRepository tagRepository;

	public List<GetTagByIdResponse> execute() {

		List<Tag> tags = tagRepository.findAll();

		return tags.stream()
		           .map(tag -> GetTagByIdResponse.of(tag.getId(), tag.getName(), tag.getBackgroundColor()))
		           .toList();
	}
}
