import java.util.*;
import java.io.*;
public class Solution
{
    static StringBuilder sb;
    static int count;
    public static void main(String [] args)
    {
        MyScanner sc = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = sc.nextInt();
        for (int p = 1; p <= t; p++) {
            int n = sc.nextInt();
            int orig = n; int curN = 0; int curK = 0;
            int row = (int) (Math.log10(n + 1)/Math.log10(2)); sb = new StringBuilder(); count = 0;
            sb.append("Case #" + p +":" + "\n");
            for (int i = 0; i < row; i++) {
                if (curK == 0) {
                    while (curK <= i) {
                        add(curN, curK);
                        curK++;
                    }
                    curN++;
                } else {
                    while (curK >= 0) {
                        add(curN, curK);
                        curK--;
                    }
                    curN++; curK++;
                }
            }
            int rest = (int) (n - (Math.pow(2, row) - 1));
            if (rest == 0) {
                out.print(sb.toString());
                continue;
            } else {
                int down = 0; boolean changed = false;
                while (rest >= row) {
                    changed = true;
                    rest -= row;
                    row++; down++;
                }
                for (int i = 0; i < down; i++) {
                    if (i == 0) {
                        if (curK == 0) {
                            curK++;
                            add(curN, curK);
                        } else {
                            curK--;
                            add(curN, curK);
                        }
                    } else {
                        if (curK == 1) {
                            curN++;
                            add(curN, curK);
                        } else {
                            curN++; curK++;
                            add(curN, curK);
                        }
                    }
                }
                if (rest == 0) {
                    out.print(sb.toString());
                    continue;
                }
                if (!changed) {
                    if (curK == 0) {
                        add(curN, curK); rest--;
                    } else {
                        add(curN, curK); rest--;
                    }
                } else if (curK == 1) {
                    curK--;
                    add(curN, curK);
                    rest--;
                } else {
                    curK++;
                    add(curN, curK);
                    rest--;
                }
                while (rest > 0) {
                    if (curK == 0) {
                        curN++;
                        add(curN, curK);
                    } else {
                        curN++; curK++;
                        add(curN, curK);
                    }
                }
                out.print(sb.toString());
            }

        }
        out.close();
    }

    static void add(int n, int k) {
        sb.append((n + 1) + " " + (k + 1) + "\n");
        count++;
    }




    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
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

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }



    }

}