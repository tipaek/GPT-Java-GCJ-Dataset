import java.util.*;
import java.io.*;
public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNum =  in.nextInt();
        for(int i = 0; i < testNum; i++){
            int sqSize = in.nextInt();
            int xor = 0;
            for(int j = 1; j <= sqSize; j++){
                xor ^= j;
            }
            int[][] ansArray = new int[2][sqSize];
            // store xor value of
            // row 1 2 ...
            // col 1 2 ...
            for(int j = 0; j < sqSize; j++){
                ansArray[0][j] = xor;
                ansArray[1][j] = xor;
            }
            int trace = 0;
            for(int j = 0; j < sqSize; j++){
                for(int k = 0; k < sqSize; k++){
                    int curNum = in.nextInt();
                    ansArray[0][j] ^= curNum;
                    ansArray[1][k] ^= curNum;
                    if(j == k){
                        trace += curNum;
                    }
                }
            }
            int repRow = 0;
            int repCol = 0;
            for(int j = 0; j < sqSize; j++){
                if(ansArray[0][j] != 0) repRow ++;
                if(ansArray[1][j] != 0) repCol ++;
            }
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + repRow + " " + repCol);
        }
    }
    
    
}