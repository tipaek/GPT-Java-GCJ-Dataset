import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int t = in.nextInt();
        for (int c = 1; c <= t; c++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            String dir = in.next();

            boolean clicked = false;
            int time = 0;
            if (X == 0 && Y == 0) {
                clicked = true;
            } else {
                for (char d : dir.toCharArray()) {
                    switch (d) {
                        case 'N': Y += 1; break;
                        case 'S': Y -= 1; break;
                        case 'W': X -= 1; break;
                        case 'E': X += 1; break;
                    }
                    time++;
                    int dist = Math.abs(X) + Math.abs(Y);
                    if (dist <= time) {
                        clicked = true;
                        break;
                    }
                }
            }

            if (clicked) {
                out.println("Case #" + c + ": " + time);
            } else {
                out.println("Case #" + c + ": IMPOSSIBLE");
            }
        }
        
        in.close();
        out.close();
    }
}

class InputReader {
    private BufferedReader reader;
    private StringTokenizer tokenizer;

    public InputReader() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
    }

    public String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public String nextLine() throws IOException {
        return reader.readLine();
    }

    public void close() throws IOException {
        reader.close();
    }
}