package controllers;
import Entities.Evaluation;
import Services.ServiceEvaluation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class AjouterEvaluationController {


    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;
    @FXML
    private TextField cour;

    @FXML
    private TextField ensei;

    @FXML
    private TextField txt3;
    private final ServiceEvaluation ser=new ServiceEvaluation();
    private  int NoteF=0;
    private String description="";

    @FXML
    void Ajouterevaluation(ActionEvent event) {
        LocalDate dat = LocalDate.now();
        String pédagogie=txt1.getText();
        String Support_cours=txt2.getText();
        String cours=cour.getText();
        String enseignant=ensei.getText();
        String ambiance=txt3.getText();

        if("pas satisfaire".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)){
            NoteF+= 1+1+1;  }
            else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "Satisfaisante".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)){
                NoteF+=3+3+3;

        }
            else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 5 + 5;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "Satisfaisante".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 3 + 5;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "Satisfaisante".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 3 + 1;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "Satisfaisante".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 3 + 3;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 5 + 3;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 5 + 1;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 1 + 1;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 1 + 3;
        }
        else if ("Très satisfaisante".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)) {
            NoteF += 5 + 1 + 5;
        }
        if("pas satisfaire".equalsIgnoreCase(pédagogie) &&  "pas satisfaire".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+= 1+1+3;  }
        if("pas satisfaire".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+= 1+1+5;  }
        if("pas satisfaire".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+= 1+5+5;  }
        if("pas satisfaire".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+= 1+5+3;  }
        if("pas satisfaire".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)){
            NoteF+= 1+5+1;  }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "Satisfaisante".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)){
            NoteF+=3+3+1;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "Satisfaisante".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+=3+3+5;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+=3+5+5;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+=3+5+3;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "Très satisfaisante".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)){
            NoteF+=3+5+1;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "Satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+=3+1+3;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "pas satisfaire".equalsIgnoreCase(ambiance)){
            NoteF+=3+1+1;

        }
        else if("Satisfaisante".equalsIgnoreCase(pédagogie) && "pas satisfaire".equalsIgnoreCase(Support_cours) && "Très satisfaisante".equalsIgnoreCase(ambiance)){
            NoteF+=3+1+5;

        }

        if(NoteF<=3){
            description="Asser bien";
        }else if(NoteF<15){
            description="Bien";
        }else if(NoteF>=15){
            description="Trés Bien";
        }


        Evaluation e1 =new Evaluation(dat,NoteF,description,cours,enseignant);
        Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation");
        alert1.setContentText("Evaluation ajouter");
        alert1.showAndWait();
        try {
            ser.ajouter(e1);
        }catch (SQLException e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(e.getMessage());
            alert.showAndWait();


        }
        }
    @FXML
    void AfficherEvaluation(ActionEvent event) {
        try {


            FXMLLoader loader = new FXMLLoader(getClass().getResource("/AfficherEvaluation.fxml"));
            Parent root = loader.load();
           AfficherEvaluationController dc=loader.getController();
           dc.setLbdedc(txt1.getText());

            txt3.getScene().setRoot(root);

        }catch (IOException e){
            throw new RuntimeException(e);
        }

    }






    }






