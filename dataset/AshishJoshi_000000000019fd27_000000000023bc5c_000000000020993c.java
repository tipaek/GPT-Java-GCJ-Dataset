import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution{
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i=1; i<=t; i++){
            int n = scan.nextInt();
            int[][] matrix = new int[n][n];
            for(int j=0; j<n; j++){
                for(int l=0; l<n; l++){
                    matrix[j][l] = scan.nextInt();
                }
            }
            //rows
            int r = 0, temp = 0;
            for(int j=0; j<n; j++){
                for(int l=0; l<n; l++){
                    temp = matrix[j][l];
                    if(containsRow(matrix,temp,n,j)){
                        r++;
                        break;
                    }
                }
            }
            //columns
            int c = 0;
            temp = 0;
            for(int j=0; j<n; j++){
                for(int l=0; l<n; l++){
                    temp = matrix[l][j];
                    if(containsCol(matrix,temp,n,l)){
                        c++;
                        break;
                    }
                }
            }
            //diagonals
            int k = 0;
            for (int j=0; j<n; j++) {
                k += matrix[j][j];
            }
            System.out.println("Case #"+i+": "+k+" "+r+" "+c);
        }
    }
    
    //count rows
	static boolean containsRow(int matrix[][],int temp, int n, int row){
        boolean result = false;
        int rcount = 0;
        for(int i=0; i<n; i++){
            if(matrix[row][i] == temp){
                rcount++;
            }
        }
        if(rcount>1){
            result = true;
        }
        return result;
    }
    //count columns
    static boolean containsCol(int matrix[][],int temp, int n, int col){
        boolean result = false;
        int ccount = 0;
        for(int i=0; i<n; i++){
            if(matrix[i][col] == temp){
                ccount++;
            }
        }
        if(ccount>1){
            result = true;
        }
        return result;
    }
}