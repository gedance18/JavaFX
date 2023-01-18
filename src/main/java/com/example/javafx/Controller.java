package com.example.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Controller {

    @FXML
    private int Jugador = 1;
    @FXML
    private Button c1;
    @FXML
    private Button c2;
    @FXML
    private Button c3;
    @FXML
    private Button c4;
    @FXML
    private Button c5;
    @FXML
    private Button c6;
    @FXML
    private Button c7;
    @FXML
    private Button c8;
    @FXML
    private Button c9;
    @FXML
    private RadioButton cVSc;
    @FXML
    private RadioButton pVSp;
    @FXML
    private RadioButton pVSc;
    @FXML
   private TextField winner;

    @FXML
    private ArrayList<Button> list_buttons;

    @FXML
    private Button statistics;
    @FXML
    private void result(ActionEvent event) {

    }

    @FXML
    private void help(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Autor");
        alert.setHeaderText("Gerard");
        alert.setContentText("Tres en ralla desarollado por Gerard Ordoñez Almendros, estudio programación en el instituto Puig Castellar uno de los mejores de Santa Coloma de Gramenet");
        alert.showAndWait();
    }

    @FXML
    private void play(ActionEvent actionEvent){
        list_buttons = new ArrayList(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9));
        if(pVSp.isSelected()){
            list_buttons.forEach(button -> {
                click(button);
            });
        }
    }

    @FXML
    private void closeGame (){
        System.exit(0);
    }

    @FXML
    private void click(Button button){
        button.setOnMouseClicked(mouseEvent -> {
            PlayerVSPlayer(button);
        });
    }
    @FXML
    private void PlayerVSPlayer(Button button){
        if(Jugador == 1){
            button.setText("O");
            button.setDisable(true);
            Jugador += 1;
        } else if (Jugador == 2){
            button.setText("X");
            button.setDisable(true);
            Jugador -= 1;
        }

    }

    @FXML
    private void Statistics() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("statistics.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage statsStage = new Stage();
        statsStage.setTitle("Estadisticas de los Jugadores");
        statsStage.setScene(scene);
        statsStage.initModality(Modality.NONE);
        statsStage.show();

    }

    @FXML
    public void checkFinishGame() {
        for (int i = 0; i < 8; i++) {
            String line = switch (i) {
                case 0 -> c1.getText() + c2.getText() + c3.getText();
                case 1 -> c4.getText() + c5.getText() + c6.getText();
                case 2 -> c7.getText() + c8.getText() + c9.getText();
                case 3 -> c1.getText() + c5.getText() + c9.getText();
                case 4 -> c3.getText() + c5.getText() + c7.getText();
                case 5 -> c1.getText() + c4.getText() + c7.getText();
                case 6 -> c2.getText() + c5.getText() + c8.getText();
                case 7 -> c3.getText() + c6.getText() + c9.getText();
                default -> null;
            };

            //X winner
            if (line.equals("XXX")) {
                winner.setText("X won!");
            }
            //O winner
            else if (line.equals("OOO")) {
                winner.setText("O won!");
            }
        }
    }
}