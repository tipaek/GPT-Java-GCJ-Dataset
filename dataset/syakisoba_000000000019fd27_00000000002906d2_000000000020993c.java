import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int[][] matrix = new int[n][n];
            int trace = 0;
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    matrix[j][k] = in.nextInt();
                    
                    if(j==k){
                        trace +=matrix[j][k];
                    }
                    //System.out.println(j + ", " + k + ": " + matrix[j][k]);
                    //System.out.println("trace: " + trace + " rowD: "+ rDupCount+"k:"+k);
                }   
            }
            int rowD = rDupA(matrix, n);
            int columnD = cDupA(matrix, n);
            
            System.out.println("Case #" + i + ": " + trace + " "+ rowD +" "+ columnD);
        }
    }
    
    
    public static int rDupA(int[][] abc, int num){
        int rDupCount = 0;
        
        for(int i = 0; i< num; i++){
            int[] aRay = new int[num];
            
            for(int j = 0; j< num; j++){
                if(aRay[abc[i][j]-1] == 0){
                    aRay[abc[i][j]-1]++;
                    //System.out.println("//"+aRay[abc[i][j]-1]+" :"+i+", "+j);
                }else{
                    //System.out.println("asd"+aRay[abc[i][j]-1]+" :"+i+", "+j);
                    rDupCount++;
                    break;
                }
            }
        }    
        return rDupCount;
    }
    
    public static int cDupA(int[][] abc, int num){
        int cDupCount = 0;
        
        for(int i = 0; i< num; i++){
            int[] aRay = new int[num];
            
            for(int j = 0; j< num; j++){
                if(aRay[abc[j][i]-1] == 0){
                    aRay[abc[j][i]-1]++;
                    //System.out.println("//"+aRay[abc[j][i]-1]+" :"+j+", "+i);
                }else{
                    //System.out.println("asd"+aRay[abc[j][i]-1]+" :"+j+", "+i);
                    cDupCount++;
                    break;
                }
            }
        }    
        return cDupCount;
    }
}