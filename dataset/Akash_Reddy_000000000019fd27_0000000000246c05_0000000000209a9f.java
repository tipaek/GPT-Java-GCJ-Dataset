import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) throws IOException{
       BufferedReader rs = new BufferedReader(new InputStreamReader(System.in));
       int T = Integer.parseInt(rs.readLine());
       int nn = 1;
       while(T>0){
           String[] ss = rs.readLine().split("");
           int ln = ss.length;
           int[] arr = new int[ln];
           String end = "";
           for(int i=0;i<ln;i++){
               arr[i] = Integer.parseInt(ss[i]);
           }
           for(int i=0;i<ln;i++){
               int x = arr[i];
               if(i==0){
                   while(x>0){
                    end+="(";  
                    x--;
                   }
                   end+=Integer.toString(arr[0]);
                   continue;
               }
               if(x>arr[i-1]){
                   x = x - arr[i-1];
                   while(x>0){
                       end+="(";
                       x--;
                   }
                   end+=Integer.toString(arr[i]);
                   continue;
               }
               if(x==arr[i-1]){
                   end+=Integer.toString(arr[i]);
                   continue;
               }
               if(x<arr[i-1]){
                   x = arr[i-1] - x;
                   while(x>0){
                       end+=")";
                       x--;
                   }
                   end+=Integer.toString(arr[i]);
                   continue;
               }
           }
           int xx = arr[ln-1];
           while(xx>0){
               end+=")";
               xx--;
           }
           System.out.println("Case #"+nn+": "+end);
           nn++;
           T--;
       }
    }
}
