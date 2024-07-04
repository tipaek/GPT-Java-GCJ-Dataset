import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {

    public static int parseInt(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer;

        int testCases = parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            output.append("Case #").append(i).append(": ");
            tokenizer = new StringTokenizer(reader.readLine());
            int N = parseInt(tokenizer.nextToken());
            int D = parseInt(tokenizer.nextToken());
            ArrayList<Long> numbers = new ArrayList<>();

            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                numbers.add(Long.parseLong(tokenizer.nextToken()));
            }
            Collections.sort(numbers);

            long previous = -1;
            int count = 1;
            int maxCount = 0;
            long mostFrequent = -1;

            for (int k = 0; k < N; k++) {
                if (numbers.get(k).equals(previous)) {
                    count++;
                    continue;
                }
                previous = numbers.get(k);
                if (count > maxCount) {
                    maxCount = count;
                    mostFrequent = previous;
                }
                count = 1;
            }

            boolean found = false;
            outerLoop:
            for (long x : numbers) {
                for (long y : numbers) {
                    if (x == (D - 1) * y) {
                        found = true;
                        break outerLoop;
                    }
                }
            }

            if (maxCount >= D) {
                output.append(0);
            } else if (found) {
                output.append(D - 2);
            } else {
                output.append(D - 1);
            }
            output.append("\n");
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
    }
}