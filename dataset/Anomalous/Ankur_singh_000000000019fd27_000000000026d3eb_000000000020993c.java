import java.io.*;
import java.util.*;

class Traces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int[][] arr2 = new int[n][n];

            // Reading the matrix
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }

            // Sorting rows of the matrix
            for (int i = 0; i < n; i++) {
                Arrays.sort(arr[i]);
            }

            int sum = 0, count1 = 0, count2 = 0;

            // Calculating the sum of the diagonal and checking for duplicates in rows
            for (int i = 0; i < n; i++) {
                sum += arr[i][i];
                for (int j = 0; j < n - 1; j++) {
                    if (arr[i][j] == arr[i][j + 1]) {
                        count1++;
                        break;
                    }
                }
            }

            // Creating the transposed matrix and checking for duplicates in columns
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr2[i][j] = arr[j][i];
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (arr2[i][j] == arr2[i][j + 1]) {
                        count2++;
                        break;
                    }
                }
            }

            System.out.println(sum + " " + count1 + " " + count2);
        }
    }
}