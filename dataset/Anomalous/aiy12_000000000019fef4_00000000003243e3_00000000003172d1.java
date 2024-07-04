import java.io.*;
import java.util.*;

public class Solution {

    public void run() throws Exception {
        FastScanner scanner = new FastScanner();

        int T = scanner.nextInt();

        for (int test = 1; test <= T; test++) {
            System.out.print("Case #" + test + ": ");

            int N = scanner.nextInt();
            int D = scanner.nextInt();

            long[] slices = new long[N];
            long maxSlice = Long.MIN_VALUE;
            Set<Long> uniqueSlices = new HashSet<>();

            for (int i = 0; i < N; i++) {
                slices[i] = scanner.nextLong();
                uniqueSlices.add(slices[i]);
                maxSlice = Math.max(maxSlice, slices[i]);
            }

            if (D == 2) {
                System.out.println(uniqueSlices.size() != N ? 0 : 1);
            } else {
                TreeMap<Long, Integer> frequencyMap = new TreeMap<>();
                long highestFrequency = -1;
                long mostFrequentValue = -1;

                for (long slice : slices) {
                    frequencyMap.put(slice, frequencyMap.getOrDefault(slice, 0) + 1);
                    if (frequencyMap.get(slice) > highestFrequency) {
                        highestFrequency = frequencyMap.get(slice);
                        mostFrequentValue = slice;
                    } else if (frequencyMap.get(slice) == highestFrequency) {
                        mostFrequentValue = Math.min(mostFrequentValue, slice);
                    }
                }

                if (highestFrequency == 3) {
                    System.out.println(0);
                } else if (highestFrequency == 2 && mostFrequentValue != maxSlice) {
                    System.out.println(1);
                } else {
                    boolean found = false;
                    for (long slice : slices) {
                        if (uniqueSlices.contains(2 * slice)) {
                            found = true;
                            break;
                        }
                    }
                    System.out.println(found ? 1 : 2);
                }
            }
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}