import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.Scanner;

public class Solution {

    private static final boolean DEBUG = false;
    
    private static void solve(int testNumber, int[][] matrix) {
        int trace = 0;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        int dupRowCount = 0;
        for (int i = 0; i < matrix.length; i++) {
            BitSet numbersPresent = new BitSet(matrix.length + 1);
            for (int j = 0; j < matrix.length; j++) {
                int v = matrix[i][j];
                if (numbersPresent.get(v)) {
                    dupRowCount++;
                    break;
                }
                numbersPresent.set(v);
            }
        }
        int dupColumnCount = 0;
        for (int j = 0; j < matrix.length; j++) {
            BitSet numbersPresent = new BitSet(matrix.length + 1);
            for (int i = 0; i < matrix.length; i++) {
                int v = matrix[i][j];
                if (numbersPresent.get(v)) {
                    dupColumnCount++;
                    break;
                }
                numbersPresent.set(v);
            }
        }
        System.out.println("Case #" + testNumber + ": " + trace + " " + dupRowCount + " " + dupColumnCount);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/codejam2020/qualification/Vestigium-1.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                int rowCount = scanner.nextInt();
                int[][] matrix = new int[rowCount][rowCount];
                for (int i = 0; i < rowCount; i++) {
                    for (int j = 0; j < rowCount; j++) {
                        matrix[i][j] = scanner.nextInt();
                    }
                }
                solve(testNumber, matrix);
            }
        }
        System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }
}