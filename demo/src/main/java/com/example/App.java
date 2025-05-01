package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.List;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // Creating a TextField for URL input
        TextField urlInput = new TextField();
        urlInput.setPromptText("Enter URL to be searched");

        // Creating a VBox layout
        VBox vbox = new VBox(10);
        vbox.getChildren().add(urlInput);

        // Creating a Scene
        Scene scene = new Scene(vbox, 400, 200);

        // Setting up the Stage
        stage.setTitle("Web Scraper");
        stage.setScene(scene);
        stage.show();

        // Start Web Scraping (Optional)
        scrapeWebsite();
    }

    // Web Scraping Method
    public static void scrapeWebsite(String url) {
        System.out.println("Scraping from: " + url);
        try {
            Document document = Jsoup.connect(url).get();

            // Select elements with car names and prices
            List<Element> names = document.select(".title");
            List<Element> prices = document.select(".price");

            for (Element name : names) {
                System.out.println("Name of car: " + name.text());
            }
            for (Element price : prices) {
                System.out.println("Car Price: " + price.text());
            }
        } catch (IOException e) {
            System.err.println("Error fetching URL: " + url);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch JavaFX application
    }
}

