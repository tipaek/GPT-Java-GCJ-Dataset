import java.io.*;
import java.util.*;

public class Solution {
    static final long MOD = (long) Math.pow(10, 9);

    public static void main(String[] args) {
        try {
            FastReader reader = new FastReader();
            int testCases = reader.nextInt();
            int caseNumber = 1;

            while (testCases-- > 0) {
                int n = reader.nextInt();
                long d = reader.nextLong();
                Map<Long, Long> frequencyMap = new HashMap<>();
                Set<Long> uniqueValues = new HashSet<>();

                for (int i = 0; i < n; i++) {
                    long value = reader.nextLong();
                    frequencyMap.put(value, frequencyMap.getOrDefault(value, 0L) + 1);
                    uniqueValues.add(value);
                }

                boolean found = false;
                for (long value : uniqueValues) {
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
                    found = false;
                    for (long value : uniqueValues) {
                        if (uniqueValues.contains(value / 2)) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Case #" + caseNumber + ": " + 1);
                    } else {
                        System.out.println("Case #" + caseNumber + ": " + 2);
                    }
                }
                caseNumber++;
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
}