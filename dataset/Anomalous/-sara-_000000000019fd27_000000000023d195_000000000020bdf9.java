import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            List<Integer> jamieSchedule = new ArrayList<>();
            List<Integer> cameronSchedule = new ArrayList<>();
            for (int minute = 0; minute <= 1440; minute++) {
                jamieSchedule.add(0);
                cameronSchedule.add(0);
            }

            int activities = scanner.nextInt();
            StringBuilder result = new StringBuilder();

            for (int activity = 0; activity < activities; activity++) {
                int startTime = scanner.nextInt();
                int endTime = scanner.nextInt();

                if (!jamieSchedule.subList(startTime, endTime).contains(1)) {
                    result.append("J");
                    for (int minute = startTime; minute < endTime; minute++) {
                        jamieSchedule.set(minute, 1);
                    }
                } else if (!cameronSchedule.subList(startTime, endTime).contains(1)) {
                    result.append("C");
                    for (int minute = startTime; minute < endTime; minute++) {
                        cameronSchedule.set(minute, 1);
                    }
                } else {
                    result = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            System.out.println("Case #" + caseNum + ": " + result);
        }

        scanner.close();
    }
}