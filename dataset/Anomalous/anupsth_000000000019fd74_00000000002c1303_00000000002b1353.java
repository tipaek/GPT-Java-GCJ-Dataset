package com.rudaconsulting.cca.ccaapp;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class Solution1A {
    private static final HashMap<Pair, Integer> map = new HashMap<>();
    private static final int[][] MOVES = {
        {-1, -1}, {-1, 0}, {0, -1}, {0, 1}, {1, 0}, {1, 1}
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();

        for (int ks = 1; ks <= T; ks++) {
            int N = input.nextInt();
            Pair startPair = new Pair(1, 1);
            Set<Pair> visited = new LinkedHashSet<>();
            visited.add(startPair);
            solve(visited, startPair, 1, N);
            
            System.out.println("Case #" + ks + ":");
            for (Pair p : visited) {
                System.out.println(p.getR() + " " + p.getK());
            }
        }

        input.close();
    }

    private static boolean solve(Set<Pair> visited, Pair pair, int sum, int N) {
        if (sum == N) {
            return true;
        }

        for (int[] move : MOVES) {
            if (isValidMove(pair, move)) {
                Pair nextPair = getMovedPair(pair, move);
                if (isSafe(visited, nextPair, sum, N)) {
                    visited.add(nextPair);
                    if (solve(visited, nextPair, sum + getValue(nextPair), N)) {
                        return true;
                    } else {
                        visited.remove(nextPair);
                    }
                }
            }
        }

        return false;
    }

    private static Pair getMovedPair(Pair pair, int[] move) {
        return new Pair(pair.getR() + move[0], pair.getK() + move[1]);
    }

    private static boolean isValidMove(Pair pair, int[] move) {
        int r = pair.getR() + move[0];
        int k = pair.getK() + move[1];
        return r > 0 && k > 0 && k <= r;
    }

    private static boolean isSafe(Set<Pair> visited, Pair pair, int sum, int N) {
        if (visited.contains(pair)) {
            return false;
        }
        int value = getValue(pair);
        return value + sum <= N;
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
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pair) {
            Pair other = (Pair) obj;
            return r == other.r && k == other.k;
        }
        return false;
    }
}