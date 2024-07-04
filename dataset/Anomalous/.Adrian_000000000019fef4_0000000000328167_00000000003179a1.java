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
                int length = max.compareTo(BigInteger.valueOf(-1)) == 0 ? defaultMax.toString().length() : max.toString().length();
                String chars = info[1];
                if (chars.length() != length) continue;

                boolean usedAll = true;
                for (int j = 0; j < length; j++) {
                    int character = chars.charAt(j);
                    options.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> opts = options.get(character);
                    if (opts.size() == 1) {
                        int option = opts.get(0);
                        max = max.subtract(BigInteger.TEN.pow(length - j - 1).multiply(BigInteger.valueOf(option)));
                    } else {
                        usedAll = false;
                    }
                }
                if (max.equals(BigInteger.ZERO) && usedAll) {
                    cache.remove(ran ? i-- : cache.size() - 1);
                    continue;
                }
                for (int j = 0; j < length; j++) {
                    int character = chars.charAt(j);
                    List<Integer> opts = options.get(character);
                    if (opts.size() > 1) {
                        if (j == 0) opts.remove((Integer) 0);
                        String rem = max.toString();
                        if (rem.length() > length - j) break;
                        else if (rem.length() < length - j) {
                            opts.clear();
                            opts.add(0);
                            found.add(0);
                        } else {
                            int b = Character.getNumericValue(rem.charAt(0));
                            opts.removeIf(option -> option > b);
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
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> option : options.entrySet()) {
                if (option.getValue().get(0) == i) {
                    result.append((char) (int) option.getKey());
                }
            }
        }
        options.entrySet().stream()
                .filter(option -> option.getValue().size() != 1)
                .forEach(option -> result.append((char) (int) option.getKey()));

        System.out.println(testcase + result);
    }

    private static int getNumber(char character) {
        return Character.getNumericValue(character);
    }
}