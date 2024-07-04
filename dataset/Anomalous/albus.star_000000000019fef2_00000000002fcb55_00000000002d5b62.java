import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        FastScanner input = new FastScanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int testCaseCount = input.nextInt();

        for (int testNumber = 1; testNumber <= testCaseCount; testNumber++) {
            pw.print("Case #" + testNumber + ": ");
            solve(input, pw);
            pw.println();
        }
        pw.close();
    }

    public static void solve(FastScanner input, PrintWriter pw) throws IOException {
        long X = input.nextLong();
        long Y = input.nextLong();

        char[] horizontal = {'E', 'W'};
        char[] vertical = {'N', 'S'};
        
        if (X < 0) {
            swap(horizontal);
            X = -X;
        }
        if (Y < 0) {
            swap(vertical);
            Y = -Y;
        }

        int[] binaryX = toBinary(X);
        int[] binaryY = toBinary(Y);
        StringBuilder path = new StringBuilder();
        long powerOfTwo = 1;

        for (int i = 33; i >= 0; i--) {
            if (binaryX[i] == 1 && binaryX[i - 1] == 1) {
                if (binaryY[i] == 0 && binaryY[i - 1] == 0) {
                    path.append(horizontal[0]);
                    X -= powerOfTwo;
                } else if (binaryY[i] == 0 && binaryY[i - 1] == 1) {
                    path.append(horizontal[1]);
                    X += powerOfTwo;
                }
            } else if (binaryX[i] == 1 && binaryX[i - 1] == 0) {
                path.append(horizontal[0]);
                X -= powerOfTwo;
            } else if (binaryY[i] == 1 && binaryY[i - 1] == 1) {
                if (binaryX[i] == 0 && binaryX[i - 1] == 0) {
                    path.append(vertical[0]);
                    Y -= powerOfTwo;
                } else if (binaryX[i] == 0 && binaryX[i - 1] == 1) {
                    path.append(vertical[1]);
                    Y += powerOfTwo;
                }
            } else if (binaryY[i] == 1 && binaryY[i - 1] == 0) {
                path.append(vertical[0]);
                Y -= powerOfTwo;
            } else {
                pw.print("IMPOSSIBLE");
                return;
            }

            if (X == 0 && Y == 0) {
                pw.print(path);
                return;
            } else {
                binaryX = toBinary(X);
                binaryY = toBinary(Y);
            }
            powerOfTwo *= 2;
        }
        pw.print("IMPOSSIBLE");
    }

    public static int[] toBinary(long number) {
        int[] binaryRepresentation = new int[34];
        int index = 33;
        while (number > 0) {
            binaryRepresentation[index--] = (int) (number % 2);
            number /= 2;
        }
        return binaryRepresentation;
    }

    private static void swap(char[] array) {
        char temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    public static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(InputStream inputStream) {
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        public int nextInt() throws IOException {
            ensureTokenizer();
            return Integer.parseInt(tokenizer.nextToken());
        }

        public long nextLong() throws IOException {
            ensureTokenizer();
            return Long.parseLong(tokenizer.nextToken());
        }

        private void ensureTokenizer() throws IOException {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
        }
    }
}