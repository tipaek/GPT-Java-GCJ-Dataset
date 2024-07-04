package com.blazej.codejam.y20.round1c.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = scanner.nextInt();

        for (int caseId = 1; caseId <= t; caseId++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int solve = solve(x, y, 0, 0, 0, moves);
            String result = solve == -1 ? "IMPOSSIBLE" : "" + solve;
            System.out.println("Case #" + caseId + ": " + result);
        }
    }

    static int solve(int pX, int pY, int mX, int mY, int moves, String pMoves) {
//        System.out.println(String.format("(%d,%d) (%d,%d) | %s | %s", pX, pY, mX, mY, moves, pMoves));
        if (pX == mX && pY == mY) {
            return moves;
        }

        if (pMoves.length() == 0 || Math.abs(pX - mX) > pMoves.length()) {
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
        int north = solve(newPx, newPy, mX, mY + 1, moves + 1, newPMoves);
        int south = solve(newPx, newPy, mX, mY - 1, moves + 1, newPMoves);
        int east = solve(newPx, newPy, mX + 1, mY, moves + 1, newPMoves);

        return IntStream.of(
                stay,
                north,
                south,
                east)
                .filter(i -> i >= 0)
                .min()
                .orElse(-1);
    }

}
