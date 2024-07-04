import java.util.*;
import java.io.*;


public class Solution{
    
    public static void findMattNums(int[][] arr, int caseNum){
        int n = arr.length;
        int trace = 0;
        int repeatRow = 0;
        for(int i = 0 ; i < n ; i++){
            Set<Integer> set = new HashSet<Integer>();
            for(int j = 0 ; j < n ; j++){
                set.add(arr[i][j]);
                if(i == j){
                    trace += arr[i][j];
                }
            }
            if(set.size() < n){
                repeatRow++;
            }
        }
        int repeatCol = 0;
        for(int i = 0 ; i < n ; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0 ;j < n ;j++){
                set.add(arr[j][i]);
            }
            if(set.size() < n){
                repeatCol++;
            }
        }
        System.out.println("Case #"+caseNum+": "+trace+" "+repeatRow+" "+repeatCol);
    }
    
    public static void main(String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for( int i = 0 ; i < t ; i++){
        int n;
        n = in.nextInt();
        int[][] arr = new int[n][n];
        for(int j = 0 ; j < n ; j++){
            for(int k = 0 ; k < n ; k++){
                arr[j][k] = in.nextInt();
            }
        }
        findMattNums(arr, i+1);
    }
}
}