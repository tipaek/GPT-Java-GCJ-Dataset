import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out), true);
        int test = sc.nextInt();
        for (int t=1; t<=test; t++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean xNeg = false;
            boolean yNeg = false;
            if (x < 0) {
                xNeg = true;
                x = -x;
            }
            if (y < 0) {
                yNeg = true;
                y = -y;
            }
            if (x % 2 == 0 && y % 2 == 0) {
                pw.println("Case #" + t + ": IMPOSSIBLE");
            } else if (x % 2 == 1 && y % 2 == 1) {
                pw.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                StringBuilder s1 = new StringBuilder(Integer.toBinaryString(x));
                StringBuilder s2 = new StringBuilder(Integer.toBinaryString(y));
                while (s1.length() < s2.length()) {
                    s1.insert(0, 0);
                }
                while (s2.length() < s1.length()) {
                    s2.insert(0, 0);
                }
                int length = s1.length();
                ArrayList<Integer> al1 = new ArrayList<Integer>();
                ArrayList<Integer> al2 = new ArrayList<Integer>();
                int last = 0;
                for (int i=0; i<length; i++) {
                    char c1 = s1.charAt(length-i-1);
                    char c2 = s2.charAt(length-i-1);
                    if (c1 == '1' && c2 == '0') {
                        al1.add(1);
                        al2.add(0);
                        last = 1;
                    } else if (c1 == '0' && c2 == '1') {
                        al1.add(0);
                        al2.add(1);
                        last = 2;
                    } else if (c1 == '0') {
                        if (last == 1) {
                            al1.remove(i-1);
                            al1.add(-1);
                            al1.add(1);
                            al2.add(0);
                        } else {
                            al2.remove(i-1);
                            al2.add(-1);
                            al2.add(1);
                            al1.add(0);
                        }
                    } else {
                        if (last == 1) {
                            if (i == length-1 || s1.charAt(length-i-2) == '0') {
                                al1.remove(i-1);
                                al1.add(-1);
                                al1.add(0);
                                al2.add(1);
                                if (i != length-1) {
                                    s1.setCharAt(length-i-2, '1');
                                } else {
                                    al1.add(1);
                                    al2.add(0);
                                }
                            } else {
                                pw.println("Case #" + t + ": IMPOSSIBLE");
                                break;
                            }
                        } else {
                            if (i == length-1 || s2.charAt(length-i-2) == '0') {
                                al2.remove(i-1);
                                al2.add(-1);
                                al2.add(0);
                                al1.add(1);
                                if (i != length-1) {
                                    s2.setCharAt(length-i-2, '1');
                                } else {
                                    al2.add(1);
                                    al1.add(0);
                                }
                            } else {
                                pw.println("Case #" + t + ": IMPOSSIBLE");
                                break;
                            }
                        }
                    }
                }
                StringBuilder answer = new StringBuilder();
                for (int i=0; i<al1.size(); i++) {
                    if (al1.get(i) == 0) {
                        if (al2.get(i) == 1) {
                            addY(answer, yNeg);
                        } else {
                            addY(answer, !yNeg);
                        }
                    } else if (al1.get(i) == 1) {
                        addX(answer, xNeg);
                    } else {
                        addX(answer, !xNeg);
                    }
                }
                pw.println("Case #" + t + ": " + answer.toString());
            }
        }
    }

    static void addX(StringBuilder sb, boolean xNeg) {
        if (xNeg) {
            sb.append("W");
        } else {
            sb.append("E");
        }
    }

    static void addY(StringBuilder sb, boolean yNeg) {
        if (yNeg) {
            sb.append("S");
        } else {
            sb.append("N");
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(String in){
            br = new BufferedReader(
                    new InputStreamReader(new ByteArrayInputStream(in.getBytes())));
        }
        public FastReader()
        {
            br = new BufferedReader(new
                     InputStreamReader(System.in));
        }
        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
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
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
