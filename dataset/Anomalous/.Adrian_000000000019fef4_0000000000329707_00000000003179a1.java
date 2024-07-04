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
        Map<Integer, List<Integer>> options = new HashMap<>();
        Set<Integer> found = new HashSet<>();
        BigInteger defaultMax = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);
        List<String> cache = new ArrayList<>();
        boolean ran = false;

        while (found.size() < 9) {
            for (int i = 0; i < 10000 && (!ran || i < cache.size()); i++) {
                String line = ran ? cache.get(i) : scanner.nextLine();
                if (!ran) cache.add(line);
                if (found.size() >= 9) break;

                String[] info = line.split(" ", 2);
                BigInteger max = new BigInteger(info[0]);
                int length = max.equals(BigInteger.valueOf(-1)) ? defaultMax.toString().length() : max.toString().length();
                String chars = info[1];

                if (chars.length() != length) {
                    int firstChar = chars.charAt(0);
                    options.computeIfAbsent(firstChar, k -> new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9))).remove((Integer) 0);
                    continue;
                }

                boolean usedAll = true;
                for (int j = 0; j < length; j++) {
                    int charCode = chars.charAt(j);
                    options.computeIfAbsent(charCode, k -> new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> opts = options.get(charCode);
                    if (opts.size() == 1) {
                        int option = opts.get(0);
                        max = max.subtract(BigInteger.TEN.pow(length - j - 1).multiply(BigInteger.valueOf(option)));
                    } else {
                        usedAll = false;
                    }
                }

                if (max.equals(BigInteger.ZERO) && usedAll) {
                    if (ran) cache.remove(i--);
                    else cache.remove(cache.size() - 1);
                    continue;
                }

                for (int j = 0; j < length; j++) {
                    int charCode = chars.charAt(j);
                    List<Integer> opts = options.get(charCode);
                    if (opts.size() > 1) {
                        if (j == 0) opts.remove((Integer) 0);
                        String remaining = max.toString();
                        if (remaining.length() > length - j) break;
                        else if (remaining.length() < length - j) {
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
            ran = true;
        }

        StringBuilder result = new StringBuilder();
        outer:
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : options.entrySet()) {
                if (entry.getValue().size() == 1 && entry.getValue().get(0) == i) {
                    result.append((char) entry.getKey().intValue());
                    continue outer;
                }
            }
            for (Map.Entry<Integer, List<Integer>> entry : options.entrySet()) {
                if (entry.getValue().size() != 1) {
                    result.append((char) entry.getKey().intValue());
                    break;
                }
            }
        }
        System.out.println(testcase + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }
}