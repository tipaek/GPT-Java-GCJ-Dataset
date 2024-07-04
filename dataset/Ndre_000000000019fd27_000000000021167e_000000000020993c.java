import java.util.HashSet;
import java.util.Scanner;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            int sum = 0;
            int row = 0;
            int col = 0;
            for(int j=0;j<n;j++){
                HashSet<Integer> currentRow = new HashSet<>();
                boolean bool = false;
                for(int k=0;k<n;k++){
                   matrix[j][k] = sc.nextInt();
                   if(j==k) sum+=matrix[j][k];
                   if(!bool){
                       if(currentRow.contains(matrix[j][k])){
                           row++;
                           bool=true;
                       }
                       else{
                           currentRow.add(matrix[j][k]);
                       }
                   }
               }
            }
            for(int j=0;j<n;j++){
                HashSet<Integer> currentCol = new HashSet<>();
                boolean bool = false;
                for(int k=0;k<n;k++){
                    if(!bool){
                        if(currentCol.contains(matrix[k][j])){
                            col++;
                            bool=true;
                        }
                        else{
                            currentCol.add(matrix[k][j]);
                        }
                    }
                }
            }
            System.out.println("Case #"+i+": " + sum + " " + row + " " + col);
        }
        sc.close;
    }
}