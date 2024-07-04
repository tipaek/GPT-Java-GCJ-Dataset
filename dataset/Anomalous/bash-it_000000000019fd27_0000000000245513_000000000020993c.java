import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Read the number of test cases
        for (int z = 1; z <= t; ++z) {
            int size = in.nextInt();  // Read the size of the matrix
            int sum = 0;
            int rowMatch = 0;
            int columnMatch = 0;
            int[][] matrix = new int[size][size];
            in.nextLine();  // Consume the newline character after the integer input

            for (int i = 0; i < size; i++) {
                String[] line = in.nextLine().split(" ");
                for (int c = 0; c < size; c++) {
                    int num = Integer.parseInt(line[c]);
                    matrix[i][c] = num;
                    if (i == c) {
                        sum += num;  // Sum the diagonal elements
                    }
                }
            }

            // Calculate rowMatch and columnMatch
            for (int i = 0; i < size; i++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int j = 0; j < size; j++) {
                    rowSet.add(matrix[i][j]);
                    colSet.add(matrix[j][i]);
                }
                if (rowSet.size() < size) {
                    rowMatch++;
                }
                if (colSet.size() < size) {
                    columnMatch++;
                }
            }

            System.out.println("Case #" + z + ": " + sum + " " + rowMatch + " " + columnMatch);
        }
    }
}