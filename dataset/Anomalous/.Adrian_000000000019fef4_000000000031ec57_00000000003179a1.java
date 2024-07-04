import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            processTestCase("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    private static void processTestCase(String caseLabel, int u, Scanner scanner) {
        Map<Integer, List<Integer>> digitOptions = new HashMap<>();
        Set<Integer> determinedDigits = new HashSet<>();
        BigInteger maxPossibleValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        for (int i = 0; i < 10000; i++) {
            String inputLine = scanner.nextLine();
            if (determinedDigits.size() == 10) continue;

            String[] parts = inputLine.split(" ", 2);
            BigInteger maxValue = new BigInteger(parts[0]);
            String numberString = maxValue.toString();
            String characters = parts[1];

            if (maxValue.equals(BigInteger.valueOf(-1))) {
                maxValue = maxPossibleValue;
                numberString = maxPossibleValue.toString();
            }

            if (characters.length() != numberString.length()) continue;

            for (int j = 0; j < numberString.length(); j++) {
                int charCode = characters.charAt(j);
                digitOptions.putIfAbsent(charCode, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                List<Integer> options = digitOptions.get(charCode);

                if (options.size() > 1) {
                    if (j == 0) options.remove((Integer) 0);

                    String remaining = maxValue.toString();
                    if (remaining.length() > numberString.length() - j) break;

                    if (remaining.length() < numberString.length() - j) {
                        options.clear();
                        options.add(0);
                        determinedDigits.add(0);
                    } else {
                        int firstDigit = Character.getNumericValue(remaining.charAt(0));
                        options.removeIf(option -> option > firstDigit);
                        options.removeAll(determinedDigits);
                        if (options.size() == 1) determinedDigits.add(options.get(0));
                    }
                    break;
                } else if (options.isEmpty()) {
                    System.out.println("ERROR");
                    return;
                } else {
                    int option = options.get(0);
                    maxValue = maxValue.subtract(BigInteger.TEN.pow(numberString.length() - j - 1).multiply(BigInteger.valueOf(option)));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) entry.getKey().intValue());
                }
            }
        }
        System.out.println(caseLabel + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> numbers) {
        return numbers.stream().min(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }
}