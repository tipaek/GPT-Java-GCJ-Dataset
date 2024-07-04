import java.util.HashSet;
import java.util.Scanner;

class Solution{
    public void checkPermutation(int[][] matrix, int n, int testNumber){
       HashSet<String> position = new HashSet<>();
       HashSet<Integer> row = new HashSet<>();
       HashSet<Integer> col = new HashSet<>();
       int diagonalSum = 0;
       for(int r = 0; r < n; r++){
           for(int c = 0; c < n; c++){
               if(r == c){
                   diagonalSum += matrix[r][c];
               }
            //    String row = matrix[r][c] + "found in row" + r;
               if(!position.add(matrix[r][c] + "found in row" + r)){
                   row.add(r);
               }
               if(!position.add(matrix[r][c] + "found in col" + c)){
                   col.add(c);
               }
           }
       }
    //    System.out.println(); 
       System.out.println("Case #"+testNumber+":"+" "+diagonalSum+" "+row.size()+" "+col.size());
    //    System.out.println(diagonalSum + "is the diagonalSum");
    //    System.out.println(row.size() + "is the row size");
    //    System.out.print(col.size() + "is the col size");
    }
}

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int n = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    matrix[r][c] = sc.nextInt();
                }
            }
            // for(int r = 0; r < n; r++){
            //     for(int c = 0; c < n; c++){
            //         // matrix[r][c] = sc.nextInt();
            //         System.out.print(matrix[r][c] + " ");
            //     }
            // }
            Solution obj = new Solution();
            obj.checkPermutation(matrix, n, i+1);
        }
    }
}