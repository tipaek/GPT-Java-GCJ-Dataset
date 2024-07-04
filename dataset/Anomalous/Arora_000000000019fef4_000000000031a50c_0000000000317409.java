import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            String moves = scanner.next();
            int moveLength = moves.length();

            boolean found = false;
            int result = 0;

            for (int i = 0; i < moveLength; i++) {
                char move = moves.charAt(i);
                switch (move) {
                    case 'S':
                        y--;
                        break;
                    case 'N':
                        y++;
                        break;
                    case 'E':
                        x++;
                        break;
                    case 'W':
                        x--;
                        break;
                }

                int distance = Math.abs(x) + Math.abs(y);
                if (distance <= (i + 1)) {
                    result = i + 1;
                    found = true;
                    break;
                }
            }

            if (found) {
                System.out.println("Case #" + testCase + ": " + result);
            } else {
                System.out.println("Case #" + testCase + ": IMPOSSIBLE");
            }
        }
    }

    static class FastScanner {
        BufferedReader bufferedReader;
        StringTokenizer stringTokenizer;

        FastScanner(InputStream inputStream) {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        }

        String next() {
            while (stringTokenizer == null || !stringTokenizer.hasMoreTokens()) {
                try {
                    stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return stringTokenizer.nextToken();
        }

        String nextLine() {
            String line = "";
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return line;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}