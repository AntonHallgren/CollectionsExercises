
/*
Which collection to use?
Duplicates are not allowed, so we are not picking a list.
We don't care about any additional data (such as what was submitted),
so we do not need a map.
This means a Set is probably best.
Since we don't care about order, a HashSet is the most efficient.
*/

import java.util.HashSet;

public class SubmissionTracker {
    private final HashSet<String> nameList = new HashSet<>();

    public void studentSubmitted(String studentName)
    {
        if(nameList.contains(studentName))
        {
            IO.println(String.format("Submission rejected. %s has already submitted", studentName));
        }
        else
        {
            nameList.add(studentName);
        }
    }

    public void print()
    {
        IO.println("Submission received from the following students: ");
        for(String name : nameList)
        {
            IO.println(name);
        }
    }
}
