package casper.pta_database;

/**
 * Created by casper on 5/23/17.
 */

public class Student
{
    String name;
    String currentClass;

    public Student (String name, String currentClass)
    {
        this.name = name;
        this.currentClass = currentClass;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public void setCurrentClass (String currentClass)
    {
        this.currentClass = currentClass;
    }

    public String getName ()
    {
        return name;
    }

    public String getCurrentClass ()
    {
        return currentClass;
    }
}
