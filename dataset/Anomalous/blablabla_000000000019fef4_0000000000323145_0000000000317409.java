import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {
    
    static int min = Integer.MAX_VALUE;
    static int localMin = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();

            min = x;
            localMin = Integer.MAX_VALUE;

            int solve = equalizeX(x, y, 0, 0, 0, moves);

            String result = solve == -1 ? "IMPOSSIBLE" : String.valueOf(solve);
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    static int equalizeX(int pX, int pY, int mX, int mY, int moves, String pMoves) {
        if (pX == mX) {
            return solve(pX, pY, mX, mY, moves, pMoves);
        }

        if (pMoves.isEmpty() || Math.abs(pX - mX) > pMoves.length()) {
            return -1;
        }

        char dir = pMoves.charAt(0);
        String newPMoves = pMoves.substring(1);

        int newPx = pX;
        int newPy = pY;
        switch (dir) {
            case 'N':
                newPy += 1;
                break;
            case 'S':
                newPy -= 1;
                break;
            case 'E':
                newPx += 1;
                break;
            case 'W':
                newPx -= 1;
                break;
        }

        return equalizeX(newPx, newPy, mX + 1, mY, moves + 1, newPMoves);
    }

    static int solve(int pX, int pY, int mX, int mY, int moves, String pMoves) {
        if (moves >= localMin) {
            return -1;
        }

        if (pX == mX && pY == mY) {
            return moves;
        }

        if (pMoves.isEmpty() || Math.abs(pX - mX) > pMoves.length()) {
            return -1;
        }

        char dir = pMoves.charAt(0);
        String newPMoves = pMoves.substring(1);

        int newPx = pX;
        int newPy = pY;
        switch (dir) {
            case 'N':
                newPy += 1;
                break;
            case 'S':
                newPy -= 1;
                break;
            case 'E':
                newPx += 1;
                break;
            case 'W':
                newPx -= 1;
                break;
        }

        int stay = solve(newPx, newPy, mX, mY, moves + 1, newPMoves);
        if (isMinimal(stay)) {
            return stay;
        }

        int north = solve(newPx, newPy, mX, mY + 1, moves + 1, newPMoves);
        if (isMinimal(north)) {
            return north;
        }

        int south = solve(newPx, newPy, mX, mY - 1, moves + 1, newPMoves);
        if (isMinimal(south)) {
            return south;
        }

        int min = IntStream.of(stay, north, south)
                .filter(i -> i >= 0)
                .min()
                .orElse(-1);
        if (min > 0) {
            localMin = Math.min(min, localMin);
        }
        return min;
    }

    static boolean isMinimal(int value) {
        return value > 0 && value <= min;
    }
}