import java.util.*;
import java.io.*;
public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNum =  in.nextInt();
        for(int i = 1; i <= testNum; i++){
            int sqSize = in.nextInt();
            int xor = 0;
            int sum = 0;
            for(int j = 1; j <= sqSize; j++){
                xor ^= j;
                sum += j;
            }
            int[][] ansArray = new int[4][sqSize];
            // store xor value of
            // row 1 2 ...
            // col 1 2 ...
            // store sum value of
            // row 1 2 ...
            // col 1 2 ...
            int trace = 0;
            for(int j = 0; j < sqSize; j++){
                for(int k = 0; k < sqSize; k++){
                    int curNum = in.nextInt();
                    ansArray[0][j] ^= curNum;
                    ansArray[1][k] ^= curNum;
                    ansArray[2][j] += curNum;
                    ansArray[3][k] += curNum;
                    if(j == k){
                        trace += curNum;
                    }
                }
            }
            int repRow = 0;
            int repCol = 0;
            for(int j = 0; j < sqSize; j++){
                if((ansArray[0][j] ^ xor) != 0 || (ansArray[2][j] - sum) != 0){
                    repRow ++;
                }
                if((ansArray[1][j] ^ xor) != 0 || (ansArray[3][j] - sum) != 0)
                    repCol ++;
                }
            System.out.println("Case #" + i + ": " + trace + " " + repRow + " " + repCol);
        }
    }
    
    
}