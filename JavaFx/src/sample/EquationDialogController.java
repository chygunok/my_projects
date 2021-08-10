package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EquationDialogController implements Initializable {

    @FXML
    private TextField equationText;

    @FXML
    private TextField Min;

    @FXML
    private TextField SRAR;

    private Stage ChartDialStage;

    public void setEquationText1(String equation) {
        this.equationText.setText(equation);
    }
    public void setEquationText2(String Min) {   this.Min.setText(Min);}
    public void setEquationText3(String SRAR) {
        this.SRAR.setText(SRAR);
    }

    public void setDialogStage(Stage ChartDialStage){
        this.ChartDialStage = ChartDialStage;
    }

    @FXML
    void closeEquaDial(ActionEvent event) {
        ChartDialStage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //TODO
    }
}
