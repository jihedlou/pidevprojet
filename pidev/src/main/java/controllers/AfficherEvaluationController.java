package controllers;
import Entities.Evaluation;
import Services.ServiceEvaluation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import javax.imageio.IIOException;

public class AfficherEvaluationController {
    @FXML
    private Label lbdedc;
    @FXML
    private TableColumn<Evaluation, LocalDate> date;

    @FXML
    private TableColumn<Evaluation, String> desc;

    @FXML
    private TableColumn<Evaluation, String> nom;
    @FXML
    private TableColumn<Evaluation, String> cour;




    @FXML
    private TableColumn<Evaluation, Integer> note;

    @FXML
    private TableView<Evaluation> tableView;
    private final ServiceEvaluation ser=new ServiceEvaluation();


    public Label getLbdedc() {
        return lbdedc;
    }

    public void setLbdedc(String lbdedc) {
        this.lbdedc.setText(lbdedc);
    }
    @FXML
    void initialize(){




        try {
            List<Evaluation> list = ser.readAll();
            ObservableList<Evaluation> obers= FXCollections.observableList(list);
            tableView.setItems(obers);
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            note.setCellValueFactory(new PropertyValueFactory<>("NoteF"));
            desc.setCellValueFactory(new PropertyValueFactory<>("description"));
            cour.setCellValueFactory(new PropertyValueFactory<>("cour"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom_enseignant"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void ModifierEvaluation(ActionEvent event) {
        Evaluation selectedevaluation = tableView.getSelectionModel().getSelectedItem();
        if (selectedevaluation != null) {
            openUpdatePage(selectedevaluation);
            System.out.println(selectedevaluation);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setContentText("Séléctionner l'evaluation a modifier !");
            alert.showAndWait();
        }

    }
    void openUpdatePage(Evaluation evaluation) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/modifierevaluation.fxml"));
            Parent root = loader.load();
            ModifierevaluationController modifierevaluationController = loader.getController();
            modifierevaluationController.setEvaluation(evaluation);
            Stage updateStage = new Stage();
            updateStage.setTitle("Modifier utilisateur");
            updateStage.setScene(new Scene(root));
            updateStage.show();
        } catch (IIOException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    @FXML
    void supprimerevaluation(ActionEvent event) {
        Evaluation selectedEvaluation = tableView.getSelectionModel().getSelectedItem();
        if (selectedEvaluation != null) {
            System.out.println(selectedEvaluation);
            try {
                ser.delete(selectedEvaluation.getId());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Evaluation supprimé avec succés");
                alert.showAndWait();
                tableView.refresh();
            }catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }

    }


}
