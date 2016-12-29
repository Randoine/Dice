package dice.rav.com.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.minimal_value_edit_field)
    EditText mMinimalValue;
    @BindView(R.id.maximum_value_edit_field)
    EditText mMaximumValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.roll_button)
    void rollTheDice(){
        Dice dice = new Dice(Integer.parseInt(mMinimalValue.getText().toString()),Integer.parseInt(mMaximumValue.getText().toString()));
        Integer result = dice.roll();
        Toast.makeText(this,String.format("Wylosowana liczba to %d", result),Toast.LENGTH_LONG).show();
    }

}
