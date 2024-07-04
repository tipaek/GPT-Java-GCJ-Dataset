import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws Exception {
        CustomScanner scanner = new CustomScanner(System.in);
        PrintWriter writer = new PrintWriter(System.out);
        int testCases = scanner.nextInt();

        for (int testCase = 1; testCase <= testCases; testCase++) {
            writer.print("Case #" + testCase + ": ");
            processTestCase(scanner, writer);
            writer.println();
        }
        writer.close();
    }

    private static void processTestCase(CustomScanner scanner, PrintWriter writer) throws IOException {
        long x = scanner.nextLong();
        long y = scanner.nextLong();

        char[] horizontal = {'E', 'W'};
        char[] vertical = {'N', 'S'};

        if (x < 0) {
            swap(horizontal);
            x = -x;
        }
        if (y < 0) {
            swap(vertical);
            y = -y;
        }

        int[] binaryX = toBinaryArray(x);
        int[] binaryY = toBinaryArray(y);
        StringBuilder path = new StringBuilder();
        long powerOfTwo = 1;

        for (int i = 33; i >= 1; i--) {
            if (binaryX[i] == 1 && binaryX[i - 1] == 1) {
                if (binaryY[i] == 0 && binaryY[i - 1] == 0) {
                    path.append(horizontal[0]);
                    x -= powerOfTwo;
                } else if (binaryY[i] == 0 && binaryY[i - 1] == 1) {
                    path.append(horizontal[1]);
                    x += powerOfTwo;
                } else {
                    writer.print("IMPOSSIBLE");
                    return;
                }
            } else if (binaryX[i] == 1 && binaryX[i - 1] == 0) {
                if (binaryY[i] == 0 && binaryY[i - 1] == 0) {
                    if (x - powerOfTwo == 0 && y == 0) {
                        path.append(horizontal[0]);
                        x -= powerOfTwo;
                    } else {
                        path.append(horizontal[1]);
                        x += powerOfTwo;
                    }
                } else if (binaryY[i] == 0 && binaryY[i - 1] == 1) {
                    path.append(horizontal[0]);
                    x -= powerOfTwo;
                } else {
                    writer.print("IMPOSSIBLE");
                    return;
                }
            } else if (binaryY[i] == 1 && binaryY[i - 1] == 1) {
                if (binaryX[i] == 0 && binaryX[i - 1] == 0) {
                    path.append(vertical[0]);
                    y -= powerOfTwo;
                } else if (binaryX[i] == 0 && binaryX[i - 1] == 1) {
                    path.append(vertical[1]);
                    y += powerOfTwo;
                } else {
                    writer.print("IMPOSSIBLE");
                    return;
                }
            } else if (binaryY[i] == 1 && binaryY[i - 1] == 0) {
                if (binaryX[i] == 0 && binaryX[i - 1] == 0) {
                    if (y - powerOfTwo == 0 && x == 0) {
                        path.append(vertical[0]);
                        y -= powerOfTwo;
                    } else {
                        path.append(vertical[1]);
                        y += powerOfTwo;
                    }
                } else if (binaryX[i] == 0 && binaryX[i - 1] == 1) {
                    path.append(vertical[0]);
                    y -= powerOfTwo;
                } else {
                    writer.print("IMPOSSIBLE");
                    return;
                }
            } else {
                writer.print("IMPOSSIBLE");
                return;
            }

            if (x == 0 && y == 0) {
                writer.print(path);
                return;
            } else {
                binaryX = toBinaryArray(x);
                binaryY = toBinaryArray(y);
            }
            powerOfTwo *= 2;
        }
        writer.print("IMPOSSIBLE");
    }

    private static void swap(char[] array) {
        char temp = array[0];
        array[0] = array[1];
        array[1] = temp;
    }

    private static int[] toBinaryArray(long number) {
        int[] binaryArray = new int[34];
        int index = 33;
        while (number > 0) {
            binaryArray[index--] = (int) (number % 2);
            number /= 2;
        }
        return binaryArray;
    }

    public static class CustomScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public CustomScanner(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
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