import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        LinkedList<testcas> testcases = new LinkedList<>();
        testcas temp = null;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int size = in.nextInt();
            temp = new testcas(i, size);
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < size; k++) {
                    temp.matrix[j][k] = in.nextInt();
                }
            }
            temp.calculateSolution();
            testcases.add(temp);
        }
    }
}

class testcas {

    int id;
    int[][] matrix;
    int trace = 0;
    int no_of_cols = 0;
    int no_of_rows = 0;
    String output;

    testcas(int id,int matrixsize) {
        this.id = id;
        this.matrix = new int[matrixsize][matrixsize];
    }

    void calculateSolution() {
        for (int i = 0; i < matrix.length; i++) {
            trace = trace + matrix[i][i];
        }

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> rowset = new HashSet<Integer>();
            for (int j = 0; j < matrix.length; j++) {
                if (rowset.contains(matrix[i][j])) {
                    no_of_rows++;
                    break;
                } else {
                    rowset.add(matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            HashSet<Integer> colset = new HashSet<>();
            for (int j = 0; j < matrix.length; j++) {
                if (colset.contains(matrix[j][i])) {
                    no_of_cols++;
                    break;
                }
                else {
                    colset.add(matrix[j][i]);
                }
            }
        }

        output = "Case #" + String.valueOf(id) + ": " + String.valueOf(trace) + " " + String.valueOf(no_of_rows) + " "
                + String.valueOf(no_of_cols);
        System.out.println(output);
    }

}