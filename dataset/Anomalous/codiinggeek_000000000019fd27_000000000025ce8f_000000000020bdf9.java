import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {

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

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int testCases = reader.nextInt();
        int caseNumber = 1;

        while (testCases-- > 0) {
            int n = reader.nextInt();
            long l = reader.nextLong();
            long r = reader.nextLong();
            n--;

            StringBuilder schedule = new StringBuilder("C");
            long lastCStart = l, lastCEnd = r;
            long lastJStart = 0, lastJEnd = 0;
            boolean isImpossible = false;

            while (n-- > 0) {
                long start = reader.nextLong();
                long end = reader.nextLong();

                if ((start < lastCEnd && end > lastCStart) || (start < lastJEnd && end > lastJStart)) {
                    if ((start < lastJEnd && end > lastJStart)) {
                        isImpossible = true;
                        break;
                    } else {
                        lastJStart = start;
                        lastJEnd = end;
                        schedule.append("J");
                    }
                } else {
                    lastCStart = start;
                    lastCEnd = end;
                    schedule.append("C");
                }
            }

            if (isImpossible) {
                System.out.printf("Case #%d: IMPOSSIBLE%n", caseNumber);
            } else {
                System.out.printf("Case #%d: %s%n", caseNumber, schedule.toString());
            }

            caseNumber++;
        }
    }
}