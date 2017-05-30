package casper.pta_database;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.concurrent.ExecutionException;


public class TeacherEdit extends AppCompatActivity {
    Button insertGrade, insertAssignment, dropAssignment, deleteGrade;
    Spinner names, assignments, dropAssignments;
    EditText assignmentName, gradeValue;
    ListView listNames;
    ActionBar actionBar;
    public static Student student = new Student ("","");

    public TeacherEdit() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_edit);
        actionBar = getSupportActionBar();
        insertGrade = (Button) findViewById(R.id.buttonInsertGrade);
        names = (Spinner) findViewById(R.id.spinner);
        assignments = (Spinner) findViewById(R.id.spinner2);
        insertAssignment = (Button) findViewById(R.id.buttonInsertAssignment);
        assignmentName = (EditText) findViewById(R.id.editTextAssignmentName);
        gradeValue = (EditText) findViewById(R.id.editGradeValue);
        listNames = (ListView) findViewById(R.id.listNames);
        dropAssignments = (Spinner) findViewById(R.id.spinnerDropAssignment);
        dropAssignment = (Button) findViewById(R.id.button);
        deleteGrade = (Button) findViewById(R.id.buttonDeleteGrade);
        actionBar.setTitle(TeacherSelect.teacher.getTableName());
        displayNameData();
        displayAssignmnentData(assignments);
        displayAssignmnentData(dropAssignments);
        allNames();
        insertGrade.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                insertGrade ();
            }
        });
        insertAssignment.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                insertAssignment();
                displayAssignmnentData(assignments);
                displayAssignmnentData(dropAssignments);
            }
        });
        listNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                student.setName(listNames.getItemAtPosition(position).toString());
                startActivity(new Intent(TeacherEdit.this, StudentInformation.class));
            }
        });
        dropAssignment.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                dropAssignment();
                displayAssignmnentData(assignments);
                displayAssignmnentData(dropAssignments);
            }
        });
        deleteGrade.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View v)
            {
                deleteGrade();
                gradeValue.setText("");
            }
        });
    }

    private void insertGrade ()
    {
        String method = "insert_grade";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName(), assignments.getSelectedItem().toString(),
                names.getSelectedItem().toString(), gradeValue.getText().toString());
    }

    private void deleteGrade ()
    {
        String method = "update_grade";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName(), assignments.getSelectedItem().toString(),
                names.getSelectedItem().toString(), gradeValue.getText().toString());
    }

    private void displayNameData ()
    {
        String method = "get_name";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName());
        String [] studentNames = new String[0];
        try {
            studentNames = serverTask.get().split(",");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_custom, studentNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        names.setAdapter(arrayAdapter);
        names.setEnabled(true);
    }

    private void allNames ()
    {
        String method = "get_name";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName());
        String [] studentNames = new String[0];
        try {
            studentNames = serverTask.get().split(",");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, studentNames);
        listNames.setAdapter(arrayAdapter);
    }

    private void displayAssignmnentData (Spinner spinner)
    {
        String method = "get_columns";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName());
        String[] columnNames = new String[0];
        try {
            columnNames = serverTask.get().split(" ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_view_custom, columnNames);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setEnabled(true);
    }

    private void insertAssignment ()
    {
        String column = assignmentName.getText().toString();
        String method = "insert_column";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName(), column);
    }

    private void dropAssignment ()
    {
        String column = dropAssignments.getSelectedItem().toString();
        String method = "drop_column";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, TeacherSelect.teacher.getTableName(), column);
    }
}