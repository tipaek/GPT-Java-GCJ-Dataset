import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        List<String> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberOfTestCases = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < numberOfTestCases; i++) {
            char[] charArrayOfNumbers = br.readLine().trim().toCharArray();
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < charArrayOfNumbers.length; j++) {
                Character c = charArrayOfNumbers[j];
                numbers.add(Integer.parseInt(c.toString()));
            }
            results.add("Case #" + (i + 1) + ": " + transformToNested(numbers));
        }
        br.close();
        results.forEach(System.out::println);
    }

    private static String transformToNested(List<Integer> numbers) {
        int depth = 0;
        StringBuilder builder = new StringBuilder();
        for (int currentNumber : numbers) {
            int difference = currentNumber - depth;
            if (difference < 0) {
                decreaseDepth(builder, Math.abs(difference));
            } else if (difference > 0) {
                increaseDepth(builder, difference);
            }
            builder.append(currentNumber);
            depth = currentNumber;
        }
        exitDepth(builder, depth);
        return builder.toString();
    }

    private static void increaseDepth(StringBuilder builder, int difference) {
        for (int i = 0; i < difference; i++) {
            builder.append('(');
        }
    }

    private static void decreaseDepth(StringBuilder builder, int difference) {
        for (int i = 0; i < difference; i++) {
            builder.append(')');
        }
    }

    private static void exitDepth(StringBuilder builder, int depth) {
        for (int i = 0; i < depth; i++) {
            builder.append(')');
        }
    }
}
