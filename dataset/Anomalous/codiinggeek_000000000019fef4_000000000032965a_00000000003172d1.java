import java.io.*;
import java.util.*;

public class Solution {
    static final long MOD = (long) Math.pow(10, 9);

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        int caseNumber = 1;

        while (t-- > 0) {
            int n = reader.nextInt();
            double d = reader.nextLong();
            Map<Double, Long> frequencyMap = new HashMap<>();
            Set<Double> uniqueValues = new HashSet<>();

            for (int i = 0; i < n; i++) {
                double value = reader.nextLong();
                frequencyMap.put(value, frequencyMap.getOrDefault(value, 0L) + 1);
                uniqueValues.add(value);
            }

            boolean found = false;
            for (double value : uniqueValues) {
                if (frequencyMap.get(value) == d) {
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Case #" + caseNumber + ": " + 0);
            } else if (d == 2) {
                System.out.println("Case #" + caseNumber + ": " + 1);
            } else {
                boolean halfFound = false;
                for (double value : uniqueValues) {
                    if (uniqueValues.contains(value / 2)) {
                        halfFound = true;
                        break;
                    }
                }
                System.out.println("Case #" + caseNumber + ": " + (halfFound ? 1 : 2));
            }
            caseNumber++;
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