import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = Integer.parseInt(in.nextLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= testCases; ++i) {
            int repeatedRows = 0;
            int repeatedColumns = 0;
            int trace = 0;
            int matrixSize = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            int[][] matrixColumns = new int[matrixSize][matrixSize];
            for (int j = 0; j < matrixSize; j++) {
                boolean repeatedRow = false;
                int[] matrixLine = new int[matrixSize];
                String line = in.nextLine();
                String[] tmp = line.split("\\s+");
                for (int x = 0; x < matrixSize; x++) {
                    int element = Integer.parseInt(tmp[x]);
                    if (!repeatedRow) {
                        for (int e : matrixLine) {
                            if (element == e) {
                                repeatedRow = true;
                                break;
                            }
                        }
                    }
                    matrixLine[x] = element;
                    if (x == j) {
                        trace += element;
                    }
                    matrixColumns[x][j] = element;
                }
                matrix[j] = matrixLine;
                if (repeatedRow) {
                    repeatedRows++;
                }
            }
            for (int j = 0; j < matrixSize; j++) {
                boolean repeatedColumn = false;
                for (int k = 0; k < matrixSize; k++) {
                    if (!repeatedColumn) {
                        for (int l = k+1; l < matrixSize; l++) {
                            if (matrixColumns[j][k] == matrixColumns[j][l]) {
                                repeatedColumn = true;
                                break;
                            }
                        }
                    }
                }
                if (repeatedColumn) {
                    repeatedColumns++;
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + repeatedRows + " " + repeatedColumns);
        }
    }
}