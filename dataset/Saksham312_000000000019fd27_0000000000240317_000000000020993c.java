import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scn.nextInt();
        for (int i = 0; i < t ; i++) {
            int n = scn.nextInt();
            int trace = 0;
            int matrix[][] = new int[n][n];
            for (int j = 0; j < n ; j++) {
                for (int k = 0; k < n ; k++) {
                    matrix[j][k] = scn.nextInt();
                    if(j == k){
                        trace = trace + matrix[j][k];
                    }
                }
            }
            ArrayList<Integer> arr = new ArrayList<>();
            int row = 0, col = 0;
            {
                //Row Evaluation
                RowOuter:
                for (int j = 0; j < n ; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k == 0) {
                            arr.add(matrix[j][k]);
                        } else {
                            if (arr.contains(matrix[j][k])) {
                                row++;
                                continue RowOuter;
                            } else {
                                arr.add(matrix[j][k]);
                            }
                        }
                    }
                    arr.removeAll(arr);
                }
            }
            {   //Column Evaluation
                ColOuter:
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k == 0) {
                            arr.add(matrix[k][j]);
                        } else {
                            if (arr.contains(matrix[k][j])) {
                                col++;
                                continue ColOuter;
                            } else {
                                arr.add(matrix[k][j]);
                            }
                        }
                    }
                    arr.removeAll(arr);
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + row + " " + col);
        }
    }
}
