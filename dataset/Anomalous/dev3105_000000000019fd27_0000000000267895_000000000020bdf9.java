import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        
        for (int ti = 1; ti <= test; ti++) {
            int n = sc.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
                intervals[i][2] = i;
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
            
            int cc = 0, jc = 0;
            boolean isPossible = true;
            String[] ans = new String[n];
            
            for (int i = 0; i < n; i++) {
                if (cc <= intervals[i][0]) {
                    ans[intervals[i][2]] = "C";
                    cc = intervals[i][1];
                } else if (jc <= intervals[i][0]) {
                    ans[intervals[i][2]] = "J";
                    jc = intervals[i][1];
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                StringBuilder finalAns = new StringBuilder();
                for (String s : ans) {
                    finalAns.append(s);
                }
                System.out.println("Case #" + ti + ": " + finalAns.toString());
            } else {
                System.out.println("Case #" + ti + ": IMPOSSIBLE");
            }
        }
    }
}