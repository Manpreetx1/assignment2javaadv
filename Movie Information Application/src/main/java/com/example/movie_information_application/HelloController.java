package com.example.movie_information_application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class HelloController {

    @FXML
    private TextField movieTitleField;  // Added TextField for movie title input
    @FXML
    private Label titleLabel;
    @FXML
    private Label releaseDateLabel;
    @FXML
    private Label ratingLabel;
    @FXML
    private Label plotLabel;
    @FXML
    private ImageView posterImageView;
    @FXML
    private Button fetchButton;

    private final String apiKey = "your_omdb_api_key";

    @FXML
    protected void onFetchButtonClick() {
        try {
            String movieTitle = movieTitleField.getText();
            if (movieTitle.isEmpty()) {
                titleLabel.setText("Please enter a movie title.");
                return;
            }

            String urlString = "https://www.omdbapi.com/?t=" + movieTitle.replaceAll(" ", "+") + "&apikey=" + "731f0d10";
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream responseStream = connection.getInputStream();
            String jsonResponse = new Scanner(responseStream).useDelimiter("\\A").next();

            JSONObject jsonObject = new JSONObject(jsonResponse);
            String title = jsonObject.getString("Title");
            String releaseDate = jsonObject.getString("Released");
            String rating = jsonObject.getString("imdbRating");
            String plot = jsonObject.getString("Plot");
            String posterUrl = jsonObject.getString("Poster");

            titleLabel.setText("Title: " + title);
            releaseDateLabel.setText("Release Date: " + releaseDate);
            ratingLabel.setText("Rating: " + rating);
            plotLabel.setText("Plot: " + plot);


            Image posterImage = new Image(posterUrl);
            posterImageView.setImage(posterImage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
