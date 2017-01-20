package dice.rav.com.dice;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import android.widget.Toast;




import java.util.ArrayList;



import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class StandardActivity extends AppCompatActivity implements DiceActivitiesMethods {

    Dice dice;
    ArrayList<Result> results;
    Result result;
    int[] rollResults;
    int rollResult;
    ResultListAdapter adapter;
    int numberOfDices = 1;


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
        if (savedInstanceState!= null){
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
    @OnClick(R.id.action_button)
     public void rollTheDice() { //Losuje liczbę i dodaje do tabeli wyników
        rollResult = dice.roll();
        addResultToList(rollResult);
        result = new Result();
        adapter.notifyDataSetChanged();
        Toast.makeText(this, String.format("Wylosowana liczba to %d", rollResult), Toast.LENGTH_LONG).show();
    }

    @Override
     public void addResultToList(int x) {
        rollResults = new int[numberOfDices];
        rollResults[0]= x;
        result = new Result();
        result.setResultArray(rollResults);
        results.add(0, result);

    }

}
