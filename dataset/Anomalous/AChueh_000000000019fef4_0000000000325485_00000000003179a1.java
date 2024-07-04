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
        for (int i = 1; i <= t; ++i) {
            U = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    private static String solve(Scanner in) {
        int[] counts = new int[26];
        int[] firstLetterFlag = new int[26];
        Arrays.fill(counts, 0);
        Arrays.fill(firstLetterFlag, 0);

        for (int i = 0; i < 10000; ++i) {
            long Q = in.nextLong();
            String input = in.next();
            char[] chars = input.toCharArray();

            for (int j = 0; j < chars.length; ++j) {
                char c = chars[j];
                if (j == 0) {
                    firstLetterFlag[c - 'A'] = 2;
                }
                if (firstLetterFlag[c - 'A'] == 0) {
                    firstLetterFlag[c - 'A'] = 1;
                }
                counts[c - 'A']++;
            }
        }

        List<Pair> queue = new ArrayList<>();
        for (int i = 0; i < 26; ++i) {
            if (counts[i] > 0) {
                queue.add(new Pair((char) ('A' + i), counts[i]));
            }
        }

        queue.sort(new PairComparator());

        StringBuilder result = new StringBuilder();
        for (int i = 9; i >= 0; --i) {
            if (firstLetterFlag[queue.get(i).first - 'A'] == 2) {
                continue;
            }
            result.append(queue.get(i).first);
            queue.remove(i);
            break;
        }

        for (Pair p : queue) {
            result.append(p.first);
        }

        return result.toString();
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.second - o1.second;
        }
    }

    static class Pair {
        char first;
        int second;

        Pair(char first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}