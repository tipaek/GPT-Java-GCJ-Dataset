//package com.company;

import java.io.*;
import java.math.*;
import java.util.*;

public class Solution {
    public static class Task {


        public int[] sim(int l, int r) {
            int a = 1;
            while (l >= a || r >= a) {
                if (l >= r) {
                    if (l >= a) {
                        l -= a;
                        a++;
                    } else {
                        return new int[]{a - 1, l, r};
                    }
                } else {
                    if (r >= a) {
                        r -= a;
                        a++;
                    } else {
                        return new int[]{a - 1, l, r};
                    }
                }
            }
            return new int[]{a - 1, l, r};
        }

        public void solve(Scanner sc, PrintWriter pw) throws IOException {
            int T = sc.nextInt();
            outer:
            for (int ks = 1; ks <= T; ks++) {
                long l = sc.nextLong();
                long r = sc.nextLong();
//                System.err.println(Arrays.toString(sim((int) l, (int) r)));
                long a = 1;
                while (l >= a || r >= a) {
                    if (l >= r) {
                        if (l - a < r) {
                            // a + 1, a + 3 ... <= r
                            long tLo = 0, tHi = Integer.MAX_VALUE / 2 + 1;
                            while (tLo < tHi - 1) {
                                long tMid = (tLo + tHi) / 2;
                                if (a * tMid + tMid * tMid <= r) {
                                    tLo = tMid;
                                } else {
                                    tHi = tMid;
                                }
                            }
                            l -= (a * tLo + tLo * tLo - tLo);
                            r -= (a * tLo + tLo * tLo);
                            if (l < 0 || r < 0) throw new RuntimeException();
                            a += 2 * tLo;
                            if (l >= a) {
                                l -= a;
                                a++;
                                if (r >= a) throw new RuntimeException();
                            }
//                            pw.println("Case #" + ks + ": " + (a - 1) + " " + l + " " + r);
//                            continue outer;
                        } else {
                            long tLo = 0, tHi = Integer.MAX_VALUE / 2 + 1;
                            while (tLo < tHi) {
                                long tMid = (tLo + tHi) / 2;
                                if ((2 * a - 1 + tMid) * tMid / 2 < l - r) {
                                    tLo = tMid + 1;
                                } else {
                                    tHi = tMid;
                                }
                            }
                            long sub = (2 * a - 1 + tLo) * tLo / 2;
                            if (sub > l) tLo--;
                            sub = (2 * a - 1 + tLo) * tLo / 2;
                            if (sub > l) throw new RuntimeException();
                            l -= sub;
                            a += tLo;
                        }
                    } else {
                        if (r - a <= l) {
                            long tLo = 0, tHi = Integer.MAX_VALUE / 2 + 1;
                            while (tLo < tHi - 1) {
                                long tMid = (tLo + tHi) / 2;
                                if (a * tMid + tMid * tMid <= l) {
                                    tLo = tMid;
                                } else {
                                    tHi = tMid;
                                }
                            }
                            r -= (a * tLo + tLo * tLo - tLo);
                            l -= (a * tLo + tLo * tLo);
                            if (l < 0 || r < 0) throw new RuntimeException();
                            a += 2 * tLo;
                            if (r >= a) {
                                r -= a;
                                a++;
                                if (l >= a) throw new RuntimeException();
                            }
//                            pw.println("Case #" + ks + ": " + (a - 1) + " " + l + " " + r);
//                            continue outer;
                        } else {
                            long tLo = 0, tHi = Integer.MAX_VALUE / 2 + 1;
                            while (tLo < tHi) {
                                long tMid = (tLo + tHi) / 2;
                                if ((2 * a - 1 + tMid) * tMid / 2 < r - l) {
                                    tLo = tMid + 1;
                                } else {
                                    tHi = tMid;
                                }
                            }
                            long sub = (2 * a - 1 + tLo) * tLo / 2;
                            if (sub > r) tLo--;
                            sub = (2 * a - 1 + tLo) * tLo / 2;
                            if (sub > r) throw new RuntimeException();
                            r -= sub;
                            a += tLo;
                        }
                    }
                }
                pw.println("Case #" + ks + ": " + (a - 1) + " " + l + " " + r);
            }
        }
    }

    static long TIME_START, TIME_END;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new FileInputStream("input"));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
//        PrintWriter pw = new PrintWriter(new FileOutputStream("input"));

        Runtime runtime = Runtime.getRuntime();
        long usedMemoryBefore = runtime.totalMemory() - runtime.freeMemory();
        TIME_START = System.currentTimeMillis();
        Task t = new Task();
        t.solve(sc, pw);
        TIME_END = System.currentTimeMillis();
        long usedMemoryAfter = runtime.totalMemory() - runtime.freeMemory();
        pw.close();
        System.err.println("Memory increased: " + (usedMemoryAfter - usedMemoryBefore) / 1000000);
        System.err.println("Time used: " + (TIME_END - TIME_START) + ".");
    }

    static class Scanner {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }

        public Scanner(FileReader s) throws FileNotFoundException {
            br = new BufferedReader(s);
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public String nextLine() throws IOException {
            return br.readLine();
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }

        public boolean ready() throws IOException {
            return br.ready();
        }
    }
}