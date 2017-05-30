package casper.pta_database;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

import org.apache.commons.codec.binary.Hex;

public class MainActivity extends AppCompatActivity {
    EditText userName, password;
    ActionBar actionBar;
    Button button;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();
        userName = (EditText) findViewById(R.id.editLoginUser);
        password = (EditText) findViewById(R.id.editLoginPassword);
        button = (Button) findViewById(R.id.buttonLogin);
        actionBar.setTitle("Palm Tree Academy");
        button.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                teacherLogin();
            }
        });
    }

    private void teacherLogin ()
    {
        String loginUser = userName.getText().toString();
        String loginPassword = password.getText().toString();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(loginPassword.getBytes("UTF-8"));
            loginPassword = new String (Hex.encodeHex(hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String method = "login";
        ServerTask serverTask = new ServerTask(this);
        serverTask.execute(method, loginUser, loginPassword);

        try {
            String serverLogin = serverTask.get();
            switch (serverLogin)
            {
                case "Rasha Hakim":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"Math_7", "Science_7", "ELA_7", "Texas_History"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Linda Jaramillo":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"Math_PK", "Reading_PK", "Skills_PK"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Jamila Ayad":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"ArabicMath_PK", "ALR_PK","Quran_PK", "ArabicMath_K", "ALR_K", "ArabicMath_1", "ALR_1"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Theresa Aldana":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"Math_K","Science_K", "SS_K", "ELA_K", "Math_1", "Science_1", "SS_1", "ELA_1"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Wesley Smith":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"PE_K", "PE_1", "PE_2_3", "PE_4_5", "PE_7"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Sahar Abuarja":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"IslamicStudies_K", "IslamicStudies_1", "Arabic_2", "Arabic_3", "Arabic_4", "Arabic_5"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Christine Sanchez":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"Math_2_3", "Science_2_3", "Math_4_5", "Science_4_5"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Ana Gomez":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"SS_2_3", "ELA_2_3", "SS_4_5", "ELA_4_5"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Heba Ahmed":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"Quran_2_3", "IslamicStudies_2_3", "Quran_4_5"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Sina'a Ali":
                    TeacherSelect.teacher.setTeacherName(serverLogin);
                    TeacherSelect.teacher.setClasses(new String[]{"IslamicStudies_4_5", "Arabic_7", "Quran_7", "IslamicStudies_7"});
                    startActivity(new Intent(MainActivity.this, TeacherSelect.class));
                    break;
                case "Sam":
                    ParentSelect.student.setName(serverLogin);
                    startActivity(new Intent(MainActivity.this, ParentSelect.class));
                    break;
                case "Paul":
                    ParentSelect.student.setName(serverLogin);
                    startActivity(new Intent(MainActivity.this, ParentSelect.class));
                    break;
                case "Aya":
                    ParentSelect.student.setName(serverLogin);
                    startActivity(new Intent(MainActivity.this, ParentSelect.class));
                    break;
                case "Aisha":
                    ParentSelect.student.setName(serverLogin);
                    startActivity(new Intent(MainActivity.this, ParentSelect.class));
                    break;
                case "Ziad":
                    ParentSelect.student.setName(serverLogin);
                    startActivity(new Intent(MainActivity.this, ParentSelect.class));
                    break;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
