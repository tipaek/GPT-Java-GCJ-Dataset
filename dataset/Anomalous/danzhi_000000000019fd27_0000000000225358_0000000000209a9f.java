import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Solution {
    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String CLASS_NAME = Solution.class.getName();
    private static final Random RANDOM = new Random();

    private static String join(Collection<?> collection) {
        StringBuilder result = new StringBuilder();
        Iterator<?> iterator = collection.iterator();
        boolean isFirst = true;
        while (iterator.hasNext()) {
            if (!isFirst) {
                result.append(',');
            }
            result.append(iterator.next().toString());
            isFirst = false;
        }
        return result.toString();
    }

    private static String generateParentheses(int[] numbers, int start, int end) {
        if (start >= end) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        int minValue = 9;
        List<Integer> indices = new ArrayList<>();

        for (int i = start; i < end; i++) {
            if (numbers[i] < minValue) {
                minValue = numbers[i];
                indices.clear();
                indices.add(i);
            } else if (numbers[i] == minValue) {
                indices.add(i);
            }
        }

        for (int i = 0; i < minValue; i++) {
            result.append('(');
        }

        for (int i = start; i < end; i++) {
            numbers[i] -= minValue;
        }

        indices.add(end);
        int previous = start;

        for (int index : indices) {
            if (previous < index) {
                result.append(generateParentheses(numbers, previous, index));
            }
            if (index < end) {
                result.append('0');
            }
            previous = index + 1;
        }

        for (int i = 0; i < minValue; i++) {
            result.append(')');
        }

        return result.toString();
    }

    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File(USER_DIR + "/io/" + CLASS_NAME + ".in");
        Scanner scanner = inputFile.exists() ? new Scanner(inputFile) : new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            String inputString = scanner.next();
            int[] numbers = new int[inputString.length()];

            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = inputString.charAt(i) - '0';
            }

            String parenthesesString = generateParentheses(numbers, 0, numbers.length);
            StringBuilder result = new StringBuilder(parenthesesString);
            int index = 0;

            for (int i = 0; i < result.length(); i++) {
                if (result.charAt(i) == '0') {
                    result.setCharAt(i, inputString.charAt(index++));
                }
            }

            System.out.format("Case #%d: %s\n", t, result.toString());
        }

        scanner.close();
    }
}