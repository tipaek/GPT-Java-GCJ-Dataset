import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

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

    public static PrintWriter out;

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            out.print(arr[i] + " ");
        }
        out.println();
    }

    public static void main(String[] args) {
        FastReader s = new FastReader();
        // out = new PrintWriter(new BufferedOutputStream(System.out));
        int t = s.nextInt();
        for (int u = 1; u <= t; u++) {
            int n = s.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.nextInt();
                }
            }
            int rows = 0;
            int cols = 0;
            // rows
            for (int i = 0; i < n; i++) {
                HashSet<Integer> set = new HashSet<>();
                for (int j = 0; j < n; j++) {
                    if (set.contains(arr[i][j])) {
                        rows++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }
            // cols
            for (int j = 0; j < n; j++) {
                HashSet<Integer> set = new HashSet<>();
                for (int i = 0; i < n; i++) {
                    if (set.contains(arr[i][j])) {
                        cols++;
                        break;
                    }
                    set.add(arr[i][j]);
                }
            }
            int i = 0;
            int j = 0;
            int sum = 0;
            while(i!=n && j!=n){
                sum += arr[i][j];
                i++;
                j++;
            }
            System.out.println("Case #" + u + ": " + sum + " " + rows + " " + cols);
            
        }
    }
}