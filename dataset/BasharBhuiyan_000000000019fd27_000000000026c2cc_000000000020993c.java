import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++){
            int N = sc.nextInt();
            int[][] column = new int[N][N];
            int[][] row = new int[N][N];
            int[] columnFlag = new int[N];
            
            int trace = 0, repCol = 0, repRow = 0;
            
            for(int j = 0; j < N; j++){
                boolean rowDone = false;
                for(int k = 0; k < N; k++){
                    int cell = sc.nextInt();
                    
                    if(j == k) trace += cell;
                    
                    row[j][cell-1]++;
                    column[k][cell-1]++;
                    
                    if(row[j][cell-1] >= 2 && !rowDone){
                       repRow++;
                       rowDone = true;
                    }
                    
                    if(column[k][cell-1] >= 2 && columnFlag[k] != 1){
                        columnFlag[k] = 1;
                        repCol++;
                    }
                }
            }
            
            System.out.println("Case #" + i + ": " +trace + " " + repRow + " " +repCol);
        }
        
  
    }

}