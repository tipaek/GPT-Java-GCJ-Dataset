import java.util.Scanner;
import java.util.Random;

public class Solution {
    public static void main(String [] args) {
        Random random = new Random();
        Scanner scannerInt = new Scanner (System.in);

        int k;
        int r;
        int c;
        int cflag;
        int rflag;

        System.out.print("Enter the number of test cases: ");
        int t = scannerInt.nextInt();

        System.out.print("Enter the size of the matrix: ");
        int n = scannerInt.nextInt();

        
        System.out.println("The matrix will be completed automatically...");
        int matrix[][] = new int[n][n];

        for(int x=0; x<t; x++){
            r = 0;
            c = 0;
            k = 0;
            
            for (int j = 0; j < n; j++) {
                for (int m = 0; m < n; m++) {
                    matrix[j][m] = random.nextInt(n) + 1;
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
            System.out.println("Case #"+ x+1 + " " + k + " " + r + " " + c);
        }
    }
}