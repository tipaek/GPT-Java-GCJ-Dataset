import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int t = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            long[] a = new long[n];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(tokenizer.nextToken());
            }
            Arrays.sort(a);

            Set<Long> gcdSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    gcdSet.add(gcd(a[i], a[j]));
                }
            }

            long minCuts = d - 1;
            for (long x : gcdSet) {
                long cleanPieces = 0;
                long cleanCuts = 0;
                long dirtyPieces = 0;

                for (long value : a) {
                    long pieces = value / x;
                    if (value % x == 0) {
                        if (cleanPieces + pieces <= d) {
                            cleanPieces += pieces;
                            cleanCuts += pieces - 1;
                        } else {
                            dirtyPieces += pieces;
                            break;
                        }
                    } else {
                        dirtyPieces += pieces;
                    }
                }

                if (cleanPieces + dirtyPieces >= d) {
                    minCuts = Math.min(minCuts, cleanCuts + (d - cleanPieces));
                } else if (d % cleanPieces == 0) {
                    minCuts = Math.min(minCuts, cleanCuts + cleanPieces * (d / cleanPieces - 1));
                }
            }

            writer.printf("Case #%d: %d\n", testCase, minCuts);
        }

        reader.close();
        writer.close();
    }

    public static long gcd(long a, long b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }
}