import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String [] args) {
        Random random = new Random();
        Scanner scannerInt = new Scanner (new BufferedReader(new InputStreamReader(System.in))) ;

        int k;
        int r;
        int c;
        int cflag;
        int rflag;

        int t = scannerInt.nextInt();

        for(int x=0; x<t; x++){
            r = 0;
            c = 0;
            k = 0;
            int n = scannerInt.nextInt();
            int matrix[][] = new int[n][n];
            
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < n; m++) {
                    matrix[j][m] = scannerInt.nextInt();
                    if (j == m) {
                        k = k + matrix[j][m];
                    }
                }
            }

            for(int i=0; i<n; i++){
                rflag=0;
                cflag=0;
                for(int j=0; j < n-1; j++){

                    for(int m=j+1; m < n; m++){
                        if(matrix[i][j]==matrix[i][m] ){
                            rflag=1;

                        }
                        if(matrix[j][i]==matrix[m][i] ){
                            cflag=1;
                        }
                    }
                }
                if(rflag==1){ r = r +1; }
                if(cflag==1){ c = c +1; }
            }
            System.out.println("Case #"+ x+1 + ": " + k + " " + r + " " + c);
        }
    }
}