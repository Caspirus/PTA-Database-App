package casper.pta_database;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TeacherSelect extends AppCompatActivity {
    ListView courses;
    ActionBar actionBar;
    public static Teacher teacher = new Teacher("","",null);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_select);

        courses = (ListView) findViewById(R.id.listCourses);
        actionBar = getSupportActionBar();
        actionBar.setTitle(TeacherSelect.teacher.getTeacherName());
        allCourses();

        courses.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                teacher.setTableName(courses.getItemAtPosition(position).toString());
                startActivity(new Intent(TeacherSelect.this, TeacherEdit.class));
            }
        });
    }

    private void allCourses ()
    {
        String [] courseNames = TeacherSelect.teacher.getClasses();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, courseNames);
        courses.setAdapter(arrayAdapter);
    }
}
