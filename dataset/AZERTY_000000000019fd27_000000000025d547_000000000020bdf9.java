    import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int nb_test = in.nextInt();
        for (int t = 0; t < nb_test; t++) {
          int N = in.nextInt();
          int activities_deb[] = new int[N];
          int activities_fin[] = new int[N];
          boolean res[] = new boolean[N];
          int curseur[] = { 0 , 0 };
          boolean impossible = false;
          for (int i = 0; i < N; i++){
              activities_deb[i] = in.nextInt();
              activities_fin[i] = in.nextInt();
          }
          
          for (int i = 0; i < N; i++){
              int min = 1500;
              int index = -1;
              for (int j = 0; j < N; j++){
                  if (activities_deb[j] < min)
                  {
                      index = j;
                      min = activities_deb[j];
                  }
              }
              
              int val = activities_deb[index];
              activities_deb[index] = 1500;
              if ( curseur[0] <= val ){
                  res[index] = false;
                  curseur[0] = activities_fin[index];
                  continue;
              }
              if ( curseur[1] <= val){
                  res[index] = true;
                  curseur[1] = activities_fin[index];
                  continue;
              }
              impossible = true;
          }
          if (impossible){
              System.out.println("Case #" + (t+1) + ": IMPOSSIBLE");
          }
          else{
              String res_output = "";
              for (int i = 0; i < N; i++){
                  if (res[i]){
                      res_output += "J";
                  }
                  else {
                      res_output += "C";
                  }
              }
              System.out.println("Case #" + (t+1) + ": " + res_output );
          }
        }
      }
    }