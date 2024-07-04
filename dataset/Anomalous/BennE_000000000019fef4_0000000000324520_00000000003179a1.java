import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.MessageFormat;
import java.util.*;

public class Solution {
    private static final String RESULT_PATTERN = "Case #{0}: {1}";

    private static String getSolution(final Scanner scanner) {
        final int digits = scanner.nextInt();
        List<List<Pair>> specialPairs = new ArrayList<>(Collections.nCopies(10, new ArrayList<>()));

        for (int i = 0; i < 10000; i++) {
            final String limitString = scanner.next();
            final long limit = Long.parseLong(limitString);
            if (limit < 0) {
                throw new RuntimeException();
            }
            final String response = scanner.next();
            final Pair pair = new Pair(limit, limitString, response);

            if (limitString.length() == response.length()) {
                for (int j = 0; j < 10; j++) {
                    if (isSpecialPair(pair, j)) {
                        specialPairs.get(j).add(pair);
                    }
                }
            }
        }

        Result[] results = new Result[10];
        boolean madeChange = true;
        while (madeChange) {
            madeChange = false;
            for (int i = 0; i < results.length; i++) {
                if (results[i] == null) {
                    final Result result = findDigit(i, results, specialPairs);
                    if (result != null) {
                        results[i] = result;
                        madeChange = true;
                    }
                }
            }
        }
        if (Arrays.stream(results).anyMatch(Objects::isNull)) {
            throw new RuntimeException();
        }

        StringBuilder sb = new StringBuilder();
        for (Result result : results) {
            sb.append(result.character);
        }
        return sb.toString();
    }

    private static boolean isSpecialPair(Pair pair, int digit) {
        int sum = 0;
        for (int i = 0; i < pair.limitString.length(); i++) {
            final int numericValue = Character.getNumericValue(pair.limitString.charAt(i));
            sum += numericValue;

            if (i > 0 && numericValue == digit) {
                pair.specialCharMap.put(digit, i);
                return true;
            }

            if (sum > 1) {
                return false;
            }

            if (i == 0 && numericValue == digit) {
                pair.specialCharMap.put(digit, i);
                return true;
            }
        }
        return false;
    }

    private static Result findDigit(int digit, Result[] results, List<List<Pair>> specialPairs) {
        for (Pair pair : specialPairs.get(digit)) {
            Integer relevantDigit = pair.specialCharMap.get(digit);
            if (relevantDigit != null) {
                char responseDigit = pair.result.charAt(relevantDigit);
                if (isUnknownResponseDigit(responseDigit, results)) {
                    return new Result(responseDigit);
                }
            }
        }
        return null;
    }

    private static boolean isUnknownResponseDigit(char responseDigit, Result[] results) {
        for (Result result : results) {
            if (result != null && result.character == responseDigit) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws FileNotFoundException {
        final Scanner scanner = new Scanner(System.in);
//        final Scanner scanner = new Scanner(new FileInputStream("B.in"));

        final int testCases = scanner.nextInt();
        for (int i = 1; i <= testCases; i++) {
            final String solution = getSolution(scanner);
            System.out.println(MessageFormat.format(RESULT_PATTERN, i, solution));
        }
    }

    private static class Result {
        char character;

        public Result(final char character) {
            this.character = character;
        }
    }

    private static class Pair {
        long limit;
        String limitString;
        String result;
        Map<Integer, Integer> specialCharMap = new HashMap<>();

        public Pair(final long limit, String limitString, final String result) {
            this.limit = limit;
            this.limitString = limitString;
            this.result = result;
        }
    }
}