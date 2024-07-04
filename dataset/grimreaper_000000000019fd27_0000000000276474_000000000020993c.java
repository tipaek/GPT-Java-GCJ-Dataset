import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            int trace = 0, dr = 0, dc = 0;
            for (int j = 0; j < n; j++) {
                boolean checkRow = true;
                for (int k = 0; k < n; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k)
                        trace += arr[j][k];
                    if (checkRow) {
                        if (set.contains(arr[j][k])) {
                            checkRow = false;
                            dr++;
                        } else
                            set.add(arr[j][k]);
                    }
                }
                set.clear();
            }

            for (int k = 0; k < n; k++) {
                boolean checkCol = true;
                for (int j = 0; j < n && checkCol; j++) {
                    if (set.contains(arr[j][k])) {
                        checkCol = false;
                        dc++;
                    } else
                        set.add(arr[j][k]);
                }
                set.clear();
            }

            System.out.printf("\nCase #%d: %d %d %d", i+1, trace, dr, dc);
        }
    }
}