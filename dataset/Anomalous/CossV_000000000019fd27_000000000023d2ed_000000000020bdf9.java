import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int t = 1; t <= testCases; t++) {
            int numberOfIntervals = Integer.parseInt(scanner.nextLine());
            List<int[]> cameronIntervals = new ArrayList<>();
            List<int[]> jamieIntervals = new ArrayList<>();
            StringBuilder result = new StringBuilder();

            boolean isPossible = true;
            for (int i = 0; i < numberOfIntervals; i++) {
                String[] intervalInput = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalInput[0]);
                int end = Integer.parseInt(intervalInput[1]);
                int[] interval = new int[]{start, end};

                if (isOverlappingWithAny(interval, cameronIntervals)) {
                    if (isOverlappingWithAny(interval, jamieIntervals)) {
                        isPossible = false;
                        break;
                    } else {
                        jamieIntervals.add(interval);
                        result.append("J");
                    }
                } else {
                    cameronIntervals.add(interval);
                    result.append("C");
                }
            }

            if (!isPossible) {
                result.setLength(0);
                result.append("IMPOSSIBLE");
            }

            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static boolean isOverlapping(int start1, int end1, int start2, int end2) {
        return start1 < end2 && start2 < end1;
    }

    private static boolean isOverlappingWithAny(int[] interval, List<int[]> intervals) {
        for (int[] existingInterval : intervals) {
            if (isOverlapping(interval[0], interval[1], existingInterval[0], existingInterval[1])) {
                return true;
            }
        }
        return false;
    }
}