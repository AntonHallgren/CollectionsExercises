/*
* Since we want to be able to find student grade by name,
* a Map would be appropriate. Emphasis on quickly, which means
* HashMap is the best option.
* We also want to be able to sort based on scores, but from what
* I could find there is no way the Map can assist with that. Instead,
* we will have to sort the names separately, and rellie on the efficiency
* of the HashMap to not make the sorting take to long.
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentGrades
{
    private final HashMap<String, Integer> grades = new HashMap<>();


    public void add(String name, int grade)
    {
        grades.put(name, grade);
    }

    public void printInOrder()
    {
        List<String> names = sortedStudents();
        for(String name : names)
        {
            IO.println(String.format("Student: %s with grade  %d", name, grades.get(name)));
        }
    }

    private List<String> sortedStudents()
    {
        ArrayList<String> names = new ArrayList<>(grades.keySet());
        names.sort((n1, n2)->(grades.get(n1) - grades.get(n2)));

        return names;
    }
}
