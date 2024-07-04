import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            HashSet<Integer> cameron = new HashSet<>();
            HashSet<Integer> jamie = new HashSet<>();
            StringBuilder schedule = new StringBuilder();
            boolean possible = true;

            int activities = scanner.nextInt();
            for (int i = 0; i < activities; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isAvailable(jamie, start, end)) {
                    schedule.append("J");
                    addTimeSlots(jamie, start, end);
                } else if (isAvailable(cameron, start, end)) {
                    schedule.append("C");
                    addTimeSlots(cameron, start, end);
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + t + ": " + schedule);
            } else {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }

    private static boolean isAvailable(HashSet<Integer> person, int start, int end) {
        for (int time = start; time < end; time++) {
            if (person.contains(time)) {
                return false;
            }
        }
        return true;
    }

    private static void addTimeSlots(HashSet<Integer> person, int start, int end) {
        for (int time = start; time < end; time++) {
            person.add(time);
        }
    }
}