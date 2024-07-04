//package codejam._2020_round1C;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main (String[] args) throws Exception {

        String s = "1\n" +
                "16\n" +
                "33 D\n" +
                "29867 ASDD A\n";



//        br = new BufferedReader(new StringReader(s));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rl(); int T = nin();
        for (int t=1; t<=T; ++t) {
            rl(); int U=nin();
            Map<Character, Integer> min = new HashMap<Character, Integer>();
            Map<Character, Integer> max = new HashMap<Character, Integer>();
            for (int i=0; i<10000; ++i) {
                rl(); int q=nin(); char[] r=nca();
                putMin(1, r[0], min);
                char[] qr = Integer.toString(q).toCharArray();
                for (int j=1; j<r.length; ++j) {
                    putMin(0, r[j], min);
                }
                if (q!=-1) {
                    if (qr.length == r.length) {
                        putMax(Integer.parseInt("" + qr[0]), r[0], max);
                    }
                }
            }

            StringBuffer sb = new StringBuffer();
            // 0
            label_0:
            for (Map.Entry<Character, Integer> mi:min.entrySet()) {
                for (Map.Entry<Character, Integer> ma:max.entrySet()) {
                    if (mi.getValue()==0) {
                        sb.append(mi.getKey());
                        break label_0;
                    }
                }
            }

            // 1
            for (int mm = 1; mm<=9; ++mm) {
                char found = ' ';
                label_1:
                for (Map.Entry<Character, Integer> mi : min.entrySet()) {
                    for (Map.Entry<Character, Integer> ma : max.entrySet()) {
                        if (mi.getKey()==ma.getKey() && mi.getValue() == mm && ma.getValue() == mm) {
                            sb.append(mi.getKey());
                            found = mi.getKey();
                            break label_1;
                        }
                    }
                }
                min.remove(found);
                max.remove(found);
                for (Map.Entry<Character, Integer> mi : min.entrySet()) {
                    putMin(mm+1, mi.getKey(), min);
                }
            }

            bw.write("Case #"+t+": "+sb.toString());
            bw.newLine();
        }
        bw.flush();
    }

    static void putMin(int v, char c, Map<Character, Integer> min) {
        if (min.containsKey(c)) {
            min.put(c, Math.max(min.get(c), v));
        } else {
            min.put(c, v);
        }
    }

    static void putMax(int v, char c, Map<Character, Integer> max) {
        if (max.containsKey(c)) {
            max.put(c, Math.min(max.get(c), v));
        } else {
            max.put(c, v);
        }
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
