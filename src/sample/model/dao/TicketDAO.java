package sample.model.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.DBConnection;
import sample.database.QueryProvider;
import sample.model.Ticket;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marcin on 16.02.2018.
 */
public class TicketDAO {

    private static final String TABLE_NAME = "Ticket";
    private static final String ID_COLUMN_NAME = "TicketID";
    private static final String INSERT_STATEMENT = QueryProvider.getInsertQuery(TABLE_NAME,4);
    private static final String SELECT_BY_ID_STATEMENT = QueryProvider.getSelectByQuery(TABLE_NAME, ID_COLUMN_NAME);
    private static final String SELECT_ALL_STATEMENT = QueryProvider.getSelectAllQuery(TABLE_NAME);
    private static final String DELETE_ALL_STATEMENT = QueryProvider.getDeleteAllQuery(TABLE_NAME);

    private TicketDAO() {

    }

    public static void insertTicket(Ticket ticket) throws SQLException, ClassNotFoundException {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_STATEMENT)) {
            String ticketName = ticket.getTicketName();
            BigDecimal pricePerDay = ticket.getPricePerDay();
            int noPersons = ticket.getNoPersons();
            int noDays = ticket.getNoDays();
            statement.setString(1, ticketName);
            statement.setBigDecimal(2,pricePerDay);
            statement.setInt(3, noPersons);
            statement.setInt(4, noDays);
            statement.execute();
        }
    }

    public static Ticket selectByID(int id) throws SQLException, ClassNotFoundException {

        Ticket ticket = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_ID_STATEMENT)) {
            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    ticket = new Ticket();
                    ticket.setTicketID(resultSet.getInt("TicketID"));
                    ticket.setTicketName(resultSet.getString("TicketName"));
                    ticket.setPricePerDay(resultSet.getBigDecimal("PricePerDay"));
                    ticket.setNoPersons(resultSet.getInt("NoPersons"));
                    ticket.setNoDays(resultSet.getInt("NoDays"));
                }
            }
        }
        return ticket;
    }

    public static ObservableList<Ticket> selectAll() throws SQLException, ClassNotFoundException {

        ObservableList<Ticket> ticketList = FXCollections.observableArrayList();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STATEMENT)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Ticket ticket = new Ticket();
                    ticket.setTicketID(resultSet.getInt("TicketID"));
                    ticket.setTicketName(resultSet.getString("TicketName"));
                    ticket.setPricePerDay(resultSet.getBigDecimal("PricePerDay"));
                    ticket.setNoPersons(resultSet.getInt("NoPersons"));
                    ticket.setNoDays(resultSet.getInt("NoDays"));
                    ticketList.add(ticket);
                }
            }
        }
        return ticketList;
    }

    public static void deleteTickets() throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ALL_STATEMENT)) {
            statement.execute();
        }
    }



}
