package casper.pta_database;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminSelect extends AppCompatActivity {
    Button createTable, insertRecord, insertColumns, viewData;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_select);

        ServerTask serverTask = new ServerTask(this);
        /*alertDialog = new AlertDialog.Builder(serverTask.getContext()).create();
        alertDialog.setTitle("Login Information:");
        alertDialog.setMessage(serverTask.getResult());
        alertDialog.show();*/

        createTable = (Button) findViewById(R.id.button2);
        createTable.setX(16);
        createTable.setY(64);

        insertRecord = (Button) findViewById(R.id.button6);
        insertRecord.setX(16);
        insertRecord.setY(264);

        insertColumns = (Button) findViewById(R.id.button5);
        insertColumns.setX(16);
        insertColumns.setY(464);

        viewData = (Button) findViewById(R.id.button4);
        viewData.setX(16);
        viewData.setY(664);

        createTable.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                startActivity(new Intent(AdminSelect.this, AdminCreateTable.class));
            }
        });

        insertRecord.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                startActivity(new Intent(AdminSelect.this, AdminInsertRecord.class));
            }
        });

        insertColumns.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                //Opens adminInsertColumns
            }
        });

        viewData.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                //Opens adminView Data
            }
        });
    }
}
