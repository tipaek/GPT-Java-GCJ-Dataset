import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static class Pair {
        private int a;
        private int b;
        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }
        public int getA() { return this.a; }
        public int getB() { return this.b; }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)))) {
            int testCount = scanner.nextInt();
            for (int i = 0; i < testCount; i++) {
                int r = scanner.nextInt();
                int s = scanner.nextInt();
                solve(r, s, i+1);
            }
        }
    }

    public static void solve(int r, int s, int caseNum) {
        List<Pair> solution = solve(r, s, new ArrayList<>());
        System.out.println("Case #" + caseNum + ": " + solution.size());
        for (Pair p : solution) {
            System.out.println(p.getA() + " " + p.getB());
        }

    }

    public static List<Pair> solve(int r, int s, List<Pair> acc) {
        if (r <= 1) return acc;
        int deckSize = r*s;
        for (int i = 0; i < s - 1; i++) {
            acc.add(new Pair(r, (deckSize - r - i - 1)));
        }
        return solve(r - 1, s, acc);
    }

}

