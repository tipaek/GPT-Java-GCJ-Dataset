import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfCases = Integer.parseInt(scanner.next());
        int caseNumber = 1;

        while (numberOfCases > 0) {
            int numberOfActivities = Integer.parseInt(scanner.next());
            boolean[] cOccupied = new boolean[1441];
            boolean[] jOccupied = new boolean[1441];
            StringBuilder schedule = new StringBuilder();

            for (int i = 0; i < numberOfActivities; i++) {
                int startTime = Integer.parseInt(scanner.next());
                int endTime = Integer.parseInt(scanner.next());

                if (schedule.toString().equals("IMPOSSIBLE")) {
                    continue;
                }

                if (isAvailable(startTime, endTime, cOccupied)) {
                    markOccupied(startTime, endTime, cOccupied);
                    schedule.append("C");
                } else if (isAvailable(startTime, endTime, jOccupied)) {
                    markOccupied(startTime, endTime, jOccupied);
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                }
            }

            System.out.println("Case #" + caseNumber + ": " + schedule);
            caseNumber++;
            numberOfCases--;
        }
    }

    private static boolean isAvailable(int startTime, int endTime, boolean[] occupied) {
        for (int i = startTime; i < endTime; i++) {
            if (occupied[i]) {
                return false;
            }
        }
        return true;
    }

    private static void markOccupied(int startTime, int endTime, boolean[] occupied) {
        for (int i = startTime; i < endTime; i++) {
            occupied[i] = true;
        }
    }
}