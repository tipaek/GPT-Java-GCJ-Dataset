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
        while (found.size() < 10) {
            for (int i = 0; i < 10000 && (!ran || i < cache.size()); i++) {
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
                int a = 0;
                String smax = max.toString();
                if (max.compareTo(new BigInteger("-1")) == 0) {
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
                    int character = chars.charAt(j);
                    if (!options.containsKey(character)) {
                        options.put(character, new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)));
                    }
                    List<Integer> opts = options.get(character);
                    if (opts.size() == 1) {
                        int option = opts.get(0);
                        max = max.subtract(BigInteger.TEN.pow(smax.length() - j - 1).multiply(new BigInteger(String.valueOf(option))));
                    } else {
                        usedAll = false;
                    }
                }
                if (max.compareTo(BigInteger.ZERO) == 0 && usedAll) {
                    if (ran) {
                        cache.remove(i);
                        i--;
                    } else {
                        cache.remove(cache.size() - 1);
                    }
                    continue;
                }
                for (int j = 0; j < smax.length(); j++) {
                    int character = chars.charAt(j);
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
                            int b = getNumber(rem.toString().charAt(0));
                            for (Iterator<Integer> it = opts.iterator(); it.hasNext(); ) {
                                int option = it.next();
                                if (option > b) {
                                    it.remove();
                                }
                            }
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

        String result = "";
        a:
        for (int i = 0; i < 10; i++) {
            for (Map.Entry<Integer, List<Integer>> option : options.entrySet()) {
                if (option.getValue().get(0) == i) {
                    result += (char) (int) option.getKey();
                    continue a;
                }
            }
            for (Map.Entry<Integer, List<Integer>> option : options.entrySet()) {
                if (option.getValue().size() > 1) {
                    result += (char) (int) option.getKey();
                    break;
                }
            }
        }
        System.out.println(testcase + result);
    }

    private static int getNumber(char character) {
        switch (character) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
        }
        return -1;
    }

    private static BigInteger findSmallest(List<BigInteger> angels) {
        BigInteger smallest = angels.get(0);
        for (int i = 1; i < angels.size(); i++) {
            BigInteger angel = angels.get(i);
            if (angel.compareTo(smallest) < 0) {
                smallest = angel;
            }
        }
        return smallest;
    }
}
