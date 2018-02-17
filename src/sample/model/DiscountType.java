package sample.model;

import javafx.beans.property.*;

/**
 * Created by Marcin on 17.02.2018.
 */
public class DiscountType {

    private IntegerProperty discountID;
    private StringProperty discountName;
    private FloatProperty percentDiscount;

    public DiscountType() {
        discountID = new SimpleIntegerProperty();
        discountName = new SimpleStringProperty();
        percentDiscount = new SimpleFloatProperty();
    }

    public int getDiscountID(){
        return discountID.get();
    }

    public IntegerProperty getDiscountIDProperty(){
        return discountID;
    }

    public void setDiscountID(int discountID) {
        this.discountID.set(discountID);
    }

    public String getDiscountName(){
        return discountName.get();
    }

    public StringProperty getDiscountNameProperty(){
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName.set(discountName);
    }

    public float getPercentDiscount(){
        return percentDiscount.get();
    }

    public FloatProperty getPercentDiscountProperty(){
        return percentDiscount;
    }

    public void setPercentDiscount(float percentDiscount) {
        this.percentDiscount.set(percentDiscount);
    }

}
