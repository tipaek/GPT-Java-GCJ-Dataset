import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCases; i++) {
            String[] input = scanner.nextLine().split(" ", 2);
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            List<BigInteger> angels = parseAngels(scanner.nextLine());
            solveCase("Case #" + (i + 1) + ": ", d, angels);
        }
    }

    private static void solveCase(String caseLabel, int d, List<BigInteger> angels) {
        if (hasEnoughAngels(new ArrayList<>(angels), d)) {
            System.out.println(caseLabel + "0");
        } else if (d == 2) {
            System.out.println(caseLabel + "1");
        } else {
            int minCuts = -1;
            while (!angels.isEmpty()) {
                BigInteger smallestAngel = findSmallestAngel(angels);
                int cuts = calculateCuts(smallestAngel, new ArrayList<>(angels), d);
                if (cuts != -1 && (minCuts == -1 || cuts < minCuts)) {
                    minCuts = cuts;
                }
                removeAllOccurrences(angels, smallestAngel);
            }
            System.out.println(caseLabel + minCuts);
        }
    }

    private static int calculateCuts(BigInteger baseAngel, List<BigInteger> angels, int d) {
        int cuts = 0;
        Iterator<BigInteger> iterator = angels.iterator();

        while (iterator.hasNext()) {
            BigInteger angel = iterator.next();
            if (angel.equals(baseAngel)) {
                d--;
                if (d == 0) return cuts;
                iterator.remove();
            }
        }

        BigInteger maxLimit = new BigInteger("360000000000");
        for (int multiplier = 2; ; multiplier++) {
            BigInteger multipliedAngel = baseAngel.multiply(BigInteger.valueOf(multiplier));
            if (multipliedAngel.compareTo(maxLimit) >= 0 || d < multiplier) break;

            iterator = angels.iterator();
            while (iterator.hasNext()) {
                BigInteger angel = iterator.next();
                if (angel.equals(multipliedAngel)) {
                    cuts += multiplier - 1;
                    d -= multiplier;
                    if (d == 0) return cuts;
                    iterator.remove();
                    if (d < multiplier) break;
                }
            }
        }

        for (BigInteger angel : angels) {
            if (angel.compareTo(baseAngel) > 0) {
                BigInteger quotient = angel.divide(baseAngel);
                if (quotient.compareTo(BigInteger.valueOf(d)) >= 0) {
                    cuts += d;
                    return cuts;
                } else {
                    d -= quotient.intValue();
                    cuts += quotient.intValue();
                }
            }
        }

        return -1;
    }

    private static boolean hasEnoughAngels(List<BigInteger> angels, int d) {
        while (angels.size() >= d) {
            BigInteger firstAngel = angels.get(0);
            int required = d - 1;

            for (int i = 1; i < angels.size(); i++) {
                if (angels.get(i).equals(firstAngel)) {
                    required--;
                    if (required == 0) return true;
                }
            }
            angels.remove(0);
        }
        return false;
    }

    private static BigInteger findSmallestAngel(List<BigInteger> angels) {
        BigInteger smallest = angels.get(0);
        for (BigInteger angel : angels) {
            if (angel.compareTo(smallest) < 0) {
                smallest = angel;
            }
        }
        return smallest;
    }

    private static void removeAllOccurrences(List<BigInteger> angels, BigInteger value) {
        angels.removeIf(angel -> angel.equals(value));
    }

    private static List<BigInteger> parseAngels(String input) {
        List<BigInteger> angels = new ArrayList<>();
        BigInteger total = new BigInteger("360000000000");

        for (String value : input.split(" ")) {
            BigInteger angel = new BigInteger(value);
            angels.add(angel);
            total = total.subtract(angel);
        }
        if (!total.equals(BigInteger.ZERO)) {
            angels.add(total);
        }

        return angels;
    }
}