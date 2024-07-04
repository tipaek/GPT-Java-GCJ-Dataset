import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int length = in.nextInt();
          int[][] x = new int[length][length];
          int ks = 0;
          for(int j = 0; j < x.length; j++){
              for(int k = 0; k < x[0].length; k++){
                x[k][j] = in.nextInt();
              }
          }
          int counter = 0;
          while(counter < length){
              ks = ks + x[counter][counter];
              counter++;
          }
          
            int pp = 0;
            int gg = 0;
          for(int j = 0; j < x.length; j++){
            HashSet<Integer> hs = new HashSet<Integer>();
            HashSet<Integer> hss = new HashSet<Integer>();
            for(int k = 0; k < x[0].length; k++){
                hs.add(x[k][j]);
                hss.add(x[j][k]);
            }
            if(hs.size() < x.length){
                pp++;
            }
            if(hss.size() < x.length){
                gg++;
            }
          }
          System.out.println("Case #" + i + ": " + ks + " " + pp + " " + gg);
        }
      }
}