import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        FastScanner sc = new FastScanner(System.in);
        int t = sc.nextInt();
        for (int p1 = 0; p1 < t; p1++) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            long[] a = new long[n];
            Map<Long, Integer> frequencyMap = new HashMap<>();
            int maxFrequency = 0;
            long overallMax = 0, currentMax = 0;

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
                overallMax = Math.max(overallMax, a[i]);
                frequencyMap.put(a[i], frequencyMap.getOrDefault(a[i], 0) + 1);
                int freq = frequencyMap.get(a[i]);
                if (maxFrequency <= freq) {
                    maxFrequency = freq;
                    currentMax = Math.max(currentMax, a[i]);
                }
            }

            int result = 0;
            if (d == 2) {
                result = (maxFrequency >= 2) ? 0 : 1;
            } else if (d == 3) {
                if (maxFrequency >= 3) {
                    result = 0;
                } else if (n == 2) {
                    result = (currentMax % 2 == 0 && frequencyMap.containsKey(currentMax / 2)) ? 1 : 2;
                } else if (maxFrequency == 1) {
                    result = 2;
                } else {
                    result = (currentMax < overallMax) ? 1 : 2;
                }
            }

            System.out.println("Case #" + (p1 + 1) + ": " + result);
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            br = new BufferedReader(new InputStreamReader(stream));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
    }
}