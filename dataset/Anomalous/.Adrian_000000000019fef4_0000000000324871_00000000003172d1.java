import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            String[] input = scanner.nextLine().split(" ", 2);
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            List<BigInteger> angels = parseAngels(scanner.nextLine());
            processTestCase("Case #" + (i + 1) + ": ", d, angels);
        }
    }

    private static void processTestCase(String testCaseLabel, int d, List<BigInteger> angels) {
        if (canSatisfyRequirement(new ArrayList<>(angels), d)) {
            System.out.println(testCaseLabel + "0");
        } else {
            int minCuts = findMinimumCuts(angels, d);
            System.out.println(testCaseLabel + minCuts);
        }
    }

    private static int findMinimumCuts(List<BigInteger> angels, int d) {
        int minCuts = -1;
        while (!angels.isEmpty()) {
            BigInteger smallestAngel = findSmallestAngel(angels);
            int cuts = calculateCuts(smallestAngel, new ArrayList<>(angels), d);
            if (cuts != -1 && (minCuts == -1 || cuts < minCuts)) {
                minCuts = cuts;
            }
            angels.removeIf(angel -> angel.equals(smallestAngel));
        }
        return minCuts;
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
        for (int multiplier = 2; baseAngel.multiply(BigInteger.valueOf(multiplier)).compareTo(maxLimit) < 0; multiplier++) {
            if (d < multiplier) break;
            BigInteger multipliedAngel = baseAngel.multiply(BigInteger.valueOf(multiplier));
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

    private static boolean canSatisfyRequirement(List<BigInteger> angels, int d) {
        while (angels.size() >= d) {
            BigInteger firstAngel = angels.get(0);
            int remaining = d - 1;
            for (int i = 1; i < angels.size(); i++) {
                if (angels.get(i).equals(firstAngel)) {
                    remaining--;
                    if (remaining == 0) return true;
                }
            }
            angels.remove(0);
        }
        return false;
    }

    private static BigInteger findSmallestAngel(List<BigInteger> angels) {
        return angels.stream().min(BigInteger::compareTo).orElse(BigInteger.ZERO);
    }

    private static List<BigInteger> parseAngels(String input) {
        List<BigInteger> angels = new ArrayList<>();
        BigInteger remaining = new BigInteger("360000000000");
        for (String value : input.split(" ")) {
            BigInteger angel = new BigInteger(value);
            angels.add(angel);
            remaining = remaining.subtract(angel);
        }
        if (!remaining.equals(BigInteger.ZERO)) {
            angels.add(remaining);
        }
        return angels;
    }
}