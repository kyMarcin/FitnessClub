package sample.controller.datamanipulation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import sample.model.DiscountType;
import sample.model.dao.DiscountTypeDAO;

import java.sql.SQLException;


/**
 * Created by Marcin on 17.02.2018.
 */
public class DiscountTypeLayoutController {

    @FXML
    private TextField discountNameTextField;
    @FXML
    private TextField percentTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField byDiscountNameTextField;
    @FXML
    private TableView discountTable;
    @FXML
    private TableColumn<DiscountType, Integer> discountIDColumn;
    @FXML
    private TableColumn<DiscountType, String> discountNameColumn;
    @FXML
    private TableColumn<DiscountType, Float> percentDiscountColumn;

    @FXML
    private void initialize() {
        discountIDColumn.setCellValueFactory(cell -> cell.getValue().getDiscountIDProperty().asObject());
        discountNameColumn.setCellValueFactory(cell -> cell.getValue().getDiscountNameProperty());
        percentDiscountColumn.setCellValueFactory(cell -> cell.getValue().getPercentDiscountProperty().asObject());
    }

    public void addDiscountButtonAction(ActionEvent actionEvent) {
        DiscountType discountType = new DiscountType();
        try{
            discountType.setDiscountName(discountNameTextField.getText());
            discountType.setPercentDiscount(Float.parseFloat(percentTextField.getText()));
            DiscountTypeDAO.insertDiscountType(discountType);
            resultLabel.setTextFill(Paint.valueOf("#0fe77e"));
            resultLabel.setText("Zniżka została dodana");
        } catch (SQLException | ClassNotFoundException e) {
            resultLabel.setTextFill(Paint.valueOf("#da0f0f"));
            resultLabel.setText("Niepoprawne dane");
        }
    }

    public void selectByNameButtonAction(ActionEvent actionEvent) {
        ObservableList<DiscountType> discountTypes = FXCollections.observableArrayList();
        String discountName = byDiscountNameTextField.getText();
        DiscountType discountType = null;
        try {
            discountType = DiscountTypeDAO.selectByName(discountName);
            discountTypes.add(discountType);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        discountTable.setItems(discountTypes);

    }

    public void selectAllButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ObservableList<DiscountType> discountTypes = DiscountTypeDAO.selectAll();
        discountTable.setItems(discountTypes);
    }

}
