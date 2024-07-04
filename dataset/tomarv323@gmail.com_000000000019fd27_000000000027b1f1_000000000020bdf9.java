 import java.util.*;
    import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
           int n = Integer.parseInt(br.readLine());
           int [][] arr = new int[n][2];
           
           for(int j=0; j<n; j++){
               String [] inp = br.readLine().split(" ");
               arr[j][0]= Integer.parseInt(inp[0]);
               arr[j][1]= Integer.parseInt(inp[1]);
           }
           
           Arrays.sort(arr, new Comparator<int []>(){
              public int compare(int [] a, int [] b){
                  if(a[1] != b[1]){
                      return a[1]- b[1];
                  }else{
                      return a[0]- b[0];
                  }
              } 
           });
           
           int prevc= -1;
           int prevj = -1;
           StringBuffer ans = new StringBuffer();
           int j=0;
           for(; j<n; j++){
               if(arr[j][0] >= prevc){
                   ans.append("C");
                   prevc= arr[j][1];
               }else if(arr[j][0]>= prevj){
                   ans.append("J");
                   prevj = arr[j][1];
               }else{
                   break;
               }
           }
           if(j<n){
               ans = new StringBuffer("IMPOSSIBLE");
           }
          System.out.println("Case #" + i + ": " + ans);
        }
    }
}