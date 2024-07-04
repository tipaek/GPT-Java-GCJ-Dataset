import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amount; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            processCase("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    private static void processCase(String testcase, int u, Scanner scanner) {
        Map<Integer, List<Integer>> options = new HashMap<>();
        Set<Integer> found = new HashSet<>();
        BigInteger maxPossibleValue = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);
        List<String> cache = new ArrayList<>();
        boolean cacheInitialized = false;

        while (found.size() < 9) {
            for (int i = 0; i < 10000 && (!cacheInitialized || i < cache.size()); i++) {
                String line = cacheInitialized ? cache.get(i) : scanner.nextLine();
                if (!cacheInitialized) cache.add(line);

                if (found.size() >= 9) {
                    if (cacheInitialized) break;
                    continue;
                }

                String[] info = line.split(" ", 2);
                BigInteger max = new BigInteger(info[0]);
                int length = max.equals(BigInteger.valueOf(-1)) ? maxPossibleValue.toString().length() : max.toString().length();
                String characters = info[1];

                if (characters.length() != length) continue;

                for (int j = 0; j < length; j++) {
                    int character = characters.charAt(j);
                    options.computeIfAbsent(character, k -> new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));

                    List<Integer> opts = options.get(character);
                    if (opts.size() == 1) {
                        int option = opts.get(0);
                        max = max.subtract(BigInteger.TEN.pow(length - j - 1).multiply(BigInteger.valueOf(option)));
                    }
                }

                if (max.equals(BigInteger.ZERO)) {
                    if (cacheInitialized) {
                        cache.remove(i);
                        i--;
                    } else {
                        cache.remove(cache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < length; j++) {
                    int character = characters.charAt(j);
                    List<Integer> opts = options.get(character);
                    if (opts.size() > 1) {
                        if (j == 0) opts.remove((Integer) 0);

                        String remaining = max.toString();
                        if (remaining.length() > length - j) break;

                        if (remaining.length() < length - j) {
                            opts.clear();
                            opts.add(0);
                            found.add(0);
                        } else {
                            int firstDigit = Character.getNumericValue(remaining.charAt(0));
                            opts.removeIf(option -> option > firstDigit);
                            opts.removeAll(found);
                            if (opts.size() == 1) found.add(opts.get(0));
                        }
                        break;
                    }
                }
            }
            cacheInitialized = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : options.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) (int) entry.getKey());
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : options.entrySet()) {
                if (entry.getValue().size() == 9) {
                    result.append((char) (int) entry.getKey());
                }
            }
        }
        System.out.println(testcase + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> numbers) {
        return Collections.min(numbers);
    }
}