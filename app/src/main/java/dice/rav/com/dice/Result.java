package dice.rav.com.dice;


import android.os.Parcel;
import android.os.Parcelable;

public class Result implements Parcelable {
    private int[] resultArray;


    public Result() {
        resultArray = new int[1];
    }

    public Result(int x) {
        resultArray = new int[x];
    }

    protected Result(Parcel in) {
        resultArray = in.createIntArray();
    }

    public static final Creator<Result> CREATOR = new Creator<Result>() {
        @Override
        public Result createFromParcel(Parcel in) {
            return new Result(in);
        }

        @Override
        public Result[] newArray(int size) {
            return new Result[size];
        }
    };

    public int[] getResultArray() {
        return resultArray;
    }

    public void setResultArray(int[] resultArray) {
        this.resultArray = resultArray;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeIntArray(resultArray);
    }



}
