import static java.lang.System.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        // Scanner has functions to read ints, longs, strings, chars, etc.
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(in)));
        int caseNum = Integer.valueOf(input.nextLine());
        for(int i = 1; i <= caseNum; i ++) {
            int size = Integer.valueOf(input.nextLine());
            String[][] matrix = new String[size][size];
            for(int row = 0; row < size; row ++) {
                matrix[row] = input.nextLine().split(" ");
            }
            String path = solve(matrix);
            out.println("Case #" + i + ": " + path);
        }
    }

    private static String solve(String[][] matrix) {
        Map<Integer, Set<Integer>> rows = new HashMap();
        Map<Integer, Set<Integer>> columns = new HashMap();

        int size = matrix.length;
        for(int i = 0; i < size; i ++) {
            rows.put(i, new HashSet());
            columns.put(i, new HashSet());
        }
        int trace = 0;
        for(int i = 0; i < size; i ++) {
            for(int j = 0; j < size; j ++) {
                int cell = Integer.valueOf(matrix[i][j]);
                if(i == j) {
                    trace += cell;
                }
                rows.get(i).add(cell);
                columns.get(j).add(cell);
            }
        }
        int repeatedRow = (int) rows.values().stream().filter(set -> set.size() < size).count();
        int repeatedColumn = (int) columns.values().stream().filter(set -> set.size() < size).count();

        return trace + " " +  repeatedRow + " " + repeatedColumn;

    }
}