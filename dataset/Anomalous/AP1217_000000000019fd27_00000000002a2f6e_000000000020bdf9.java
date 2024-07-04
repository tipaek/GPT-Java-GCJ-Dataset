import java.util.*;

public class Solution {

    public static void sortbyColumn(Integer[][] arr, int col) {
        Arrays.sort(arr, Comparator.comparingInt(o -> o[col]));
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCase = s.nextInt();
        s.nextLine();
        List<Integer[][]> testCases = new ArrayList<>();

        for (int t = 0; t < testCase; t++) {
            int numIntervals = Integer.parseInt(s.nextLine());
            if (numIntervals > 0) {
                Integer[][] intervals = new Integer[numIntervals][2];
                for (int i = 0; i < numIntervals; i++) {
                    String[] values = s.nextLine().split(" ");
                    intervals[i][0] = Integer.parseInt(values[0]);
                    intervals[i][1] = Integer.parseInt(values[1]);
                }
                testCases.add(intervals);
            }
        }
        s.close();

        for (int t = 0; t < testCases.size(); t++) {
            Integer[][] intervals = testCases.get(t);
            sortbyColumn(intervals, 0);

            String[] assignments = new String[intervals.length];
            int lastJ = -1, lastC = -1;
            boolean possible = true;

            for (int i = 0; i < intervals.length; i++) {
                if (intervals[i][0] >= lastJ) {
                    assignments[i] = "J";
                    lastJ = intervals[i][1];
                } else if (intervals[i][0] >= lastC) {
                    assignments[i] = "C";
                    lastC = intervals[i][1];
                } else {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                System.out.println("Case #" + (t + 1) + ": " + String.join("", assignments));
            } else {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            }
        }
    }
}