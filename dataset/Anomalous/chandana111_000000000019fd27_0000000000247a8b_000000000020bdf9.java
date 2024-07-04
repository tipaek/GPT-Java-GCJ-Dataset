import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<List<String>> results = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<int[]> intervals = new ArrayList<>();
            List<String> schedule = new ArrayList<>();

            int k = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int j = 0; j < k; j++) {
                String[] input = scanner.nextLine().split(" ");
                int[] interval = {Integer.parseInt(input[0]), Integer.parseInt(input[1])};
                intervals.add(interval);
            }

            int x = intervals.get(0)[0];
            int y = intervals.get(0)[1];
            schedule.add("C");

            for (int m = 1; m < intervals.size(); m++) {
                int start = intervals.get(m)[0];
                int end = intervals.get(m)[1];

                if ((end > y && start > y) || (start < x && end < x)) {
                    schedule.add("C");
                } else if ((start > x && start < y) || (start < x)) {
                    schedule.add("J");
                } else {
                    schedule.add("I");
                }
            }

            results.add(schedule);
        }

        for (int i = 0; i < results.size(); i++) {
            List<String> schedule = results.get(i);
            boolean impossible = false;

            for (String s : schedule) {
                if (s.equals("I")) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                System.out.print("Case #" + (i + 1) + ": ");
                for (String s : schedule) {
                    System.out.print(s);
                }
                System.out.println();
            }
        }

        scanner.close();
    }
}