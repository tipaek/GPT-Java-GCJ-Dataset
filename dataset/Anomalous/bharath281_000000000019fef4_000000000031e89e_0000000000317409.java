import java.io.*;
import java.util.*;

public class Solution {
    static class Reader {
        private BufferedReader br;
        private StringTokenizer st;
        private BufferedWriter bw;

        public Reader() {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public void print(String s) {
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void println(String s) {
            try {
                bw.write(s + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void close() {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static int calculateDistance(int x, int y) {
        return Math.abs(x) + Math.abs(y);
    }

    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int queries = reader.nextInt();
        for (int i = 1; i <= queries; i++) {
            String[] input = reader.nextLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            char[] directions = input[2].toCharArray();
            int time = 0;
            int result = -1;

            for (char direction : directions) {
                switch (direction) {
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                    case 'S':
                        y--;
                        break;
                }
                time++;
                if (calculateDistance(x, y) <= time) {
                    result = time;
                    break;
                }
            }

            reader.print("Case #" + i + ": ");
            if (result == -1) {
                reader.println("IMPOSSIBLE");
            } else {
                reader.println(String.valueOf(result));
            }
        }
        reader.close();
    }
}