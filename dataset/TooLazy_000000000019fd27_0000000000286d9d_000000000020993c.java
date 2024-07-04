import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int no = 0;
        while(no < testCase){
            no++;
            int N = scanner.nextInt();
            int[][] matrix = new int[N][N];
            int trace = 0;
            int r_row = 0;
            int r_col = 0;
            for(int i = 0;i < N;i++){
                boolean[] hasUsed = new boolean[N+1];
                boolean repeat = false;
                for(int j = 0;j < N;j++){
                    matrix[i][j] = scanner.nextInt();
                    if(i == j) trace += matrix[i][j];
                    if((!repeat) && hasUsed[matrix[i][j]]) repeat = true;
                    else
                        hasUsed[matrix[i][j]] = true;
                }
                if(repeat) r_row++;
            }
            for(int j = 0;j < N;j++){
                boolean[] hasUsed = new boolean[N+1];
                boolean repeat = false;
                for(int i = 0;i < N;i++){
                    if((!repeat) && hasUsed[matrix[i][j]]) repeat = true;
                    else
                        hasUsed[matrix[i][j]] = true;
                }
                if(repeat) r_col++;
            }
            
          System.out.println("Case #"+ no + ": "+trace+" "+r_row+" "+r_col);
        }
    }
}