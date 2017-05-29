package casper.pta_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class AdminCreateTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_create_table);

        final TextView tableName = (TextView) findViewById(R.id.textView);
        tableName.setX(113);
        tableName.setY(60);

        final TextView primaryKey = (TextView) findViewById(R.id.textView2);
        primaryKey.setX(113);
        primaryKey.setY(360);

        final EditText enterTable = (EditText) findViewById(R.id.editText3);
        enterTable.setX(360);
        enterTable.setY(50);

        final EditText enterPrimaryKey = (EditText) findViewById(R.id.editText4);
        enterPrimaryKey.setX(360);
        enterPrimaryKey.setY(350);

        final Button createTable = (Button) findViewById(R.id.button3);
        createTable.setX(700);
        createTable.setY(500);

        createTable.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
            //Creates table
            }
        });
    }
}
