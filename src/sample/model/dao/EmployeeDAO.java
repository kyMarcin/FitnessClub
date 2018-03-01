package sample.model.dao;

import sample.database.DBConnection;
import sample.database.QueryProvider;
import sample.model.Employee;
import sample.model.JobPosition;

import java.sql.*;

/**
 * Created by Marcin on 18.02.2018.
 */
public class EmployeeDAO {

    private static final String TABLE_NAME = "Employee";
    // TODO create people dao
    private static final String PARENT_TABLE_NAME = "People";
    private static final String EMAIL_COLUMN_NAME = "Email";
    private static final String ADD_EMPLOYEE_PROC_NAME = "addEmployee";
    private static final String ADD_EMPLOYEE_PROC_EXEC_STATEMENT = QueryProvider.getExecProcQuery(ADD_EMPLOYEE_PROC_NAME, 16);
    private static final String SELECT_BY_EMAIL_STATEMENT = QueryProvider.getSelectByQuery(PARENT_TABLE_NAME, EMAIL_COLUMN_NAME);
    // TODO create EmployeeJobPositionDAO
    private static final String EMPLOYEE_JOB_POSITION_TABLE_NAME = "EmployeeJobPosition";
    private static final String INSERT_EMPLOYEE_JOB_POSITION_STATEMENT = QueryProvider.getInsertQuery(EMPLOYEE_JOB_POSITION_TABLE_NAME, 2);

    private EmployeeDAO() {

    }

    public static void insertEmployee(Employee employee) throws SQLException, ClassNotFoundException {

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(ADD_EMPLOYEE_PROC_EXEC_STATEMENT)) {
            statement.setString(1, employee.getFirstName());
            statement.setString(2, employee.getMiddleName());
            statement.setString(3, employee.getLastName());
            statement.setString(4, employee.getNin());
            statement.setString(5, employee.getNationality());
            statement.setString(6, employee.getGender());
            statement.setDate(7, employee.getDateOfBirth());
            statement.setDate(8, employee.getDateJoined());
            statement.setString(9, employee.getTelephoneNumber());
            statement.setString(10, employee.getStreetAddress());
            statement.setString(11, employee.getCity());
            statement.setString(12, employee.getZipCode());
            statement.setString(13, employee.getEmail());
            if (employee.getEmail().isEmpty()) {
                statement.setNull(14, Types.NVARCHAR);
            } else {
                statement.setString(14, employee.getPictureURL());
            }
            statement.setBoolean(15, employee.getIsActive());
            statement.setBigDecimal(16, employee.getSalary());
            statement.execute();
        }
    }

    public static Employee selectByEmail(String email) throws SQLException, ClassNotFoundException {

        Employee employee = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(SELECT_BY_EMAIL_STATEMENT)) {
            statement.setString(1, email);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    employee = new Employee();
                    //TODO set all fields
                    employee.setEmployeeID(resultSet.getInt("PersonID"));
                    employee.setFirstName(resultSet.getString("FirstName"));
                    employee.setLastName(resultSet.getString("LastName"));
                    employee.setPictureURL(resultSet.getString("PictureURL"));
                }
            }
        }
        return employee;
    }

    public static void insertEmployeeJobPosition(JobPosition jobPosition, Employee employee) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_EMPLOYEE_JOB_POSITION_STATEMENT)) {
            statement.setInt(1, jobPosition.getJobPositionID());
            statement.setInt(2, employee.getEmployeeID());
            statement.execute();
        }
    }

}
