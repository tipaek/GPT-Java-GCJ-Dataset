import java.util.*;
import java.io.*;
import java.util.function.IntFunction;

public class Solution {
    public static int[][][] tests;
    public static int nTest;
    public static void main(String[] args) {
        readInput();
        produceOutput();
    }

    private static void produceOutput() {
        int x = 1;
        for (int[][] matrix : tests) {
            int k = 0 ,r = 0, c = 0;    //k: sum of the diagonal, r: rep in rows, c: rep in cols

            List<Set<Integer>> colsSet = new ArrayList<>();
            boolean checkRepInCols[] = new boolean[matrix.length];
            //initialize
            for (int i = 0; i < matrix.length; i++) {
                colsSet.add(new HashSet<Integer>());
                checkRepInCols[i] = true;
            }

            for (int col = 0; col < matrix.length; col++) {
                Set<Integer> rowSet = new HashSet<>();
                boolean checkRepInRow = true;
                //1. sum of the natural diagonal
                k += matrix[col][col];
                for (int row = 0; row < matrix[col].length; row++) {
                    //2. check whether there's repetition in a row
                    if (checkRepInRow && !rowSet.add(matrix[col][row])) {
                        r++;
                        checkRepInRow = false;
                    }
                    //3. check whether there's repetition in a column
                    if (checkRepInCols[row] && !colsSet.get(row).add(matrix[col][row])) {
                        c++;
                        checkRepInCols[row] = false;
                    }
                }
            }

            System.out.println("Case #"+ x++ + " " + k + " " + r+ " " + c);
        }
    }

    private static void readInput() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try {
            nTest = Integer.parseInt(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        tests = new int[nTest][][];

        for (int i = 0; i < nTest; i++) {
            int size = 0;
            try {
                size = Integer.parseInt(in.readLine());

                int[][] matrix = new int[size][];
                for (int j = 0; j < size; j++) {
                    matrix[j] = Arrays.stream(in.readLine().split("\\s+"))
                            .map(Integer::parseInt)
                            .mapToInt(x -> x)
                            .toArray();
                } // read matrix
                tests[i] = matrix;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}


