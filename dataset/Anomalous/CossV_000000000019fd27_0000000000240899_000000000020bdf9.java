import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            List<int[]> cameron = new ArrayList<>();
            List<int[]> jamie = new ArrayList<>();
            String result = "";
            int activities = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < activities; i++) {
                try {
                    String[] intervalInput = scanner.nextLine().split(" ");
                    int[] interval = new int[2];
                    interval[0] = Integer.parseInt(intervalInput[0]);
                    interval[1] = Integer.parseInt(intervalInput[1]);

                    // Additional logic to determine the result can be added here

                } catch (Exception e) {
                    // Handle exception if necessary
                }
            }

            System.out.println("Case #" + testCase + ": " + result);
        }
    }

    public static boolean overlaps(int start1, int end1, int start2, int end2) {
        return (end1 > start2) && (start1 < end2);
    }

    public static boolean listContains(int[] interval, List<int[]> intervals) {
        for (int[] currentInterval : intervals) {
            if (currentInterval != null && currentInterval.length == 2) {
                if (overlaps(interval[0], interval[1], currentInterval[0], currentInterval[1])) {
                    return true;
                }
            }
        }
        return false;
    }
}