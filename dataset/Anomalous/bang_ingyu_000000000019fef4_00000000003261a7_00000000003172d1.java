import java.io.*;
import java.util.*;

public class Solution {
    public static int parseStringToInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int testCaseCount = parseStringToInt(reader.readLine());

        for (int i = 1; i <= testCaseCount; i++) {
            result.append(String.format("Case #%d: ", i));
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int elementCount = parseStringToInt(tokenizer.nextToken());
            int requiredFrequency = parseStringToInt(tokenizer.nextToken());

            List<Long> elements = new ArrayList<>();
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < elementCount; j++) {
                elements.add(Long.parseLong(tokenizer.nextToken()));
            }

            Collections.sort(elements);

            long previousElement = -1;
            int currentFrequency = 1;
            int maxFrequency = 0;
            long mostFrequentElement = -1;

            for (int k = 0; k < elementCount; k++) {
                if (elements.get(k).equals(previousElement)) {
                    currentFrequency++;
                } else {
                    previousElement = elements.get(k);
                    if (currentFrequency > maxFrequency) {
                        maxFrequency = currentFrequency;
                        mostFrequentElement = previousElement;
                    }
                    currentFrequency = 1;
                }
            }
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                mostFrequentElement = previousElement;
            }

            if (maxFrequency >= requiredFrequency) {
                result.append(0);
            } else if (requiredFrequency - maxFrequency == 2 && elements.contains(mostFrequentElement * 2)) {
                result.append(1);
            } else {
                result.append(requiredFrequency - maxFrequency);
            }
            result.append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}