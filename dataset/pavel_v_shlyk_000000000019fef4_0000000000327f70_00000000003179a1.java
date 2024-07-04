//package codejam._2020_round1C;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main (String[] args) throws Exception {

        String s = "1\n" +
                "2\n" +
                "20 P\n" +
                "37 PU\n" +
                "26 L\n" +
                "95 FB\n" +
                "24 L\n" +
                "86 HU\n" +
                "30 PP\n" +
                "77 H\n" +
                "22 P\n" +
                "89 ST\n" +
                "24 FX\n" +
                "8 L\n" +
                "64 H\n" +
                "63 FS\n" +
                "68 P\n" +
                "33 PP\n" +
                "8 U\n" +
                "77 PT\n" +
                "71 UO\n" +
                "97 PB\n" +
                "3 P\n" +
                "9 O\n" +
                "71 OB\n" +
                "88 PT\n" +
                "99 FU\n" +
                "53 OT\n" +
                "95 XH\n" +
                "23 B\n" +
                "52 XP\n" +
                "14 PT\n" +
                "60 XP\n" +
                "69 O\n" +
                "19 PP\n" +
                "50 FH\n" +
                "13 L\n" +
                "47 S\n" +
                "14 O\n" +
                "86 LO\n" +
                "50 X\n" +
                "65 UO\n" +
                "65 H\n" +
                "15 X\n" +
                "90 OX\n" +
                "31 FH\n" +
                "36 PO\n" +
                "99 X\n" +
                "18 F\n" +
                "34 PX\n" +
                "41 L\n" +
                "18 P\n" +
                "23 PU\n" +
                "3 P\n" +
                "81 X\n" +
                "82 OO\n" +
                "12 H\n" +
                "71 OP\n" +
                "8 S\n" +
                "48 PB\n" +
                "42 PP\n" +
                "62 OU\n" +
                "64 PL\n" +
                "43 P\n" +
                "39 OS\n" +
                "45 PU\n" +
                "59 LH\n" +
                "2 P\n" +
                "63 OB\n" +
                "79 PH\n" +
                "61 LS\n" +
                "7 P\n" +
                "7 L\n" +
                "1 P\n" +
                "5 O\n" +
                "80 UB\n" +
                "90 OO\n" +
                "52 XX\n" +
                "10 O\n" +
                "75 FL\n" +
                "43 PP\n" +
                "55 XX\n" +
                "57 XP\n" +
                "32 FB\n" +
                "30 L\n" +
                "31 OP\n" +
                "26 FX\n" +
                "13 F\n" +
                "21 PS\n" +
                "85 UO\n" +
                "59 OO\n" +
                "33 F\n" +
                "71 O\n" +
                "39 FB\n" +
                "82 PX\n" +
                "21 FT\n" +
                "72 OX\n" +
                "69 XB\n" +
                "39 H\n" +
                "84 XH\n" +
                "58 OS\n" +
                "22 L\n" +
                "41 PT\n" +
                "9 H\n" +
                "86 LO\n" +
                "97 O\n" +
                "82 XT\n" +
                "86 XB\n" +
                "79 LX\n" +
                "26 P\n" +
                "24 PU\n" +
                "66 H\n" +
                "75 FU\n" +
                "35 PS\n" +
                "39 FO\n" +
                "59 XH\n" +
                "45 OO\n" +
                "3 P\n" +
                "44 FB\n" +
                "30 PU\n" +
                "23 PP\n" +
                "92 LS\n" +
                "47 OU\n" +
                "92 SL\n" +
                "56 XO\n" +
                "38 H\n" +
                "50 FF\n" +
                "21 PL\n" +
                "33 B\n" +
                "78 S\n" +
                "65 UX\n" +
                "1 P\n" +
                "88 FL\n" +
                "4 O\n" +
                "48 XH\n" +
                "34 FS\n" +
                "10 B\n" +
                "28 F\n" +
                "30 FX\n" +
                "69 OP\n" +
                "73 UT\n" +
                "25 PB\n" +
                "48 FL\n" +
                "12 X\n" +
                "95 HH\n" +
                "25 PX\n" +
                "76 F\n" +
                "9 O\n" +
                "75 XO\n" +
                "80 FS\n" +
                "71 PT\n" +
                "35 U\n" +
                "4 P\n" +
                "80 PL\n" +
                "14 P\n" +
                "99 U\n" +
                "86 PT\n" +
                "51 OF\n" +
                "12 H\n" +
                "51 S\n" +
                "72 FU\n" +
                "85 PP\n" +
                "24 PO\n" +
                "42 FL\n" +
                "74 LP\n" +
                "44 FL\n" +
                "76 FS\n" +
                "89 OP\n" +
                "87 FL\n" +
                "27 FF\n" +
                "95 XB\n" +
                "83 PT\n" +
                "32 FU\n" +
                "1 P\n" +
                "99 U\n" +
                "21 F\n" +
                "14 O\n" +
                "62 FO\n" +
                "30 FF\n" +
                "46 OB\n" +
                "7 P\n" +
                "38 PL\n" +
                "45 FS\n" +
                "64 LT\n" +
                "63 XB\n" +
                "98 FO\n" +
                "76 UH\n" +
                "60 XS\n" +
                "54 PF\n" +
                "92 L\n" +
                "39 FU\n" +
                "72 OS\n" +
                "41 FO\n" +
                "22 FF\n" +
                "89 FP\n" +
                "28 PU\n" +
                "93 LF\n" +
                "38 PF\n" +
                "76 LT\n" +
                "69 OU\n" +
                "31 B\n" +
                "3 P\n" +
                "56 FF\n" +
                "73 SF\n" +
                "19 PS\n" +
                "62 OF\n" +
                "98 FH\n" +
                "96 SS\n" +
                "77 FP\n" +
                "18 PX\n" +
                "20 H\n" +
                "83 U\n" +
                "7 L\n" +
                "4 F\n" +
                "44 FX\n" +
                "15 PO\n" +
                "34 H\n" +
                "53 PP\n" +
                "1 P\n" +
                "94 UB\n" +
                "41 OS\n" +
                "12 L\n" +
                "32 X\n" +
                "22 S\n" +
                "53 XP\n" +
                "56 FU\n" +
                "45 FP\n" +
                "84 UX\n" +
                "25 FT\n" +
                "34 X\n" +
                "9 L\n" +
                "69 PX\n" +
                "56 OH\n" +
                "66 OX\n" +
                "94 PL\n" +
                "96 PF\n" +
                "39 FX\n" +
                "82 PL\n" +
                "96 BF\n" +
                "15 PP\n" +
                "12 B\n" +
                "28 P\n" +
                "97 OT\n" +
                "45 S\n" +
                "3 F\n" +
                "40 PO\n" +
                "23 PL\n" +
                "30 PO\n" +
                "31 FP\n" +
                "44 PS\n" +
                "36 FT\n" +
                "94 U\n" +
                "83 FP\n" +
                "52 B\n" +
                "22 B\n" +
                "80 OP\n" +
                "37 FO\n" +
                "95 ST\n" +
                "5 F\n" +
                "80 ST\n" +
                "70 OL\n" +
                "70 FX\n" +
                "65 XU\n" +
                "61 XL\n" +
                "15 PL\n" +
                "91 FT\n" +
                "66 XB\n" +
                "13 F\n" +
                "3 F\n" +
                "39 OO\n" +
                "86 FO\n" +
                "43 B\n" +
                "40 X\n" +
                "63 XF\n" +
                "40 PB\n" +
                "96 U\n" +
                "24 PL\n" +
                "17 O\n" +
                "29 PX\n" +
                "9 O\n" +
                "25 O\n" +
                "62 FX\n" +
                "81 X\n" +
                "20 PF\n" +
                "4 X\n" +
                "37 FS\n" +
                "35 L\n" +
                "85 LU\n" +
                "2 F\n" +
                "63 XH\n" +
                "71 XL\n" +
                "43 PP\n" +
                "4 F\n" +
                "51 XS\n" +
                "2 P\n" +
                "54 LP\n" +
                "61 OT\n" +
                "1 P\n" +
                "71 FH\n" +
                "32 PS\n" +
                "44 XF\n" +
                "29 U\n" +
                "42 OS\n" +
                "58 PB\n" +
                "78 XU\n" +
                "67 F\n" +
                "73 XO\n" +
                "74 US\n" +
                "40 L\n" +
                "91 HB\n" +
                "6 O\n" +
                "48 PX\n" +
                "76 OP\n" +
                "74 OO\n" +
                "68 UH\n" +
                "22 P\n" +
                "48 XU";



//        br = new BufferedReader(new StringReader(s));
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        rl(); int T = nin();
        for (int t=1; t<=T; ++t) {
            rl(); int U=nin();
            Map<Character, Integer> min = new HashMap<Character, Integer>();
            Map<Character, Integer> max = new HashMap<Character, Integer>();
            for (int i=0; i<314; ++i) {
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
