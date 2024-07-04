import java.util.*;
import java.io.*;
import static java.lang.Math.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) throws Exception {
        FastScanner scanner = new FastScanner();

        int[] tmp = scanner.nextIntArray(); int T = tmp[0]; int B = tmp[1];

        int c = 1;
        int[] ans = new int[B];
        while (T-- != 0) {
            int l = B / 2 - 1;
            int r = B / 2;

            int rldiff, rrdiff;
            rldiff = rrdiff = -1;
            int rleq, rreq;
            rleq = rreq = -1;
            int q = 5;

            int rev, inv;
            rev = inv = 0;

            int req = 0;

            while (true) {
                for (int j = 0; j < q; j++) {
                    System.out.println(l + 1);
                    System.out.flush();
                    ans[l] = scanner.nextInt();

                    System.out.println(r + 1);
                    System.out.flush();
                    ans[r] = scanner.nextInt();

                    if (ans[l] != ans[r]) {
                        rldiff = l; rrdiff = r;
                    } else {
                        rleq = l; rreq = r;
                    }
                    l--; r++;
                }

                req += 10;
                if (req == B)
                    break;
                q = min(4, (B - req + 2 * ((req - 10) / 10)) / 2);
                // System.out.println("!!!!! " + q);
                if (rldiff >= 0) {
                    System.out.println(rldiff + 1);
                    System.out.flush();
                    int t = scanner.nextInt();
                    if (t != ans[rldiff]) {
                        if (rleq < 0) {
                            inv ^= 1L << (req / 10 - 1);
                        } else {
                            System.out.println(rleq + 1);
                            System.out.flush();
                            t = scanner.nextInt();
                            if (t != ans[rleq]) {
                                inv ^= 1L << (req / 10 - 1);
                            } else {
                                rev ^= 1L << (req / 10 - 1);
                            }
                        }
                    } else {
                        if (rleq >= 0) {
                            System.out.println(rleq + 1);
                            System.out.flush();
                            t = scanner.nextInt();
                            if (t != ans[rleq]) {
                                rev ^= 1L << (req / 10 - 1);
                                inv ^= 1L << (req / 10 - 1);
                            }
                        }
                    }
                } else {
                    System.out.println(rleq + 1);
                    System.out.flush();
                    int t = scanner.nextInt();
                    if (t != ans[rleq]) {
                        inv ^= 1L << (req / 10 - 1);
                    }
                    System.out.println(rleq + 1);
                    System.out.flush();
                    scanner.nextInt();
                }
            }
            l = B / 2 - 1;

            for (int i = 0; i < req / 10 + 1; i++) {
                if (i == 0)
                    q = 5;
                else
                    q = 4;

                if (((rev >> i) & 1L) == 1) {
                    // System.out.println("Reversing from " + l + " to " + max(0, l - q + 1));
                    for (int j = l; j >= max(0, l - q + 1); j--) {
                        int t = ans[j];
                        ans[j] = ans[B - j - 1];
                        ans[B - j - 1] = t;
                    }
                }
                if (((inv >> i) & 1L) == 1) {
                    // System.out.println("Inverting from " + l + " to " + max(0, l - q + 1));
                    for (int j = l; j >= max(0, l - q + 1); j--) {
                        ans[j] ^= 1;
                        ans[B - j - 1] ^= 1;
                    }
                }
                l -= q;
            }

            char[] chAns = new char[B];
            for (int i = 0; i < B; i++) {
                if (ans[i] == 1)
                    chAns[i] = '1';
                else
                    chAns[i] = '0';
            }
            System.out.println(chAns);
            System.out.flush();
            char[] response = scanner.nextLine().toCharArray();
            if (response[0] == 'N')
                return;
        }
    }

    private static class FastScanner {
        private BufferedReader br;

        public FastScanner() { br = new BufferedReader(new InputStreamReader(System.in)); }
        public int[] nextIntArray() throws IOException {
            String line = br.readLine();
            String[] strings = line.trim().split("\\s+");
            int[] array = new int[strings.length];
            for (int i = 0; i < array.length; i++)
                array[i] = Integer.parseInt(strings[i]);
            return array;
        }
        public int nextInt() throws IOException { return Integer.parseInt(br.readLine()); }
        public String nextLine() throws IOException { return br.readLine(); }
    }
}
