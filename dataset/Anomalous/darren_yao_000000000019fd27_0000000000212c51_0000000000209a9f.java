import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    static class InputReader {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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

    private static final InputReader reader = new InputReader(System.in);
    private static final PrintWriter writer = new PrintWriter(System.out);

    public static void main(String[] args) {
        int testCases = reader.nextInt();
        for (int caseNumber = 1; caseNumber <= testCases; caseNumber++) {
            writer.print("Case #" + caseNumber + ": ");
            String inputString = reader.next();
            int[] levels = new int[inputString.length() + 2];
            int length = inputString.length();

            for (int i = 1; i <= length; i++) {
                levels[i] = charToInt(inputString.charAt(i - 1));
            }

            for (int i = 1; i <= length; i++) {
                int difference = levels[i] - levels[i - 1];
                if (difference >= 0) {
                    for (int j = 0; j < difference; j++) {
                        writer.print("(");
                    }
                } else {
                    for (int j = 0; j < -difference; j++) {
                        writer.print(")");
                    }
                }
                writer.print(levels[i]);
            }

            for (int i = 0; i < levels[length]; i++) {
                writer.print(")");
            }
            writer.println();
        }

        writer.close();
    }

    private static int charToInt(char c) {
        return c - '0';
    }
}

/**
*                _        _                 _                                                
*               | |      | |               | |                                               
*   ___ ___   __| | ___  | |__  _   _    __| | __ _ _ __ _ __ ___ _ __     _   _  __ _  ___  
*  / __/ _ \ / _` |/ _ \ | '_ \| | | |  / _` |/ _` | '__| '__/ _ \ '_ \   | | | |/ _` |/ _ \ 
* | (_| (_) | (_| |  __/ | |_) | |_| | | (_| | (_| | |  | | |  __/ | | |  | |_| | (_| | (_) |
*  \___\___/ \__,_|\___| |_.__/ \__, |  \__,_|\__,_|_|  |_|  \___|_| |_|   \__, |\__,_|\___/ 
*                                __/ |                               ______ __/ |            
*                               |___/                               |______|___/             
 */