import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amount; i++) {
            int u = Integer.parseInt(scanner.nextLine());
            solve("Case #" + (i + 1) + ": ", u, scanner);
        }
    }

    public static void solve(String testcase, int u, Scanner scanner) {
        Map<Integer, List<Integer>> options = new HashMap<>();
        List<Integer> found = new ArrayList<>();
        BigInteger defaultMax = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> cache = new ArrayList<>();
        boolean ran = false;

        while (found.size() < 9) {
            for (int i = 0; i < 10000 && (!ran || i < cache.size()); i++) {
                String line = ran ? cache.get(i) : scanner.nextLine();
                if (!ran) cache.add(line);

                if (found.size() == 10) {
                    if (ran) break;
                    continue;
                }

                String[] info = line.split(" ");
                BigInteger max = new BigInteger(info[0]);
                String chars = info[1];

                if (max.equals(BigInteger.valueOf(-1))) {
                    max = defaultMax;
                }

                if (chars.length() != max.toString().length()) continue;

                boolean usedAll = true;
                for (int j = 0; j < max.toString().length(); j++) {
                    int character = chars.charAt(j);
                    options.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> opts = options.get(character);

                    if (opts.size() == 1) {
                        max = max.subtract(BigInteger.TEN.pow(max.toString().length() - j - 1).multiply(BigInteger.valueOf(opts.get(0))));
                    } else {
                        usedAll = false;
                    }
                }

                if (max.equals(BigInteger.ZERO) && usedAll) {
                    if (ran) {
                        cache.remove(i--);
                    } else {
                        cache.remove(cache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < max.toString().length(); j++) {
                    int character = chars.charAt(j);
                    List<Integer> opts = options.get(character);

                    if (opts.size() > 1) {
                        if (j == 0) opts.remove((Integer) 0);

                        String rem = max.toString();
                        if (rem.length() > max.toString().length() - j) break;

                        if (rem.length() < max.toString().length() - j) {
                            opts.clear();
                            opts.add(0);
                            found.add(0);
                        } else {
                            int b = Character.getNumericValue(rem.charAt(0));
                            opts.removeIf(option -> option > b);
                            opts.removeAll(found);

                            if (opts.size() == 1) {
                                found.add(opts.get(0));
                            }
                        }
                        break;
                    }
                }
            }
            ran = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> option : options.entrySet()) {
                if (option.getValue().get(0) == i) {
                    result.append((char) (int) option.getKey());
                }
            }
        }
        for (Map.Entry<Integer, List<Integer>> option : options.entrySet()) {
            if (option.getValue().size() == 9) {
                result.append((char) (int) option.getKey());
            }
        }
        System.out.println(testcase + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> angels) {
        return angels.stream().min(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }
}