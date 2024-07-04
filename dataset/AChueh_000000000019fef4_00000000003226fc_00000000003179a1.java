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
        Arrays.fill(counts, 0);
        for(int i = 0; i < 10000; ++i) {
            long Q = in.nextLong();
            String input = in.next();
            char[] carr = input.toCharArray();
            for(char c : carr) {
                ++counts[c-'A'];
            }
        }
        ArrayList<Pair> queue = new ArrayList<>();
        for(int i = 0; i < 26; ++i) {
            if(counts[i] > 0) {
                queue.add(new Pair((char)('A'+i), counts[i]));
            }
        }
        Collections.sort(queue, new pairComparator());
        StringBuilder sb = new StringBuilder();
        sb.append(queue.get(9).first);
        queue.remove(9);
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