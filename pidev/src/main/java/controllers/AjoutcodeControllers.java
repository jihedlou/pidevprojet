package controllers;
import Entities.Code;
import Entities.Evaluation;
import Services.ServiceCode;
import Services.ServiceEvaluation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

public class AjoutcodeControllers {
    @FXML
    private TextField txt1;

    @FXML
    private TextField nom;

    @FXML
    private TextField txt2;
    private final ServiceCode ser=new ServiceCode();

    @FXML
    void Ajoutercode(ActionEvent event) {
        String noms =nom.getText();
        String pourcentage = txt1.getText();
        int code = Integer.parseInt(txt2.getText());
        LocalDate dat = LocalDate.now();
        Code c1 = new Code(pourcentage, code, dat,noms);

        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation");
        alert1.setContentText("Code Promo ajouter");
        alert1.showAndWait();
        try {
            ser.ajouter(c1);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();

        }
    }
    @FXML
    void Affichercode(ActionEvent event) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Affichercode.fxml"));
            Parent root = loader.load();
            AffichercodeController dc=loader.getController();
            dc.setPour(txt1.getText());

            txt2.getScene().setRoot(root);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
