import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[] rows = new int[n];
            int[] cols = new int[n];
            int trace = 0;
            in.nextLine(); // Consume the remaining newline

            for (int j = 0; j < n; j++) {
                String[] input = in.nextLine().split(" ");
                for (int k = 0; k < n; k++) {
                    int number = Integer.parseInt(input[k]);
                    rows[j] += number;
                    cols[k] += number;
                    if (j == k) {
                        trace += number;
                    }
                }
            }

            int sum = getSum(n);
            int rowsDup = getDup(rows, sum, n);
            int colsDup = getDup(cols, sum, n);
            System.out.println("Case #" + i + ": " + trace + " " + rowsDup + " " + colsDup);
        }
    }

    public static int getSum(int n) {
        return n * (n + 1) / 2;
    }

    public static int getDup(int[] arr, int sum, int n) {
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != sum) {
                res++;
            }
        }
        return res;
    }
}