import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution();
    }

    public Solution() throws IOException {
        FasterScanner sc = new FasterScanner(System.in);

        int amountOfTasks = sc.nextInt();
        for (int task = 1; task <= amountOfTasks; task++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            for (int i = 0; i < n; i++) {
                patterns[i] = sc.nextString();
            }

            String longestStart = "";
            String longestEnd = "";

            for (String pattern : patterns) {
                int lastAsterisk = -1;
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        if (lastAsterisk == -1 && longestStart.length() < j) {
                            longestStart = pattern.substring(0, j);
                        }
                        lastAsterisk = j;
                    }
                }
                if (lastAsterisk < pattern.length() - 1 && pattern.length() - lastAsterisk - 1 > longestEnd.length()) {
                    longestEnd = pattern.substring(lastAsterisk + 1);
                }
            }

            boolean possible = true;

            for (String pattern : patterns) {
                int lastAsterisk = -1;
                for (int j = 0; j < pattern.length(); j++) {
                    if (pattern.charAt(j) == '*') {
                        if (lastAsterisk == -1) {
                            String startPattern = pattern.substring(0, j);
                            if (longestStart.length() > 0 && !longestStart.startsWith(startPattern)) {
                                possible = false;
                            }
                        }
                        lastAsterisk = j;
                    }
                }
                if (lastAsterisk < pattern.length() - 1) {
                    String endPattern = pattern.substring(lastAsterisk + 1);
                    if (longestEnd.length() > 0 && !longestEnd.endsWith(endPattern)) {
                        possible = false;
                    }
                }
            }

            String solution = "*";
            if (possible) {
                StringBuilder sb = new StringBuilder();
                sb.append(longestStart);
                for (String pattern : patterns) {
                    int firstAsterisk = -1;
                    int lastAsterisk = -1;
                    for (int j = 0; j < pattern.length(); j++) {
                        if (pattern.charAt(j) == '*') {
                            if (firstAsterisk == -1) {
                                firstAsterisk = j;
                            }
                            lastAsterisk = j;
                        }
                    }
                    if (firstAsterisk != lastAsterisk) {
                        for (int j = firstAsterisk + 1; j < lastAsterisk; j++) {
                            if (pattern.charAt(j) != '*') {
                                sb.append(pattern.charAt(j));
                            }
                        }
                    }
                }
                sb.append(longestEnd);
                solution = sb.toString();
            }

            System.out.println("Case #" + task + ": " + solution);
        }

        sc.close();
    }

    public static class FasterScanner {
        private InputStream is;
        private byte[] buffer = new byte[1024];
        private int currentChar;
        private int numChars;

        public FasterScanner(InputStream is) {
            this.is = is;
        }

        public int read() {
            if (numChars == -1) {
                throw new InputMismatchException();
            }
            if (currentChar >= numChars) {
                currentChar = 0;
                try {
                    numChars = is.read(buffer);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (numChars <= 0) {
                    return -1;
                }
            }
            return buffer[currentChar++];
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int result = 0;
            do {
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                result = result * 10 + (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return result * sign;
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public void close() {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}