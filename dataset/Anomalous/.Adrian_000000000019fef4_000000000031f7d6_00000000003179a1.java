import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            processTestCase("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    public static void processTestCase(String testCaseLabel, int u, Scanner scanner) {
        Map<Integer, List<Integer>> digitOptions = new HashMap<>();
        List<Integer> identifiedDigits = new ArrayList<>();
        BigInteger maxPossibleValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        for (int i = 0; i < 10000; i++) {
            String inputLine = scanner.nextLine();
            if (identifiedDigits.size() == 10) continue;

            String[] parts = inputLine.split(" ", 2);
            BigInteger maxValue = new BigInteger(parts[0]);
            int length = 0;
            String maxValueStr = maxValue.toString();

            if (maxValue.equals(BigInteger.valueOf(-1))) {
                maxValue = maxPossibleValue;
                maxValueStr = maxPossibleValue.toString();
                length = maxValueStr.length();
            } else {
                length = maxValueStr.length();
            }

            String characters = parts[1];
            if (characters.length() != length) continue;

            for (int j = 0; j < maxValueStr.length(); j++) {
                int character = characters.charAt(j);
                digitOptions.computeIfAbsent(character, k -> new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                List<Integer> options = digitOptions.get(character);

                if (options.size() > 1) {
                    if (j == 0) {
                        options.remove((Integer) 0);
                    }

                    String remaining = maxValue.toString();
                    if (remaining.length() > maxValueStr.length() - j) {
                        break;
                    } else if (remaining.length() < maxValueStr.length() - j) {
                        options.clear();
                        options.add(0);
                        identifiedDigits.add(0);
                    } else {
                        int firstDigit = Character.getNumericValue(remaining.charAt(0));
                        options.removeIf(option -> option > firstDigit);
                        options.removeAll(identifiedDigits);
                        if (options.size() == 1) {
                            identifiedDigits.add(options.get(0));
                        }
                    }
                    break;
                } else {
                    if (options.isEmpty()) {
                        System.out.println("ERROR");
                        return;
                    }
                    int option = options.get(0);
                    maxValue = maxValue.subtract(BigInteger.TEN.pow(maxValueStr.length() - j - 1).multiply(BigInteger.valueOf(option)));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) (int) entry.getKey());
                }
            }
        }
        System.out.println(testCaseLabel + result);
    }

    private static int getNumericValue(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> numbers) {
        return numbers.stream().min(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }
}