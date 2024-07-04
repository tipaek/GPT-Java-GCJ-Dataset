import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCases; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            processCase("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    public static void processCase(String caseLabel, int u, Scanner scanner) {
        Map<Integer, List<Integer>> digitOptions = new HashMap<>();
        List<Integer> confirmedDigits = new ArrayList<>();
        BigInteger maxDefault = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);
        List<String> inputCache = new ArrayList<>();
        boolean isProcessed = false;

        while (confirmedDigits.size() < 9) {
            for (int i = 0; i < 10000 && (!isProcessed || i < inputCache.size()); i++) {
                String inputLine;
                if (isProcessed) {
                    inputLine = inputCache.get(i);
                } else {
                    inputLine = scanner.nextLine();
                    inputCache.add(inputLine);
                }

                if (confirmedDigits.size() >= 9) {
                    if (isProcessed) break;
                    continue;
                }

                String[] parts = inputLine.split(" ", 2);
                BigInteger maxValue = new BigInteger(parts[0]);
                int length = 0;
                String maxStr = maxValue.toString();
                if (maxValue.compareTo(BigInteger.valueOf(-1)) == 0) {
                    maxValue = maxDefault;
                    maxStr = maxDefault.toString();
                    length = maxStr.length();
                } else {
                    length = maxStr.length();
                }

                String characters = parts[1];
                if (characters.length() != length) continue;

                boolean allUsed = true;

                for (int j = 0; j < maxStr.length(); j++) {
                    int charCode = characters.charAt(j);
                    if (!digitOptions.containsKey(charCode)) {
                        digitOptions.put(charCode, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    }
                    List<Integer> options = digitOptions.get(charCode);
                    if (options.size() == 1) {
                        int option = options.get(0);
                        maxValue = maxValue.subtract(BigInteger.TEN.pow(maxStr.length() - j - 1).multiply(BigInteger.valueOf(option)));
                    } else {
                        allUsed = false;
                    }
                }

                if (maxValue.equals(BigInteger.ZERO) && allUsed) {
                    if (isProcessed) {
                        inputCache.remove(i);
                        i--;
                    } else {
                        inputCache.remove(inputCache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < maxStr.length(); j++) {
                    int charCode = characters.charAt(j);
                    List<Integer> options = digitOptions.get(charCode);
                    if (options.size() > 1) {
                        if (j == 0) {
                            options.remove(Integer.valueOf(0));
                        }

                        String remaining = maxValue.toString();
                        if (remaining.length() > maxStr.length() - j) {
                            break;
                        } else if (remaining.length() < maxStr.length() - j) {
                            options.clear();
                            options.add(0);
                            confirmedDigits.add(0);
                        } else {
                            int firstDigit = charToDigit(remaining.charAt(0));
                            options.removeIf(option -> option > firstDigit);
                            options.removeAll(confirmedDigits);
                            if (options.size() == 1) {
                                confirmedDigits.add(options.get(0));
                            }
                        }
                        break;
                    }
                }
            }
            isProcessed = true;
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

    private static int charToDigit(char character) {
        return character - '0';
    }

    private static BigInteger findSmallest(List<BigInteger> numbers) {
        return Collections.min(numbers);
    }
}