package sample.model.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.DBConnection;
import sample.database.QueryProvider;
import sample.model.DiscountType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marcin on 17.02.2018.
 */
public class DiscountTypeDAO {

    private static final String TABLE_NAME = "DiscountType";
    private static final String DISCOUNT_NAME_COLUMN_NAME = "DiscountName";
    private static final String INSERT_STATEMENT = QueryProvider.getInsertQuery(TABLE_NAME,2);
    private static final String SELECT_BY_NAME_STATEMENT = QueryProvider.getSelectByQuery(TABLE_NAME, DISCOUNT_NAME_COLUMN_NAME);
    private static final String SELECT_ALL_STATEMENT = QueryProvider.getSelectAllQuery(TABLE_NAME);
    private static final String DELETE_ALL_STATEMENT = QueryProvider.getDeleteAllQuery(TABLE_NAME);

    private DiscountTypeDAO() {

    }

    public static void insertDiscountType(DiscountType discountType) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_STATEMENT)) {
            String discountName = discountType.getDiscountName();
            float percentDiscount = discountType.getPercentDiscount();
            statement.setString(1,discountName);
            statement.setFloat(2,percentDiscount);
            statement.execute();
        }
    }

    public static DiscountType selectByName(String discountName) throws SQLException, ClassNotFoundException {
        DiscountType discountType = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_NAME_STATEMENT)) {
            statement.setString(1, discountName);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    discountType = new DiscountType();
                    discountType.setDiscountID(resultSet.getInt("DiscountID"));
                    discountType.setDiscountName(resultSet.getString("DiscountName"));
                    discountType.setPercentDiscount(resultSet.getFloat("PercentDiscount"));
                }
            }
        }
        return discountType;
    }

    public static ObservableList<DiscountType> selectAll() throws SQLException, ClassNotFoundException {
        ObservableList<DiscountType> discountTypeList = FXCollections.observableArrayList();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STATEMENT)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    DiscountType discountType = new DiscountType();
                    discountType.setDiscountID(resultSet.getInt("DiscountID"));
                    discountType.setDiscountName(resultSet.getString("DiscountName"));
                    discountType.setPercentDiscount(resultSet.getFloat("PercentDiscount"));
                    discountTypeList.add(discountType);
                }
            }
        }
        return discountTypeList;
    }

    public static void deleteDiscounts() throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ALL_STATEMENT)) {
            statement.execute();
        }
    }
}
