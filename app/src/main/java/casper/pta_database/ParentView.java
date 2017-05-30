package casper.pta_database;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.concurrent.ExecutionException;

public class ParentView extends AppCompatActivity {
    ActionBar actionBar;
    ListView parentAssignments, parentGrades;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_view);
        actionBar = getSupportActionBar();
        parentAssignments = (ListView) findViewById(R.id.listParentAssignments);
        parentGrades = (ListView) findViewById(R.id.listParentGradeValues);
        actionBar.setTitle(ParentSelect.student.getCurrentClass());
        ArrayAdapter<String> arrayAdapterAssignments = new ArrayAdapter<String>(this, R.layout.list_view_custom, getAssignments());
        parentAssignments.setAdapter(arrayAdapterAssignments);
        ArrayAdapter<String> arrayAdapterGrades = new ArrayAdapter<String>(this, R.layout.list_view_custom, getGrades());
        parentGrades.setAdapter(arrayAdapterGrades);
    }

    private String[] getAssignments ()
    {
        String method = "get_columns";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, ParentSelect.student.getCurrentClass());
        String[] columns = new String [0];
        try {
            columns = serverTask.get().split(" ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return columns;
    }

    private String[] getGrades ()
    {
        String method = "get_grades";
        String[] assignments = getAssignments();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < assignments.length; i++)
        {
            stringBuilder.append(assignments[i]);
            if (i != assignments.length-1)
            {
                stringBuilder.append(", ");
            }
        }
        String columns = stringBuilder.toString();
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, ParentSelect.student.getCurrentClass(), ParentSelect.student.getName(), columns);
        String[] grades = new String[0];
        try {
            grades = serverTask.get().split(" ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return grades;
    }
}
