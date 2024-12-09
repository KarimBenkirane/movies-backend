package ma.uiass.eia.movies.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.transaction.Transactional;
import ma.uiass.eia.movies.entity.FavoriteEntity;

public interface FavoriteRepository extends JpaRepository<FavoriteEntity, Integer> {
  FavoriteEntity findByUserIdAndFilmId(String userId, int filmId);

  List<FavoriteEntity> findByUserId(String userId);

  FavoriteEntity findByFilmId(int filmId);

  @Transactional
  int deleteByUserIdAndFilmId(String userId, int filmId);
}
