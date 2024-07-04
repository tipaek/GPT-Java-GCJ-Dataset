import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTestCases = scanner.nextInt();
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < numberOfTestCases; i++) {
            int intervalSize = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            String[][] intervals = new String[intervalSize][2];
            for (int j = 0; j < intervalSize; j++) {
                intervals[j] = scanner.nextLine().split(" ");
            }
            result.append("Case #").append(i + 1).append(": ").append(getIntervals(intervalSize, intervals)).append("\n");
        }

        System.out.print(result.toString());
    }

    public static String getIntervals(int size, String[][] intervals) {
        int[] intervalInfo = new int[size]; // 1 for Jamie and 2 for Cameron
        int[][] intervalsWithIndex = new int[size][3];
        for (int i = 0; i < size; i++) {
            intervalsWithIndex[i] = new int[]{i, Integer.parseInt(intervals[i][0]), Integer.parseInt(intervals[i][1])};
        }
        Arrays.sort(intervalsWithIndex, Comparator.comparingInt(o -> o[1]));

        boolean impossible = false;
        int cameronEndTime = 0;
        int jamieEndTime = 0;

        for (int[] interval : intervalsWithIndex) {
            if (jamieEndTime <= interval[1]) {
                intervalInfo[interval[0]] = 1;
                jamieEndTime = interval[2];
            } else if (cameronEndTime <= interval[1]) {
                intervalInfo[interval[0]] = 2;
                cameronEndTime = interval[2];
            } else {
                impossible = true;
                break;
            }
        }

        if (impossible) {
            return "IMPOSSIBLE";
        }

        StringBuilder answer = new StringBuilder();
        for (int i : intervalInfo) {
            answer.append(i == 1 ? "C" : "J");
        }
        return answer.toString();
    }
}