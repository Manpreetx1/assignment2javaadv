module com.example.movie_information_application {
    requires javafx.controls;
    requires javafx.fxml;

    // Add this line to allow your module to read the unnamed module
    requires org.json;

    // Allow your module to read the unnamed module
    opens com.example.movie_information_application to javafx.fxml;
    exports com.example.movie_information_application;
}
