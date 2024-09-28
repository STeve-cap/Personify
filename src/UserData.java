import java.lang.*;
import java.awt.Font;
public class UserData {
    private String name;
    private String favoriteGenre;
    private String favoriteArtist;
    private String favoriteSong;
   
    private String uniqueKey;

    // Constructor
    public UserData(String name, String favoriteGenre, String favoriteArtist, String favoriteSong, String uniqueKey) {
        this.name = name;
        this.favoriteGenre = favoriteGenre;
        this.favoriteArtist = favoriteArtist;
        this.favoriteSong = favoriteSong;
        this.uniqueKey = uniqueKey;
    }

    // Getters
    public String getName() { return name; }
    public String getFavoriteGenre() { return favoriteGenre; }
    public String getFavoriteArtist() { return favoriteArtist; }
    public String getFavoriteSong() { return favoriteSong; }
    public String getUniqueKey() { return uniqueKey; }
}
