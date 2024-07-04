import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());
        
        for (int test = 1; test <= t; test++) {
            int n = Integer.parseInt(reader.readLine().trim());
            int[][] intervals = new int[n][4];
            int[] time = new int[1440];
            boolean impossible = false;
            
            for (int i = 0; i < n; i++) {
                String[] toks = reader.readLine().split(" ");
                int start = Integer.parseInt(toks[0]);
                int end = Integer.parseInt(toks[1]);
                intervals[i][0] = start;
                intervals[i][1] = end;
                intervals[i][2] = -1; // To store the assigned person (0 for C, 1 for J)
                intervals[i][3] = i;  // To keep track of original index
                
                for (int j = start; j < end; j++) {
                    time[j]++;
                    if (time[j] > 2) {
                        impossible = true;
                    }
                }
            }
            
            if (impossible) {
                System.out.println("Case #" + test + ": IMPOSSIBLE");
                continue;
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            
            int currentPerson = 0;
            for (int i = 0; i < n; i++) {
                if (time[intervals[i][0]] == 1) {
                    intervals[i][2] = currentPerson;
                } else {
                    for (int j = 0; j < i; j++) {
                        if (intervals[j][1] > intervals[i][0] && intervals[j][2] == currentPerson) {
                            currentPerson ^= 1;  // Switch between 0 and 1
                            break;
                        }
                    }
                    intervals[i][2] = currentPerson;
                }
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[3]));
            StringBuilder result = new StringBuilder("Case #").append(test).append(": ");
            
            for (int i = 0; i < n; i++) {
                result.append(intervals[i][2] == 0 ? 'C' : 'J');
            }
            
            System.out.println(result);
        }
    }
}