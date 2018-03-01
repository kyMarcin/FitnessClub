package sample.controller.datamanipulation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.model.Ticket;
import sample.model.dao.TicketDAO;
import sample.window.SceneManager;

import java.math.BigDecimal;
import java.sql.SQLException;


/**
 * Created by Marcin on 16.02.2018.
 */
public class TicketLayoutController {

    @FXML
    private TextField ticketNameTextField;
    @FXML
    private TextField pricePerDayTextField;
    @FXML
    private TextField noPersonsTextField;
    @FXML
    private TextField noDaysTextField;
    @FXML
    private Label resultLabel;
    @FXML
    private TextField idTextField;
    @FXML
    private TableView ticketTable;
    @FXML
    private TableColumn<Ticket, Integer> ticketIDColumn;
    @FXML
    private TableColumn<Ticket, String> ticketNameColumn;
    @FXML
    private TableColumn<Ticket, BigDecimal> pricePerDayColumn;
    @FXML
    private TableColumn<Ticket, Integer> noPersonsColumn;
    @FXML
    private TableColumn<Ticket, Integer> noDaysColumn;

    @FXML
    private void initialize() {
            ticketIDColumn.setCellValueFactory(cell -> cell.getValue().getTicketIDProperty().asObject());
            ticketNameColumn.setCellValueFactory(cell -> cell.getValue().getTicketNameProperty());
            pricePerDayColumn.setCellValueFactory(cell -> cell.getValue().getPricePerDayProperty());
            noPersonsColumn.setCellValueFactory(cell -> cell.getValue().getNoPersonsProperty().asObject());
            noDaysColumn.setCellValueFactory(cell -> cell.getValue().getNoDaysProperty().asObject());
    }
    
    public void addTicketButtonAction(ActionEvent actionEvent) {
        Ticket ticket = new Ticket();
        try {
            ticket.setTicketName(ticketNameTextField.getText());
            ticket.setPricePerDay(new BigDecimal(pricePerDayTextField.getText()));
            ticket.setNoPersons(Integer.parseInt(noPersonsTextField.getText()));
            ticket.setNoDays(Integer.parseInt(noDaysTextField.getText()));
            TicketDAO.insertTicket(ticket);
            SceneManager.setLabel(resultLabel, SceneManager.Color.GREEN, "Karnet został dodany");
        } catch (Exception e) {
            SceneManager.setLabel(resultLabel, SceneManager.Color.RED, "Niepoprawne dane");
            e.printStackTrace();
        }
    }


    public void selectByIDButtonAction(ActionEvent actionEvent) {
        ObservableList<Ticket> tickets = FXCollections.observableArrayList();
        try {
            int id = Integer.parseInt(idTextField.getText());
            Ticket ticket = TicketDAO.selectByID(id);
            tickets.add(ticket);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        ticketTable.setItems(tickets);
    }

    public void selectAllButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        ObservableList<Ticket> tickets = TicketDAO.selectAll();
        ticketTable.setItems(tickets);
    }
}
