package ma.uiass.eia.movies.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comments") // Map to the table in your database
public class CommentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generate IDs
  private int id;

  @Column(name = "film_id", nullable = false) // Map field to a database column
  private int filmId;

  @Column(nullable = false)
  private Date date;

  @Column(nullable = false, length = 300) // Specify constraints
  private String content;

  @Column(nullable = false) // Specify constraints
  private String author;

  public CommentEntity() {
  }

  public CommentEntity(int id, int filmId, Date date, String content, String author) {
    this.id = id;
    this.filmId = filmId;
    this.date = date;
    this.content = content;
    this.author = author;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

}