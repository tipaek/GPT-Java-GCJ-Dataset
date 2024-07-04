import java.util.*;

public class Solution {
    static final Map<Pair, Integer> map = new HashMap<>();
    static final int[][] moves = {
        {-1, -1},
        {-1, 0},
        {0, -1},
        {0, 1},
        {1, 0},
        {1, 1}
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
                System.out.println(p.r + " " + p.k);
            }
        }
        input.close();
    }

    static boolean solve(Set<Pair> visited, Pair currentPair, int currentSum, int targetSum) {
        if (currentSum == targetSum) {
            return true;
        }
        for (int[] move : moves) {
            if (isValidMove(currentPair, move)) {
                Pair nextPair = movePair(currentPair, move);
                if (isSafeMove(visited, nextPair, currentSum, targetSum)) {
                    visited.add(nextPair);
                    if (solve(visited, nextPair, currentSum + getValue(nextPair), targetSum)) {
                        return true;
                    } else {
                        visited.remove(nextPair);
                    }
                }
            }
        }
        return false;
    }

    static Pair movePair(Pair p, int[] move) {
        return new Pair(p.r + move[0], p.k + move[1]);
    }

    static boolean isValidMove(Pair pair, int[] move) {
        int newR = pair.r + move[0];
        int newK = pair.k + move[1];
        return newR > 0 && newK > 0 && newK <= newR;
    }

    static boolean isSafeMove(Set<Pair> visited, Pair pair, int currentSum, int targetSum) {
        if (visited.contains(pair)) {
            return false;
        }
        int value = getValue(pair);
        return currentSum + value <= targetSum;
    }

    static int getValue(Pair pair) {
        return getValue(pair.r, pair.k);
    }

    static int getValue(int r, int k) {
        if (k == 1 || r == k) {
            return 1;
        }
        Pair key = new Pair(r, k);
        return map.computeIfAbsent(key, k1 -> getValue(r - 1, k - 1) + getValue(r - 1, k));
    }
}

class Pair {
    final int r;
    final int k;

    public Pair(int r, int k) {
        this.r = r;
        this.k = k;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r, k);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Pair other = (Pair) obj;
        return r == other.r && k == other.k;
    }
}