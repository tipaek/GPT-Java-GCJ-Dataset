import java.util.*;
import java.io.*;
public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testNum =  in.nextInt();
        for(int i = 1; i <= testNum; i++){
            int sqSize = in.nextInt();
            int[][] row = new int[sqSize + 1][sqSize + 1];
            int[][] col = new int[sqSize + 1][sqSize + 1];
            int trace = 0;
            // row/col index(count)
            //   1      1 2 3 4
            //   2      1 2 3 4
            //   3      1 2 3 4
            for(int j = 1; j <= sqSize; j++){
                for(int k = 1; k <= sqSize; k++){
                    int num = in.nextInt();
                    row[j][num] ++;
                    col[k][num] ++;
                    if(j == k){
                        trace += num;
                    }
                }
            }
            int repRow = 0;
            int repCol = 0;
            for(int j = 1; j <= sqSize; j++){
                for(int k = 1; k <= sqSize; k++){
                    if(row[j][k] != 1){
                        repRow ++;
                        break;
                    }
                }
            }
            for(int j = 1; j <= sqSize; j++){
                for(int k = 1; k <= sqSize; k++){
                    if(col[j][k] != 1){
                        repCol ++;
                        break;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + repRow + " " + repCol);
        }
    }
    
    
}