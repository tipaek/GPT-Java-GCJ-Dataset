import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader(System.in);
        int numberOfTests = inputReader.nextInt();
        int caseNumber = 1;
        
        while (numberOfTests-- > 0) {
            int x = inputReader.nextInt();
            int y = inputReader.nextInt();
            char[] directions = inputReader.next().toCharArray();
            int result = -1;
            
            for (int i = 0; i < directions.length; i++) {
                switch (directions[i]) {
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
                
                int distance = Math.abs(x) + Math.abs(y);
                int time = i + 1;
                
                if (distance <= time) {
                    result = time;
                    break;
                }
            }
            
            if (result == -1) {
                System.out.printf("Case #%d: IMPOSSIBLE\n", caseNumber++);
            } else {
                System.out.printf("Case #%d: %d\n", caseNumber++, result);
            }
        }
    }

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            tokenizer = null;
        }

        public InputReader(FileReader stream) {
            reader = new BufferedReader(stream);
            tokenizer = null;
        }

        public String nextLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
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
    }
}