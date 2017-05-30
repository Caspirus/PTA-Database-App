package casper.pta_database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import android.support.v7.app.ActionBar;

import java.util.concurrent.ExecutionException;

public class StudentInformation extends AppCompatActivity {
    ListView assignments, grades;
    ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_information);
        actionBar = getSupportActionBar();
        assignments = (ListView) findViewById(R.id.listAssignments);
        grades = (ListView) findViewById(R.id.listGradeValues);
        actionBar.setTitle(TeacherEdit.student.getName());
        ArrayAdapter<String> arrayAdapterAssignments = new ArrayAdapter<String>(this, R.layout.list_view_custom, getAssignments());
        assignments.setAdapter(arrayAdapterAssignments);
        ArrayAdapter<String> arrayAdapterGrades = new ArrayAdapter<String>(this, R.layout.list_view_custom, getGrades());
        grades.setAdapter(arrayAdapterGrades);
    }


    private String[] getAssignments ()
    {
        String method = "get_columns";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName());
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
        serverTask.execute(method, TeacherSelect.teacher.getTableName(), TeacherEdit.student.getName(), columns);
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
