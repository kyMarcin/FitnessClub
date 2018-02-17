package sample.model;

import javafx.beans.property.*;

import java.math.BigDecimal;

/**
 * Created by Marcin on 16.02.2018.
 */
public class Ticket {

    private IntegerProperty ticketID;
    private StringProperty ticketName;
    private SimpleObjectProperty<BigDecimal> pricePerDay;
    private IntegerProperty noPersons;
    private IntegerProperty noDays;

    public Ticket() {
        ticketID = new SimpleIntegerProperty();
        ticketName = new SimpleStringProperty();
        pricePerDay = new SimpleObjectProperty<>();
        noPersons = new SimpleIntegerProperty();
        noDays = new SimpleIntegerProperty();
    }

    public int getTicketID(){
        return ticketID.get();
    }

    public IntegerProperty getTicketIDProperty() {
        return ticketID;
    }

    public void setTicketID(int ticketID) {
        this.ticketID.set(ticketID);
    }

    public String getTicketName() {
        return ticketName.get();
    }

    public StringProperty getTicketNameProperty() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName.set(ticketName);
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay.get();
    }

    public SimpleObjectProperty<BigDecimal> getPricePerDayProperty() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay.set(pricePerDay);
    }

    public int getNoPersons() {
        return noPersons.get();
    }

    public IntegerProperty getNoPersonsProperty() {
        return noPersons;
    }

    public void setNoPersons(int noPersons) {
        this.noPersons.set(noPersons);
    }

    public int getNoDays() {
        return noDays.get();
    }

    public IntegerProperty getNoDaysProperty() {
        return noDays;
    }

    public void setNoDays(int noDays) {
        this.noDays.set(noDays);
    }

}
