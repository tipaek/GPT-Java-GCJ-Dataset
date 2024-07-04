import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cases = 1; cases <= t; cases++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            long[][] arr = new long[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    arr[i][j] = sc.nextLong();   
                }
            }
            long total = 0;
            boolean done = false;
            while (!done) {
                done = true;
                long[][] updated = new long[r][c];
                for (int i = 0; i < r; i++) {
                    for (int j = 0; j < c; j++) {
                        long sq = 0;
                        int neighbors = 0;
                        for (int k = 1; k <= j; k++) {
                            if (arr[i][j-k] != 0) {
                                sq += arr[i][j-k];
                                neighbors++;
                                break;
                            }
                        }
                        for (int k = 1; j+k < c; k++) {
                            if (arr[i][j+k] != 0) {
                                sq += arr[i][j+k];
                                neighbors++;
                                break;
                            }
                        }
                        for (int k = 1; i-k >= 0; k++) {
                            if (arr[i-k][j] != 0) {
                                sq += arr[i-k][j];
                                neighbors++;
                                break;
                            }
                        }
                        for (int k = 1; i+k < r; k++) {
                            if (arr[i+k][j] != 0) {
                                sq += arr[i+k][j];
                                neighbors++;
                                break;
                            }
                        }
                        if (sq * 1.0 / neighbors <= arr[i][j]) {
                            updated[i][j] = arr[i][j];
                            total += arr[i][j];
                        } else {
                            done = false;
                        }
                    }
                }
                arr = updated;
            }
        }
    }
}