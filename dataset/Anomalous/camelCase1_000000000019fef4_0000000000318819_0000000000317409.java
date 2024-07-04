import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fan {

    private static BufferedReader br;
    private static StringTokenizer tokenizer;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int t = readInt();
        int caseNumber = 1;
        PrintWriter out = new PrintWriter(System.out);
        
        while (t-- > 0) {
            int x = readInt();
            int y = readInt();
            String directions = readString();
            int currentX = 0, currentY = 0;
            boolean reached = false;

            for (int i = 0; i < directions.length(); i++) {
                char direction = directions.charAt(i);
                switch (direction) {
                    case 'S': y--; break;
                    case 'N': y++; break;
                    case 'E': x++; break;
                    case 'W': x--; break;
                }

                if (Math.abs(currentX - x) + Math.abs(currentY - y) <= i + 1) {
                    out.println("Case #" + (caseNumber++) + ": " + (i + 1));
                    reached = true;
                    break;
                }
            }

            if (!reached) {
                out.println("Case #" + (caseNumber++) + ": IMPOSSIBLE");
            }
        }
        
        out.close();
    }

    private static String readString() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            String line = br.readLine();
            if (line == null) throw new IOException();
            tokenizer = new StringTokenizer(line);
        }
        return tokenizer.nextToken();
    }

    private static int readInt() throws IOException {
        return Integer.parseInt(readString());
    }

    private static long readLong() throws IOException {
        return Long.parseLong(readString());
    }

    private static double readDouble() throws IOException {
        return Double.parseDouble(readString());
    }
}