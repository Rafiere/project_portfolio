package dev.picco.portfolio.project.services;

import dev.picco.portfolio.project.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class DeleteProjectService {

	private final ProjectRepository projectRepository;

	public void execute(final Long projectId) {

		projectRepository.deleteById(projectId);
	}
}
