import java.io.*;
import java.util.*;

public class Solution {
    public static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseStringToInt(reader.readLine());

        for (int caseNum = 1; caseNum <= testCases; ++caseNum) {
            resultBuilder.append(String.format("Case #%d: ", caseNum));

            int U = parseStringToInt(reader.readLine());

            Map<Long, List<String>> digitToCharsMap = new HashMap<>();
            for (long digit = 0; digit < 10; ++digit) {
                digitToCharsMap.put(digit, new ArrayList<>());
            }

            for (int queryIndex = 0; queryIndex < 10000; ++queryIndex) {
                tokenizer = new StringTokenizer(reader.readLine());
                long Q = parseStringToInt(tokenizer.nextToken());
                String[] R = tokenizer.nextToken().split("");
                boolean isLargeQuery = Q >= 10;

                if (isLargeQuery) {
                    if (!digitToCharsMap.get(0L).contains(R[R.length - 1])) {
                        digitToCharsMap.get(0L).add(R[R.length - 1]);
                    }

                    int leadingDigit = (int) Math.log10(Q);

                    if (leadingDigit + 1 == R.length) {
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

            StringBuilder output = new StringBuilder();
            for (long digit = 1; digit < 10; ++digit) {
                String character = digitToCharsMap.get(digit).get(0);
                output.append(character);
                digitToCharsMap.get(0L).remove(character);
                for (long nextDigit = digit + 1; nextDigit < 10; nextDigit++) {
                    digitToCharsMap.get(nextDigit).remove(character);
                }
            }
            output.insert(0, digitToCharsMap.get(0L).get(0));
            resultBuilder.append(output.toString());
            resultBuilder.append("\n");
        }
        writer.write(resultBuilder.toString());
        writer.flush();
        writer.close();
    }
}