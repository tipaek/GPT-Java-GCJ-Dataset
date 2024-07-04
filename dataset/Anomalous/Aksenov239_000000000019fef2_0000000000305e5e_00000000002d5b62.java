import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        new Solution().execute();
    }

    private BufferedReader reader;
    private StringTokenizer tokenizer;
    private PrintWriter writer;

    private String getNextToken() throws IOException {
        while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private int getNextInt() throws IOException {
        return Integer.parseInt(getNextToken());
    }

    private void solveCase() throws IOException {
        int x = getNextInt();
        int y = getNextInt();
        int signX = x < 0 ? -1 : 1;
        int signY = y < 0 ? -1 : 1;
        x = Math.abs(x);
        y = Math.abs(y);

        char[] binaryX = Integer.toBinaryString(x).toCharArray();
        char[] binaryY = Integer.toBinaryString(y).toCharArray();

        boolean[] bitsX = new boolean[33];
        boolean[] bitsY = new boolean[33];
        long[] powersOfTwo = new long[33];

        powersOfTwo[0] = 1;
        for (int i = 0; i < bitsX.length; i++) {
            if (i < binaryX.length) {
                bitsX[i] = binaryX[binaryX.length - i - 1] == '1';
            }
            if (i < binaryY.length) {
                bitsY[i] = binaryY[binaryY.length - i - 1] == '1';
            }
            if (i > 0) {
                powersOfTwo[i] = powersOfTwo[i - 1] * 2;
            }
        }

        for (int maxLength = Math.max(binaryX.length, binaryY.length); maxLength < Math.max(binaryX.length, binaryY.length) + 3; maxLength++) {
            for (int mask = 0; mask < (1 << 16); mask++) {
                boolean[] useX = new boolean[33];
                char[] result = new char[33];
                int segmentLength = 0;
                int id = 0;

                for (int i = 0; i < maxLength; i++) {
                    if (bitsX[i]) {
                        segmentLength++;
                    } else {
                        if (segmentLength == 0) continue;
                        if ((mask & (1 << id)) != 0) {
                            for (int j = i - segmentLength; j < i; j++) {
                                useX[j] = true;
                                result[j] = signX == 1 ? 'E' : 'W';
                            }
                        } else {
                            useX[i] = true;
                            result[i] = signX == 1 ? 'E' : 'W';
                            useX[i - segmentLength] = true;
                            result[i - segmentLength] = signX == 1 ? 'W' : 'E';
                        }
                        id++;
                        segmentLength = 0;
                    }
                }

                if (bitsX[maxLength - 1]) {
                    for (int j = maxLength - segmentLength; j < maxLength; j++) {
                        useX[j] = true;
                        result[j] = signX == 1 ? 'E' : 'W';
                    }
                }

                boolean[] useY = new boolean[33];
                boolean invalid = false;
                long total = 0;
                segmentLength = 0;

                for (int i = 0; i < maxLength; i++) {
                    if (total == y) break;
                    useY[i] = !useX[i];
                    if (bitsY[i]) {
                        segmentLength++;
                    } else {
                        if (useY[i]) {
                            if (segmentLength == 0 || !useY[i - segmentLength]) {
                                invalid = true;
                            }
                            result[i] = signY == 1 ? 'N' : 'S';
                            result[i - segmentLength] = signY == 1 ? 'S' : 'N';
                            total += powersOfTwo[i] - powersOfTwo[i - segmentLength];
                        } else {
                            for (int j = i - segmentLength; j < i; j++) {
                                if (!useY[j]) {
                                    invalid = true;
                                }
                                total += powersOfTwo[j];
                                result[j] = signY == 1 ? 'N' : 'S';
                            }
                        }
                        segmentLength = 0;
                    }
                }

                if (bitsY[maxLength - 1]) {
                    for (int j = maxLength - segmentLength; j < maxLength; j++) {
                        if (!useY[j]) {
                            invalid = true;
                        }
                        total += powersOfTwo[j];
                        result[j] = signY == 1 ? 'N' : 'S';
                    }
                }

                for (int i = 0; i < maxLength; i++) {
                    if (useX[i] == useY[i]) {
                        invalid = true;
                    }
                }

                if (invalid || total != y) {
                    continue;
                }

                StringBuilder output = new StringBuilder();
                for (int i = 0; i < maxLength; i++) {
                    output.append(result[i]);
                }
                writer.println(output);
                return;
            }
        }
        writer.println("IMPOSSIBLE");
    }

    private void execute() {
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            writer = new PrintWriter(System.out);

            int testCases = getNextInt();
            for (int i = 0; i < testCases; i++) {
                writer.printf("Case #%d: ", i + 1);
                solveCase();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}