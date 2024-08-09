package com.example.movie_information_application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Movie Information Application");
        stage.setScene(scene);
        stage.setHeight(700);
        stage.setWidth(1200);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
