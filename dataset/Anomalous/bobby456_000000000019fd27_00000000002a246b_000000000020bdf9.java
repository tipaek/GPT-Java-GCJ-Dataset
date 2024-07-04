import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][4];
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
                intervals[i][2] = i;
            }
            sortIntervals(intervals);
            String result = "C";
            int lastC = 0, lastJ = -1;
            intervals[0][3] = 0;
            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= intervals[i - 1][1]) {
                    char lastAssigned = result.charAt(i - 1);
                    result += lastAssigned;
                    if (lastAssigned == 'C') {
                        lastC = i;
                        intervals[i][3] = 0;
                    } else {
                        lastJ = i;
                        intervals[i][3] = 1;
                    }
                } else {
                    if (lastJ == -1) {
                        result += "J";
                        intervals[i][3] = 1;
                        lastJ = i;
                    } else {
                        if (intervals[i][0] >= intervals[lastJ][1]) {
                            result += "J";
                            intervals[i][3] = 1;
                            lastJ = i;
                        } else if (intervals[i][0] >= intervals[lastC][1]) {
                            result += "C";
                            intervals[i][3] = 0;
                            lastC = i;
                        } else {
                            result = "IMPOSSIBLE";
                            break;
                        }
                    }
                }
            }
            sortByOriginalOrder(intervals);
            if (result.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + (t + 1) + ": IMPOSSIBLE");
            } else {
                System.out.print("Case #" + (t + 1) + ": ");
                for (int i = 0; i < n; i++) {
                    System.out.print(intervals[i][3] == 0 ? "C" : "J");
                }
                System.out.println();
            }
        }
    }

    private static void sortIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
    }

    private static void sortByOriginalOrder(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[2]));
    }
}