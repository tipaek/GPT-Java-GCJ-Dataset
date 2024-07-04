import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int activities = scanner.nextInt();
            String result = "";
            boolean isImpossible = false;
            List<Integer> cameronTimes = new ArrayList<>();
            List<Integer> jamieTimes = new ArrayList<>();

            for (int j = 0; j < activities; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();

                if (isTimeOverlap(start, end, cameronTimes) && isTimeOverlap(start, end, jamieTimes)) {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    isImpossible = true;
                    break;
                } else if (!isTimeOverlap(start, end, cameronTimes)) {
                    fillTimeSlots(start, end, cameronTimes);
                    result += "C";
                } else if (!isTimeOverlap(start, end, jamieTimes)) {
                    fillTimeSlots(start, end, jamieTimes);
                    result += "J";
                }
            }

            if (!isImpossible) {
                System.out.println("Case #" + (i + 1) + ": " + result);
            }
        }

        scanner.close();
    }

    private static boolean isTimeOverlap(int start, int end, List<Integer> times) {
        for (int i = start; i <= end; i++) {
            if (times.contains(i)) {
                return true;
            }
        }
        return false;
    }

    private static void fillTimeSlots(int start, int end, List<Integer> times) {
        for (int i = start; i <= end; i++) {
            times.add(i);
        }
    }
}