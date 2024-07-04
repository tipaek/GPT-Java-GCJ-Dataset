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
          int ordre[] = new int[N];
          boolean impossible = false;
          for (int i = 0; i < N; i++){
              ordre[i] = -1;
              activities_deb[i] = in.nextInt();
              activities_fin[i] = in.nextInt();
          }
          for (int i = 0; i < N; i++){
              int min = 1500;
              int index = -1;
              for (int j = 0; j < N; j++){
                  int candidat = activities_deb[j];
                  boolean check = true;
                  for (int k = 0; k < i; k++){
                      if (ordre[k] == j){
                          check = false;
                      }
                  }
                  if (check){
                      if (candidat < min)
                      {
                          index = j;
                          min = candidat;
                      }
                  }
              }
              ordre[i] = index;
          }
          for (int i = 0; i < N; i++){
              int val = activities_deb[ordre[i]];
              if ( curseur[0] <= val ){
                  res[ordre[i]] = false;
                  curseur[0] = activities_fin[ordre[i]];
                  continue;
              }
              if ( curseur[1] <= val){
                  res[ordre[i]] = true;
                  curseur[1] = activities_fin[ordre[i]];
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