package dice.rav.com.dice;

import java.io.Serializable;
import java.util.ArrayList;


public class Result {
    private ArrayList<String> resultArray;
    private int arraySize;

    public ArrayList getResultArray() {
        return resultArray;
    }

    public void setResultArray(ArrayList resultArray) {
        this.resultArray = resultArray;
    }

    public int getArraySize() {
        return arraySize;
    }

    public void setArraySize(int arraySize) {
        this.arraySize = arraySize;
    }

}
