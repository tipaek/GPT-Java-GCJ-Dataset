import java.util.*;
import java.io.*;

class Solution {
    
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

    public static void swap(int i, int[] ar, int[] br) {
        int temp = ar[i];
        ar[i] = ar[i + 1];
        ar[i + 1] = temp;

        temp = br[i];
        br[i] = br[i + 1];
        br[i + 1] = temp;
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        StringBuilder result = new StringBuilder();
        int t = sc.nextInt();

        for (int i = 1; i <= t; i++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            int[] br = new int[n];

            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
                br[j] = sc.nextInt();
            }

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n - 1; j++) {
                    if (ar[j] > ar[j + 1]) {
                        swap(j, ar, br);
                    }
                }
            }

            StringBuilder schedule = new StringBuilder();
            int cEnd = br[0];
            int jEnd = -1;
            schedule.append("C");

            for (int j = 1; j < n; j++) {
                if (ar[j] >= cEnd) {
                    cEnd = br[j];
                    schedule.append("C");
                } else if (ar[j] >= jEnd) {
                    jEnd = br[j];
                    schedule.append("J");
                } else {
                    schedule = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }

            result.append("Case #").append(i).append(": ").append(schedule).append("\n");
        }

        System.out.print(result);
    }
}