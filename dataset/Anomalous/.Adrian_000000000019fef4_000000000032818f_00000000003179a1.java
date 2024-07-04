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
        List<Integer> confirmedDigits = new ArrayList<>();
        BigInteger maxDefault = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> inputCache = new ArrayList<>();
        boolean cacheFilled = false;
        
        while (confirmedDigits.size() < 10) {
            for (int i = 0; i < 10000 && (!cacheFilled || i < inputCache.size()); i++) {
                String input;
                if (cacheFilled) {
                    input = inputCache.get(i);
                } else {
                    input = scanner.nextLine();
                    inputCache.add(input);
                }
                
                if (confirmedDigits.size() >= 10) {
                    if (cacheFilled) break;
                    continue;
                }

                String[] parts = input.split(" ", 2);
                BigInteger maxValue = new BigInteger(parts[0]);
                String digitString = parts[1];
                
                if (maxValue.equals(BigInteger.valueOf(-1))) {
                    maxValue = maxDefault;
                }

                int length = maxValue.toString().length();
                if (digitString.length() != length) continue;

                boolean allDigitsUsed = true;

                for (int j = 0; j < length; j++) {
                    int digit = digitString.charAt(j);
                    digitOptions.putIfAbsent(digit, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> options = digitOptions.get(digit);
                    
                    if (options.size() == 1) {
                        int option = options.get(0);
                        maxValue = maxValue.subtract(BigInteger.TEN.pow(length - j - 1).multiply(BigInteger.valueOf(option)));
                    } else {
                        allDigitsUsed = false;
                    }
                }

                if (maxValue.equals(BigInteger.ZERO) && allDigitsUsed) {
                    if (cacheFilled) {
                        inputCache.remove(i);
                        i--;
                    } else {
                        inputCache.remove(inputCache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < length; j++) {
                    int digit = digitString.charAt(j);
                    List<Integer> options = digitOptions.get(digit);
                    
                    if (options.size() > 1) {
                        if (j == 0) {
                            options.remove((Integer) 0);
                        }

                        String remainder = maxValue.toString();
                        if (remainder.length() > length - j) {
                            break;
                        } else if (remainder.length() < length - j) {
                            options.clear();
                            options.add(0);
                            confirmedDigits.add(0);
                        } else {
                            int leadingDigit = Character.getNumericValue(remainder.charAt(0));
                            options.removeIf(option -> option > leadingDigit);
                            options.removeAll(confirmedDigits);
                            if (options.size() == 1) {
                                confirmedDigits.add(options.get(0));
                            }
                        }
                        break;
                    }
                }
            }
            cacheFilled = true;
        }

        StringBuilder result = new StringBuilder();
        outerLoop:
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) (int) entry.getKey());
                    continue outerLoop;
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : digitOptions.entrySet()) {
                if (entry.getValue().size() > 1) {
                    result.append((char) (int) entry.getKey());
                    break;
                }
            }
        }
        System.out.println(testCaseLabel + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }
}