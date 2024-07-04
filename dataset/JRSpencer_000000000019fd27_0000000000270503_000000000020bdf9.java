import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] array = new int[n][3];
            for (int j = 0; j < n; j++) {
                int start = in.nextInt();
                int stop = in.nextInt();
                array[j][0] = start;
                array[j][1] = stop;
                array[j][2] = j;
            }
            int[][] sortedArray = new int[n][3];
            //Sorting Array
            int[] reset = {24 * 60 + 1, 0, 0};
            for (int j = 0; j < n; j++) {
                int[] earliestTime = reset;
                for (int k = 0; k < n; k++) {
                    if (array[k][0] < earliestTime[0]) {
                        earliestTime = array[k];
                    }
                }
                sortedArray[j] = earliestTime;
                array[sortedArray[j][2]] = reset;
            }
            char[] sequence = new char[n];
            String output = "";
            int cLatest = 0;
            int jLatest = 0;
            for (int j = 0; j < n; j++) {
                int startTime = sortedArray[j][0];
                int endTime = sortedArray[j][1];
                int position = sortedArray[j][2];
                if (cLatest <= startTime) {
                    sequence[position] = 'C';
                    cLatest = endTime;
                } else if (jLatest <= startTime) {
                    sequence[position] = 'J';
                    jLatest = endTime;
                } else {
                    output = "IMPOSSIBLE";
                    break;
                }
            }
            if (output != "IMPOSSIBLE") {
                output = new String(sequence);
            }
            System.out.println(String.format("Case #%d: %s", i, output));
        }
    }
}
