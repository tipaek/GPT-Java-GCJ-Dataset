import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        
        int numCases, n, k, r, c, x;
        File inputFile = new File(args[0]);

        Scanner scanner = new Scanner(inputFile);

        numCases = scanner.nextInt();
        
        for(int i = 1; i <= numCases; i++) {
            k = r = c = x = 0;
            n = scanner.nextInt();
            
            int[][] numMatrix = new int[n][n];
            int[] dummyMatrix = new int[n];

            for(int row = 0; row < n; row++){
                for(int col = 0; col < n; col++){
                    numMatrix[row][col] = scanner.nextInt();
                }
            }

            for(int i2 = 0; i2 < n; i2++) {
                
                for(int index = 0; index < n; index++){dummyMatrix[index] = 0;}

                for(int j = 0; j < n; j ++){
                    
                    x = numMatrix[i2][j];

                    if(dummyMatrix[x-1] == 0){
                        dummyMatrix[x-1] = x;
                    }
                    else {
                        r++;
                        j = n;
                    }                        
                }
            }

            for(int i2 = 0; i2 < n; i2++) {
                
                for(int index = 0; index < n; index++){dummyMatrix[index] = 0;}

                for(int j = 0; j < n; j ++){
                    
                    x = numMatrix[j][i2];

                    if(dummyMatrix[x-1] == 0){
                        dummyMatrix[x-1] = x;
                    }
                    else {
                        c++;
                        j = n;
                    }                        
                }
            }

            for(int i2 = 0; i2 < n; i2++){ k = k + numMatrix[i2][i2]; }

            System.out.println("Case #" + i + ": " + k + " " + r + " " + c);

        }

        scanner.close();
    }
}
