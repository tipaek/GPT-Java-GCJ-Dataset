import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
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
                out.printf("Case #%d:\n", i);
                for (int[] values : solvePascal(N)) {
                    out.printf("%d %d\n", values[0], values[1]);
                }
            }
            out.close();
        }
        catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    private static List<int[]> solvePascal(int n) {
        String s = Integer.toBinaryString(n);
        List<int[]> solution = new ArrayList<>();
        if (n == 1) {
            solution.add(new int[]{1, 1});
            return solution;
        }
        boolean left = true;
        int len = s.length();
        for (int i = 1; i <= s.length() - 1; i++) {
            int bit = s.charAt(i - 1) - '0';
            if (left) {
                for (int j = 1; j <= i; j++)
                    solution.add(new int[]{i, j});
            }
            else {
                for (int j = i; j >= 1; j--)
                    solution.add(new int[]{i, j});
            }
            left = !left;
        }
        int value = (1 << (len - 1)) - 1;

        int diff = n - value;
        int index = len;
        while (diff > 0) {
            if (left) {
                solution.add(new int[]{index, 1});
                diff--;
                if (index > 3 && diff >= index + index + 1) {
                    solution.add(new int[]{index, 2});
                    solution.add(new int[]{index + 1, 2});
                    diff -= (index + index + 1);
                }
            }
            else {
                solution.add(new int[]{index, index});
                diff--;
                if (index > 3 && diff >= index + index + 1) {
                    solution.add(new int[]{index, index - 1});
                    solution.add(new int[]{index + 1, index - 2});
                    diff -= (index + index + 1);
                }
            }
            index++;
        }
        return solution;
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

//            if (bit == 0) {
//                if (left) {
//                    solution.add(new int[]{i, 1});
//                }
//                else {
//                    solution.add(new int[]{i, i});
//                }
//                excess++;
//            }
//            else {
//                if (i == 1 && excess > 0) {
//                    int val = 1 << (s.length() - 1);
//                    int need = val - excess;
//                    int current = 0;
//                    if (left) {
//                        for (int j = 0; j < i; j++) {
//                            solution.add(new int[]{i, Math.max(j / 2 - 1, 1)});
//                        }
//                    }
//                    else {
//                        for (int j = i; j >= 1; j--) {
//                            solution.add(new int[]{i, Math.max(j / 2 - 1, 1)});
//                        }
//                    }
//                }
//                else {
//                    if (left) {
//                        for (int j = 0; j < i; j++)
//                            solution.add(new int[]{i, j});
//                    }
//                    else {
//                        for (int j = i; j >= 1; j--)
//                            solution.add(new int[]{i, j});
//                    }
//                }
//                left = !left;
//            }