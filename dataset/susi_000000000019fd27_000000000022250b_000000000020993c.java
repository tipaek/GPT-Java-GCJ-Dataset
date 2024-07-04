import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int cases = Integer.parseInt(input.nextLine());
        for (int i = 1; i <= cases; i++) {
            int N = Integer.parseInt(input.nextLine());
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                String s = input.nextLine();
                String[] nums = s.split(" ");
                for (int k = 0; k < N; k++) {
                    matrix[j][k] = Integer.parseInt(nums[k]);
                }
            }
            vestigium(i, N, matrix);
        }
    }

    private static void vestigium(int ca, int N, int[][] matrix) {
        int k = 0;
        for (int i = 0; i < N; i++) {
            k += matrix[i][i];
        }

        int r = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (set.contains(matrix[i][j])) {
                    r++;
                    break;
                } else {
                    set.add(matrix[i][j]);
                }
            }
        }

        int c = 0;
        for (int i = 0; i < N; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < N; j++) {
                if (set.contains(matrix[j][i])) {
                    c++;
                    break;
                } else {
                    set.add(matrix[j][i]);
                }
            }
        }

        System.out.println("Case #" + ca + ": " + k + " " + r + " " + c);
    }
}
