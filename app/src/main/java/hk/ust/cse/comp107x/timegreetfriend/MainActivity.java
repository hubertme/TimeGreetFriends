package hk.ust.cse.comp107x.timegreetfriend;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    Button greetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get a reference to the greetButton on the UI
        greetButton = (Button) findViewById(R.id.greetButton);
        // Set the onClickListener for the greetButton to be this class.
        // This requires that the class implement the View.OnClickListener callback
        // the onClick() method
        greetButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        // get a reference to the TextView on the UI
        TextView textMessage = (TextView) findViewById(R.id.textMessage);

        //get a reference to the EditText so that we can read in the value typed
        // by the user
        EditText editFriendName = (EditText) findViewById(R.id.editFriendName);

        // get the name of the friend typed in by the user in the EditText field
        String friendName = editFriendName.getText().toString();

        // TODO 1
        if (v.getId() == R.id.greetButton){
            String greeting = "Hi, ";

            // Create calendar
            Calendar calendar = Calendar.getInstance();
            Date date = new Date();
            calendar.setTime(date);
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            if (hour >= 5 && hour <= 11){
                textMessage.setText(getString(R.string.goodmorning)+friendName+"!");
            } else if (hour <= 18){
                textMessage.setText(getString(R.string.goodafternoon)+friendName+"!");
            } else if (hour <= 22){
                textMessage.setText(getString(R.string.goodevening)+friendName+"!");
            } else {
                textMessage.setText(getString(R.string.goodnight)+friendName+"!");
            }
            editFriendName.setText("");
        }
    }
}
