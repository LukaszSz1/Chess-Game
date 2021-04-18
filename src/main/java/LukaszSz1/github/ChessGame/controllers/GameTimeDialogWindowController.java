package LukaszSz1.github.ChessGame.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class GameTimeDialogWindowController implements Initializable {

    @FXML
    private Spinner<Integer> gameTimeChooser;

    private Integer chosenTime;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chosenTime = 5;

        SpinnerValueFactory<Integer> itemValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 90, 5) {
            @Override
            public void decrement(int steps) {
                setValue(getValue() - 5);
            }

            @Override
            public void increment(int steps) {
                setValue(getValue() + 5);
            }
        };

        gameTimeChooser.setValueFactory(itemValueFactory);
        gameTimeChooser.setEditable(false);

        //value changeListener
        itemValueFactory.valueProperty().addListener((observableValue, oldVal, newVal) -> chosenTime = newVal);
    }

    public Integer getChosenTime() {
        return chosenTime;
    }
}



