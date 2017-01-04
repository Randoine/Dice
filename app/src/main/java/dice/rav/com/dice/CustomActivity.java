package dice.rav.com.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomActivity extends AppCompatActivity {

    @BindView(R.id.minimal_value_field)
    EditText mMinimalValue;
    @BindView(R.id.maximum_value_field)
    EditText mMaximumValue;

    private Dice dice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dice = new Dice();
    }


    @OnClick(R.id.roll_button)
    void rollTheDice() {
        try {
            dice.setMinValue(Integer.parseInt(mMinimalValue.getText().toString()));
            dice.setMaxValue(Integer.parseInt(mMaximumValue.getText().toString()));

            if (dice.getMaxValue() < 0 || dice.getMinValue() < 0) {
                Toast.makeText(this, "Nieprawidłowy zakres", Toast.LENGTH_SHORT).show();
            }
            Integer result = dice.roll();
            Toast.makeText(this, String.format("Wylosowana liczba to %d", result), Toast.LENGTH_LONG).show();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Nieprawidłowy zakres", Toast.LENGTH_SHORT).show();
        }
    }
}


