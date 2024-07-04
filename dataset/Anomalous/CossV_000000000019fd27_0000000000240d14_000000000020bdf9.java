import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            List<int[]> cameronList = new ArrayList<>();
            List<int[]> jamieList = new ArrayList<>();
            StringBuilder output = new StringBuilder();
            int intervalsCount = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < intervalsCount; i++) {
                String[] intervalStr = scanner.nextLine().split(" ");
                int start = Integer.parseInt(intervalStr[0]);
                int end = Integer.parseInt(intervalStr[1]);
                int[] interval = {start, end};
                if (doesListContainOverlap(interval, jamieList)) {
                    // You can add logic for Cameron if needed here
                } else {
                    jamieList.add(interval);
                    output.append("J");
                }
            }
            System.out.println("Case #" + caseNumber + ": " + output.toString());
        }
        scanner.close();
    }

    private static boolean doesOverlap(int start1, int end1, int start2, int end2) {
        return end1 > start2 && start1 < end2;
    }

    private static boolean doesListContainOverlap(int[] interval, List<int[]> list) {
        for (int[] existingInterval : list) {
            if (doesOverlap(interval[0], interval[1], existingInterval[0], existingInterval[1])) {
                return true;
            }
        }
        return false;
    }
}