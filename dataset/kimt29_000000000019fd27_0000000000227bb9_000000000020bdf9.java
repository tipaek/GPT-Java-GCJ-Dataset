import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int[][] times = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    times[j][k] = scanner.nextInt();
                }
            }
            
            int j = 1;
            int overlapCounter = 0;
            String result = "C";
            while (j < n) {
                if (!isOverlap(times, j)) {
                    result += "C";
                } else if (isOverlap(times, j) && !isOverlap(times, j-1)){ 
                    result += "J";
                } else {
                    result = "IMPOSSIBLE";
                }
                j++;
            }
            System.out.println("Case #" + i + ": " + result);
        }
    }
    
    // compares j and j-1 times for overlap
    public static boolean isOverlap(int[][] t, int j) {
        if (j < 1) return false;
        if (t[j-1][1] > t[j][0]) return true;
        return false;
    }
}