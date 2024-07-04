import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    private static String schedule(ArrayList<int[]> intervals) {
        StringBuilder result = new StringBuilder();
        ArrayList<int[]> originalList = new ArrayList<>(intervals);
        HashMap<int[], Character> assignmentMap = new HashMap<>();

        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));

        int jameFreeAt = -1;
        int camFreeAt = -1;

        for (int[] interval : intervals) {
            if (jameFreeAt == -1 || interval[0] >= jameFreeAt) {
                assignmentMap.put(interval, 'J');
                jameFreeAt = interval[1];
            } else if (interval[0] >= camFreeAt) {
                assignmentMap.put(interval, 'C');
                camFreeAt = interval[1];
            } else {
                return "IMPOSSIBLE";
            }
        }

        for (int[] interval : originalList) {
            result.append(assignmentMap.get(interval));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int n = scanner.nextInt();
            ArrayList<int[]> intervals = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals.add(new int[]{start, end});
            }
            String result = schedule(intervals);
            System.out.println("Case #" + i + ": " + result);
        }

        scanner.close();
    }
}