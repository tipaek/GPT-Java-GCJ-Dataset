import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

class Solution {

    class InputDataObject {
        int[][] matrix;

        public InputDataObject(int[][] matrix) {
            this.matrix = matrix;
        }
    }

    public static ArrayList<InputDataObject> getDataFromStdin() {
        ArrayList<InputDataObject> res = new ArrayList<>();
        Scanner myReader = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        System.out.println("Got reader");

        int T = 0, N = 0;
        if (myReader.hasNextLine()) {
            T = Integer.valueOf(myReader.nextLine());
        }

        for (int i = 0; i < T; i++) {
            System.out.println("Got test case " + i);
            if (myReader.hasNextLine()) {
                N = Integer.valueOf(myReader.nextLine());
            }
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                if (myReader.hasNextLine()) {
                    String[] rowVals = myReader.nextLine().replace("\n", "").trim().split(" ");
                    for (int k = 0; k < N; k++) {
                        matrix[j][k] = Integer.valueOf(rowVals[k]);
                    }
                }

            }
            res.add(new Solution(). new InputDataObject(matrix));
        }
        return res;
    }

    public static boolean getRowValidity(int[][] matrix, int rowVal) {
        HashSet<Integer> foundVals = new HashSet<>();
        for (int i = 0; i < matrix[rowVal].length; i++) {
            if (foundVals.contains(matrix[rowVal][i])) return false;
            else foundVals.add(matrix[rowVal][i]);
        }
        return true;
    }

    public static boolean getColValidity(int[][] matrix, int colVal) {
        HashSet<Integer> foundVals = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            if (foundVals.contains(matrix[i][colVal])) return false;
            else foundVals.add(matrix[i][colVal]);
        }
        return true;
    }

    public static int calcTrace(int[][] matrix) {
        int trace = 0 ;
        for (int i = 0; i < matrix.length; i++) {
            trace += matrix[i][i];
        }
        return trace;
    }

    public static void main(String[] args) {
        ArrayList<InputDataObject> inputData = getDataFromStdin();
        System.out.println("Read finished");
        int testCaseNum = 1;
        for (InputDataObject currInput : inputData) {
            int trace = calcTrace(currInput.matrix);
            int rowsWithRepeat = 0, colsWithRepeat = 0;
            for (int i = 0; i < currInput.matrix.length; i++) {
                if (!getRowValidity(currInput.matrix, i)) {
                    rowsWithRepeat ++;
                }
            }
            for (int i = 0; i < currInput.matrix.length; i++) {
                if (!getColValidity(currInput.matrix, i)) {
                    colsWithRepeat++;
                }
            }
            System.out.printf("Case #%d: %d %d %d\n", testCaseNum, trace, rowsWithRepeat, colsWithRepeat);
            testCaseNum++;
        }
    }
}
