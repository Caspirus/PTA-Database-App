package casper.pta_database;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent;

import java.util.concurrent.ExecutionException;

public class ParentSelect extends AppCompatActivity {
    ListView allClasses;
    ActionBar actionBar;
    public static Student student = new Student ("","");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_select);
        actionBar = getSupportActionBar();
        allClasses = (ListView) findViewById(R.id.listAllClasses);
        actionBar.setTitle(student.getName());
        ArrayAdapter<String> arrayAdapterGrades = new ArrayAdapter<String>(this, R.layout.list_view_custom, getStudentClasses());
        allClasses.setAdapter(arrayAdapterGrades);
        allClasses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                student.setCurrentClass(allClasses.getItemAtPosition(position).toString());
                startActivity(new Intent(ParentSelect.this, ParentView.class));
            }
        });

    }

    private String[] getStudentClasses ()
    {
        String[] result = new String[0];
        String method = "get_student_classes";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, student.getName());
        try {
            result = serverTask.get().split(",");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return result;
    }
}
