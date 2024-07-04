import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++) {
                    int val = in.nextInt();
                    matrix[j][k] = val;
                }
            }
            list = matrix(matrix, n);
            System.out.println("Case #" + i + ": " + list.get(0) + " " + list.get(1) + " " + list.get(2));
        }
    }

    public static ArrayList<Integer> matrix(int[][] matrix,int n) {
        int trace = 0;
        for (int i = 0; i < n; i++) {
            trace += matrix[i][i];
        }

        ArrayList<Integer> rowList = new ArrayList<>();
        ArrayList<Integer> duplicateList = new ArrayList<>();
        int row = 0;
        int cul = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <n; j++){
                rowList.add(matrix[i][j]);
            }

            for (int k = 1; k<=n; k++){
                int rowDuplicate = Collections.frequency(rowList, k);
                if(rowDuplicate >= 2){
                    row++;
                    break;
                }


            }
            rowList.clear();
        }
        //int rowCount = Collections.max(duplicateList);
        duplicateList.clear();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <n; j++){
                rowList.add(matrix[j][i]);
            }

            for (int k = 1; k <= n; k++){
                int rowDuplicate = Collections.frequency(rowList, k);
                if(rowDuplicate >= 2){
                    cul++;
                    break;
                }
            }
            rowList.clear();
        }
        //int culCount = Collections.max(duplicateList);
        duplicateList.clear();

        ArrayList<Integer> returnValue = new ArrayList<>();
        returnValue.add(trace);
        returnValue.add(row);
        returnValue.add(cul);

        return returnValue;
    }
}