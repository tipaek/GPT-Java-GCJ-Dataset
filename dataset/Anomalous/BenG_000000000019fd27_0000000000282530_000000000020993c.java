import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases
        for (int i = 1; i <= t; ++i) {
            int elements = in.nextInt(); // Number of elements per row/column
            in.nextLine(); // Consume the remaining newline

            int trace = 0;
            int rowCount = 0;
            int colCount = 0;

            int[][] matrix = new int[elements][elements];
            int[][] invMatrix = new int[elements][elements];

            for (int a = 0; a < elements; a++) {
                String rowIn = in.nextLine();
                for (int e = 0; e < elements; e++) {
                    int intVal = Character.getNumericValue(rowIn.charAt(e));
                    matrix[a][e] = intVal;
                    invMatrix[e][a] = intVal;
                    if (a == e) {
                        trace += intVal;
                    }
                }
            }

            for (int a = 0; a < elements; a++) {
                Set<Integer> rowSet = new HashSet<>();
                Set<Integer> colSet = new HashSet<>();
                for (int e = 0; e < elements; e++) {
                    rowSet.add(matrix[a][e]);
                    colSet.add(invMatrix[a][e]);
                }
                if (rowSet.size() < elements) rowCount++;
                if (colSet.size() < elements) colCount++;
            }

            System.out.println("Case #" + i + ": " + trace + " " + rowCount + " " + colCount);
        }
    }
}