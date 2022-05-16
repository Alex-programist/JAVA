package com.example.demo3;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.io.IOException;

public class HelloApplication extends Application {
    public static Connection conn;
    @Override
    public void start(Stage stage) throws IOException, SQLException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/timetable",
                "postgres","Oleksander2004!");
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Лабораторна 10 - 10 варіант.");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}