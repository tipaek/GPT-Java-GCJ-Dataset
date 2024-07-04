import java.io.*;
import java.util.*;

class Solution {
    public static int U;
    public static void main(String[] args) {
        boolean DEBUG = false;
        Scanner in = null;
        try {
            in = DEBUG?new Scanner(new FileInputStream("test.in")):new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            U = in.nextInt();
            System.out.println("Case #" + i + ": " + solve(in));
        }
    }

    static String solve(Scanner in) {
        int[] counts = new int[26];
        int[] counts2 = new int[26];
        Arrays.fill(counts, 0);
        Arrays.fill(counts2, 0);
        for(int i = 0; i < 10000; ++i) {
            long Q = in.nextLong();
            String input = in.next();
            char[] carr = input.toCharArray();
            for(int j = 0; j < carr.length && j < 2; ++j) {
                char c = carr[j];
                if(j == 0) {
                    counts2[c-'A'] = 2;
                }
                if(counts2[c-'A'] == 0)
                    counts2[c-'A'] = 1;
                ++counts[c-'A'];
            }
        }
        ArrayList<Pair> queue = new ArrayList<>();
        for(int i = 0; i < 26; ++i) {
            if(counts[i] > 0) {
                queue.add(new Pair((char)('A'+i), counts[i]));
            }
        }
        queue.sort(new pairComparator());
        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; --i) {
            if(counts2[queue.get(i).first-'A'] == 2)
                continue;
            sb.append(queue.get(i).first);
            queue.remove(i);
            break;
        }
        for(Pair p: queue) {
            sb.append(p.first);
        }
        return sb.toString();
    }

    static class pairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o2.second - o1.second;
        }
    }

    static class Pair {
        public Pair(char a, Integer b) {
            this.first = a;
            this.second = b;
        }
        public char first;
        public Integer second;
    }
}