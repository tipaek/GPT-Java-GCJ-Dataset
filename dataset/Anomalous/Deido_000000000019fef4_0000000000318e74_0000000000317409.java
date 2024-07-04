import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        int t = reader.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            int x = reader.nextInt();
            int y = reader.nextInt();
            char[] moves = reader.next().toCharArray();
            if (x == 0 && y == 0) {
                System.out.println("Case #" + tc + ": 0");
                continue;
            }
            int answer = -1;
            for (int i = 0; i < moves.length; i++) {
                switch (moves[i]) {
                    case 'N':
                        y++;
                        break;
                    case 'S':
                        y--;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }
                int time = Math.abs(x) + Math.abs(y);
                if (time <= i + 1) {
                    answer = i + 1;
                    break;
                }
            }
            System.out.println("Case #" + tc + ": " + (answer == -1 ? "IMPOSSIBLE" : answer));
        }
    }
}

class FastReader {
    private BufferedReader br;
    private StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
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

    public int[] nextIntArray(int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextInt();
        }
        return array;
    }

    public long[] nextLongArray(int n) {
        long[] array = new long[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextLong();
        }
        return array;
    }

    public double[] nextDoubleArray(int n) {
        double[] array = new double[n];
        for (int i = 0; i < n; i++) {
            array[i] = nextDouble();
        }
        return array;
    }

    public String[] nextStringArray(int n) {
        String[] array = new String[n];
        for (int i = 0; i < n; i++) {
            array[i] = next();
        }
        return array;
    }
}