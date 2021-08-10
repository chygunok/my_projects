package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddNoteController implements Initializable {

    @FXML
    private TextField addRadius;


    private Stage dialogStage;
    private MyСircle circle;
    private boolean okClicked = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public MyСircle getCircle() {
        return circle;
    }

    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean isInputValid() {
        String errorMessage = "";

        if (addRadius.getText() == null || addRadius.getText().length() == 0) {
            errorMessage += "Не корректное значение!\n";


        } else {
            try {
                addRadius.getText();
            } catch (NumberFormatException e) {
                errorMessage += "Не корректные данные (должны вводится целые числа)!\n";
            }
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Не корректные данные в полях ввода");
            alert.setHeaderText("Пожалуйста исправте ошибки ввода");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }


    @FXML
    void handleOk(ActionEvent event) {
        if (isInputValid()) {
            circle = new MyСircle(addRadius.getText());
            okClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    void handleCancel(ActionEvent event) {
        okClicked = false;
        dialogStage.close();
    }

}