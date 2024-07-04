import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(scanner.nextLine());
        
        for (int t = 0; t < testCases; t++) {
            int size = Integer.parseInt(scanner.nextLine());
            int[][] intervals = new int[size][2];

            for (int i = 0; i < size; i++) {
                String[] input = scanner.nextLine().split(" ");
                intervals[i][0] = Integer.parseInt(input[0]);
                intervals[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            int cEnd = -1;
            int jEnd = -1;
            StringBuilder schedule = new StringBuilder();

            boolean isPossible = true;

            for (int[] interval : intervals) {
                if (interval[0] >= cEnd) {
                    cEnd = interval[1];
                    schedule.append("C");
                } else if (interval[0] >= jEnd) {
                    jEnd = interval[1];
                    schedule.append("J");
                } else {
                    System.out.println("IMPOSSIBLE");
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println(schedule.toString());
            }
        }
    }
}