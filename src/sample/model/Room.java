package sample.model;

import javafx.beans.property.*;

import java.math.BigDecimal;

/**
 * Created by Marcin on 15.02.2018.
 */
public class Room {

    private IntegerProperty roomID;
    private StringProperty roomName;
    private SimpleObjectProperty<BigDecimal> pricePerHour;

    public Room() {
        roomID = new SimpleIntegerProperty();
        roomName = new SimpleStringProperty();
        pricePerHour = new SimpleObjectProperty<>();
    }

    public int getRoomID() {
        return roomID.get();
    }

    public IntegerProperty getRoomIDProperty() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID.set(roomID);
    }


    public String getRoomName() {
        return roomName.get();
    }

    public StringProperty getRoomNameProperty() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName.set(roomName);
    }


    public BigDecimal getPricePerHour() {
        return pricePerHour.get();
    }

    public SimpleObjectProperty<BigDecimal> getPricePerHourProperty() {
        return pricePerHour;
    }

    public void setPricePerHour(BigDecimal pricePerHour) {
        this.pricePerHour.set(pricePerHour);
    }
}
