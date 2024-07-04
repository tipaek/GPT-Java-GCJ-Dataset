import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = reader.nextInt();
            int d = reader.nextInt();
            long[] array = new long[n];
            HashSet<Long> uniqueNumbers = new HashSet<>();
            HashMap<Long, Integer> frequencyMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                array[i] = reader.nextLong();
                frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
                uniqueNumbers.add(array[i]);
            }

            Arrays.sort(array);

            int result = 2;
            if (n == 1) {
                result = (d == 2) ? 1 : 2;
            } else if (n == 2) {
                if (d == 2) {
                    result = (uniqueNumbers.size() == 1) ? 0 : 1;
                } else {
                    result = (uniqueNumbers.size() == 1) ? 2 : (array[1] == 2 * array[0] ? 1 : 2);
                }
            } else {
                if (d == 2) {
                    result = (uniqueNumbers.size() < n) ? 0 : 1;
                } else {
                    if (uniqueNumbers.size() < n - 1) {
                        result = 0;
                    } else if (uniqueNumbers.size() < n) {
                        outerLoop:
                        for (long value : array) {
                            if (value % 2 == 0 && uniqueNumbers.contains(value / 2)) {
                                result = 1;
                                break;
                            }
                            if (frequencyMap.get(value) >= 2) {
                                for (long val : array) {
                                    if (val > value) {
                                        result = 1;
                                        break outerLoop;
                                    }
                                }
                            }
                        }
                    } else {
                        for (long value : array) {
                            if (value % 2 == 0 && uniqueNumbers.contains(value / 2)) {
                                result = 1;
                            }
                        }
                    }
                }
            }
            System.out.printf("Case #%d: %d%n", caseNumber++, result);
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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
    }
}