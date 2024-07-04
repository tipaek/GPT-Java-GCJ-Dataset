import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();

        for (int x = 0; x < t; x++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            int sum = 0;
            int countRow = 0, countCol = 0;

            // Calculate the sum of the diagonal elements
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
            }

            // Count rows with duplicate elements
            for (int i = 0; i < n; i++) {
                Set<Integer> rowSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!rowSet.add(arr[i][j])) {
                        countRow++;
                        break;
                    }
                }
            }

            // Count columns with duplicate elements
            for (int i = 0; i < n; i++) {
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (!colSet.add(arr[j][i])) {
                        countCol++;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (x + 1) + ": " + sum + " " + countRow + " " + countCol);
        }
    }
}