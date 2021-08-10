package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainSceneController implements Initializable {

    @FXML
    private TableView<MyСircle> tableCircle;

    @FXML
    private TableColumn<MyСircle, SimpleStringProperty> radiusColumn;

    private Main mainApp;

    //@FXML
    private void openChart(ActionEvent event) throws IOException {
        int selectedIndex = tableCircle.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            MyСircle circle = mainApp.getData().get(selectedIndex);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("chartDialogFXML.fxml"));
            Parent root = loader.load();
            ChartDialogController controller = loader.getController();
            Stage ChartDialStage = new Stage();
            ChartDialStage.setTitle("График круговой");
            ChartDialStage.setResizable(false);
            controller.plotting(circle);
            controller.setDialogStage(ChartDialStage);
            Scene scene = new Scene(root);
            ChartDialStage.setScene(scene);
            ChartDialStage.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("No selected item!");
            alert.setHeaderText("Please select item!");
            alert.setContentText("No selected item!");
            alert.showAndWait();
        }
    }

    @FXML
    private void showEquation(ActionEvent event) throws IOException {
        int selectedIndex = tableCircle.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            MyСircle circle = mainApp.getData().get(selectedIndex);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("EquationDialogFXML.fxml"));
            Parent root = loader.load();
            EquationDialogController controller = loader.getController();
            Stage ChartDialStage = new Stage();
            ChartDialStage.setTitle("Уравнение окружности");
            ChartDialStage.setResizable(false);
            controller.setEquationText1(circle.Max());
            controller.setEquationText2(circle.Min());
            controller.setEquationText3(circle.SrAr());
            controller.setDialogStage(ChartDialStage);
            Scene scene = new Scene(root);
            ChartDialStage.setScene(scene);
            ChartDialStage.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Запись не выбрана!");
            alert.setHeaderText("Выберите запись!");
            alert.setContentText("Запись не выбрана!");
            alert.showAndWait();
        }
    }

    @FXML
    private void setData(ActionEvent event) {
        tableCircle.setItems(mainApp.getData());
    }

    @FXML
    private void saveData(ActionEvent event) {
        try (FileWriter writer = new FileWriter("redacted List.txt")) {
            writer.flush();
            for (MyСircle circle : mainApp.getData()) {
                writer.write(circle.getLine());
                writer.write("\n");
            }
        } catch

        (IOException e) {
            e.printStackTrace();
        } //Сохранение в новом доке.
    }

    @FXML
    private void closeApp(ActionEvent event){
        System.exit(0);
    }


    @FXML
    private void addNote(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("AddNoteFXML.fxml"));
        Parent root = loader.load();
        AddNoteController controller = loader.getController();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Edit Organization");
        Scene scene = new Scene(root);
        dialogStage.setScene(scene);
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
        if (controller.isOkClicked()) {
            mainApp.getData().add(controller.getCircle());
        }
    }

    @FXML
    private void deleteNote(ActionEvent event) {
        int selectedIndex = tableCircle.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            tableCircle.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Удаляемая записть отсутвует!");
            alert.setHeaderText("Выберите запись!");
            alert.setContentText("Удаляемая записть отсутвует!");
            alert.showAndWait();
        }

    }

    @FXML
    private void aboutDialog(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("aboutDialogFXML.fxml"));
        Parent root = loader.load();
        aboutDialogController controller = loader.getController();
        Stage ChartDialStage = new Stage();
        ChartDialStage.setTitle("О приложении");
        ChartDialStage.setResizable(false);
        controller.setDialogStage(ChartDialStage);
        Scene scene = new Scene(root);
        ChartDialStage.setScene(scene);
        ChartDialStage.showAndWait();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO
        radiusColumn.setCellValueFactory(new PropertyValueFactory<>("line"));
    }

    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
    }
}
