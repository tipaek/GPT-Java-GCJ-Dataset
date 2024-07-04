import java.io.*;
import java.util.*;

public class Solution {
    public static int U;

    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner scanner = null;
        try {
            if (DEBUG) {
                scanner = new Scanner(new FileInputStream("test.in"));
            } else {
                scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = scanner.nextInt();
        for (int i = 1; i <= t; i++) {
            U = scanner.nextInt();
            System.out.println("Case #" + i + ": " + solve(scanner));
        }
    }

    private static String solve(Scanner scanner) {
        int[] letterCounts = new int[26];
        Arrays.fill(letterCounts, 0);

        for (int i = 0; i < 10000; i++) {
            long Q = scanner.nextLong();
            String input = scanner.next();
            for (char c : input.toCharArray()) {
                letterCounts[c - 'A']++;
            }
        }

        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (letterCounts[i] > 0) {
                pairs.add(new Pair((char) ('A' + i), letterCounts[i]));
            }
        }

        pairs.sort(new PairComparator());
        StringBuilder result = new StringBuilder();
        result.append(pairs.get(9).first);
        pairs.remove(9);

        for (Pair pair : pairs) {
            result.append(pair.first);
        }

        return result.toString();
    }

    private static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    private static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            return Integer.compare(p2.second, p1.second);
        }
    }
}