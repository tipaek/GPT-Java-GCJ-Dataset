import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Code_Jam {
    public static void main(String[] args) {
        Scanner scn  = new Scanner(System.in);
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
            int row = 0, col = 0;
            {
                //Row Evaluation
                RowOuter:
                for (int j = 0; j < n ; j++) {
                    Arrays.sort(matrix[i]);
                    for (int k = 0; k < n-1 ; k++) {
                        if(matrix[j][k] == matrix[j][k+1]){
                            row++;
                            continue RowOuter;
                        }
                    }
                }
            }
            {   //Column Evaluation
                ColOuter:
                for (int j = 0; j < n; j++) {
                    ArrayList<Integer> arr = new ArrayList<>();
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
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + row + " " + col);
        }
    }
}
