package casper.pta_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class AdminInsertRecord extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_insert_record);

        final TextView tableName = (TextView) findViewById(R.id.textView4);
        tableName.setX(31);
        tableName.setY(55);

        final TextView columnName = (TextView) findViewById(R.id.textView3);
        columnName.setX(31);
        columnName.setY(355);

        final TextView dataEntry = (TextView) findViewById(R.id.textView5);
        dataEntry.setX(31);
        dataEntry.setY(655);

        final EditText enterTable = (EditText) findViewById(R.id.editText6);
        enterTable.setX(350);
        enterTable.setY(55);

        final EditText enterColumn = (EditText) findViewById(R.id.editText5);
        enterColumn.setX(350);
        enterColumn.setY(355);

        final EditText enterData = (EditText) findViewById(R.id.editText7);
        enterData.setX(350);
        enterData.setY(655);

        final Button insertRecord = (Button) findViewById(R.id.button7);
        insertRecord.setX(400);
        insertRecord.setY(800);

        insertRecord.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                //Insert Record
            }
        });
    }
}
