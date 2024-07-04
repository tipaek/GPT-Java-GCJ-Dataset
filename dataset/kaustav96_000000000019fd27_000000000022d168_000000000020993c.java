import java.util.*;

public class Solution{
    private static void findLatinSquare(int x,int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int trace = 0;
        int count_rows = 0, count_cols = 0;
        for(int i=0;i<rows;i++){
            trace = trace + arr[i][i];
        }
        //row
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols-1;j++){
                if(arr[i][j]==arr[i][j+1]){
                    count_rows++;break;
                }
            }
        }
        //columns
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows-1;j++){
                if(arr[j][i]==arr[j+1][i]){
                    count_cols++;break;
                }
            }
        }
        System.out.println("Case #" +(x+1) +" "+ trace+" "+count_rows+" "+count_cols);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();//no. of test cases
        for(int i=0;i<t;i++){
            int n = sc.nextInt(); //size of matrix
            int[][] matrix = new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    matrix[j][k]=sc.nextInt();
                }
            }
            findLatinSquare(i,matrix);
        }
    }
}