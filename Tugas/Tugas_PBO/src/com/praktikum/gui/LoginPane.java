package com.praktikum.gui;

import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class LoginPane extends StackPane {
    public LoginPane(MainApp app) {
        Label title = new Label("Login Sistem Lost & Found");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        TextField usernameField = new TextField();
        usernameField.setPromptText("Username / Nama");

        TextField passwordField = new TextField();
        passwordField.setPromptText("Password / NIM");

        ComboBox<String> pilihRole = new ComboBox<>();
        pilihRole.getItems().addAll("Admin", "Mahasiswa");
        pilihRole.setPromptText("Pilih Role");

        Button loginButton = new Button("Login");

        loginButton.setOnAction(e -> {
            String user = usernameField.getText();
            String pass = passwordField.getText();
            String role = pilihRole.getValue();
            switch (role){
                case "Admin":
                    if (user.equals("Admin022") && pass.equals("Password022")) {
                        app.showDashboardAdmin();
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Login gagal!");
                        alert.showAndWait();
                    }
                    break;
                case "Mahasiswa":
                    if (user.equals("Ahmadfahmy") && pass.equals("202410370110022")) {
                        app.showDashboardMahasiswa(user, pass);
                    } else {
                        Alert alert = new Alert(Alert.AlertType.ERROR, "Login gagal!");
                        alert.showAndWait();
                    }
                    break;
            }
        });

        Button button2 = new Button("Button2");
        VBox boxInput = new VBox(10);
        boxInput.getChildren().addAll(title, pilihRole, usernameField, passwordField, loginButton, button2);

        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(boxInput);

        hbox.setAlignment(Pos.CENTER);
        this.getChildren().add(hbox);
    }
}
