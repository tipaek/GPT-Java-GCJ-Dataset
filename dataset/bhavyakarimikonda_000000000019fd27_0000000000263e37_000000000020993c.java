import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int test = 0;
        while(t > 0){
            test++;
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            int[][] atp = new int[n][n];
            int trace = 0, r = 0, c= 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    arr[i][j] = sc.nextInt();
                    atp[j][i] = arr[i][j];
                    if(i==j)
                        trace += arr[i][j];
                }
                if(!isValid(arr[i]))r++ ;
            }
            for(int i=0; i<n; i++){
                if(!isValid(atp[i]))c++ ;
            }
            System.out.println("Case #"+test+": "+trace+" "+r+" "+c);
            t--;
        }
    }
    
    public static boolean isValid(int[] arr){
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            for(int j=i+1; j<n; j++){
                if(arr[i]==arr[j]){
                    return false;
                }
            }
        }
        return true;
    }
}













