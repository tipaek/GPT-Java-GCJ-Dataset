import java.util.Arrays;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        
        for (int l = 0; l < t; l++) {
            int n = scan.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = scan.nextInt();
                intervals[i][1] = scan.nextInt();
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
            
            int[] startTimes = new int[n];
            int[] endTimes = new int[n];
            
            for (int i = 0; i < n; i++) {
                startTimes[i] = intervals[i][0];
                endTimes[i] = intervals[i][1];
            }
            
            int count = 0;
            int i = 0;
            int j = 0;
            StringBuilder ans = new StringBuilder();
            
            while (i < n && j < n) {
                if (startTimes[i] < endTimes[j]) {
                    count++;
                    i++;
                } else {
                    count--;
                    j++;
                }
                
                if (count == 1 && ans.length() < n) {
                    ans.append("J");
                } else if (count == 2 && ans.length() < n) {
                    ans.append("C");
                }
            }
            
            if (count > 2) {
                ans = new StringBuilder("IMPOSSIBLE");
            }
            
            System.out.println("Case #" + (l + 1) + ": " + ans);
        }
        
        scan.close();
    }
}