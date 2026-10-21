void main() {
    boolean running = true;
    while (running) {
        int exercise = Integer.parseInt(IO.readln("Which exercise (pick 0 to quit): "));
        switch (exercise) {
            case 0 -> running = false;
            case 1 -> shoppingList();
            default -> IO.println("No exercise of that number has been completed");
        }
    }
}

private static void shoppingList() {
    ArrayList<String> shoppingList = new ArrayList<>();
    shoppingList.add("Bread");
    shoppingList.add("Milk");
    shoppingList.add("Cheese");
    shoppingList.add("Eggs");
    shoppingList.add("Apples");
    printNumberedList(shoppingList);
    IO.println();
    IO.println("(Removing \"Eggs\")");
    shoppingList.remove("Eggs");
    IO.println();
    printNumberedList(shoppingList);
}

private static void printNumberedList(ArrayList<String> list)
{
    for(int i = 0; i < list.size(); i++)
    {
        IO.println(String.format("%d: %s", i, list.get(i)));
    }
}