import java.util.*;
import java.io.*;
public class Solution {

    private static final boolean DEBUG = false;

    public static String solve(int[][] matrix){


        Set<Integer> currentSet = new HashSet<>();
        List<Set<Integer>> columnSets = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            columnSets.add(new HashSet<>());
        }

        int numberRows = 0;
        int numberColumns = 0;

        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    trace += matrix[i][j];
                }

                currentSet.add(matrix[i][j]);
                columnSets.get(j).add(matrix[i][j]);

            }

            if (currentSet.size() != matrix.length) {
                numberRows ++;
            }
            currentSet.clear();

        }
        for (Set<Integer> columnSet : columnSets) {
            if (columnSet.size() != matrix.length) {
                numberColumns++;
            }
        }

        return trace + " " + numberRows + " " + numberColumns;
    }



    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = DEBUG ? new FileInputStream("resources/qualification/vestigium/input.txt") : System.in;
        try (Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
            for (int i = 1; i <= t; ++i) {
                int N = in.nextInt();

                int[][] matrix = new int[N][N];
                for (int j = 0; j < N; j++) {

                    for(int k = 0; k<N; k++){

                        matrix[j][k] = in.nextInt();
                    }

                }
                String result = solve(matrix);
                System.out.println("Case #" + i + ": " + result);
            }
        } catch( Exception e) {
            e.printStackTrace();
        }
    }
}