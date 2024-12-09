package ma.uiass.eia.movies.dto;

public class FavoriteRequest {
  private String userId;
  private int filmId;

  public FavoriteRequest() {

  }

  public FavoriteRequest(String userId, int filmId) {
    this.userId = userId;
    this.filmId = filmId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int getFilmId() {
    return filmId;
  }

  public void setFilmId(int filmId) {
    this.filmId = filmId;
  }

}