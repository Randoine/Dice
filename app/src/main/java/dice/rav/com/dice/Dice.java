package dice.rav.com.dice;



public class Dice implements Rollable {
    public Integer minValue;
    public Integer maxValue;

    public Dice(Integer minValue, Integer maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

        public Integer getMinValue() {
        return minValue;
    }

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public int roll() {

        Integer range = (maxValue - minValue) + 1;
        Double result = ((Math.random() * range) + minValue);
        return result.intValue();
    }
}
