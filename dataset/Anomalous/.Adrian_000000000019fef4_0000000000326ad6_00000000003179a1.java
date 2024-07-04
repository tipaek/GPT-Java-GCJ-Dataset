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

    public static void solve(String testCaseLabel, int u, Scanner scanner) {
        Map<Integer, List<Integer>> digitOptions = new HashMap<>();
        List<Integer> identifiedDigits = new ArrayList<>();
        BigInteger maxPossibleValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> inputCache = new ArrayList<>();
        boolean isCacheLoaded = false;

        while (identifiedDigits.size() < 9) {
            for (int i = 0; i < 10000 && (!isCacheLoaded || i < inputCache.size()); i++) {
                String inputLine;
                if (isCacheLoaded) {
                    inputLine = inputCache.get(i);
                } else {
                    inputLine = scanner.nextLine();
                    inputCache.add(inputLine);
                }

                if (identifiedDigits.size() == 10) {
                    if (isCacheLoaded) break;
                    continue;
                }

                String[] parts = inputLine.split(" ", 2);
                BigInteger maxValue = new BigInteger(parts[0]);
                int valueLength = maxValue.compareTo(BigInteger.valueOf(-1)) == 0 ? maxPossibleValue.toString().length() : maxValue.toString().length();
                String characters = parts[1];

                if (characters.length() != valueLength) continue;

                for (int j = 0; j < valueLength; j++) {
                    int character = characters.charAt(j);
                    digitOptions.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> options = digitOptions.get(character);
                    if (options.size() == 1) {
                        int option = options.get(0);
                        maxValue = maxValue.subtract(BigInteger.TEN.pow(valueLength - j - 1).multiply(BigInteger.valueOf(option)));
                    }
                }

                if (maxValue.equals(BigInteger.ZERO)) {
                    inputCache.remove(isCacheLoaded ? i : inputCache.size() - 1);
                    if (isCacheLoaded) i--;
                    continue;
                }

                for (int j = 0; j < valueLength; j++) {
                    int character = characters.charAt(j);
                    List<Integer> options = digitOptions.get(character);
                    if (options.size() > 1) {
                        if (j == 0) {
                            options.remove((Integer) 0);
                        }

                        String remainingValue = maxValue.toString();
                        if (remainingValue.length() > valueLength - j) {
                            break;
                        } else if (remainingValue.length() < valueLength - j) {
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
            isCacheLoaded = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) (int) entry.getKey());
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().size() == 9) {
                    result.append((char) (int) entry.getKey());
                }
            }
        }
        System.out.println(testCaseLabel + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> numbers) {
        return Collections.min(numbers);
    }
}