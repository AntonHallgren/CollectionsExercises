void main() {
    boolean running = true;
    while (running) {
        int exercise = Integer.parseInt(IO.readln("Which exercise (pick 0 to quit): "));
        IO.println();
        switch (exercise) {
            case 0 -> running = false;
            case 1 -> shoppingList();
            case 2 -> uniqueCities();
            case 3 -> phoneBook();
            case 4 -> findLargest(new int[]{14, 3, 78, 45, 22, 91, 7, 56});
            case 5 -> countByLetter(new String[]{"Anna", "Bob", "Alice", "Charlie", "Amanda", "David", "Amy", "Brian"});
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

private static void phoneBook()
{
    HashMap<String, String> phoneBook = new HashMap<>();
    phoneBook.put("Astrid", "1234567");
    phoneBook.put("Pippi", "8910111");
    phoneBook.put("Tommy", "2131415");
    phoneBook.put("Anika", "1617181");

    String name = IO.readln("Who do you want to look up: ");
    String number = phoneBook.get(name);
    if(number == null)
    {
        IO.println("Contact not found.");
        return;
    }
    IO.println("Their number is: " + number);
}

private static void findLargest(int[] list)
{
    int largest = list[0];//initiates on a number in the list to be sure that its value is not larger than the largest in the list
    for(int i = 1; i < list.length; i++)//does not need to check the first element again
    {
        largest = Math.max(largest, list[i]);
    }
    IO.println(String.format("Largest number found: %d", largest));
}

private static void countByLetter(String[] names)
{
    boolean validLetter = false;
    char letter = enterLetter();
    int count = 0;
    for(String s : names)
    {
        if(s == null || s.isEmpty())
        {
            continue;
        }
        if(Character.toUpperCase(s.charAt(0)) == letter)
        {
            count++;
        }
    }
    IO.println(String.format("Found %d names matching starting with letter %c", count, letter));
}

private static char enterLetter()
{
    while(true)
    {
        String entered = IO.readln("Enter a letter: ").trim();
        if(entered.length() > 1)
        {
            IO.println("Only one letter needed");
            continue;
        }
        else if(entered.isEmpty())
        {
            IO.println("At least one letter need");
            continue;
        }
        char letter = entered.charAt(0);
        if(!Character.isLetter(letter))
        {
            IO.println("That is not a letter");
            continue;
        }
        return Character.toUpperCase(letter);
    }
}