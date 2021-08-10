package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main extends Application {

    private ObservableList<MyСircle> data = FXCollections.observableArrayList();
    File file = new File("SequencesList.txt");

    Scanner scanner;
    {
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                data.add(new MyСircle(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public ObservableList<MyСircle> getData() {
        return data;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("MainSceneFXML.fxml"));
        Parent root = loader.load();
        MainSceneController controller = loader.getController();
        controller.setMainApp(this);
        Scene scene = new Scene(root);
        primaryStage.setTitle("Circle Builder");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
