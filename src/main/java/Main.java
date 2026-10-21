public class Main {


    static void main() {
        boolean running = true;
        while(running)
        {
            int exercise = Integer.parseInt(IO.readln("Which exercise (pick 0 to quit): "));
            switch (exercise)
            {
                case 0 -> running = false;
                default -> IO.println("No exercise of that number has been completed");
            }
        }
    }
}
