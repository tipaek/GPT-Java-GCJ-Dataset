package com.blazej.codejam.y20.round1c.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int t = scanner.nextInt();

            for (int caseId = 1; caseId <= t; caseId++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                String moves = scanner.next();
                int result = findMinimumMoves(x, y, moves);
                System.out.println("Case #" + caseId + ": " + (result == -1 ? "IMPOSSIBLE" : result));
            }
        }
    }

    private static int findMinimumMoves(int targetX, int targetY, String moves) {
        return findMoves(targetX, targetY, 0, 0, 0, moves);
    }

    private static int findMoves(int targetX, int targetY, int currentX, int currentY, int moveCount, String remainingMoves) {
        if (targetX == currentX && targetY == currentY) {
            return moveCount;
        }

        if (remainingMoves.isEmpty() || Math.abs(targetX - currentX) > remainingMoves.length() || Math.abs(targetY - currentY) > remainingMoves.length()) {
            return -1;
        }

        char direction = remainingMoves.charAt(0);
        String newRemainingMoves = remainingMoves.substring(1);

        int newX = currentX;
        int newY = currentY;
        switch (direction) {
            case 'N':
                newY++;
                break;
            case 'S':
                newY--;
                break;
            case 'E':
                newX++;
                break;
            case 'W':
                newX--;
                break;
        }

        int stay = findMoves(targetX, targetY, newX, newY, moveCount + 1, newRemainingMoves);
        int north = findMoves(targetX, targetY, newX, newY + 1, moveCount + 1, newRemainingMoves);
        int south = findMoves(targetX, targetY, newX, newY - 1, moveCount + 1, newRemainingMoves);
        int east = findMoves(targetX, targetY, newX + 1, newY, moveCount + 1, newRemainingMoves);
        int west = findMoves(targetX, targetY, newX - 1, newY, moveCount + 1, newRemainingMoves);

        return IntStream.of(stay, north, south, east, west)
                        .filter(i -> i >= 0)
                        .min()
                        .orElse(-1);
    }
}