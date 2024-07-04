import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import static java.util.Arrays.fill;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int a = 1; a <= t; a++) {
            int n = in.nextInt();
            int[][] arr = new int[n][n];
            for (int b = 0; b < n; b++) {
                for (int c = 0; c < n; c++) {
                    arr[b][c] = in.nextInt();
                }
            }

            int trace = 0;
            for (int b = 0; b < n; b++) {
                trace += arr[b][b];
            }

            int repeatedRows = 0;
            boolean numbers[] = new boolean[n + 1];
            for (int b = 0; b < n; b++) {
                fill(numbers, false);
                for (int c = 0; c < n; c++) {
                    int number = arr[b][c];
                    if (numbers[number]) {
                        ++repeatedRows;
                        break;
                    }
                    numbers[number] = true;
                }
            }

            int repeatedColumns = 0;
            for (int b = 0; b < n; b++) {
                fill(numbers, false);
                for (int c = 0; c < n; c++) {
                    int number = arr[c][b];
                    if (numbers[number]) {
                        ++repeatedColumns;
                        break;
                    }
                    numbers[number] = true;
                }
            }

            System.out.println("Case #" + a + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}
