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
        Map<Character, List<Integer>> options = new HashMap<>();
        Set<Integer> found = new HashSet<>();
        BigInteger defaultMax = BigInteger.TEN.pow(u).subtract(BigInteger.ONE);

        List<String> cache = new ArrayList<>();
        boolean ran = false;

        while (found.size() < 9) {
            for (int i = 0; i < 10000 && (!ran || i < cache.size()); i++) {
                String line;
                if (ran) {
                    line = cache.get(i);
                } else {
                    line = scanner.nextLine();
                    cache.add(line);
                }
                if (found.size() >= 9) {
                    if (ran) break;
                    continue;
                }

                String[] info = line.split(" ", 2);
                BigInteger max = new BigInteger(info[0]);
                int a;
                String smax = max.toString();
                if (max.equals(BigInteger.valueOf(-1))) {
                    max = defaultMax;
                    smax = defaultMax.toString();
                    a = smax.length();
                } else {
                    a = smax.length();
                }

                String chars = info[1];
                if (chars.length() != a) continue;

                boolean usedAll = true;

                for (int j = 0; j < smax.length(); j++) {
                    char character = chars.charAt(j);
                    options.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> opts = options.get(character);
                    if (opts.size() == 1) {
                        int option = opts.get(0);
                        max = max.subtract(BigInteger.TEN.pow(smax.length() - j - 1).multiply(BigInteger.valueOf(option)));
                    } else {
                        usedAll = false;
                    }
                }

                if (max.equals(BigInteger.ZERO) && usedAll) {
                    if (ran) {
                        cache.remove(i);
                        i--;
                    } else {
                        cache.remove(cache.size() - 1);
                    }
                    continue;
                }

                for (int j = 0; j < smax.length(); j++) {
                    char character = chars.charAt(j);
                    List<Integer> opts = options.get(character);
                    if (opts.size() > 1) {
                        if (j == 0) {
                            opts.remove((Integer) 0);
                        }

                        String rem = max.toString();
                        if (rem.length() > smax.length() - j) {
                            break;
                        } else if (rem.length() < smax.length() - j) {
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
        outer: for (int i = 0; i < 10; i++) {
            for (Map.Entry<Character, List<Integer>> option : options.entrySet()) {
                if (option.getValue().size() == 1 && option.getValue().get(0) == i) {
                    result.append(option.getKey());
                    continue outer;
                }
            }
            for (Map.Entry<Character, List<Integer>> option : options.entrySet()) {
                if (option.getValue().size() != 1) {
                    result.append(option.getKey());
                    break;
                }
            }
        }
        System.out.println(testcase + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }

    private static BigInteger findSmallest(List<BigInteger> angels) {
        return Collections.min(angels);
    }
}