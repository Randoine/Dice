package dice.rav.com.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomActivity extends AppCompatActivity implements DiceActivitiesMethods {

    @BindView(R.id.minimal_value_field)
    EditText mMinimalValue;
    @BindView(R.id.maximum_value_field)
    EditText mMaximumValue;
    @BindView(R.id.number_of_dices)
    EditText mNumberOfDices;
    @BindView(R.id.list_of_results)
    RecyclerView mResultList;

    private Dice dice;
    private int[] rollResults;
    Result result;
    ArrayList<Result> results;
    ResultListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        dice = new Dice();

        mResultList.setLayoutManager(new LinearLayoutManager(this));
        //2. Tworzy ArrayListę której elementy będą wyświetlane jako poszczególne wiersze listy
        results = new ArrayList<>();
        adapter = new ResultListAdapter(results, this);
        mResultList.setAdapter(adapter);
        if (savedInstanceState != null) {
            results = savedInstanceState.getParcelableArrayList("results");
            adapter.setmResults(results);
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("results", results);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        results = savedInstanceState.getParcelableArrayList("results");
        adapter.setmResults(results);
    }

    @Override
    @OnClick(R.id.roll_button)
    public void rollTheDice() {
        int numberOfDices = Integer.parseInt(mNumberOfDices.getText().toString());

        dice.setMinValue(Integer.parseInt(mMinimalValue.getText().toString()));
        dice.setMaxValue(Integer.parseInt(mMaximumValue.getText().toString()));

        if (dice.getMaxValue() < 0 || dice.getMinValue() < 0) {
            Toast.makeText(this, "Nieprawidłowy zakres", Toast.LENGTH_SHORT).show();
        }

        if (numberOfDices == 1) {
            try {
                Integer result = dice.roll();
                Toast.makeText(this, String.format("Wylosowana liczba to %d", result),
                        Toast.LENGTH_LONG).show();

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Nieprawidłowy zakres", Toast.LENGTH_SHORT).show();
            }
        } else if (numberOfDices > 1) {
            rollResults = new int[numberOfDices];
            try {
                for (int i = 0; i <= numberOfDices - 1; i++) {
                    rollResults[i] = dice.roll();
                }
                result = new Result();
                result.setResultArray(rollResults);
                results.add(0, result);
                adapter.notifyDataSetChanged();

                Toast.makeText(this, "Wylosowane liczby to " + Arrays.toString(rollResults),
                        Toast.LENGTH_LONG).show();

            } catch (NumberFormatException e) {
                Toast.makeText(this, "Nieprawidłowy zakres", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


