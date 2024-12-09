package ma.uiass.eia.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.uiass.eia.movies.dto.FavoriteRequest;
import ma.uiass.eia.movies.entity.FavoriteEntity;
import ma.uiass.eia.movies.repository.FavoriteRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/api/favorites")
public class FavoriteController {

  @Autowired
  private FavoriteRepository favoriteRepository;

  @GetMapping("/user/{userId}")
  public List<FavoriteEntity> getFavorites(@PathVariable String userId) {
    return favoriteRepository.findByUserId(userId);
  }

  @GetMapping("/user/{userId}/film/{filmId}")
  public FavoriteEntity isFavorite(@PathVariable String userId, @PathVariable int filmId) {
    return favoriteRepository.findByUserIdAndFilmId(userId, filmId);
  }

  @PostMapping("/add")
  public ResponseEntity<String> addToFavorites(@RequestBody FavoriteRequest favoriteRequest) {
    FavoriteEntity favoriteEntity = new FavoriteEntity();
    favoriteEntity.setUserId(favoriteRequest.getUserId());
    favoriteEntity.setFilmId(favoriteRequest.getFilmId());
    favoriteRepository.save(favoriteEntity);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/user/{userId}/film/{filmId}")
  public ResponseEntity<String> removeFromFavorites(@PathVariable String userId, @PathVariable int filmId) {
    int deletedCount = favoriteRepository.deleteByUserIdAndFilmId(userId, filmId);
    if (deletedCount > 0) {
      return ResponseEntity.ok().build();
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

  }
}
