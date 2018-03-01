package sample.controller.datamanipulation;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import sample.model.Employee;
import sample.model.JobPosition;
import sample.model.dao.EmployeeDAO;
import sample.model.dao.JobPositionDAO;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.stream.Collectors;

/**
 * Created by Marcin on 18.02.2018.
 */
public class EmployeeLayoutController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField middleNameTextField;
    @FXML
    private TextField lastNameTextField;
    @FXML
    private TextField ninTextField;
    @FXML
    private TextField nationalityTextField;
    @FXML
    private TextField genderTextField;
    @FXML
    private TextField dateOfBirthTextField;
    @FXML
    private TextField dateJoinedTextField;
    @FXML
    private TextField telephoneTextField;
    @FXML
    private TextField streetTextField;
    @FXML
    private TextField cityTextField;
    @FXML
    private TextField zipCodeTextField;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField pictureURLTextField;
    @FXML
    private TextField isActiveTextField;
    @FXML
    private TextField salaryTextField;
    @FXML
    private Label resultLabel;

    @FXML
    private MenuButton jobPositionsMenuButton;

    @FXML
    private TextField byEmailTextField;
    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private ImageView imageView;

    private ObservableList<CheckBox> jobPositionCheckBoxes;
    private static final String DEFAULT_PHOTO_URL = "https://t4.ftcdn.net/jpg/00/78/73/53/240_F_78735333_o3qJe4bT5ciwldLIjVDulFKrDAV3jGYO.jpg";


    @FXML
    private void initialize() throws SQLException, ClassNotFoundException {

        ObservableList<JobPosition> jobPositionsList = JobPositionDAO.selectAll();
        jobPositionCheckBoxes = FXCollections.observableArrayList();
        for (JobPosition jobPosition : jobPositionsList) {
            CheckBox checkBox = new CheckBox(jobPosition.getJobPositionName());
            jobPositionCheckBoxes.add(checkBox);
        }
        jobPositionsMenuButton.getItems().setAll(jobPositionCheckBoxes.stream()
                .map(CustomMenuItem::new)
                .peek(item -> item.setHideOnClick(false))
                .collect(Collectors.toList()));
    }

    @FXML
    private void addEmployeeButtonAction(ActionEvent actionEvent) {
        Employee employee = new Employee();
        try {
            employee.setFirstName(nameTextField.getText());
            employee.setMiddleName(middleNameTextField.getText());
            employee.setLastName(lastNameTextField.getText());
            employee.setNin(ninTextField.getText());
            employee.setNationality(nationalityTextField.getText());
            employee.setGender(genderTextField.getText());
            String[] dateOfBirthComponents = dateOfBirthTextField.getText().split("-");
            LocalDate dateOfBirth = LocalDate.of(Integer.parseInt(dateOfBirthComponents[0])
                    , Integer.parseInt(dateOfBirthComponents[1]), Integer.parseInt(dateOfBirthComponents[2]));
            employee.setDateOfBirth(Date.valueOf(dateOfBirth));

            LocalDate dateOJoined;
            if (!dateJoinedTextField.getText().isEmpty()) {
                String[] dateJoinedComponents = dateJoinedTextField.getText().split("-");
                dateOJoined = LocalDate.of(Integer.parseInt(dateJoinedComponents[0])
                        , Integer.parseInt(dateJoinedComponents[1]), Integer.parseInt(dateJoinedComponents[2]));
            }
            else {
                dateOJoined = LocalDate.now(ZoneId.systemDefault());
            }
            employee.setDateJoined(Date.valueOf(dateOJoined));

            employee.setTelephoneNumber(telephoneTextField.getText());
            employee.setStreetAddress(streetTextField.getText());
            employee.setCity(cityTextField.getText());
            employee.setZipCode(zipCodeTextField.getText());
            employee.setEmail(emailTextField.getText());
            employee.setPictureURL(pictureURLTextField.getText().isEmpty() ? null : pictureURLTextField.getText());
            employee.setIsActive(Boolean.parseBoolean(isActiveTextField.getText()));
            employee.setSalary(new BigDecimal(salaryTextField.getText()));
            EmployeeDAO.insertEmployee(employee);

            employee = EmployeeDAO.selectByEmail(employee.getEmail());
            for (CheckBox jobPosition : jobPositionCheckBoxes) {
                if (jobPosition.isSelected()) {
                    EmployeeDAO.insertEmployeeJobPosition(JobPositionDAO.selectByJobPositionName(jobPosition.getText()), employee);
                }
            }
            resultLabel.setTextFill(Paint.valueOf("#0fe77e"));
            resultLabel.setText("Pracownik został dodany");
        } catch (Exception e) {
            e.printStackTrace();
            resultLabel.setTextFill(Paint.valueOf("#da0f0f"));
            resultLabel.setText("Niepoprawne dane");
        }
    }

    @FXML
    private void handleSelectByEmailButtonAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        String email = byEmailTextField.getText();
        Employee employee = EmployeeDAO.selectByEmail(email);
        firstNameLabel.setText(employee.getFirstName());
        lastNameLabel.setText(employee.getLastName());

        String imageSource = employee.getPictureURL();
        Image image = null;
        if (imageSource != null) {
            image = new Image(imageSource);
        } else {
            image = new Image(DEFAULT_PHOTO_URL);
        }
        imageView.setImage(image);
    }

}
