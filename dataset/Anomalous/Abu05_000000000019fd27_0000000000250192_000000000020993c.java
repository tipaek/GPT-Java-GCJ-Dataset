import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    static boolean DEBUG = false;

    public static void main(String[] args) throws Exception {
        long beginTime = System.nanoTime();

        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/vestigium.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {

            int testCount = scanner.nextInt();

            for (int testNumber = 1; testNumber <= testCount; testNumber++) {

                int n = scanner.nextInt();
                int[][] matrix = new int[n][n];

                int trace = 0;
                int repeatedRows = 0;
                int repeatedColumns = 0;

                for (int i = 0; i < n; i++) {
                    HashSet<Integer> rowSet = new HashSet<>();
                    boolean rowHasDuplicate = false;
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = scanner.nextInt();
                        if (!rowSet.add(matrix[i][j]) && !rowHasDuplicate) {
                            repeatedRows++;
                            rowHasDuplicate = true;
                        }
                        if (i == j) {
                            trace += matrix[i][j];
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    HashSet<Integer> colSet = new HashSet<>();
                    boolean colHasDuplicate = false;
                    for (int i = 0; i < n; i++) {
                        if (!colSet.add(matrix[i][j]) && !colHasDuplicate) {
                            repeatedColumns++;
                            colHasDuplicate = true;
                        }
                    }
                }

                System.out.println("Case #" + testNumber + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
            }
        }
    }
}