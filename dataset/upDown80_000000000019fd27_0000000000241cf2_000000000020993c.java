import java.util.*;

class Solution {
    static void Diagonal(int[][]mat,int row,int col,int n) {
        int left =  0;
        for(int i = 0; i < n; i++){
            left += mat[i][i];
        }
        System.out.println(left);
    }
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        int t = obj.nextInt();
        int n = obj.nextInt();
        int row = obj.nextInt();
        int col = row;
        while(t-- > 0) {
            int number[][] = new int[row][col];
            
            for(int a = 0; a < row; a++){
                
                for(int b = 0; b < col; b++){
                    
                    number[a][b] = obj.nextInt();
                }
            }
            Diagonal(number,row,col,n);
        }
        
    }
}