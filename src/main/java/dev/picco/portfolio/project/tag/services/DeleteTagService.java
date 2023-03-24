package dev.picco.portfolio.project.tag.services;

import dev.picco.portfolio.project.tag.repositories.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteTagService {

	private final TagRepository tagRepository;

	public void execute(final Long tagId) {

		tagRepository.deleteById(tagId);
	}
}
