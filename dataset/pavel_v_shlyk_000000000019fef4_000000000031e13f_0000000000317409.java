//package codejam._2020_round1C;

import java.io.*;
import java.util.MissingFormatArgumentException;
import java.util.StringTokenizer;

public class Solution {

    public static void main (String[] args) throws Exception {

        String s = "5\n" +
                "4 4 SSSS\n" +
                "3 0 SNSS\n" +
                "2 10 NSNNSN\n" +
                "0 1 S\n" +
                "2 7 SSSSSSSS";

//        String s = "2\n" +
//                "3 2 SSSW\n" +
//                "4 0 NESW";


//        br = new BufferedReader(new StringReader(s));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rl(); int T = nin();
        for (int t=1; t<=T; ++t) {
            rl(); int x=nin(), y=nin();
            char[] M=nca(); int len = M.length;
            int min = Integer.MAX_VALUE;
            if (getLength(x, y) <= 0) min = 0;
            for (int i=0; i<len; ++i) {
                switch (M[i]) {
                    case 'S': --y; break;
                    case 'N': ++y; break;
                    case 'W': --x; break;
                    case 'E': ++x; break;
                }
                int l = getLength(x,y);
                if (getLength(x,y)<=i+1) min = Math.min(min, i+1);
            }

            if (min<=M.length) {
                bw.write("Case #"+t+": "+min);
            } else {
                bw.write("Case #"+t+": IMPOSSIBLE");
            }
            bw.newLine();
        }
        bw.flush();
    }

    static int getLength(int x, int y) {
        return Math.abs(x) + Math.abs(y);
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
