package sample.model.dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.database.DBConnection;
import sample.database.QueryProvider;
import sample.model.JobPosition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Marcin on 20.02.2018.
 */
public class JobPositionDAO {

    private static final String TABLE_NAME = "JobPosition";
    private static final String JOB_POSITION_NAME_COLUMN = "JobPositionName";
    private static final String INSERT_STATEMENT = QueryProvider.getInsertQuery(TABLE_NAME, 1);
    private static final String SELECT_ALL_STATEMENT = QueryProvider.getSelectAllQuery(TABLE_NAME);
    private static final String SELECT_BY_JOB_POSITION_NAME_STATEMENT = QueryProvider.getSelectByQuery(TABLE_NAME, JOB_POSITION_NAME_COLUMN);


    private JobPositionDAO() {

    }

    public static void insertJobPosition(JobPosition jobPosition) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_STATEMENT)) {
            String jobPositionName = jobPosition.getJobPositionName();
            statement.setString(1, jobPositionName);
            statement.execute();
        }
    }

    public static JobPosition selectByJobPositionName(String jobPositionName) throws SQLException, ClassNotFoundException {

        JobPosition jobPosition = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_JOB_POSITION_NAME_STATEMENT)) {
            statement.setString(1, jobPositionName);
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    jobPosition = new JobPosition();
                    jobPosition.setJobPositionID(resultSet.getInt("JobPositionID"));
                    jobPosition.setJobPositionName(jobPositionName);
                }
            }
        }
        return jobPosition;
    }

    public static ObservableList<JobPosition> selectAll() throws SQLException, ClassNotFoundException {

        ObservableList<JobPosition> jobPositionList = FXCollections.observableArrayList();
        try(Connection connection = DBConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_STATEMENT)) {
            try(ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    JobPosition jobPosition = new JobPosition();
                    jobPosition.setJobPositionID(resultSet.getInt("JobPositionID"));
                    jobPosition.setJobPositionName(resultSet.getString("JobPositionName"));
                    jobPositionList.add(jobPosition);
                }
            }
        }
        return jobPositionList;
    }
}
