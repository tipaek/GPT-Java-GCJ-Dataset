import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        final int MAX_LINES = 10000;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int testCases = Integer.parseInt(reader.readLine());
        for (int caseIndex = 0; caseIndex < testCases; caseIndex++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int d = Integer.parseInt(tokenizer.nextToken());
            StringTokenizer arrayTokenizer = new StringTokenizer(reader.readLine());
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = Long.parseLong(arrayTokenizer.nextToken());
            }
            Arrays.sort(array);

            Set<Long> gcdSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    gcdSet.add(computeGCD(array[i], array[j]));
                }
            }
            long minimumCuts = d - 1;
            for (long gcdValue : gcdSet) {
                long cleanPieces = 0;
                long cleanCuts = 0;
                long dirtyPieces = 0;
                for (long value : array) {
                    long pieces = value / gcdValue;
                    if (value % gcdValue == 0) {
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
                    if (cleanPieces + dirtyPieces >= d) {
                        minimumCuts = Math.min(minimumCuts, cleanCuts + (d - cleanPieces));
                    }
                }
            }
            writer.printf("Case #%d: %d\n", caseIndex + 1, minimumCuts);
        }

        reader.close();
        writer.close();
    }

    public static long computeGCD(long a, long b) {
        return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
    }
}