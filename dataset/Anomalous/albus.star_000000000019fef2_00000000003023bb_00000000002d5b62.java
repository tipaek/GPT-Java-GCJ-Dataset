import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        CustomScanner input = new CustomScanner(System.in);
        PrintWriter output = new PrintWriter(System.out);
        int testCases = input.nextInt();

        for (int testNumber = 1; testNumber <= testCases; testNumber++) {
            output.print("Case #" + testNumber + ": ");
            solve(input, output);
            output.println();
        }
        output.close();
    }

    public static void solve(CustomScanner input, PrintWriter output) throws IOException {
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
        long step = 1;

        for (int i = 33; i >= 1; i--) {
            if (binaryX[i] == 1 && binaryX[i - 1] == 1) {
                if (binaryY[i] == 0 && binaryY[i - 1] == 0) {
                    path.append(horizontal[0]);
                    X -= step;
                } else if (binaryY[i] == 0 && binaryY[i - 1] == 1) {
                    path.append(horizontal[1]);
                    X += step;
                } else {
                    output.print("IMPOSSIBLE");
                    return;
                }
            } else if (binaryX[i] == 1 && binaryX[i - 1] == 0) {
                if (binaryY[i] == 0 && binaryY[i - 1] == 0) {
                    path.append(X - step == 0 ? horizontal[0] : horizontal[1]);
                    X = X - step == 0 ? X - step : X + step;
                } else if (binaryY[i] == 0 && binaryY[i - 1] == 1) {
                    path.append(horizontal[0]);
                    X -= step;
                } else {
                    output.print("IMPOSSIBLE");
                    return;
                }
            } else if (binaryY[i] == 1 && binaryY[i - 1] == 1) {
                if (binaryX[i] == 0 && binaryX[i - 1] == 0) {
                    path.append(Y - step == 0 ? vertical[0] : vertical[1]);
                    Y = Y - step == 0 ? Y - step : Y + step;
                } else if (binaryX[i] == 0 && binaryX[i - 1] == 1) {
                    path.append(vertical[1]);
                    Y += step;
                } else {
                    output.print("IMPOSSIBLE");
                    return;
                }
            } else if (binaryY[i] == 1 && binaryY[i - 1] == 0) {
                if (binaryX[i] == 0 && binaryX[i - 1] == 0) {
                    path.append(vertical[1]);
                    Y += step;
                } else if (binaryX[i] == 0 && binaryX[i - 1] == 1) {
                    path.append(vertical[0]);
                    Y -= step;
                } else {
                    output.print("IMPOSSIBLE");
                    return;
                }
            } else {
                output.print("IMPOSSIBLE");
                return;
            }

            if (X == 0 && Y == 0) {
                output.print(path);
                return;
            } else {
                binaryX = toBinary(X);
                binaryY = toBinary(Y);
            }
            step *= 2;
        }
        output.print("IMPOSSIBLE");
    }

    public static int[] toBinary(long number) {
        int[] binaryArray = new int[34];
        int index = 33;
        while (number > 0) {
            binaryArray[index--] = (int) (number % 2);
            number /= 2;
        }
        return binaryArray;
    }

    public static void swap(char[] array) {
        char temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    public static class CustomScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream inputStream) {
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