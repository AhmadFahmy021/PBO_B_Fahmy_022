package com.praktikum.gui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainApp extends Application {
    private Stage primaryStage;
    private ObservableList<String[]> adminReports = FXCollections.observableArrayList();
    private ObservableList<String[]> mahasiswaReports = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginPage();
    }

    public void showLoginPage() {
        LoginPane loginPane = new LoginPane(this);
        Scene scene = new Scene(loginPane, 500, 250);
        primaryStage.setTitle("Login");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showDashboardAdmin() {
        AdminDashboard adminView = new AdminDashboard(this, adminReports);
        Scene scene = new Scene(adminView, 1000, 500);
        primaryStage.setTitle("Dashboard Admin");
        primaryStage.setScene(scene);
    }

    public void showDashboardMahasiswa(String nama, String nim) {
        MahasiswaDashboard mahasiswaView = new MahasiswaDashboard(nama, nim, mahasiswaReports, this);
        Scene scene = new Scene(mahasiswaView, 1000, 500);
        primaryStage.setTitle("Dashboard Mahasiswa");
        primaryStage.setScene(scene);
    }

    public void addReport(String[] input){
        mahasiswaReports.add(input);
        adminReports.add(new String[]{input[0], input[1], input[2], "Reported"});
    }

    public void updateAdminReportStatus(int index, String newStatus) {
        System.out.println("kode"+index);
        String[] old = adminReports.get(index);
        adminReports.set(index, new String[]{ old[0], old[1], old[2], newStatus });
    }

    private ObservableList<String[]> mahasiswaData = FXCollections.observableArrayList();
    public void setMahasiswaData(ObservableList<String[]> data) {
        this.mahasiswaData = data;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
