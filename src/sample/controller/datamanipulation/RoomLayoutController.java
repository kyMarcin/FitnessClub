package sample.controller.datamanipulation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import sample.model.Room;
import sample.model.dao.RoomDAO;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Created by Marcin on 13.02.2018.
 */
public class RoomLayoutController {

    @FXML
    private TextField roomNameTextField;
    @FXML
    private TextField pricePerHourTextField;
    @FXML
    private Text resultText;
    @FXML
    private TextField IDTextField;
    @FXML
    private TableView roomTable;
    @FXML
    private TableColumn<Room, Integer> roomIDColumn;
    @FXML
    private TableColumn<Room, String> roomNameColumn;
    @FXML
    private TableColumn<Room, BigDecimal> pricePerDayColumn;

    @FXML
    private void initialize() {
        roomIDColumn.setCellValueFactory(cell -> cell.getValue().getRoomIDProperty().asObject());
        roomNameColumn.setCellValueFactory(cell -> cell.getValue().getRoomNameProperty());
        pricePerDayColumn.setCellValueFactory(cell -> cell.getValue().getPricePerHourProperty());
    }

    @FXML
    private void addRoomButtonAction(ActionEvent actionEvent) {

        Room room = new Room();
        try {
            room.setRoomName(roomNameTextField.getText());
            room.setPricePerHour(new BigDecimal(pricePerHourTextField.getText()));
            RoomDAO.insertRoom(room);
            resultText.setFill(Paint.valueOf("#0fe77e"));
            resultText.setText("Sala została dodana");
        } catch (Exception e) {
            e.printStackTrace();
            resultText.setFill(Paint.valueOf("#da0f0f"));
            resultText.setText("Niepoprawne dane");
        }
    }

    @FXML
    private void selectByIDButtonAction(ActionEvent actionEvent) {

        ObservableList<Room> rooms = FXCollections.observableArrayList();
        try {
            int id = Integer.parseInt(IDTextField.getText());
            Room room = RoomDAO.selectByID(id);
            rooms.add(room);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        roomTable.setItems(rooms);
    }

    @FXML
    private void selectAllButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ObservableList<Room> rooms = RoomDAO.selectAll();
        roomTable.setItems(rooms);
    }

}
