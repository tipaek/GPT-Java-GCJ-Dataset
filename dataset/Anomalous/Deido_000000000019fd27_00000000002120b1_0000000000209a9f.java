import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++) {
            char[] s = in.next().toCharArray();
            int n = s.length;
            StringBuilder ans = new StringBuilder();
            int d = 0;
            for (int i = 0; i < n; i++) {
                int currentDigit = s[i] - '0';
                while (d > currentDigit) {
                    ans.append(")");
                    d--;
                }
                while (d < currentDigit) {
                    ans.append("(");
                    d++;
                }
                ans.append(s[i]);
            }
            while (d > 0) {
                ans.append(")");
                d--;
            }
            System.out.println("Case #" + tc + ": " + ans);
        }
    } 
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
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