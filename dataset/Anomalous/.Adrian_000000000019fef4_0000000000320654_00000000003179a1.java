import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            solve("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    public static void solve(String testCase, int u, Scanner scanner) {
        Map<Integer, Set<Integer>> digitOptions = new HashMap<>();
        Set<Integer> identifiedDigits = new HashSet<>();
        BigInteger defaultMaxValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> inputCache = new ArrayList<>();
        boolean cacheFilled = false;

        while (identifiedDigits.size() < 10) {
            for (int i = 0; i < 10000; i++) {
                String inputLine;
                if (cacheFilled) {
                    inputLine = inputCache.get(i);
                } else {
                    inputLine = scanner.nextLine();
                    inputCache.add(inputLine);
                }

                if (identifiedDigits.size() == 10) {
                    if (cacheFilled) break;
                    continue;
                }

                String[] parts = inputLine.split(" ", 2);
                BigInteger maxValue = new BigInteger(parts[0]);
                String characters = parts[1];
                int length = characters.length();

                if (maxValue.equals(BigInteger.valueOf(-1))) {
                    maxValue = defaultMaxValue;
                }

                if (characters.length() != maxValue.toString().length()) continue;

                for (int j = 0; j < length; j++) {
                    int character = characters.charAt(j);
                    digitOptions.computeIfAbsent(character, k -> new HashSet<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    Set<Integer> options = digitOptions.get(character);

                    if (options.size() == 1) {
                        int singleOption = options.iterator().next();
                        maxValue = maxValue.subtract(BigInteger.TEN.pow(length - j - 1).multiply(BigInteger.valueOf(singleOption)));
                    }
                }

                for (int j = 0; j < length; j++) {
                    int character = characters.charAt(j);
                    Set<Integer> options = digitOptions.get(character);

                    if (options.size() > 1) {
                        if (j == 0) {
                            options.remove(0);
                        }

                        String remaining = maxValue.toString();
                        if (remaining.length() > length - j) {
                            break;
                        } else if (remaining.length() < length - j) {
                            options.clear();
                            options.add(0);
                            identifiedDigits.add(0);
                        } else {
                            int leadingDigit = Character.getNumericValue(remaining.charAt(0));
                            options.removeIf(option -> option > leadingDigit);
                            options.removeAll(identifiedDigits);

                            if (options.size() == 1) {
                                identifiedDigits.add(options.iterator().next());
                            }
                        }
                        break;
                    }
                }
            }
            cacheFilled = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, Set<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().iterator().next() == i) {
                    result.append((char) entry.getKey().intValue());
                }
            }
        }
        System.out.println(testCase + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> numbers) {
        return numbers.stream().min(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }
}