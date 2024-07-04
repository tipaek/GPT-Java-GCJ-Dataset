import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder outputBuilder = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseStringToInt(bufferedReader.readLine());

        for (int i = 1; i <= testCases; ++i) {
            outputBuilder.append(String.format("Case #%d: ", i));
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int N = parseStringToInt(tokenizer.nextToken());
            int D = parseStringToInt(tokenizer.nextToken());
            ArrayList<Long> numbers = new ArrayList<>();

            tokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; ++j) {
                numbers.add(Long.parseLong(tokenizer.nextToken()));
            }
            Collections.sort(numbers);
            long previousNumber = -1;
            int currentCount = 1;
            int maxCount = 0;
            long mostFrequentNumber = -1;

            for (int k = 0; k < N; k++) {
                if (numbers.get(k) == previousNumber) {
                    currentCount++;
                    continue;
                }
                previousNumber = numbers.get(k);
                if (currentCount > maxCount) {
                    maxCount = currentCount;
                    mostFrequentNumber = previousNumber;
                }
                currentCount = 1;
            }

            boolean foundPair = false;

            for (int x = 0; x < numbers.size(); x++) {
                for (int y = x + 1; y < numbers.size(); y++) {
                    if (numbers.get(y) == (D - 1) * numbers.get(x)) {
                        foundPair = true;
                        break;
                    }
                }
                if (foundPair) break;
            }

            if (maxCount >= D) {
                outputBuilder.append(0);
            } else if (foundPair) {
                outputBuilder.append(D - 2);
            } else {
                outputBuilder.append(D - 1);
            }
            outputBuilder.append("\n");
        }
        bufferedWriter.write(outputBuilder.toString());
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}