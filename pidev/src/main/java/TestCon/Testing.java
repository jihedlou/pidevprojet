package TestCon;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Testing extends Application {
    @Override
    public void start(Stage stage) throws Exception {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("/AjouterEvaluation.fxml"));
            Parent root=loader.load();
            Scene scene =new Scene(root);
            stage.setTitle("Gérer evaluation");
            stage.setScene(scene);
            stage.show();

    }
    public  static void main(String[] args){
        launch(args);
    }

}
