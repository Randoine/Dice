package dice.rav.com.dice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StandardActivity extends AppCompatActivity {

    private Dice dice;

    @BindView(R.id.list_of_results)
    RecyclerView mResultList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
        ButterKnife.bind(this);
        dice = new Dice(1, 6);

        //1. W jakim układzie ma się wyświetlać lista wyników
        //Układ pionowy 1- element na wiersz
        mResultList.setLayoutManager(new LinearLayoutManager(this));

        List<Result> results = new ArrayList<>();
        Result result = new Result();
        ArrayList<String> rollResults = new ArrayList<>();
        rollResults.add("10");
        rollResults.add("6");
        result.setResultArray(rollResults);
        results.add(result);

        result = new Result();
        rollResults = new ArrayList<>();
        rollResults.add("3");
        rollResults.add("2");
        result.setResultArray(rollResults);
        results.add(result);

        ResultListAdapter adapter = new ResultListAdapter(results);
        mResultList.setAdapter(adapter);
    }

    @OnClick(R.id.roll_button)
    void rollTheDice() {
        Integer result = dice.roll();
        Toast.makeText(this, String.format("Wylosowana liczba to %d", result), Toast.LENGTH_LONG).show();
    }



}
