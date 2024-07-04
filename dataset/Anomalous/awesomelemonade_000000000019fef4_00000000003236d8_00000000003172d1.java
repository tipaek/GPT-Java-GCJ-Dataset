import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out)) {

            int t = Integer.parseInt(reader.readLine());
            for (int tt = 0; tt < t; tt++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int n = Integer.parseInt(tokenizer.nextToken());
                int d = Integer.parseInt(tokenizer.nextToken());
                long[] a = Arrays.stream(reader.readLine().split(" "))
                                 .mapToLong(Long::parseLong)
                                 .toArray();
                Arrays.sort(a);

                Set<Long> gcdSet = new TreeSet<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        gcdSet.add(gcd(a[i], a[j]));
                    }
                }

                long minCuts = d - 1;
                for (long gcdValue : gcdSet) {
                    long cleanPieces = 0, cleanCuts = 0, dirtyPieces = 0;
                    for (long value : a) {
                        long numPieces = value / gcdValue;
                        if (value % gcdValue == 0) {
                            if (cleanPieces + numPieces <= d) {
                                cleanPieces += numPieces;
                                cleanCuts += numPieces - 1;
                            } else {
                                dirtyPieces += numPieces;
                                break;
                            }
                        } else {
                            dirtyPieces += numPieces;
                        }
                    }
                    if (cleanPieces + dirtyPieces >= d) {
                        minCuts = Math.min(minCuts, cleanCuts + (d - cleanPieces));
                    }
                }

                writer.printf("Case #%d: %s\n", tt + 1, minCuts);
            }
        }
    }

    private static long gcd(long a, long b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }
}