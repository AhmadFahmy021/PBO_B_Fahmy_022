package com.praktikum.gui;

import com.praktikum.data.DataStore;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.List;

public class MahasiswaDashboard extends StackPane {
    public MahasiswaDashboard(String name, String nim, ObservableList<String[]> mahasiswaReports, MainApp app){
        Label title = new Label("Dashboard Mahasiswa");
        Label selamatDatang = new Label("Selamat Datang, " + name);
        Label pendukung = new Label("Laporkan Barang Hilang / Temuan");

        TextField inputNama = new TextField();
        inputNama.setPromptText("Nama Barang");

        TextField inputDeskripsiBarang = new TextField();
        inputDeskripsiBarang.setPromptText("Deskripsi Barang");

        TextField inputLokasi = new TextField();
        inputLokasi.setPromptText("Lokasi Terakhir");

        Button buttonSubmit = new Button("Submit");

        buttonSubmit.setOnAction(e->{
            String valueNamaBarang = inputNama.getText().trim();
            String valueDeskrispiBarang = inputDeskripsiBarang.getText().trim();
            String valueLokasiBarang = inputLokasi.getText().trim();

            if (valueNamaBarang.isEmpty()||valueDeskrispiBarang.isEmpty()||valueLokasiBarang.isEmpty()){
                Alert alertEmpty = new Alert(Alert.AlertType.WARNING);
                alertEmpty.setContentText("Input Tidak Boleh Kosong");
                alertEmpty.showAndWait();
                return;
            }

            String[] report = new String[]{valueNamaBarang, valueDeskrispiBarang, valueLokasiBarang, "Reported"};
            app.addReport(report);

            inputNama.clear();
            inputDeskripsiBarang.clear();
            inputLokasi.clear();

        });

        HBox barangBox = new HBox(5, inputNama, inputDeskripsiBarang, inputLokasi, buttonSubmit);

        TableView<String[]> mahasiswaTableReports = new TableView<>();
        mahasiswaTableReports.setItems(mahasiswaReports);

        TableColumn<String[], String> columnNameBarang = new TableColumn<>("Nama");
        columnNameBarang.setCellValueFactory(p->new javafx.beans.property.SimpleStringProperty(p.getValue()[0]));

        TableColumn<String[], String> columnDeskripsiBarang = new TableColumn<>("Deskripsi Barang");
        columnDeskripsiBarang.setCellValueFactory(p->new javafx.beans.property.SimpleStringProperty(p.getValue()[1]));

        TableColumn<String[], String> columnLokasiBarang = new TableColumn<>("Lokasi Terakhir");
        columnLokasiBarang.setCellValueFactory(p->new javafx.beans.property.SimpleStringProperty(p.getValue()[2]));

        TableColumn<String[], String> columnStatusBarang = new TableColumn<>("Status");
        columnStatusBarang.setCellValueFactory(p->new javafx.beans.property.SimpleStringProperty(p.getValue()[3]));

        mahasiswaTableReports.getColumns().addAll(columnNameBarang, columnDeskripsiBarang, columnLokasiBarang, columnStatusBarang);

        DataStore dataStore = DataStore.getInstance();
        List<String[]> lostItems = dataStore.getLostItems();

        Button logout = new Button("Logout");
        logout.setOnAction(e->{
            app.showLoginPage();
        });


        VBox layout = new VBox(5, title, selamatDatang, pendukung,barangBox, mahasiswaTableReports, logout);


        this.getChildren().add(layout);
    }
}
