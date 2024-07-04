package com.rudaconsulting.cca.ccaapp;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    private static final HashMap<Pair, Integer> map = new HashMap<>();
    private static final int[][] moves = {
        {-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int testCases = input.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int N = input.nextInt();
            Pair startPair = new Pair(1, 1);
            Set<Pair> visited = new LinkedHashSet<>();
            visited.add(startPair);

            solve(visited, startPair, 1, N);

            System.out.println("Case #" + t + ":");
            for (Pair p : visited) {
                System.out.println(p.getR() + " " + p.getK());
            }
        }
    }

    private static boolean solve(Set<Pair> visited, Pair currentPair, int currentSum, int targetSum) {
        if (currentSum == targetSum) {
            return true;
        }

        for (int[] move : moves) {
            if (isValidMove(currentPair, move)) {
                Pair newPair = movePair(currentPair, move);
                if (isSafeMove(visited, newPair, currentSum, targetSum)) {
                    visited.add(newPair);
                    if (solve(visited, newPair, currentSum + getValue(newPair), targetSum)) {
                        return true;
                    } else {
                        visited.remove(newPair);
                    }
                }
            }
        }
        return false;
    }

    private static Pair movePair(Pair pair, int[] move) {
        return new Pair(pair.getR() + move[0], pair.getK() + move[1]);
    }

    private static boolean isValidMove(Pair pair, int[] move) {
        int newRow = pair.getR() + move[0];
        int newCol = pair.getK() + move[1];
        return newRow > 0 && newCol > 0 && newCol <= newRow;
    }

    private static boolean isSafeMove(Set<Pair> visited, Pair pair, int currentSum, int targetSum) {
        if (visited.contains(pair)) {
            return false;
        }
        int value = getValue(pair);
        return currentSum + value <= targetSum;
    }

    private static int getValue(Pair pair) {
        return getValue(pair.getR(), pair.getK());
    }

    private static int getValue(int r, int k) {
        if (k == 1 || r == k) {
            return 1;
        }
        Pair key = new Pair(r, k);
        return map.computeIfAbsent(key, k1 -> getValue(r - 1, k - 1) + getValue(r - 1, k));
    }
}

class Pair {
    private final int r;
    private final int k;

    public Pair(int r, int k) {
        this.r = r;
        this.k = k;
    }

    public int getR() {
        return r;
    }

    public int getK() {
        return k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, k);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Pair) {
            Pair otherPair = (Pair) obj;
            return r == otherPair.r && k == otherPair.k;
        }
        return false;
    }
}