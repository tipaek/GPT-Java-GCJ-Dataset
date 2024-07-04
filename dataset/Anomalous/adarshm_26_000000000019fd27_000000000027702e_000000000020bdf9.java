import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        for (int z = 1; z <= t; z++) {
            int n = in.nextInt();
            List<int[]> intervals = new ArrayList<>();
            char[] result = new char[n];
            boolean impossible = false;

            for (int i = 0; i < n; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                intervals.add(new int[]{start, 1, i});
                intervals.add(new int[]{end, 0, i});
            }

            intervals.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

            boolean cOccupied = false, jOccupied = false;
            int cIndex = -1, jIndex = -1;

            for (int[] interval : intervals) {
                int time = interval[0];
                int type = interval[1];
                int index = interval[2];

                if (type == 1) {
                    if (!cOccupied) {
                        result[index] = 'C';
                        cOccupied = true;
                        cIndex = index;
                    } else if (!jOccupied) {
                        result[index] = 'J';
                        jOccupied = true;
                        jIndex = index;
                    } else {
                        impossible = true;
                        break;
                    }
                } else {
                    if (cOccupied && cIndex == index) {
                        cOccupied = false;
                    } else if (jOccupied && jIndex == index) {
                        jOccupied = false;
                    }
                }
            }

            if (impossible) {
                pw.println("Case #" + z + ": IMPOSSIBLE");
            } else {
                pw.print("Case #" + z + ": ");
                pw.println(new String(result));
            }
        }

        pw.close();
    }

    static class InputReader {
        BufferedReader br;
        StringTokenizer st;

        public InputReader(InputStream inputStream) {
            br = new BufferedReader(new InputStreamReader(inputStream));
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