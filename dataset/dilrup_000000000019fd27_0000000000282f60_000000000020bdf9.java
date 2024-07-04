 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int cS=in.nextInt(),cE=in.nextInt(),jS=in.nextInt(),jE=in.nextInt();
          String result = "CJ";
          for(int j=2; j<n; j++){
              int s = in.nextInt();
              int e = in.nextInt();
              if((e>cS && e<cE && e>jS && e<jE) ||
              (s>cS && s<cE && s>jS && s<jE)){
                 
                result = "IMPOSSIBLE";
                break;
                 
              }
              if(e<=cS){
                result+="C";
                cS = s;
              }
              else if(e<=jS){
                result+="J";
                jS = s;
              }
              else if(s>=cE){
                  result+="C";
                  cE = e;
              }
              else if(s>=jE){
                  result+="J";
                  jE = e;
              }
          }
          System.out.println("Case #" + i + ": " + result);
        }
      }
    }