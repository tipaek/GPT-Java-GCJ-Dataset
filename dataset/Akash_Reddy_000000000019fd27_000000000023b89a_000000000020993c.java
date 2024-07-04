import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) throws IOException{
       BufferedReader rs = new BufferedReader(new InputStreamReader(System.in));
         Set<Integer> hash_Set; 
       int T = Integer.parseInt(rs.readLine());
       int nn = 1;
       while(T>0){
           int n = Integer.parseInt(rs.readLine());
           int[][] arr = new int[n][n];
           for(int i=0;i<n;i++){
               String[] ss = rs.readLine().split(" ");
               for(int j=0;j<n;j++){
                   arr[i][j] = Integer.parseInt(ss[j]);
               }
//               System.out.println(Arrays.toString(arr[i]));
           }
           int tp = 0;
           int r = 0;
           int c = 0;
           for(int i=0;i<n;i++){
               hash_Set = new HashSet<Integer>();
               boolean flag1 = false;
               tp += arr[i][i];
               for(int j=0;j<n;j++){
                   if(!hash_Set.add(arr[i][j]) && !flag1){
                       r++;
                       flag1 = true;
                   }
               }            
           }
           for(int i=0;i<n;i++){
               hash_Set = new HashSet<Integer>();
               boolean flag = false;
               for(int j=0;j<n;j++){
                   if(!hash_Set.add(arr[j][i]) && !flag){
                       c++;
                       flag = true;
                   }
               }            
           }
           System.out.println("Case #"+nn+": "+ tp+" "+r+" "+c);
           nn++;
           T--;
       }
       System.out.println(rs.readLine());
    }
}
