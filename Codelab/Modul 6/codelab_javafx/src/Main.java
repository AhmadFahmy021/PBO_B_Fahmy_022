import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    private Button buttonTebakan;
    private TextField textFieldTebakan;
    private Label labelFeedback;
    private Label labelTitle;
    private Label labelPercobaan;
    private RandomNumber  randomgNumber;
    private AtomicInteger percobaan;
    private String status;

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage){
        percobaan = new AtomicInteger(5);
        status = "mulai";

        randomgNumber = new RandomNumber();
    try{
        textFieldTebakan = new TextField();
        buttonTebakan = new Button("Coba Tebak!");
        labelFeedback = new Label("Ketikkan Angka");
        labelFeedback.setFont(Font.font("Segoe UI Emoji", FontWeight.BOLD,17));

        labelTitle = new Label("🔢 Tebak Angka 1-100");
        labelTitle.setFont(Font.font("Segoe UI Emoji", FontWeight.BOLD, 20));
        labelPercobaan = new Label("Jumlah percobaan : "+ percobaan);

        buttonTebakan.setOnAction(e -> {
            switch (status){
                case "mulai":
                        percobaan.set(percobaan.get()-1);
                    if (percobaan.get() > 0){
                        if (randomgNumber.getRandom() > Integer.parseInt(textFieldTebakan.getText())){
                            labelFeedback.setText("⚠️ Terlalu kecil !!!");
                            labelFeedback.setTextFill(Color.RED);
                            labelPercobaan.setText("Jumlah percobaan : "+ percobaan);
                        } else if(randomgNumber.getRandom() < Integer.parseInt(textFieldTebakan.getText())){
                            labelFeedback.setText("⚠️ Telalu Besar !!");
                            labelFeedback.setTextFill(Color.RED);
                            labelPercobaan.setText("Jumlah percobaan : "+ percobaan);
                        } else{
                            status = "reset";
                            labelFeedback.setText("Yeay kamu telah menebak dengan benar!!!");
                            buttonTebakan.setText("Main Lagi");
                            labelPercobaan.setText("Jumlah percobaan : "+ percobaan);
                            randomgNumber.setRandom();
                        }
                    } else {
                        labelFeedback.setText("Yah kamu sedang tidak beruntung nih!!!");
                        buttonTebakan.setText("Mulai Ulang");
                        buttonTebakan.setStyle("-fx-background-color: lightblue;");
                        labelPercobaan.setText("Jumlah percobaan : "+ percobaan);
                        status = "reset";

//                        randomgNumber.setRandom();

                    }
                    break;
                case "reset":
                    percobaan.set(5);
                    randomgNumber.setRandom();
                    buttonTebakan.setText("Coba Tebak!");
                    labelFeedback.setText("Ketikkan Angka");
                    labelFeedback.setTextFill(Color.BLACK);
                    labelPercobaan.setText("Jumlah percobaan : "+ percobaan);
                    status = "mulai";
                    break;
            }


        });
    } catch (NumberFormatException e) {
        throw new RuntimeException(e);
    }




        HBox hbox = new HBox(10);
        hbox.getChildren().addAll(textFieldTebakan, buttonTebakan);
        hbox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(5);
        layout.getChildren().addAll(labelTitle, labelFeedback, hbox, labelPercobaan);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: lavender;");

        Scene scene = new Scene(layout, 300, 200, Color.RED);

        primaryStage.setTitle("Tebak Angka");
        primaryStage.setScene(scene);
        primaryStage.show();
    }



}