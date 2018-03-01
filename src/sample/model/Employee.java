package sample.model;

import javafx.beans.property.*;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Marcin on 18.02.2018.
 */
public class Employee {

    private IntegerProperty employeeID;
    private StringProperty firstName;
    private StringProperty middleName;
    private StringProperty lastName;
    private StringProperty nin;
    private StringProperty nationality;
    private StringProperty gender;
    private SimpleObjectProperty<Date> dateOfBirth;
    private SimpleObjectProperty<Date> dateJoined;
    private StringProperty telephoneNumber;
    private StringProperty streetAddress;
    private StringProperty city;
    private StringProperty zipCode;
    private StringProperty email;
    private StringProperty pictureURL;
    private BooleanProperty isActive;
    private SimpleObjectProperty<BigDecimal> salary;

    public Employee(){

        employeeID = new SimpleIntegerProperty();
        firstName = new SimpleStringProperty();
        middleName = new SimpleStringProperty();
        lastName = new SimpleStringProperty();
        nin = new SimpleStringProperty();
        nationality = new SimpleStringProperty();
        gender = new SimpleStringProperty();
        dateOfBirth = new SimpleObjectProperty<>();
        dateJoined = new SimpleObjectProperty<>();
        telephoneNumber = new SimpleStringProperty();
        streetAddress = new SimpleStringProperty();
        city = new SimpleStringProperty();
        zipCode = new SimpleStringProperty();
        email = new SimpleStringProperty();
        pictureURL = new SimpleStringProperty();
        isActive = new SimpleBooleanProperty();
        salary = new SimpleObjectProperty<>();
    }


    public int getEmployeeID(){
        return employeeID.get();
    }

    public IntegerProperty getEmployeeIDProperty(){
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID.set(employeeID);
    }

    public String getFirstName(){
        return firstName.get();
    }

    public StringProperty getFirstNameProperty(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getMiddleName(){
        return middleName.get();
    }

    public StringProperty getMiddleNameProperty(){
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName.set(middleName);
    }

    public String getLastName(){
        return lastName.get();
    }

    public StringProperty getLastNameProperty(){
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getNin(){
        return nin.get();
    }

    public StringProperty getNinProperty(){
        return nin;
    }

    public void setNin(String nin) {
        this.nin.set(nin);
    }

    public String getNationality(){
        return nationality.get();
    }

    public StringProperty getNationalityProperty(){
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality.set(nationality);
    }

    public String getGender(){
        return gender.get();
    }

    public StringProperty getGenderProperty(){
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public Date  getDateOfBirth(){
        return dateOfBirth.get();
    }

    public SimpleObjectProperty<Date> getDateOfBirthProperty(){
        return dateOfBirth;
    }

    public void setDateOfBirth(Date  dateOfBirth) {
        this.dateOfBirth.set(dateOfBirth);
    }

    public Date  getDateJoined(){
        return dateJoined.get();
    }

    public SimpleObjectProperty<Date> getDateJoinedProperty(){
        return dateJoined;
    }

    public void setDateJoined(Date  dateJoined) {
        this.dateJoined.set(dateJoined);
    }

    public String getTelephoneNumber(){
        return telephoneNumber.get();
    }

    public StringProperty getTelephoneNumberProperty(){
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber.set(telephoneNumber);
    }

    public String getStreetAddress(){
        return streetAddress.get();
    }

    public StringProperty getStreetAddressProperty(){
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress.set(streetAddress);
    }

    public String getCity(){
        return city.get();
    }

    public StringProperty getCityProperty(){
        return city;
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public String getZipCode(){
        return zipCode.get();
    }

    public StringProperty getZipCodeProperty(){
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode.set(zipCode);
    }

    public String getEmail(){
        return email.get();
    }

    public StringProperty getEmailProperty(){
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPictureURL(){
        return pictureURL.get();
    }

    public StringProperty getPictureURLProperty(){
        return pictureURL;
    }

    public void setPictureURL(String pictureURL) {
        this.pictureURL.set(pictureURL);
    }

    public boolean getIsActive(){
        return isActive.get();
    }

    public BooleanProperty getIsActiveProperty(){
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive.set(isActive);
    }

    public BigDecimal  getSalary(){
        return salary.get();
    }

    public SimpleObjectProperty<BigDecimal> getSalaryProperty(){
        return salary;
    }

    public void setSalary(BigDecimal  salary) {
        this.salary.set(salary);
    }

}
