import java.util.ArrayList;

public class Main {


    static void main() {
        boolean running = true;
        while(running)
        {
            int exercise = Integer.parseInt(IO.readln("Which exercise (pick 0 to quit): "));
            switch (exercise)
            {
                case 0 -> running = false;
                case 1 -> shoppingList();
                default -> IO.println("No exercise of that number has been completed");
            }
        }
    }

    static void shoppingList()
    {
        ArrayList<String> shoppingList = new ArrayList<>();
        shoppingList.add("Bread");
        shoppingList.add("Milk");
        shoppingList.add("Cheese");
        shoppingList.add("Eggs");
        shoppingList.add("Apples");
    }
}
