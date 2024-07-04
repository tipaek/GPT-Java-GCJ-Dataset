import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
class Solution {
    public static void main(String[] args){
               Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i < t; i++){
            int n = scan.nextInt();
            int trace = 0;
            int rows = 0;
            int columns = 0;
            int[][] arr = new int[n][n];
            for(int j = 0; j < n; j++){
            	Set<Integer> set = new HashSet<>();
            	boolean flag = false;
                for(int k = 0; k < n; k++){
                    arr[j][k] = scan.nextInt();
                    if(j == k){
                        trace = trace + arr[j][k];
                    }
                    if(set.contains(arr[j][k]) && !flag ){
                        rows++;
                        flag = true;
                    } else
                        set.add(arr[j][k]);
                }
            }
            for(int j = 0; j < n; j++){
            	Set<Integer> set = new HashSet<>();
            	boolean flag = false;
                for(int k = 0; k < n; k++){
                    if(set.contains(arr[k][j]) && !flag ){
                        columns++;
                        flag = true;
                    } else {
                    	set.add(arr[k][j]);
                    }
                }
            }
            System.out.println("Case #" + (i + 1) +  ": " + trace + " " + rows + " " + columns);
        }
        scan.close();
        return;
    }
}