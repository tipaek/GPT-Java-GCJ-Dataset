import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args){
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();
    for (int i=1;i<=t;++i) {
      String result=new String();
      int N=in.nextInt();
      int start_interval[]=new int[N];
      int end_interval[]=new int[N];
      int c_Start[]=new int[N];
      int c_End[]=new int[N];
      int j_Start[]=new int[N];
      int j_End[]=new int[N];
      
      for (int j=0;j<N;j++){
        start_interval[j] = in.nextInt();
        end_interval[j] = in.nextInt();
      }
      for (int k=0;k<N;k++){
        boolean C_flag = false;
        boolean J_flag = false;
        int j=0;
        for (j =0;j<N;j++){
          if (c_Start[j] != 0 || c_End[j] != 0) {
            if (((c_Start[j] <= start_interval[k]) && (start_interval[k] < c_End[j])) || ((c_Start[j] < end_interval[k]) && (end_interval[k] <= c_End[j]))) {
              C_flag = true;
            }
          } else {
            break;
          }
        }
        if (C_flag == false){
          c_Start[j] = start_interval[k];
          c_End[j] = end_interval[k];
          result += "C";
        } else if(C_flag == true){
          for (j=0;j<N;j++){
            if (j_Start[j] != 0 || j_End[j] != 0) {
              if (((j_Start[j] <= start_interval[k]) && (start_interval[k] < j_End[j])) || ((j_Start[j] < end_interval[k]) && (end_interval[k] <= j_End[j]))) {
                J_flag = true;
              }
            }
            else {
              break;
            }
          }
          if (J_flag == false){
            j_Start[j] = start_interval[k];
            j_End[j] = end_interval[k];
            result += "J";
          }
          else if(J_flag == true){
            result = "IMPOSSIBLE";
            break;
          }
        }
      }
      System.out.println("Case #" + i + ": " + result);
    }
  }
}

