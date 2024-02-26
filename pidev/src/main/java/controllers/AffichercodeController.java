package controllers;
import Entities.Code;
import Entities.Evaluation;
import Services.ServiceCode;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import javafx.event.ActionEvent;


public class AffichercodeController {
    @FXML
    private Label pour;

    @FXML
    private TableColumn<Code, Integer> code;

    @FXML
    private TableColumn<Code, LocalDate> date;

    @FXML
    private TableColumn<Code, String> pourcentage;

    @FXML
    private TableColumn<Code, String> nom;

    @FXML
    private TableView<Code> tableview;
    private final ServiceCode ser=new ServiceCode();

    public Label getPour() {
        return pour;
    }

    public void setPour(String pour) {
        this.pour.setText(pour);
    }
    @FXML
    void initialize(){




        try {
            List<Code> list = ser.readAll();
            ObservableList<Code> obers= FXCollections.observableList(list);
            tableview.setItems(obers);
            pourcentage.setCellValueFactory(new PropertyValueFactory<>("pourcentage"));
            code.setCellValueFactory(new PropertyValueFactory<>("code"));
            date.setCellValueFactory(new PropertyValueFactory<>("date"));
            nom.setCellValueFactory(new PropertyValueFactory<>("nom_etudiant"));



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void supprimercode(ActionEvent event) {
        Code selectedCode = tableview.getSelectionModel().getSelectedItem();
        if (selectedCode != null) {
            System.out.println(selectedCode);
            try {
                ser.delete(selectedCode.getId());
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setContentText("Code promo supprimé avec succés");
                alert.showAndWait();
                tableview.refresh();
            }catch (SQLException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }

    }
}
