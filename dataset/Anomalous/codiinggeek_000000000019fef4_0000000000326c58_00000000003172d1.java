import java.io.*;
import java.util.*;

public class Solution {
    static final long MOD = (long) Math.pow(10, 9);

    public static void main(String[] args) {
        try {
            FastReader reader = new FastReader();
            int testCases = reader.nextInt();
            for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
                int n = reader.nextInt();
                int d = reader.nextInt();
                Map<Long, Integer> frequencyMap = new HashMap<>();
                Set<Long> uniqueElements = new HashSet<>();

                for (int i = 0; i < n; i++) {
                    long element = reader.nextLong();
                    frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
                    uniqueElements.add(element);
                }

                boolean foundExactMatch = uniqueElements.stream().anyMatch(element -> frequencyMap.get(element) == d);
                if (foundExactMatch) {
                    System.out.println("Case #" + caseNumber + ": " + 0);
                    continue;
                }

                if (d == 2) {
                    System.out.println("Case #" + caseNumber + ": " + 1);
                    continue;
                }

                boolean foundHalfMatch = uniqueElements.stream().anyMatch(element -> uniqueElements.contains(element / 2));
                System.out.println("Case #" + caseNumber + ": " + (foundHalfMatch ? 1 : 2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class Pair<U, V> {
        U first;
        V second;

        Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}