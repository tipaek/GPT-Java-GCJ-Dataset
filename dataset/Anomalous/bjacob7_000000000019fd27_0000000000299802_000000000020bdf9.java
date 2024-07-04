import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int size = scanner.nextInt();
            int[][] intervals = new int[size][2];
            
            for (int i = 0; i < size; i++) {
                intervals[i][0] = scanner.nextInt();
                intervals[i][1] = scanner.nextInt();
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            
            int cEnd = -1;
            int jEnd = -1;
            StringBuilder result = new StringBuilder();
            boolean possible = true;
            
            for (int i = 0; i < size; i++) {
                if (intervals[i][0] >= cEnd) {
                    cEnd = intervals[i][1];
                    result.append("C");
                } else if (intervals[i][0] >= jEnd) {
                    jEnd = intervals[i][1];
                    result.append("J");
                } else {
                    System.out.println("IMPOSSIBLE");
                    possible = false;
                    break;
                }
            }
            
            if (possible) {
                System.out.println(result.toString());
            }
        }
        
        scanner.close();
    }
}