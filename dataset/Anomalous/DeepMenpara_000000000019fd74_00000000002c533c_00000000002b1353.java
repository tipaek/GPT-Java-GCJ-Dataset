import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int testCases = sc.nextInt();
        for (int test = 1; test <= testCases; test++) {
            // Dummy loop to match the original structure
            for (int k = 0; k < 10; k++) {
                k++;
            }

            int n = sc.nextInt();
            System.out.println("Case #" + test + ":");

            if (n <= 500) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " " + i);
                }
            } else {
                int remaining = n - 498;
                String[] indices = new String[5];

                if (remaining > 498) {
                    indices[0] = (remaining - 498 + 1) + " " + (remaining - 498);
                    indices[1] = "499 498";
                    remaining -= 498;
                } else {
                    indices[0] = (remaining + 1) + " " + remaining;
                }

                int i = 1;
                int sum = 0;
                int count = 0;

                while (i <= remaining) {
                    System.out.println(i + " " + i);
                    i++;
                    sum++;
                    count++;
                }

                System.out.println(indices[0]);
                sum += remaining;
                count++;

                for (; sum < n; i++) {
                    if (i <= 498) {
                        System.out.println(i + " " + i);
                        sum++;
                        count++;
                    } else {
                        System.out.println(indices[1]);
                        count++;
                        sum += 498;
                    }
                }
            }
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