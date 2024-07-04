import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static int trySolve(long[] pieces, int pieceIndex, int divideBy, int d) {
        long piecesLeft = d;
        long cutMade = 0;

        long baseSize = pieces[pieceIndex];

        for (int i = pieceIndex; i < pieces.length && piecesLeft > 0; ++i) {
            long currentSize = pieces[i];

            if (currentSize % baseSize == 0) {
                long maxCanEarn = (currentSize / baseSize) * divideBy;
                if (piecesLeft >= maxCanEarn) {
                    long cutNeeded = (currentSize / baseSize) * divideBy - 1;
                    cutMade +=cutNeeded;
                    piecesLeft -= maxCanEarn;
                } else {
                    cutMade += piecesLeft;
                    piecesLeft = 0;
                }
            }
        }

        for (int i = pieceIndex; i < pieces.length && piecesLeft > 0; ++i) {
            long currentSize = pieces[i];
            if (currentSize % baseSize != 0) {
                long canEarn = (currentSize * divideBy) / baseSize;
                long willEarn = Math.min(piecesLeft, canEarn);
                cutMade += willEarn;
                piecesLeft -= willEarn;
            }
        }

        return piecesLeft == 0 ? (int)cutMade : Integer.MAX_VALUE;
    }

    private static int solve(long[] pieces, int d) {
        int bestResult = Integer.MAX_VALUE;

        Arrays.sort(pieces);

        for (int i = pieces.length - 1; i >= 0; --i) {
            while (i > 0 && pieces[i - 1] == pieces[i]) --i;
            for (int j = 1; j <= d; ++j) {
                int candidate = trySolve(pieces, i, j, d);
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
