import java.io.*;
import java.util.*;

public class Solution {
    public static int U;

    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG ? new Scanner(new FileInputStream("test.in")) : new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            U = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static String solve(Scanner in) {
        int[] counts = new int[26];
        Arrays.fill(counts, 0);

        for (int i = 0; i < 10000; i++) {
            int Q = in.nextInt();
            String input = in.next();
            for (char c : input.toCharArray()) {
                counts[c - 'A']++;
            }
        }

        List<Pair> queue = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (counts[i] > 0) {
                queue.add(new Pair((char) ('A' + i), counts[i]));
            }
        }

        queue.sort(new PairComparator());

        StringBuilder sb = new StringBuilder();
        sb.append(queue.remove(9).first); // Append the 10th element first
        for (Pair p : queue) {
            sb.append(p.first);
        }

        return sb.toString();
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
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o2.second, o1.second);
        }
    }
}