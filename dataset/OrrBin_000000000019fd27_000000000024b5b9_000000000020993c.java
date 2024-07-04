import java.util.*;
import java.io.*;

public class Vestigium {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            var matrix = new int[n][n];

            var badRows = 0;
            var badCols = 0;

            var trace = 0;
            //Fill up the matrix, and calc the trace
            for(var row = 0; row < n; row++) {
                var rowNumbers = new boolean[n];
                for(var col = 0; col < n; col++) {
                    var val = in.nextInt();
                    matrix[row][col] = val;

                    rowNumbers[val-1] = true;

                    if(row == col)
                        trace += val;
                }

                for(var cell = 0; cell < n; cell++) {
                    if(!rowNumbers[cell]) {
                        badRows++;
                        break;
                    }
                }

            }

            for(var col = 0; col < n; col++) {
                var colNumbers = new boolean[n];
                for(var row = 0; row < n; row++) {
                    var val = matrix[row][col] ;

                    colNumbers[val-1] = true;
                }

                for(var cell = 0; cell < n; cell++) {
                    if(!colNumbers[cell]) {
                        badCols++;
                        break;
                    }
                }
            }

            System.out.println(String.format("Case #%d: %d %d %d", i+1, trace, badRows, badCols));
        }
    }
}
