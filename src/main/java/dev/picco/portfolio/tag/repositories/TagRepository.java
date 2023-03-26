package dev.picco.portfolio.tag.repositories;

import dev.picco.portfolio.tag.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {

	@Query("SELECT t FROM Tag t " +
	       "WHERE t.id IN :tagsIds " +
	       "AND NOT EXISTS (SELECT 1 FROM Tag t2 WHERE t2.id = t.id)")
	List<Long> findMissingTagIds(List<Long> tagsIds);
}
