package controllers;
import Entities.Evaluation;
import Services.ServiceEvaluation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;

public class ModifierevaluationController {
    @FXML
    private DatePicker dat;

    @FXML
    private TextField desc;

    @FXML
    private TextField note;

    @FXML
    private TextField cour;

    @FXML
    private TextField nom;
    @FXML


    private Evaluation evaluation;
    private final ServiceEvaluation ser=new ServiceEvaluation();
    public ModifierevaluationController(){
        evaluation = new Evaluation();
    }
    public Evaluation getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Evaluation evaluation) {
        this.evaluation = evaluation;
        String dat=evaluation.getDate().toString();
        LocalDate localDate = LocalDate.parse(dat);
        this.dat.setValue(localDate);
        this.note.setText(evaluation.getNoteF());
        this.desc.setText(evaluation.getDescription());
        this.cour.setText(evaluation.getCour());
        this.nom.setText(evaluation.getNom_enseignant());



    }


    @FXML
    void modifierevaluation(ActionEvent event) {
        LocalDate localDate = dat.getValue();
        evaluation.setDate(Date.valueOf(localDate).toLocalDate());
        evaluation.setDescription(note.getText());
        evaluation.setDescription(desc.getText());
        try {
            ser.update(evaluation);
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("evaluation modifié avec succés");
            alert.showAndWait();
        } catch (SQLException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText(ex.getMessage());
            alert.showAndWait();
        }


    }
}
