/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;
import java.util.*;
import java.lang.*;

public class JavaApplication2 {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numberofcase=input.nextInt();
        
        for (int i=1;i<=numberofcase;i++){
            int size=input.nextInt();
            int[][] matrix=new int[size][size];
            
            for (int row=0;row<size;row++){
                for (int col=0;col<size;col++){
                    matrix[row][col]=input.nextInt();
                }
            }
            
            int[] output=dispose(matrix);
            System.out.println("Case #"+i+": "+output[0]+" "+output[1]+" "+output[2]);
        }
    }
    
    public static int[] dispose(int[][] matrix){
        int[] output=new int[3];
        int[] dp=new int[matrix.length+1];
                
        for (int i=0;i<matrix.length;i++){
            output[0]+=matrix[i][i];
        }
        
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                if (++dp[matrix[i][j]]>1){
                    output[1]++;
                    break;
                }
            }
            Arrays.fill(dp,0);
        }
        
        for (int j=0;j<matrix[0].length;j++){
            for (int i=0;i<matrix.length;i++){
                if (++dp[matrix[i][j]]>1){
                    output[2]++;
                    break;
                }
            }
            Arrays.fill(dp,0);
        }
        return output;
    }
}
