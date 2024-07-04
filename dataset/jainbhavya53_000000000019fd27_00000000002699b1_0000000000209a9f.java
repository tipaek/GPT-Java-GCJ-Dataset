//package com.guavus.jobs2.bhavya.codejam;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author bhavya.jain
 */
class Solution {
    public static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException ex) {
                    //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String temp = "";
            try {
                temp = br.readLine();
            } catch (IOException ex) {
                //Logger.getLogger(CodeJam.class.getName()).log(Level.SEVERE, null, ex);
            }
            return temp;
        }
    }

    public static PrintWriter out;

    public static void main(String args[]) {
        MyScanner in = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out), true);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            String input = in.nextLine();
            StringBuilder sb = new StringBuilder();
            int j = 0;
            int start = 0;
            int end = 0;
            while (j < input.length()) {
                char curr = input.charAt(j);
                if (curr == '0') {
                    if (end > start) {
                        sb.append(generateParanthesis(input.substring(start, end)));
                    }
                    while (j < input.length() && input.charAt(j) == '0') {
                        sb.append('0');
                        j++;
                    }
                    start = j;
                    end = start;
                } else {
                    end = end + 1;
                    j++;
                }
            }
            if (input.charAt(input.length() - 1) != '0') {
                sb.append(generateParanthesis(input.substring(start, end)));
            }
            out.printf("Case #%d: %s\n", i + 1, sb.toString());
        }
    }

    public static String generateParanthesis(String input) {
        StringBuilder sb = new StringBuilder();
        int counter = input.charAt(0) - '0';
        appendLeft(sb, counter);
        sb.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            int value = input.charAt(i) - '0';
            if (value < counter) {
                appendRight(sb, counter - value);
                counter = value;
                sb.append(value);
            } else if (value > counter) {
                appendLeft(sb, value - counter);
                sb.append(value);
                appendRight(sb, value - counter);
            } else {
                sb.append(value);
            }
        }
        if (counter != 0) {
            appendRight(sb, counter);
        }
        return sb.toString();
    }

    public static void appendLeft(StringBuilder sb, int num) {
        for (int i = 0; i < num; i++) {
            sb.append("(");
        }
    }

    public static void appendRight(StringBuilder sb, int num) {
        for (int i = 0; i < num; i++) {
            sb.append(")");
        }
    }
}
