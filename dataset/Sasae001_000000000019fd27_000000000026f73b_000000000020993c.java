import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int c = 1; c <= t; ++c) {
            int n = in.nextInt();
            int trace=0;
            int matrix[][]= new int[n][n];
            for (int i = 0; i<n; i++) {
                for (int j = 0; j < n; j++) {
                    int m = in.nextInt();
                    matrix[i][j] = m;
                    if(i==j){
                        trace+=m;
                    }
                }
            }
            int rowC =0;
            for ( int row =0; row<n; row++){
                for(int rowValue1=0; rowValue1<n; rowValue1++){
                    for (int rowValue2=1; rowValue2<n;rowValue2++){
                        if(matrix[row][rowValue1]==matrix[row][rowValue2]&&rowValue1!=rowValue2){
                            rowC++;
                            row++;
                            break;
                        }
                    }
                    if(row>=n){
                        break;
                    }
                }
            }
            int columnC =0;
            boolean columnCed=false;
            for ( int column =0; column<n; column++) {
                for (int columnValue1 = 0; columnValue1 < n; columnValue1++) {
                    for (int columnValue2 = 1; columnValue2 < n ; columnValue2++) {
                        if (matrix[columnValue1][column] == matrix[columnValue2][column]&&columnValue1!=columnValue2&&columnCed==false) {
                            columnC++;
                            columnCed=true;
                            break;
                        }
                    }
                    if (column >= n) {
                        break;
                    }
                }
                columnCed=false;
            }
            System.out.println("Case #" + c + ": " + (trace) + " " + (rowC)+ " " + (columnC));

        }
    }
}
