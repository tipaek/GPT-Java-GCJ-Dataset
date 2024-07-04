import java.util.*;
import java.io.*;

public class Solution {
    public int countRepeatedRows(int[][] arr, int N) {
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

    public int countRepeatedColumns(int[][] arr, int N) {
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
        int T = in.nextInt();
        Solution solution = new Solution();

        for (int i = 1; i <= T; ++i) {
            int N = in.nextInt();
            int[][] arr = new int[N][N];
            int sum = 0;

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = in.nextInt();
                    if (j == k) {
                        sum += arr[j][k];
                    }
                }
            }

            int rowRepeats = solution.countRepeatedRows(arr, N);
            int colRepeats = solution.countRepeatedColumns(arr, N);

            System.out.println("Case #" + i + ": " + sum + " " + rowRepeats + " " + colRepeats);
        }
    }
}