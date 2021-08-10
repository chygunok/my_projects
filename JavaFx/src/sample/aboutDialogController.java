package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class aboutDialogController implements Initializable {

    private Stage ChartDialStage;

    public void setDialogStage(Stage ChartDialStage){
        this.ChartDialStage = ChartDialStage;
    }

    @FXML
    void closeAbout(ActionEvent event) {
        ChartDialStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
    }
}
