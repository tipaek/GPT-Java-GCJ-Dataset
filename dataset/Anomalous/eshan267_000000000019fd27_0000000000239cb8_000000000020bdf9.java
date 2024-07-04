import java.util.*;
import java.io.*;

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

        for (int testCase = 1; testCase <= t; testCase++) {
            int n = sc.nextInt();
            int[] ar = new int[n];
            int[] br = new int[n];
            HashMap<String, Integer> indexMap = new HashMap<>();

            for (int j = 0; j < n; j++) {
                ar[j] = sc.nextInt();
                br[j] = sc.nextInt();
                indexMap.put(ar[j] + " " + br[j], j);
            }

            for (int k = 0; k < n; k++) {
                for (int j = 0; j < n - 1; j++) {
                    if (ar[j] > ar[j + 1]) {
                        swap(j, ar, br);
                    }
                }
            }

            String[] assignments = new String[n];
            StringBuilder schedule = new StringBuilder();
            int cameronEnd = br[0];
            int jamieEnd = 0;
            assignments[indexMap.get(ar[0] + " " + br[0])] = "C";
            boolean possible = true;

            for (int j = 1; j < n; j++) {
                if (ar[j] >= cameronEnd) {
                    cameronEnd = br[j];
                    assignments[indexMap.get(ar[j] + " " + br[j])] = "C";
                } else if (ar[j] >= jamieEnd) {
                    jamieEnd = br[j];
                    assignments[indexMap.get(ar[j] + " " + br[j])] = "J";
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                schedule = new StringBuilder("IMPOSSIBLE");
            } else {
                for (int e = 0; e < n; e++) {
                    schedule.append(assignments[e]);
                }
            }

            result.append("Case #").append(testCase).append(": ").append(schedule).append("\n");
        }

        System.out.print(result);
    }
}