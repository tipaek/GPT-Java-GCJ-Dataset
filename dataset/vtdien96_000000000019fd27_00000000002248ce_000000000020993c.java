
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numTest = Integer.parseInt(input.nextLine());
        for (int i = 0; i < numTest; i++) {
            int width = Integer.parseInt(input.nextLine());
            String[] matrix = new String[width];
            for(int j = 0; j < width; j ++){
                matrix[j] = input.nextLine();
            }
            solve(i + 1, width, matrix);
        }
    }

    private static void solve(int testNum, int width, String[] matrix) {
        int trace = 0, row = 0, column = 0;
        int[][] revertMatrix = new int[width][width];

        for (int i = 0; i < width; i++) {
            String[] tmp = matrix[i].split(" ");
            Set<Integer> rowSet = new HashSet<Integer>();
            int repeat = 0;
            for (int j = 0; j < width; j++) {
                int intVar = Integer.parseInt(tmp[j]);
                if (!rowSet.add(intVar)) {
                    repeat = 1;
                }
                if (i == j) {
                    trace += intVar;
                }
                revertMatrix[j][i] = intVar;
            }
            row += repeat;
        }

        for (int i = 0; i < width; i++) {
            Set<Integer> set = new HashSet<Integer>();
            int repeat = 0;
            for (int j = 0; j < width; j++) {
                if (!set.add(revertMatrix[i][j])) {
                    repeat = 1;
                }
            }
            column += repeat;
        }

        System.out.println(String.format("Case #%d: %d %d %d", testNum, trace, row, column));
    }
}