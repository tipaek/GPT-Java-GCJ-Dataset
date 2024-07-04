import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++) {
            solution.processCase(i + 1, in);
        }
    }

    private void processCase(int t, Scanner in) {
        int n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        System.out.println("Case #" + t + ": "
                + calculateTrace(arr, n) + " "
                + rowsWithRepetition(arr, n) + " "
                + columnsWithRepetition(arr, n));
    }

    private int calculateTrace(int[][] arr, int n) {
        int total = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i == j) {
                    total += arr[i][j];
                }
            }
        }
        return total;
    }

    private int rowsWithRepetition(int[][] arr, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            Set<Integer> numbers = new HashSet<>();
            for(int j = 0; j < n; j++) {
                numbers.add(arr[i][j]);
            }
            if(numbers.size() != n) {
                count++;
            }
        }
        return count;
    }

    private int columnsWithRepetition(int[][] arr, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            Set<Integer> numbers = new HashSet<>();
            for(int j = 0; j < n; j++) {
                numbers.add(arr[j][i]);
            }
            if(numbers.size() != n) {
                count++;
            }
        }
        return count;
    }
}
