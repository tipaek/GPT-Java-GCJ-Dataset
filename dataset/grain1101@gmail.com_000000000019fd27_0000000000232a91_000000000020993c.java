import com.algorithm.leetcode.UndergroundSystem;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class Solution {
    public Solution() {

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int K = 0;
            int R = 0;
            int C = 0;
            for(int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for(int k = 0; k < n; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k) { K += arr[j][k]; }
                    set.add(arr[j][k]);
                }
                if (set.size() != n) R++;
            }
            for(int j = 0; j < n; j++) {
                Set<Integer> set = new HashSet<>();
                for(int k = 0; k < n; k++) {
                    set.add(arr[k][j]);
                }
                if (set.size() != n) C++;
            }
            System.out.println("Case #" + i +": " + K + " " + R + " " + C);
        }
    }
}
