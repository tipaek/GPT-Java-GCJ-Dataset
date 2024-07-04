import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        MyScanner scan = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        int tc = scan.nextInt();
        for (int ttc = 1; ttc <= tc; ttc++) {
            int n = scan.nextInt();
            int[][] activities = new int[n][3];
            for (int i = 0; i < n; i++) {
                activities[i][0] = scan.nextInt();
                activities[i][1] = scan.nextInt();
                activities[i][2] = i;
            }
            out.println("Case #" + ttc + ": " + solve(activities));
        }


        out.close();
    }

    private static String solve(int[][] input) {
        char[] output = new char[input.length];
        Arrays.sort(input, Comparator.comparingInt(a -> a[0]));
        int C = 0;
        int J = 0;
        for (int i = 0; i < input.length; i++) {
            if (C <= input[i][0]) {
                C = input[i][1];
                output[input[i][2]] = 'C';
            } else if (J <= input[i][0]) {
                J = input[i][1];
                output[input[i][2]] = 'J';
            } else {
                return "IMPOSSIBLE";
            }
        }
        return new String(output);
    }


    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
    //--------------------------------------------------------

}