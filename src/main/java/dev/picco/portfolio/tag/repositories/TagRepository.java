package dev.picco.portfolio.tag.repositories;

import dev.picco.portfolio.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, Long> {

}
