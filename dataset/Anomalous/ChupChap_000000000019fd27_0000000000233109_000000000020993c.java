import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static int countDuplicateRows(int[][] arr, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (seen.contains(arr[i][j])) {
                    count++;
                    break;
                }
                seen.add(arr[i][j]);
            }
        }
        return count;
    }

    public static int countDuplicateColumns(int[][] arr, int N) {
        int count = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (seen.contains(arr[j][i])) {
                    count++;
                    break;
                }
                seen.add(arr[j][i]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt(); // Number of test cases
        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            int diagonalSum = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    arr[i][j] = in.nextInt();
                    if (i == j) {
                        diagonalSum += arr[i][j];
                    }
                }
            }

            int rowCount = countDuplicateRows(arr, N);
            int colCount = countDuplicateColumns(arr, N);
            System.out.println("Case #" + t + ": " + diagonalSum + " " + rowCount + " " + colCount);
        }
        in.close();
    }
}