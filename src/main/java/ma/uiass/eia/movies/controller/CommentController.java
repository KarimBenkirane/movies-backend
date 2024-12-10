package ma.uiass.eia.movies.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ma.uiass.eia.movies.entity.CommentEntity;
import ma.uiass.eia.movies.repository.CommentRepository;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/comments")
public class CommentController {

  @Autowired
  private CommentRepository commentRepository;

  @GetMapping("/{filmId}")
  public List<CommentEntity> getComments(@PathVariable int filmId) {
    return commentRepository.findByFilmId(filmId);
  }

  @PostMapping("/{filmId}")
  public CommentEntity postComment(@PathVariable int filmId, @RequestBody CommentEntity comment) {
    comment.setFilmId(filmId);
    if (comment.getDate() == null) {
      comment.setDate(new Date());
    }
    return commentRepository.save(comment);
  }

}
