package com.praktikum.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;


public class AdminDashboard extends StackPane {
    public AdminDashboard(MainApp app, ObservableList<String[]> adminReports){
        Label title = new Label("Selamat Datang di Dashboard Admin!");
        Label sapaan = new Label("Halo, Administrator admin");
        Label laporanLabel = new Label("Laporan Barang");

        ObservableList<String[]> laporanData = FXCollections.observableArrayList(
                new String[]{"Dompet", "Dompen hitam", "LAB A", "Reported"},
                new String[]{"Mouse", "mouse hitam", "LAB A", "Reported"}
        );

        TableView<String[]> laporanTable = new TableView<>(adminReports);
        laporanTable.setPrefSize(400, 300);

        TableColumn<String[], String> columnNama = new TableColumn<>("Nama");
        columnNama.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[0]));

        TableColumn<String[], String> columnDeskripsiBarang = new TableColumn<>("Deskripsi Barang");
        columnDeskripsiBarang.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[1]));

        TableColumn<String[], String>  columnLokasiTerakhir= new TableColumn<>("Lokasi Terakhir");
        columnLokasiTerakhir.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[2]));

        TableColumn<String[], String>  columnStatus= new TableColumn<>("Status");
        columnStatus.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[3]));



        laporanTable.getColumns().addAll(columnNama, columnDeskripsiBarang, columnLokasiTerakhir,columnStatus);

        Button claimedButton = new Button("Claimed");
        claimedButton.setOnAction(e -> {
            int i = laporanTable.getSelectionModel().getSelectedIndex();
            System.out.println(adminReports.size());
            if (i >= 0) {
                String[] row = laporanTable.getItems().get(i);
                row[3] = "Claimed";
                System.out.println(i);
                app.updateAdminReportStatus(0, "Claimed");
                laporanTable.refresh();
            }
        });

        Button logout = new Button("Logout");
        logout.setOnAction(e->{
            app.showLoginPage();
        });

        VBox leftBox = new VBox(5, title, sapaan, laporanLabel, laporanTable, claimedButton, logout);
        leftBox.setPadding(new Insets(0, 10, 0, 0));

        ObservableList<String[]> mahasiswaData = FXCollections.observableArrayList(
                new String[]{"Ahamd Fahmy", "202410370110022"},
                new String[]{"Budi", "202410370110021"}
        );

        TableView<String[]> mahasiswaTable = new TableView<>(mahasiswaData);
        mahasiswaTable.setPrefSize(400, 300);

        TableColumn<String[], String> columnNamaMahasiswa = new TableColumn<>("Nama");
        columnNamaMahasiswa.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[0]));

        TableColumn<String[], String> columnNimMahasiswa = new TableColumn<>("NIM");
        columnNimMahasiswa.setCellValueFactory(p ->
                new javafx.beans.property.SimpleStringProperty(p.getValue()[1]));

        mahasiswaTable.getColumns().addAll(columnNamaMahasiswa, columnNimMahasiswa);

        Label labelMahasiswa = new Label("Data Mahasiswa");
        TextField namaField = new TextField();
        namaField.setPromptText("Nama Mahasiswa");
        TextField nimField = new TextField();
        nimField.setPromptText("NIM");

        Button tambahBtn = new Button("Tambah");
        tambahBtn.setOnAction(e -> {
            String nama = namaField.getText().trim();
            String nim  = nimField.getText().trim();
            if (!nama.isEmpty() && !nim.isEmpty()) {
                mahasiswaData.add(new String[]{nama, nim});
                namaField.clear();
                nimField.clear();
                app.setMahasiswaData(mahasiswaData);
            }
        });

        Button hapusBtn = new Button("Hapus");
        hapusBtn.setOnAction(e -> {
            int i = mahasiswaTable.getSelectionModel().getSelectedIndex();
            if (i >= 0) {
                mahasiswaData.remove(i);
                app.setMahasiswaData(mahasiswaData);
            }
        });

        HBox inputBoxMahasiswa = new HBox(5, namaField, nimField, tambahBtn, hapusBtn);
        Label labelKosong1 = new Label();
        Label labelKosong2 = new Label();
        VBox rightBox = new VBox(5, labelKosong1, labelKosong2, labelMahasiswa, mahasiswaTable, inputBoxMahasiswa);
        rightBox.setPadding(new Insets(0, 10, 0, 0));
        HBox hbox = new HBox(5, leftBox, rightBox);

        this.getChildren().add(hbox);
    }
}
