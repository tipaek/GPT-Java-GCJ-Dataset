import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int[][] arr=new int[n][2];
      int[][] jarr=new int[n][2];
      int[][] carr=new int[n][2];
      StringBuilder sb=new StringBuilder();
      for(int j=0;j<n;j++){
          arr[j][0]=in.nextInt();
          arr[j][1]=in.nextInt();
      }
      for(int j=0;j<n;j++){
          int k=0;
          boolean flag=true;
          while(!(carr[k][0] ==0 && carr[k][1] ==0)){
              if((arr[j][0] > carr[k][0] && arr[j][0] < carr[k][1]) || (arr[j][1] > carr[k][0] && arr[j][0] < carr[k][1])){
                            flag=false;
                            break;
                        }
                        k++;
          }
          if(flag){
              carr[k][0]=arr[j][0];
              carr[k][1]=arr[j][1];
              sb.append("C");
          }else{
              k=0;
              while(!(jarr[k][0] ==0 && jarr[k][1] ==0)){
                  if((arr[j][0] > jarr[k][0] && arr[j][0] < jarr[k][1]) || (arr[j][1] > jarr[k][0] && arr[j][0] < jarr[k][1])){
                            flag=true;
                            break;
                        }
                        k++;
              }
              if(!flag){
              jarr[k][0]=arr[j][0];
              jarr[k][1]=arr[j][1];
              sb.append("J");
            }else{
              sb=new StringBuilder("IMPOSSIBLE");
              break;
                }
          }
      }
      System.out.println("Case #" + i + ": " + sb.toString());
    }
  }
}