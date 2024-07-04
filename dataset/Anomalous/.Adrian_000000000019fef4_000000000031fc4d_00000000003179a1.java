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

        while (found.size() != 10) {
            for (int i = 0; i < 10000; i++) {
                String line;
                if (ran) {
                    line = cache.get(i);
                } else {
                    line = scanner.nextLine();
                    cache.add(line);
                }
                if (found.size() == 10) {
                    if (ran) break;
                    continue;
                }

                String[] info = line.split(" ", 2);
                BigInteger max = new BigInteger(info[0]);
                int a = max.equals(BigInteger.valueOf(-1)) ? defaultMax.toString().length() : max.toString().length();
                String chars = info[1];

                if (chars.length() != a) continue;

                for (int j = 0; j < chars.length(); j++) {
                    int character = chars.charAt(j);
                    options.putIfAbsent(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    List<Integer> opts = options.get(character);

                    if (opts.size() > 1) {
                        if (j == 0) opts.remove((Integer) 0);

                        String rem = max.toString();
                        if (rem.length() > chars.length() - j) break;

                        if (rem.length() < chars.length() - j) {
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
                    } else {
                        if (opts.isEmpty()) {
                            System.out.println("ERROR");
                            return;
                        }
                        int option = opts.get(0);
                        max = max.subtract(BigInteger.TEN.pow(chars.length() - j - 1).multiply(BigInteger.valueOf(option)));
                    }
                }
            }
            ran = true;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> entry : options.entrySet()) {
                if (entry.getValue().get(0) == i) {
                    result.append((char) (int) entry.getKey());
                }
            }
        }
        System.out.println(testcase + result);
    }
}