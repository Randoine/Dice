package dice.rav.com.dice;



public class Dice implements Rollable {
    public int minValue;
    public int maxValue;

    public Dice(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

        public int getMinValue() {
        return minValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    @Override
    public int roll() {
        int range = (maxValue - minValue) + 1;
        return (int)(Math.random() * range) + minValue;
    }
}
