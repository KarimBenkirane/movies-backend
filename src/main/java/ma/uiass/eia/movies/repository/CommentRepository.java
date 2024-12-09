package ma.uiass.eia.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.uiass.eia.movies.entity.CommentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Integer> {
  List<CommentEntity> findByFilmId(int filmId);

}
