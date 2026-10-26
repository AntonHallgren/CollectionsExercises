//for comments on "Choose Your Collection" tasks, see their respective classes

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
            case 8 -> exercise8();
            case 9 -> exercise9();
            case 10 -> exercise10();
            case 11 -> exercise11();
            case 12 -> exercise12();
            case 13 -> exercise13();
            case 14 -> exercise14();
            case 15 -> exercise15();
            case 16 -> exercise16();
            case 17 -> exercise17();
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
    phoneBook.put("Anna", "1234567");
    phoneBook.put("Bob", "8910111");
    phoneBook.put("Alice", "2131415");
    phoneBook.put("Charlie", "1617181");

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
    ArrayList<Integer> merged = mergeWithoutDuplicates(listA, listB);
    IO.println(String.format("Number of elements: %d\n Contents: %s", merged.size(), merged));
}

public static ArrayList<Integer> mergeWithoutDuplicates(List<Integer> listA, List<Integer> listB)
{
    ArrayList<Integer> merged = new ArrayList<>(listA);
    merged.addAll(listB);
    merged = removeDuplicatesKeepOrder(merged);
    return merged;
}

public static void exercise9()
{
    SubmissionTracker st = new SubmissionTracker();
    st.studentSubmitted("Bob");
    st.studentSubmitted("Alice");
    st.studentSubmitted("Charlie");
    st.studentSubmitted("David");
    st.studentSubmitted("Charlie");
    st.studentSubmitted("Charlie");
    st.studentSubmitted("Bob");
    st.studentSubmitted("Alice");
    st.print();
}

private static void exercise10()
{
    ConcertQueue cq = new ConcertQueue();
    String[] names = {"Anna", "Bob", "Alice", "Charlie", "Amanda", "David"};
    for(String n : names)
    {
        cq.add(n);
    }
    cq.letIn();
    cq.letIn();
    cq.print();
}

private static void exercise11()
{
    StudentGrades sg = new StudentGrades();
    sg.add("Alice", 15);
    sg.add("Bob", 10);
    sg.add("Anna", 100);
    sg.add("Charlie", 50);
    sg.add("Brian", 4);
    sg.add("Amanda", 50);
    sg.printInOrder();
}

private static void exercise12()
{
    groupByFirstLetter(Arrays.asList(
            "Alice", "Bob", "Anna", "Charlie", "Brian", "Amanda", "Carl"
    ));
}

private static void groupByFirstLetter(List<String> names)
{
    Map<Character, Set<String>> groups = new HashMap<>();
    for(String name : names)
    {
        Character c = name.charAt(0);//could do be some proper checking
        Set<String> group = groups.computeIfAbsent(c, _ -> new HashSet<>());
        group.add(name);
    }
    for(char c : groups.keySet())
    {
        IO.println(String.format("People starting with %c: ", c));
        for(String name : groups.get(c))
        {
            IO.println(name);
        }
    }
}

private static void exercise13()
{
    findMostFrequentWord(Arrays.asList("cat", "dog", "cat", "bird", "dog", "cat", "fish", "dog", "dog"));
}

private static void findMostFrequentWord(List<String> words)
{
    Map<String, Integer> map = new HashMap<>();
    String mostFrequent = null;
    int frequency = 0;
    for(String word : words)
    {
        map.merge(word, 1, Integer::sum);
        if(map.get(word)>frequency)
        {
            mostFrequent = word;
            frequency = map.get(word);
        }
    }
    IO.println(String.format("The most frequent word is %s which appeared %d times", mostFrequent, frequency));
}

private static void exercise14()
{
    Integer[] l1 = {1, 3, 5, 7, 9, 11};
    Integer[] l2 = {3, 6, 9, 12, 15};
    IO.println("Common elements: " + commonElements(Arrays.asList(l1), Arrays.asList(l2)));
}

private static List<Integer> commonElements(List<Integer> l1, List<Integer> l2)
{
    Set<Integer> asSet = new HashSet<>(l2);
    Set<Integer> alreadyAdded = new HashSet<>();
    List<Integer> common = new ArrayList<>();
    for(int value : l1)
    {
        if(asSet.contains(value) && !alreadyAdded.contains(value))
        {
            common.add(value);
            alreadyAdded.add(value);
        }
    }
    return common;
}

private static void exercise15()
{
    Integer[] list = {2, 7, 11, 15, 4, 6};
    int target = 13;
    twoSum(Arrays.asList(list), target);
}

private static void twoSum(List<Integer> numbers, int target)
{
    Set<Integer> numbersInSet = new HashSet<>(numbers);
    for(int number : numbers)
    {
        if(numbersInSet.contains(target-number))
        {
            IO.println(String.format("The list contains the numbers %d and %d that sum to %d", number, target-number, target));
            return;//
        }
    }
    IO.println("No pair of numbers in the list sum to " + target);
}

private static void exercise16()
{
    Integer[] numbers = {34, 78, 23, 78, 91, 56, 91, 12};
    int second = secondLargest(Arrays.asList(numbers));
    IO.println("Second largest number: " + second);
}

private static int secondLargest(List<Integer> numbers)
{
    if(numbers.size() < 2)
    {
        throw new IllegalArgumentException("List needs at least two elements");
    }
    int largest = Math.max(numbers.get(0), numbers.get(1));
    int second = Math.min(numbers.get(0), numbers.get(1));
    for(int i = 2; i < numbers.size(); i++)
    {
        int next = numbers.get(i);
        if(next == largest || next == second)
        {
            continue;//ignore repeated values
        }
        if(next < second)
        {
            continue;//not large enough to matter
        }
        if(next < largest)
        {
            second = next;//new second largest
            continue;
        }
        second = largest;//new largest
        largest = next;
    }
    return second;
}

private static void exercise17()
{
    String[] strings = {"java", "python", "java", "c++", "python", "java", "ruby", "c++", "python", "ruby", "java"};
    top3MostFrequent(Arrays.asList(strings));
}

private static void top3MostFrequent(List<String> words)
{
    Map<String, Integer> map = new HashMap<>();
    for(String word : words)
    {
        map.merge(word, 1, Integer::sum);
    }
    for(int i = 0; i < 3; i++)
    {
        String most = highestCount(map);
        IO.println(String.format("Place %d: %s, %d occurrences", i+1, most, map.get(most)));
        map.remove(most);
    }
}

private static String highestCount(Map<String, Integer> map)
{
    List<String> strings = new ArrayList<>(map.keySet());
    String mostFrequent = strings.getFirst();
    for(String s : strings)
    {
        if(map.get(s) > map.get(mostFrequent))
        {
            mostFrequent = s;
        }
    }
    return mostFrequent;
}