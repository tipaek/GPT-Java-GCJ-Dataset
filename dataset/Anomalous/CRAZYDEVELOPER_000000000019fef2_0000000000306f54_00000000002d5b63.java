import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        solve(in, out);
        out.close();
    }

    public static void solve(InputReader sc, PrintWriter pw) {
        int t = sc.nextInt();
        long A = sc.nextLong(), B = sc.nextLong();
        for (int iter = 1; iter <= t; iter++) {
            long d = 1000000000, l = -1000000000, u = -1000000000, r = 1000000000;
            while (l <= r && u <= d) {
                long mx = (l + r) / 2;
                long my = (u + d) / 2;
                println(mx + " " + my);
                String ver = sc.next();
                
                if (ver.equals("CENTER")) {
                    continue;
                }
                
                if (ver.equals("HIT")) {
                    boolean found = false;
                    
                    if (isValid(mx + A)) {
                        println((Math.min(r, mx + A)) + " " + my);
                        ver = sc.next();
                        if (ver.equals("CENTER")) {
                            continue;
                        }
                        if (ver.equals("HIT")) {
                            l = mx + 1;
                            r = Math.min(r, mx + A);
                            found = true;
                        }
                    }
                    
                    if (!found && isValid(mx - A)) {
                        println(Math.max(l, mx - A) + " " + my);
                        ver = sc.next();
                        if (ver.equals("CENTER")) {
                            continue;
                        }
                        if (ver.equals("HIT")) {
                            r = mx - 1;
                            l = Math.max(l, mx - A);
                        }
                    }
                    
                    found = false;
                    if (isValid(my + A)) {
                        println(mx + " " + Math.min(my + A, d));
                        ver = sc.next();
                        if (ver.equals("CENTER")) {
                            continue;
                        }
                        if (ver.equals("HIT")) {
                            u = my + 1;
                            d = Math.min(d, my + A);
                            found = true;
                        }
                    }
                    
                    if (!found && isValid(my - A)) {
                        println(mx + " " + Math.max(my - A, u));
                        ver = sc.next();
                        if (ver.equals("CENTER")) {
                            continue;
                        }
                        if (ver.equals("HIT")) {
                            d = my - 1;
                            u = Math.max(u, my - A);
                        }
                    }
                }
                
                if (ver.equals("MISS")) {
                    break;
                }
            }
        }
    }

    private static boolean isValid(long value) {
        return value >= -1000000000 && value <= 1000000000;
    }

    static void println(String s) {
        System.out.println(s);
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}