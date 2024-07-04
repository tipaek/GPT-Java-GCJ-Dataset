import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            solve("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    public static void solve(String testcase, int u, Scanner scanner) {
        Map<Integer, List<Integer>> digitOptions = new HashMap<>();
        Set<Integer> discoveredDigits = new HashSet<>();
        BigInteger maxPossibleValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> inputCache = new ArrayList<>();
        boolean cacheFilled = false;

        while (discoveredDigits.size() < 10) {
            for (int i = 0; i < 10000 && (!cacheFilled || i < inputCache.size()); i++) {
                String line;
                if (cacheFilled) {
                    line = inputCache.get(i);
                } else {
                    line = scanner.nextLine();
                    inputCache.add(line);
                }

                if (discoveredDigits.size() == 10) {
                    if (cacheFilled) break;
                    continue;
                }

                String[] parts = line.split(" ", 2);
                BigInteger max = new BigInteger(parts[0]);
                String maxStr = max.toString();
                int length = maxStr.length();

                if (max.equals(BigInteger.valueOf(-1))) {
                    max = maxPossibleValue;
                    maxStr = maxPossibleValue.toString();
                    length = maxStr.length();
                }

                String characters = parts[1];
                if (characters.length() != length) continue;

                for (int j = 0; j < maxStr.length(); j++) {
                    int character = characters.charAt(j);
                    digitOptions.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> options = digitOptions.get(character);

                    if (options.size() == 1) {
                        int singleOption = options.get(0);
                        max = max.subtract(BigInteger.TEN.pow(maxStr.length() - j - 1).multiply(BigInteger.valueOf(singleOption)));
                    }
                }

                if (max.equals(BigInteger.ZERO)) {
                    if (cacheFilled) {
                        inputCache.remove(i);
                        i--;
                    } else {
                        inputCache.remove(inputCache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < maxStr.length(); j++) {
                    int character = characters.charAt(j);
                    List<Integer> options = digitOptions.get(character);

                    if (options.size() > 1) {
                        if (j == 0) {
                            options.remove((Integer) 0);
                        }

                        String remaining = max.toString();
                        if (remaining.length() > maxStr.length() - j) {
                            break;
                        } else if (remaining.length() < maxStr.length() - j) {
                            options.clear();
                            options.add(0);
                            discoveredDigits.add(0);
                        } else {
                            int leadingDigit = Character.getNumericValue(remaining.charAt(0));
                            options.removeIf(option -> option > leadingDigit);
                            options.removeAll(discoveredDigits);
                            if (options.size() == 1) {
                                discoveredDigits.add(options.get(0));
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
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) (int) entry.getKey());
                }
            }
        }
        System.out.println(testcase + result);
    }
}