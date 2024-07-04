import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int trySolve(List<Long> pieceSizes, int sizeIndex, Map<Long, Integer> count, int divideBy, int d) {
        long piecesLeft = d;
        long cutMade = 0;

        long baseSize = pieceSizes.get(sizeIndex);
        for (int i = sizeIndex; i < pieceSizes.size() && piecesLeft > 0; ++i) {
            long currentSize = pieceSizes.get(i);
            int currentCount = count.get(currentSize);
            if (currentSize % baseSize == 0) {
                long maxCanEarn = (currentSize / baseSize) * currentCount * divideBy;
                if (piecesLeft >= maxCanEarn) {
                    long cutNeeded = ((currentSize / baseSize) * divideBy - 1) * currentCount;
                    cutMade +=cutNeeded;
                    piecesLeft -= maxCanEarn;
                } else {
                    long fullCutPieces = piecesLeft / ((currentSize / baseSize) * divideBy);
                    cutMade += fullCutPieces * ((currentSize / baseSize) * divideBy - 1);
                    piecesLeft -= fullCutPieces * ((currentSize / baseSize) * divideBy);
                    cutMade += piecesLeft;
                    piecesLeft = 0;
                }
            }
        }

        for (int i = sizeIndex; i < pieceSizes.size() && piecesLeft > 0; ++i) {
            long currentSize = pieceSizes.get(i);
            int currentCount = count.get(currentSize);
            if (currentSize % baseSize != 0) {
                long willEarn = Math.min(piecesLeft, currentSize / baseSize) * currentCount;
                cutMade += willEarn;
                piecesLeft -= willEarn;
            }
        }

        return piecesLeft == 0 ? (int)cutMade : Integer.MAX_VALUE;
    }

    private static int solve(long[] pieces, int d) {
        int bestResult = Integer.MAX_VALUE;

        Map<Long, Integer> counts = new HashMap<>();
        for (long i : pieces) {
            Integer cnt = counts.get(i);
            if (cnt == null) cnt = 0;
            ++cnt;
            counts.put(i, cnt);
        }

        List<Long> pieceSizes = new ArrayList<>(counts.keySet());
        Collections.sort(pieceSizes);

        for (int i = pieceSizes.size() - 1; i >= 0; --i) {
            for (int j = 1; j <= d; ++j) {
                int candidate = trySolve(pieceSizes, i, counts, j, d);
                if (candidate < bestResult) bestResult = candidate;
            }
        }

        return bestResult;
    }

    public static void main(String[] params) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; ++i) {
            String[] in = reader.readLine().split(" ");
            int n = Integer.parseInt(in[0]);
            int d = Integer.parseInt(in[1]);
            String[] piecesStr = reader.readLine().split(" ");
            long[] pieces = new long[n];
            for (int j = 0; j < piecesStr.length; ++j) pieces[j] = Long.parseLong(piecesStr[j]);
            int solution = solve(pieces, d);
            System.out.println(String.format("Case #%d: %d", i + 1, solution));
        }
    }
}
