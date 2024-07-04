// package codejam._2020_round1B;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {

    static long X, Y;

    public static void main (String[] args) throws Exception {

        String s = "4\n" +
                "2 3\n" +
                "-2 -3\n" +
                "3 0\n" +
                "-1 1";

//        String s = "1\n" +
//                "-2 -3";

//        br = new BufferedReader(new StringReader(s));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rl(); int T = nin();
        for (int t=1; t<=T; ++t) {
            rl(); X=nin(); Y=nin();

            String result = recursion(0, 0, 0, "");

            System.out.println("Case #"+t+": " + (result==null ? "IMPOSSIBLE" : result));
        }
    }

    static String recursion(long x, long y, int pow, String path) {
        if (X==x && Y==y) return path;

        long v = 1<<pow;
        if (X!=x && Math.abs(X-x)%v!=0)
            return null;
        if (Y!=y && Math.abs(Y-y)%v!=0)
            return null;

        if (X-x>0) {
            String s1 = recursion(x + v, y, pow + 1, path + "E");
            if (s1 != null)
                return s1;
            String s2 = recursion(x-v, y, pow+1, path+"W");
            if (s2!=null)
                return s2;
        } else {
            String s2 = recursion(x-v, y, pow+1, path+"W");
            if (s2!=null)
                return s2;
            String s1 = recursion(x + v, y, pow + 1, path + "E");
            if (s1 != null)
                return s1;
        }

        if (Y-y>0) {
            String s3 = recursion(x, y+v, pow+1, path+"N");
            if (s3!=null)
                return s3;
            String s4 = recursion(x, y-v, pow+1, path+"S");
            if (s4!=null)
                return s4;
        } else {
            String s4 = recursion(x, y-v, pow+1, path+"S");
            if (s4!=null)
                return s4;
            String s3 = recursion(x, y+v, pow+1, path+"N");
            if (s3!=null)
                return s3;
        }

        return null;
    }

    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    static void rl() throws Exception{
        st = new StringTokenizer(br.readLine());
    }
    static long nlo(){
        return Long.parseLong(st.nextToken());
    }
    static int nin(){
        return Integer.parseInt(st.nextToken());
    }
    /*private static void te(){
      }*/
    static double ndo(){
        return Double.parseDouble(st.nextToken());
    }
    static char[] nca(){
        return st.nextToken().toCharArray();
    }
}
