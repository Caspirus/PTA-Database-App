package casper.pta_database;

/**
 * Created by casper on 5/23/17.
 */

public class Teacher
{
    String teacherName;
    String tableName;
    String[] classes;

    public Teacher (String teacherName, String tableName, String[] classes)
    {
        this.teacherName = teacherName;
        this.tableName = tableName;
        this.classes = classes;
    }

    public void setTeacherName (String teacherName)
    {
        this.teacherName = teacherName;
    }

    public void setTableName (String tableName)
    {
        this.tableName = tableName;
    }

    public void setClasses (String[] classes)
    {
        this.classes = classes;
    }

    public String getTeacherName ()
    {
        return teacherName;
    }

    public String getTableName ()
    {
        return tableName;
    }

    public String[] getClasses ()
    {
        return classes;
    }
}
