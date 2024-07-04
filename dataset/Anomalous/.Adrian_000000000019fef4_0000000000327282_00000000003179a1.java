import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfCases; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            processCase("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    public static void processCase(String caseLabel, int u, Scanner scanner) {
        Map<Integer, List<Integer>> digitOptions = new HashMap<>();
        List<Integer> identifiedDigits = new ArrayList<>();
        BigInteger maxPossibleValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> inputCache = new ArrayList<>();
        boolean isCached = false;

        while (identifiedDigits.size() < 9) {
            for (int i = 0; i < 10000 && (!isCached || i < inputCache.size()); i++) {
                String inputLine;
                if (isCached) {
                    inputLine = inputCache.get(i);
                } else {
                    inputLine = scanner.nextLine();
                    inputCache.add(inputLine);
                }

                if (identifiedDigits.size() == 10) {
                    if (isCached) break;
                    continue;
                }

                String[] parts = inputLine.split(" ", 2);
                BigInteger maxValue = new BigInteger(parts[0]);
                int digitLength = 0;
                String maxValueStr = maxValue.toString();

                if (maxValue.equals(BigInteger.valueOf(-1))) {
                    maxValue = maxPossibleValue;
                    maxValueStr = maxPossibleValue.toString();
                    digitLength = maxValueStr.length();
                } else {
                    digitLength = maxValueStr.length();
                }

                String characters = parts[1];
                if (characters.length() != digitLength) continue;

                for (int j = 0; j < maxValueStr.length(); j++) {
                    int charCode = characters.charAt(j);
                    digitOptions.putIfAbsent(charCode, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> options = digitOptions.get(charCode);

                    if (options.size() == 1) {
                        int digit = options.get(0);
                        maxValue = maxValue.subtract(BigInteger.TEN.pow(maxValueStr.length() - j - 1).multiply(BigInteger.valueOf(digit)));
                    }
                }

                if (maxValue.equals(BigInteger.ZERO)) {
                    if (isCached) {
                        inputCache.remove(i);
                        i--;
                    } else {
                        inputCache.remove(inputCache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < maxValueStr.length(); j++) {
                    int charCode = characters.charAt(j);
                    List<Integer> options = digitOptions.get(charCode);

                    if (options.size() > 1) {
                        if (j == 0) {
                            options.remove((Integer) 0);
                        }

                        String remainingValue = maxValue.toString();
                        if (remainingValue.length() > maxValueStr.length() - j) {
                            break;
                        } else if (remainingValue.length() < maxValueStr.length() - j) {
                            options.clear();
                            options.add(0);
                            identifiedDigits.add(0);
                        } else {
                            int leadingDigit = Character.getNumericValue(remainingValue.charAt(0));
                            options.removeIf(option -> option > leadingDigit);
                            options.removeAll(identifiedDigits);

                            if (options.size() == 1) {
                                identifiedDigits.add(options.get(0));
                            }
                        }
                        break;
                    }
                }
            }
            isCached = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) entry.getKey().intValue());
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().size() == 9) {
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