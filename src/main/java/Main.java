void main() {
    boolean running = true;
    while (running) {
        int exercise = Integer.parseInt(IO.readln("Which exercise (pick 0 to quit): "));
        IO.println();
        switch (exercise) {
            case 0 -> running = false;
            case 1 -> shoppingList();
            case 2 -> uniqueCities();
            default -> IO.println("No exercise of that number has been completed");
        }
        if(running)
        {
            IO.println();
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

private static void uniqueCities()
{
    String[] citiesToAdd = {"Stockholm", "Gothenburg", "Malmö", "Stockholm", "Uppsala", "Gothenburg", "Lund"};
    HashSet<String> citiesSet = new HashSet<>(Arrays.asList(citiesToAdd));
    for(String s : citiesSet)
    {
        IO.println(s);
    }
    IO.println(String.format("Total number of unique cities: %d", citiesSet.size()));
}