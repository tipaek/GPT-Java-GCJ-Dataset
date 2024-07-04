import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numCases = input.nextInt();
        for (int caseNum = 1; caseNum <= numCases; caseNum++) {
            int size = input.nextInt();
            int[][] grid = new int[size][size];
            for (int i = 0; i < size; i++)
                for (int j = 0; j < size; j++)
                    grid[i][j] = input.nextInt();

            int trace = 0;
            for (int i = 0; i < size; i++)
                trace += grid[i][i];

            int numRepeatedRows = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> nums = new HashSet<>();
                for (int j = 0; j < size; j++)
                    nums.add(grid[i][j]);
                if (nums.size() < size)
                    numRepeatedRows++;
            }

            int numRepeatedCols = 0;
            for (int i = 0; i < size; i++) {
                Set<Integer> nums = new HashSet<>();
                for (int j = 0; j < size; j++)
                    nums.add(grid[j][i]);
                if (nums.size() < size)
                    numRepeatedCols++;
            }

            System.out.printf("Case #%d: %d %d %d\n", caseNum, trace, numRepeatedRows, numRepeatedCols);
        }
    }
}
