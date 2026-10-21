/*
* There is an interface called Queue, so checking what
* implements that seems like a good start
* ArrayDequeue seems like an ok pick, cannot say whether
* any other would be more appropriate
* */

import java.util.ArrayDeque;

public class ConcertQueue {

    private final ArrayDeque<String> queue = new ArrayDeque<>();

    public void add(String name)
    {
        queue.add(name);
    }

    public void letIn()
    {
        if(queue.isEmpty())
        {
            IO.println("No one is standing in line");
            return;
        }
        String name = queue.remove();
        IO.println(name + " was let in");
    }

    public void print()
    {
        IO.println("People still in queue: ");
        for(String name : queue)
        {
            IO.println(name);
        }
    }

}
