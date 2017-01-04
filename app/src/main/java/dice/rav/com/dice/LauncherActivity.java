package dice.rav.com.dice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import butterknife.ButterKnife;
import butterknife.OnClick;

public class LauncherActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.custom_dice_button)
    void openCustomDiceScreen() {
        Intent openNextScreen = new Intent(this, CustomActivity.class);
        startActivity(openNextScreen);
    }

    @OnClick(R.id.standard_dice_button)
    void openStandardDiceScreen() {
        Intent openNextScreen = new Intent(this, StandardActivity.class);
        startActivity(openNextScreen);
    }

}
