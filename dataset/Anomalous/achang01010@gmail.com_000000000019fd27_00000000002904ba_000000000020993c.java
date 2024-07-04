import java.io.*;
import java.util.StringTokenizer;

public class Vestigium {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("input.txt")) {
            FastScanner sc = new FastScanner(is);
            // You can add additional code to use the FastScanner here
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class FastScanner {
    private BufferedReader br;
    private StringTokenizer st;

    public FastScanner(InputStream is) throws IOException {
        br = new BufferedReader(new InputStreamReader(is), 32768);
    }

    public String next() {
        while (st == null || !st.hasMoreTokens()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
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
        try {
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}