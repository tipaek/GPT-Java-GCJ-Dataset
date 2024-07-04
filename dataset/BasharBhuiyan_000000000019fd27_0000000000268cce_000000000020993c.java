import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        for (int i = 1; i <= t; i++){
            int N = sc.nextInt();
            int[][] column = new int[N][N];
            int[][] row = new int[N][N];
            
            int trace = 0, maxCol = 0, maxRow = 0;
            
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++){
                    int cell = sc.nextInt();
                    
                    if(j == k) trace += cell;
                    
                    row[j][cell-1]++;
                    column[k][cell-1]++;
                    
                    if(row[j][cell-1] > maxRow){
                        maxRow = row[j][cell-1];
                    }
                    
                    if(column[k][cell-1] > maxCol){
                        maxCol = column[k][cell-1];
                    }
                }
            }
            
            if(maxCol == 1){
                maxCol = 0;
            }
            if(maxRow == 1){
                maxRow = 0;
            }
            
            System.out.println("Case #" + i + ": " +trace + " " + maxRow + " " +maxCol);
        }
        
  
    }

}