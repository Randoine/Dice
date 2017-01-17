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

public class StandardActivity extends AppCompatActivity implements DiceActivitiesMethods {

    Dice dice;
    List<Result> results;
    Result result;
    ArrayList<String> rollResults;
    Integer rollResult;
    ResultListAdapter adapter;


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
        //2. Tworzy ArrayListę której elementy będą wyświetlane jako poszczególne wiersze listy
        results = new ArrayList<>();
        adapter = new ResultListAdapter(results, this);
        mResultList.setAdapter(adapter);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("results", );
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }



    @Override
    @OnClick(R.id.roll_button)
    public void rollTheDice() {
        rollResult = dice.roll();
        addResultToList(rollResult);
        result = new Result();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, String.format("Wylosowana liczba to %d", rollResult), Toast.LENGTH_LONG).show();
    }

    @Override
    public void addResultToList(int x) {
        rollResults = new ArrayList<>();
        rollResults.add(String.valueOf(x));
        result = new Result();
        result.setResultArray(rollResults);
        results.add(0, result);

    }
    
    
    // TODO: 2017-01-06 Zrobić żeby lista nie znikała po przekręceniu ekranu lub zablokować możliwość obrotu ekranu

    // TODO: Dodać action button jako przycisk do losowania



}
