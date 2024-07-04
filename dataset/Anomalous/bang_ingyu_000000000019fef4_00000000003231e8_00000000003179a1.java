import java.io.*;
import java.util.*;

public class Solution {
    public static int stringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder outputBuilder = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = stringToInt(bufferedReader.readLine());

        for (int testCase = 1; testCase <= testCases; ++testCase) {
            outputBuilder.append(String.format("Case #%d: ", testCase));

            int U = stringToInt(bufferedReader.readLine());

            Map<Long, List<String>> digitToCharsMap = new HashMap<>();
            for (long digit = 0; digit < 10; ++digit) {
                digitToCharsMap.put(digit, new ArrayList<>());
            }

            for (int j = 0; j < 10000; ++j) {
                tokenizer = new StringTokenizer(bufferedReader.readLine());
                long Q = stringToInt(tokenizer.nextToken());
                String[] R = tokenizer.nextToken().split("");
                boolean isLargeNumber = Q >= 10;

                if (isLargeNumber) {
                    if (!digitToCharsMap.get(0L).contains(R[R.length - 1])) {
                        digitToCharsMap.get(0L).add(R[R.length - 1]);
                    }

                    int numDigits = (int) Math.log10(Q) + 1;
                    if (numDigits == R.length) {
                        while (Q >= 10) {
                            Q /= 10;
                        }
                        if (!digitToCharsMap.get(Q).contains(R[0])) {
                            digitToCharsMap.get(Q).add(R[0]);
                        }
                    }
                } else {
                    Q %= 10;
                    if (!digitToCharsMap.get(Q).contains(R[R.length - 1])) {
                        digitToCharsMap.get(Q).add(R[R.length - 1]);
                    }
                }
            }

            StringBuilder result = new StringBuilder();
            for (long digit = 1; digit < 10; ++digit) {
                String charToAdd = digitToCharsMap.get(digit).get(0);
                result.append(charToAdd);
                digitToCharsMap.get(0L).remove(charToAdd);
                for (long nextDigit = digit + 1; nextDigit < 10; nextDigit++) {
                    digitToCharsMap.get(nextDigit).remove(charToAdd);
                }
            }
            result.insert(0, digitToCharsMap.get(0L).get(0));
            outputBuilder.append(result.toString()).append("\n");
        }

        bufferedWriter.write(outputBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}