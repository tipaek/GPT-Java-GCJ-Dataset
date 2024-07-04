/**
 * Created by oana on 4/5/20.
 */

import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int N = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int t = 0; t < N; t++) {

            int n = in.nextInt();
            int[][] m=new int[n][n];
            int k=0;
            int r=0;
            int c=0;

            for (int i=0;i<n;i++) {
                Set<Integer> rs=new HashSet<>();
                boolean dup=false;
                for (int j = 0; j < n; j++) {
                   m[i][j]=in.nextInt();
                    if(rs.contains(m[i][j])){
                        dup=true;

                    }
                    rs.add( m[i][j]);
                    if(i==j){
                        k+=m[i][j];
                    }
                }
                if(dup){
                    r++;
                }
            }

            for (int i=0;i<n;i++) {
                Set<Integer> cs=new HashSet<>();
                boolean dup=false;
                for (int j = 0; j < n; j++) {

                    if(cs.contains(m[j][i])){
                        dup=true;
                    }
                    cs.add( m[j][i]);

                }
                if(dup){
                    c++;
                }
            }
            System.out.println("Case #" + (t+1) + ": " + k +" " + r+ " " + c);
        }
    }
}