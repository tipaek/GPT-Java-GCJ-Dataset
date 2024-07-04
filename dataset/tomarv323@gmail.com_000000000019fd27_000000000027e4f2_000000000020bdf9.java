 import java.util.*;
    import java.io.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
           int n = Integer.parseInt(br.readLine());
           int [][] arr = new int[n][4];
           
           for(int j=0; j<n; j++){
               String [] inp = br.readLine().split(" ");
               arr[j][0]= Integer.parseInt(inp[0]);
               arr[j][1]= Integer.parseInt(inp[1]);
               arr[j][2]= j+1;
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
           
           
           int curr= 1;
           int prevc= -1;
           int prevj = -1;
           StringBuffer ans = new StringBuffer();
           int j=0;
           for(; j<n; j++){
               if(curr== 1){
                  if(arr[j][0] >= prevc){
                   arr[j][3]= 1;
                   prevc= arr[j][1];
                 }else if(arr[j][0]>= prevj){
                   arr[j][3]= 2;
                   prevj = arr[j][1];
                   curr = 2;
                  }else{
                   break;
                 }
               }else{
                   if(arr[j][0] >= prevj){
                   arr[j][3]= 2;
                   prevj= arr[j][1];
                 }else if(arr[j][0]>= prevc){
                   arr[j][3]= 1;
                   prevc = arr[j][1];
                   curr= 1;
                  }else{
                   break;
                 }
               }
           }
           if(j<n){
               ans = new StringBuffer("IMPOSSIBLE");
           }else{
               Arrays.sort(arr, new Comparator<int []>(){
                  public int compare(int [] a, int [] b){
                      return a[2]- b[2];
                  } 
               });
               
               for(int k=0; k<n; k++){
                   if(arr[k][3]==1){
                       ans.append("C");
                   }else{
                       ans.append("J");
                   }
               }
           }
           
           
          System.out.println("Case #" + i + ": " + ans);
        }
    }
}