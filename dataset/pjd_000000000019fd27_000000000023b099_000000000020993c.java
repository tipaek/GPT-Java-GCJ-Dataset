import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // long startTime = System.nanoTime();
        /////////////////////////////////////////////////////
        int t = sc.nextInt();
        HashSet<Integer> hs = new HashSet<>();

        for (int caseno = 1; caseno <= t; ++caseno) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; ++i) {
                grid[i] = new int[n];
                for (int j = 0; j < n; ++j) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for (int i = 0; i < n; ++i) {
                trace += grid[i][i];
            }

            int r = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    hs.add(grid[i][j]);
                }
                if (hs.size() != n) {
                    ++r;
                }
                hs.clear();
            }

            int c = 0;
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    hs.add(grid[j][i]);
                }
                if (hs.size() != n) {
                    ++c;
                }
                hs.clear();
            }
            System.out.println("Case #" + caseno + ": " + trace + " " + r + " " + c);
        }

        /////////////////////////////////////////////////////
        // long endTime = System.nanoTime();
        // System.out.printf("Executed in: %.2fms\n", ((double)endTime - startTime) /
        ///////////////////////////////////////////////////// 1000000);
        // sc.close();
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }

    static boolean isOdd(int n) {
        return n % 2 == 1;
    }

    static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        } else {
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}

class Pair {
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        // System.out.println("inside equals");
        if (o == this) {
            return true;
        } else if (!(o instanceof Pair)) {
            return false;
        } else {
            Pair p = (Pair) o;
            return this.x == p.x && this.y == p.y;
        }
    }

    @Override
    public int hashCode() {
        // System.out.println("inside hashcode");
        return Arrays.hashCode(new int[] { this.x, this.y });
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }
}