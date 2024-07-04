import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static class Test implements Comparable<Test> {
        String value;
        int length;

        public Test(String value) {
            this.value = value;
            this.length = value.length();
        }

        @Override
        public int compareTo(Test other) {
            return Integer.compare(this.length, other.length);
        }
    }

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        int caseCount = reader.nextInt();

        for (int caseIndex = 0; caseIndex < caseCount; caseIndex++) {
            int N = reader.nextInt();
            Test[] tests = new Test[N];

            for (int i = 0; i < N; i++) {
                tests[i] = new Test(reader.nextLine().substring(1));
            }

            Arrays.sort(tests);
            boolean isPossible = true;

            for (int i = 0; i < N - 1; i++) {
                if (!tests[N - 1].value.endsWith(tests[i].value)) {
                    isPossible = false;
                    break;
                }
            }

            if (isPossible) {
                System.out.println("Case #" + (caseIndex + 1) + ": " + tests[N - 1].value);
            } else {
                System.out.println("Case #" + (caseIndex + 1) + ": *");
            }
        }
    }

    public static class FastReader {
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
            String str = null;
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}