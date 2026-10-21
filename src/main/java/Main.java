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
            case 4 -> findLargest(Arrays.asList(14, 3, 78, 45, 22, 91, 7, 56));
            case 5 -> countByLetter(Arrays.asList("Anna", "Bob", "Alice", "Charlie", "Amanda", "David", "Amy", "Brian"));
            case 6 -> wordFrequency(Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple", "grape", "orange"));
            case 7 -> exercise7();
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

private static void printNumberedList(List<String> list)
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

private static void findLargest(List<Integer> numbers)
{
    int largest = numbers.getFirst();//initiates on a number in the list to be sure that its value is not larger than the largest in the list
    for(int i = 1; i < numbers.size(); i++)//does not need to check the first element again
    {
        largest = Math.max(largest, numbers.get(i));
    }
    IO.println(String.format("Largest number found: %d", largest));
}

private static void countByLetter(List<String> names)
{
    char letter = enterLetter();
    int count = 0;
    for(String s : names)
    {
        if(s == null || s.isEmpty())
        {
            continue;
        }
        if(Character.toUpperCase(s.charAt(0)) == Character.toUpperCase(letter))
        {
            count++;
        }
    }
    IO.println(String.format("Found %d names starting with letter %c", count, letter));
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
        return letter;
    }
}

private static void wordFrequency(List<String> words)
{
    TreeMap<String, Integer> map = new TreeMap<>();
    for(String s : words)
    {
        //Intellij suggested this formulation
        //I am not that familiar with maps, so I had to look up what it does
        //Seems like what I want
        map.merge(s, 1, Integer::sum);
    }
    for(String key : map.keySet())
    {
        IO.println(String.format("The word %s appeared %d times. ", key, map.get(key)));
    }
}

private static void exercise7()
{
    Integer[] numbers = {4, 7, 2, 7, 9, 4, 1, 9, 3};
    ArrayList<Integer> list = removeDuplicatesKeepOrder(Arrays.asList(numbers));
    IO.println(list);
}

private static ArrayList<Integer> removeDuplicatesKeepOrder(List<Integer> numbers)
{
    ArrayList<Integer> newList = new ArrayList<>();
    /* a hash set seems like an appropriate tool to keep
    track of what elements has already been seen. */
    HashSet<Integer> used = new HashSet<>();
    for(int n : numbers)
    {
        if(!used.contains(n))
        {
            used.add(n);
            newList.add(n);
        }
    }
    return  newList;
}

public static void exercise8()
{
    ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
    ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7));
}

public static ArrayList<Integer> mergeWithoutDuplicates(List<Integer> listA, List<Integer> listB)
{
    ArrayList<Integer> merged = new ArrayList<>(listA);
    merged.addAll(listB);
    merged = removeDuplicatesKeepOrder(merged);
    return merged;
}