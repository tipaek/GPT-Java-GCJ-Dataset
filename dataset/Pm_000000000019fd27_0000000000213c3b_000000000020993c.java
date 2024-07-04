import java.util.*;
public class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
     int t = sc.nextInt();
     int testCase = 1;
     while(t-->0){
         int n = sc.nextInt();
         int[][] m = new int[n][n];
         for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 m[i][j] = sc.nextInt();
             }
         }
         int sum = 0;
           for(int i=0;i<n;i++){
             for(int j=0;j<n;j++){
                 if(i==j){
                     sum = sum+m[i][j];
                 }
             }
         }
         
            int rowCount = 0;
            for(int i=0;i<n;i++){
                Map<Integer, Integer> map = new HashMap<>();
             for(int j=0;j<n;j++){
                if(map.containsKey(m[i][j])){
                    rowCount++;
                    break;
                }else{
                    map.put(m[i][j], 1);
                }
             }
         }
         
         int colCount = 0;
            for(int i=0;i<n;i++){
                Map<Integer, Integer> map = new HashMap<>();
             for(int j=0;j<n;j++){
                if(map.containsKey(m[j][i])){
                    colCount++;
                    break;
                }else{
                    map.put(m[j][i], 1);
                }
             }
         }
         
         System.out.println("Case #"+testCase+": "+sum+" "+rowCount+" "+colCount);
         testCase++;
         
     }

    }
}
