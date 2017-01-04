package dice.rav.com.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StandardActivity extends AppCompatActivity {

    private Dice dice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        ButterKnife.bind(this);
        dice = new Dice(1, 6);
    }

    @OnClick(R.id.roll_button)
    void rollTheDice() {
        Integer result = dice.roll();
        Toast.makeText(this, String.format("Wylosowana liczba to %d", result), Toast.LENGTH_LONG).show();
    }

}
