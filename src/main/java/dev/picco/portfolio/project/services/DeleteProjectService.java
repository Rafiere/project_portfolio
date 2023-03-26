package dev.picco.portfolio.project.services;

import dev.picco.portfolio.project.repositories.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteProjectService {

	private final ProjectRepository projectRepository;

	public void execute(Long projectId) {

		projectRepository.deleteById(projectId);
	}
}
