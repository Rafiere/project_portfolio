package dev.picco.portfolio.project.repositories;

import dev.picco.portfolio.project.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
