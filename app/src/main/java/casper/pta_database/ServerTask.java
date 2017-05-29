package casper.pta_database;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by casper on 5/17/17.
 */

public class ServerTask extends AsyncTask <String, Void, String> {
    AlertDialog alertDialog;
    private Context context;

    ServerTask (Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Information:");
    }

    @Override
    protected String doInBackground(String... params) {
        String insertStringUrl = "http://138.68.245.206/webapp/insert_string.php";
        String loginUrl = "http://138.68.245.206/webapp/login.php";
        String getNameUrl = "http://138.68.245.206/webapp/get_name.php";
        String getColumnsUrl = "http://138.68.245.206/webapp/get_columns.php";
        String insertColumnUrl = "http://138.68.245.206/webapp/insert_column.php";
        String insertGradeUrl = "http://138.68.245.206/webapp/insert_grade.php";
        String dropColumnUrl = "http://138.68.245.206/webapp/drop_column.php";
        String getStudentUrl = "http://138.68.245.206/webapp/get_student.php";
        String getColumnCountUrl = "http://138.68.245.206/webapp/get_column_count.php";
        String getGradesUrl = "http://138.68.245.206/webapp/get_grades.php";
        String updateGradeUrl = "http://138.68.245.206/webapp/update_grade.php";
        String getStudentClassesUrl = "http://138.68.245.206/webapp/get_student_classes.php";
        String parentLoginUrl = "http://138.68.245.206/webapp/parent_login.php";
        String method = params[0];
        String tableName, colName, record, userName, password, studentName, columns, column, tables;

        switch (method)
        {
            case "insert_string":
                tableName = params[1];
                colName = params[2];
                record = params[3];
                try {
                    URL url = new URL (insertStringUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("col_name", "UTF-8") + "=" + URLEncoder.encode(colName, "UTF-8") + "&" +
                            URLEncoder.encode("record", "UTF-8") + "=" + URLEncoder.encode(record, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return "Success!";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "login":
                userName = params[1];
                password = params[2];
                try {
                    String response = "";
                    String line = "";
                    URL url = new URL (loginUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8") + "&" +
                            URLEncoder.encode("user_password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        response += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "get_name":
                tableName = params[1];
                try {
                    String names = "";
                    String line = "";
                    URL url = new URL (getNameUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        names += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return names;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "get_columns":
                tableName = params[1];
                try {
                    String getColumns = "";
                    String line = "";
                    URL url = new URL (getColumnsUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        getColumns += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return getColumns;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "insert_column":
                tableName = params[1];
                colName = params[2];
                try {
                    URL url = new URL (insertColumnUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("col_name", "UTF-8") + "=" + URLEncoder.encode(colName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return colName + " added!";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "insert_grade":
                tableName = params[1];
                colName = params[2];
                studentName = params[3];
                record = params[4];
                try {
                    URL url = new URL (insertGradeUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("col_name", "UTF-8") + "=" + URLEncoder.encode(colName, "UTF-8") + "&" +
                            URLEncoder.encode("record", "UTF-8") + "=" + URLEncoder.encode(record, "UTF-8") + "&" +
                            URLEncoder.encode("student_name", "UTF-8") + "=" + URLEncoder.encode(studentName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return studentName + "'s grade added!";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "drop_column":
                tableName = params[1];
                colName = params[2];
                try {
                    URL url = new URL(dropColumnUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("col_name", "UTF-8") + "=" + URLEncoder.encode(colName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return colName + " dropped!";
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "get_student":
                tableName = params[1];
                studentName = params[2];
                try {
                    String info = "";
                    String line = "";
                    URL url = new URL (getStudentUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("student_name", "UTF-8") + "=" + URLEncoder.encode(studentName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        info += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return info;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "get_column_count":
                tableName = params[1];
                try {
                    String num = "";
                    String line = "";
                    URL url = new URL (getColumnCountUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        num += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return num;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "get_grades":
                tableName = params[1];
                studentName = params[2];
                columns = params[3];
                try {
                    String grades = "";
                    String line = "";
                    URL url = new URL (getGradesUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("student_name", "UTF-8") + "=" + URLEncoder.encode(studentName, "UTF-8") + "&" +
                            URLEncoder.encode("col_name", "UTF-8") + "=" + URLEncoder.encode(columns, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        grades += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return grades;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "update_grade":
                tableName = params[1];
                column = params[2];
                studentName = params[3];
                record = params[4];
                try {
                    URL url = new URL (updateGradeUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("table_name", "UTF-8") + "=" + URLEncoder.encode(tableName, "UTF-8") + "&" +
                            URLEncoder.encode("student_name", "UTF-8") + "=" + URLEncoder.encode(studentName, "UTF-8") + "&" +
                            URLEncoder.encode("col_name", "UTF-8") + "=" + URLEncoder.encode(column, "UTF-8") + "&" +
                            URLEncoder.encode("record", "UTF-8") + "=" + URLEncoder.encode(record, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return "Grade changed to " + record;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "get_student_classes":
                studentName = params[1];
                try {
                    String classes = "";
                    String line = "";
                    URL url = new URL (getStudentClassesUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("student_name", "UTF-8") + "=" + URLEncoder.encode(studentName, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        classes += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return classes;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "parent_login":
                userName = params[1];
                password = params[2];
                try {
                    String response = "";
                    String line = "";
                    URL url = new URL (parentLoginUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setRequestMethod("POST");
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(userName, "UTF-8") + "&" +
                            URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                    bufferedWriter.write(data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();

                    InputStream inputStream = httpURLConnection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                    while ((line = bufferedReader.readLine()) != null)
                    {
                        response += line;
                    }
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return response;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        if (result.equals("Success")) {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
        else if (result.contains("added!"))
        {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
        else if (result.contains("grade added!"))
        {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
        else if (result.contains(" dropped!"))
        {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
        else if (result.contains("changed"))
        {
            Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        }
    }
}
