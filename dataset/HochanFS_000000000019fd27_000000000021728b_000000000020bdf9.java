import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.io.PrintWriter;

public class Solution {
    public static void main(String[] args) {

        In in = new In(System.in);
        PrintWriter out = new PrintWriter(System.out);
        try {
            int T = in.nextInt();
            for (int i = 1; i <= T; i++) {
                int N = in.nextInt();
                int[][] schedules = new int[N][2];
                for (int j = 0; j < N; j++) {
                    schedules[j][0] = in.nextInt();
                    schedules[j][1] = in.nextInt();
                }
                Arrays.sort(schedules, Comparator.comparingInt(u -> u[0]));
                out.printf("Case #%d: %s\n", i, arrangeSchedule(schedules));
            }
            out.close();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private static String arrangeSchedule(int[][] schedules) {
        int cameronNextAvailability = 0;
        int jamieNextAvailability = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < schedules.length; i++) {
            int start = schedules[i][0];
            int end = schedules[i][1];
            if (cameronNextAvailability <= start) {
                sb.append('C');
                cameronNextAvailability = end;
                continue;
            }
            if (jamieNextAvailability <= start ) {
                sb.append('J');
                jamieNextAvailability = end;
                continue;
            }
            return "IMPOSSIBLE";
        }
        return sb.toString();
    }

    //@
    static class In {
        BufferedReader br;
        StringTokenizer st;

        public In(InputStream i) {
            br = new BufferedReader(new InputStreamReader(i));
            st = new StringTokenizer("");
        }

        public String next() throws IOException {
            if(st.hasMoreTokens())
                return st.nextToken();
            else
                st = new StringTokenizer(br.readLine());
            return next();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        //#
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
        //$
    }
}