package dev.picco.portfolio.project.tag.repositories;

import dev.picco.portfolio.project.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
