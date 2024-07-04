import java.util.*;
import java.io.*;

    public class Solution {
      public static void main(final String[] args) {
          final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
          final int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
              int z=0;
              int r=0;
              int flag = 0;
              int c =0;
          for (int i = 1; i <= t; i++) {
            int s = in.nextInt();
            z=0;
            r=0;
            flag=0;
            c=0;
            HashSet<Integer> aln = new HashSet<Integer>(s);
            HashSet<Integer> alc = new HashSet<Integer>(s); 
            int a[][] = new int[s][s];
            for(int m = 0; m < s; m++){
              aln.clear();
              flag=0;
              for(int n = 0; n< s;n++){
                a[m][n] =in.nextInt();
                if (m == n){z+=a[m][n];}
                if ( (flag == 0) && (aln.contains(a[m][n]))){
                  r++;flag++;
                }else if(flag == 0){
                  aln.add(a[m][n]);
                }
              }
            }
            for(int m = 0; m < s; m++){
              alc.clear();
              for(int n =0; n<s;n++){
                if(alc.contains(a[n][m])){
                  c++;
                  break;
                }else{
                  alc.add(a[n][m]);
                }
              }
            }
              
          System.out.println("Case #" + i + ": " + (z) + " "+ (r) + " "+ (c) );
        }
      }
    }