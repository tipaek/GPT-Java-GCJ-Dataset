import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
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

    static class Node {
        boolean visited = false;
        StringBuilder combo = new StringBuilder();
    }

    static Node[][] core;

    static void recurser(int x, int y, StringBuilder sb, int cnt) {
        int fl = 1;

        if (x < 0 || x >= core.length || y < 0 || y >= core[0].length)
            return;
        if (core[x][y].visited) {
            if (core[x][y].combo.length() > sb.length()) {
                core[x][y].combo = new StringBuilder(sb.toString());
            } else
                fl = 0;
        } else {
            core[x][y].visited = true;
            core[x][y].combo = new StringBuilder(sb.toString());
        }
        if (fl == 1) {
            recurser(x - (int)Math.pow(2, cnt), y, new StringBuilder(sb.toString() + "W"), cnt + 1);
            recurser(x + (int)Math.pow(2, cnt), y, new StringBuilder(sb.toString() + "E"), cnt + 1);
            recurser(x, y - (int)Math.pow(2, cnt), new StringBuilder(sb.toString() + "S"), cnt + 1);
            recurser(x, y + (int)Math.pow(2, cnt), new StringBuilder(sb.toString() + "N"), cnt + 1);
        }
    }

    public static void main(String[] args) {
        FastReader keyboard = new FastReader();
        int T = keyboard.nextInt();
        for (int i = 0; i < T; i++) {
            int N = 4;
            core = new Node[2 * N + 1][2 * N + 1];
            for (int j = 0; j < 2 * N + 1; j++) {
                for (int k = 0; k < 2 * N + 1; k++)
                    core[j][k] = new Node();
            }
            recurser(N, N, new StringBuilder(), 0);
            // can we reach target?
            int finx = keyboard.nextInt() + N;
            int finy = keyboard.nextInt() + N;
            System.out.print("Case #" + (i + 1) + ": ");
            if (core[finx][finy].visited) {
                System.out.println(core[finx][finy].combo.toString());
            } else {
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}
