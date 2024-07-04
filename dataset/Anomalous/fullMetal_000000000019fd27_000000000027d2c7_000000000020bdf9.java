import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int testCases = reader.nextInt();
        
        for (int t = 1; t <= testCases; t++) {
            int n = reader.nextInt();
            int[][] intervals = new int[n][3];
            
            for (int i = 0; i < n; i++) {
                intervals[i][0] = reader.nextInt();
                intervals[i][1] = reader.nextInt();
                intervals[i][2] = i;
            }
            
            Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

            char[] schedule = new char[n];
            boolean isPossible = true;
            int cEndTime = 0;
            int jEndTime = 0;
            
            for (int i = 0; i < n; i++) {
                if (intervals[i][0] >= cEndTime) {
                    cEndTime = intervals[i][1];
                    schedule[intervals[i][2]] = 'C';
                } else if (intervals[i][0] >= jEndTime) {
                    jEndTime = intervals[i][1];
                    schedule[intervals[i][2]] = 'J';
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (isPossible) {
                out.println("Case #" + t + ": " + new String(schedule));
            } else {
                out.println("Case #" + t + ": Impossible");
            }
        }
        
        out.close();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        FastReader() {
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