import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    static class Coord {
        int r, k;

        Coord(int r, int k) {
            this.r = r;
            this.k = k;
        }

        @Override
        public String toString() {
            return "(" + r + ", " + k + ")";
        }
    }

    static Scanner in;
    static int T;
    static int[][] pascal = new int[501][501];

    static {
        pascal[1][1] = 1;
        for (int i = 2; i <= 500; i++) {
            pascal[i][1] = 1;
            pascal[i][i] = 1;
            for (int j = 2; j < i; j++) {
                pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
            }
        }
    }

    int N;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        T = in.nextInt();

        for (int merp = 1; merp <= T; merp++) {
            Solution s = new Solution();
            s.solve(merp);
        }

        in.close();
    }

    void solve(int caseNum) {
        readInput();
        int min = 1, max = 500;
        int good = -1;

        while (min < max) {
            int guess = (min + max) / 2;
            int v = checkViability(guess);

            if (v == 1) {
                max = guess - 1;
            } else if (v == -1) {
                min = guess + 1;
            } else {
                good = guess;
                break;
            }
        }

        List<Coord> path = constructPath(good);
        System.out.println("Case #" + caseNum + ": ");
        for (Coord co : path) {
            System.out.println(co.r + " " + co.k);
        }
    }

    void readInput() {
        N = in.nextInt();
    }

    int checkViability(int a) {
        int sum = a;
        int s = a;
        int r = a, k = 1;

        if (sum > N) return 1;

        while (s <= 500 && sum < N && r != k) {
            if (sum + pascal[r + 1][k + 1] <= N) {
                sum += pascal[r + 1][k + 1];
                r += 1;
                k += 1;
            } else if (sum + pascal[r][k + 1] <= N) {
                sum += pascal[r][k + 1];
                k += 1;
            } else {
                return 1;
            }
            s += 1;
        }

        s += N - sum;
        sum += N - sum;

        if (s > 500) return -1;
        else if (sum == N && s <= 500) return 0;
        else throw new RuntimeException();
    }

    List<Coord> constructPath(int a) {
        List<Coord> path = new ArrayList<>();
        int sum = a;
        int r = a, k = 1;

        for (int i = 1; i <= a; i++) {
            path.add(new Coord(i, 1));
        }

        while (sum < N && r != k) {
            if (sum + pascal[r + 1][k + 1] <= N) {
                sum += pascal[r + 1][k + 1];
                r += 1;
                k += 1;
            } else if (sum + pascal[r][k + 1] <= N) {
                sum += pascal[r][k + 1];
                k += 1;
            }
            path.add(new Coord(r, k));
        }

        while (sum < N) {
            r += 1;
            k += 1;
            sum += 1;
            path.add(new Coord(r, k));
        }

        return path;
    }

    int pathSum(List<Coord> path) {
        int sum = 0;
        for (Coord c : path) {
            sum += pascal[c.r][c.k];
        }
        return sum;
    }
}