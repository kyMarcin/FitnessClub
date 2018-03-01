package sample.controller.datamanipulation;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import sample.model.JobPosition;
import sample.model.dao.JobPositionDAO;

import java.sql.SQLException;


/**
 * Created by Marcin on 20.02.2018.
 */
public class JobPositionLayoutController {

    @FXML
    private TextField jobPositionNameTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private TableView jobPositionTable;
    @FXML
    private TableColumn<JobPosition, Integer> jobPositionIDColumn;
    @FXML
    private TableColumn<JobPosition, String> jobPositionNameColumn;

    @FXML
    private void initialize() {
        jobPositionIDColumn.setCellValueFactory(cell -> cell.getValue().getJobPositionIDProperty().asObject());
        jobPositionNameColumn.setCellValueFactory(cell -> cell.getValue().getJobPositionNameProperty());
    }

    @FXML
    public void handleAddPositionAction(ActionEvent actionEvent) {
        JobPosition jobPosition = new JobPosition();
        jobPosition.setJobPositionName(jobPositionNameTextField.getText());
        try {
            JobPositionDAO.insertJobPosition(jobPosition);
            resultLabel.setTextFill(Paint.valueOf("#0fe77e"));
            resultLabel.setText("Stanowisko zostało dodane");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            resultLabel.setTextFill(Paint.valueOf("#da0f0f"));
            resultLabel.setText("Niepoprawne dane");
        }
    }

    public void selectAllButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ObservableList<JobPosition> jobPositions = JobPositionDAO.selectAll();
        jobPositionTable.setItems(jobPositions);
}
}
