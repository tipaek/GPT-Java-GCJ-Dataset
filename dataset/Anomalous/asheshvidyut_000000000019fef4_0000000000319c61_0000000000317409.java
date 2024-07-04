import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastReader in = new FastReader(System.in);
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = in.nextInt();
        for (int t = 1; t <= tc; t++) {
            int x = in.nextInt();
            int y = in.nextInt();
            String directions = in.next();
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < directions.length(); i++) {
                char c = directions.charAt(i);
                switch (c) {
                    case 'N': y++; break;
                    case 'S': y--; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }
                if (Math.abs(x) + Math.abs(y) <= i + 1) {
                    ans = Math.min(i + 1, ans);
                }
            }
            if (ans != Integer.MAX_VALUE) {
                out.write("Case #" + t + ": " + ans);
            } else {
                out.write("Case #" + t + ": IMPOSSIBLE");
            }
            out.newLine();
        }
        out.close();
    }
}

class FastReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public FastReader(InputStream stream) {
        reader = new BufferedReader(new InputStreamReader(stream));
    }

    public String next() {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return tokenizer.nextToken();
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
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}