import java.util.*;
import java.io.*;

public class Solution{
    static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static int t = in.nextInt();
    public static void main(String[] args){
        for(int loop=1;loop<=t; t++){
            
            int size = in.nextInt();
            int[][] matrix = new int[size][size];
            
            for(int j=0; j<matrix.length; j++){
                for(int k=0; k<matrix[j].length; k++){
                    matrix[j][k] = in.nextInt();
                }
            }
            
            //loop through each row
            int r = 0;
            for(int j=0; j<matrix.length; j++){
                if(hasDuplicates(matrix[j]))
                    r++;
            }
            
            //loop through columns
            int c = 0;
            int[] temp = new int[size];
            for(int j=0; j<matrix.length; j++){
                for(int k=0; k<matrix[j].length; k++){
                    temp[k] = matrix[k][j];
                }
                
                if(hasDuplicates(temp))
                    c++;
                
            }
            
            //compute trace
            int trace = 0;
            for(int x=0; x<size; x++){
                trace += matrix[x][x];
            }
            
            //print desired results
            System.out.println("Case #" + loop + " " + trace + " " + r + " " + c);
            
        }
    }
    
    
    public static boolean hasDuplicates(int[] arr){
        for(int x=0; x<arr.length; x++){
            for(int y=x+1; y<arr.length; y++){
                if(arr[x]==arr[y])
                    return true;
            }
        }
        
        return false;
        
    }
    
}