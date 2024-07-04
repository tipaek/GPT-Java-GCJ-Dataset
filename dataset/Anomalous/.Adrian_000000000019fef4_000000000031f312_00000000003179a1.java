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

        for (int i = 0; i < 10000; i++) {
            String inputLine = scanner.nextLine();
            if (identifiedDigits.size() == 10) continue;

            String[] parts = inputLine.split(" ", 2);
            BigInteger maxValue = new BigInteger(parts[0]);
            int expectedLength = (maxValue.compareTo(BigInteger.valueOf(-1)) == 0) ? u : maxValue.toString().length();
            String characters = parts[1];

            if (characters.length() != expectedLength) continue;

            for (int j = 0; j < maxValue.toString().length(); j++) {
                int character = characters.charAt(j);
                digitOptions.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                List<Integer> options = digitOptions.get(character);

                if (options.size() > 1) {
                    if (j == 0) options.remove((Integer) 0);

                    if (maxValue.toString().length() > expectedLength - j) {
                        break;
                    } else if (maxValue.toString().length() < expectedLength - j) {
                        options.clear();
                        options.add(0);
                        identifiedDigits.add(0);
                    } else {
                        int leadingDigit = charToDigit(maxValue.toString().charAt(0));
                        options.removeIf(option -> option > leadingDigit);
                        options.removeAll(identifiedDigits);
                        if (options.size() == 1) identifiedDigits.add(options.get(0));
                    }
                    break;
                } else if (options.isEmpty()) {
                    System.out.println("ERROR");
                    return;
                } else {
                    int option = options.get(0);
                    maxValue = maxValue.subtract(BigInteger.TEN.pow(expectedLength - j - 1).multiply(BigInteger.valueOf(option)));
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

    private static int charToDigit(char character) {
        return character - '0';
    }
}