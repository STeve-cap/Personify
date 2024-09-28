import java.lang.*;
import java.awt.Font;
import java.io.*;

public class UserDataManager {
    private static final String FILE_PATH = "user.txt"; // path to store the user data

    // Method to save user data to the text file
    public static void saveUser(UserData userData) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            // Write user data in CSV format (name, genre, artist, song, color, password)
            String userInfo = userData.getName() + "," + userData.getFavoriteGenre() + "," + 
                              userData.getFavoriteArtist() + "," + userData.getFavoriteSong() + "," + userData.getUniqueKey();
            writer.write(userInfo);
            writer.newLine(); // Move to the next line after writing
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read all users from the text file
    public static UserData getUser(String name, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma to extract user info
                String[] userInfo = line.split(",");
                String storedName = userInfo[0];
                String storedPassword = userInfo[5];

                // Check if the name and password match
                if (storedName.equals(name) && storedPassword.equals(password)) {
                    // Return the user data if the credentials match
                    return new UserData(userInfo[0], userInfo[1], userInfo[2], userInfo[3], userInfo[4]);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return null; // return null if the user is not found
    }
}

