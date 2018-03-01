package sample.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Marcin on 19.02.2018.
 */
public class JobPosition {

    private IntegerProperty jobPositionID;
    private StringProperty jobPositionName;

    public JobPosition() {
        jobPositionID = new SimpleIntegerProperty();
        jobPositionName = new SimpleStringProperty();
    }


    public int getJobPositionID(){
        return jobPositionID.get();
    }

    public IntegerProperty getJobPositionIDProperty(){
        return jobPositionID;
    }

    public void setJobPositionID(int jobPositionID) {
        this.jobPositionID.set(jobPositionID);
    }

    public String getJobPositionName(){
        return jobPositionName.get();
    }

    public StringProperty getJobPositionNameProperty(){
        return jobPositionName;
    }

    public void setJobPositionName(String jobPositionName) {
        this.jobPositionName.set(jobPositionName);
    }
}
