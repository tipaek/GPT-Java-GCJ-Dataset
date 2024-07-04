import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseCount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < testCaseCount; i++) {
            String[] input = scanner.nextLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);

            List<BigInteger> angels = parseAngels(scanner.nextLine());

            processTestCase("Case #" + (i + 1) + ": ", d, angels);
        }
    }

    public static void processTestCase(String testCaseLabel, int d, List<BigInteger> angels) {
        if (hasSufficientAngels(new ArrayList<>(angels), d)) {
            System.out.println(testCaseLabel + "0");
        } else if (d == 2) {
            System.out.println(testCaseLabel + "1");
        } else {
            System.out.println(testCaseLabel + calculateCuts(findSmallestAngel(angels), angels, d));
        }
    }

    private static int calculateCuts(BigInteger smallestAngel, List<BigInteger> angels, int d) {
        int cuts = 0;

        for (Iterator<BigInteger> iterator = angels.iterator(); iterator.hasNext(); ) {
            BigInteger angel = iterator.next();
            if (angel.equals(smallestAngel)) {
                d--;
                if (d == 0) return cuts;
                iterator.remove();
            }
        }

        BigInteger maxLimit = new BigInteger("360000000000");
        BigInteger multiple;
        for (int multiplier = 2; (multiple = smallestAngel.multiply(BigInteger.valueOf(multiplier))).compareTo(maxLimit) < 0; multiplier++) {
            if (d < multiplier) break;

            for (Iterator<BigInteger> iterator = angels.iterator(); iterator.hasNext(); ) {
                BigInteger angel = iterator.next();
                if (angel.equals(multiple)) {
                    cuts += multiplier - 1;
                    d -= multiplier;
                    if (d == 0) return cuts;
                    iterator.remove();
                    if (d < multiplier) break;
                }
            }
        }

        for (BigInteger angel : angels) {
            if (angel.compareTo(smallestAngel) > 0) {
                BigInteger quotient = angel.divide(smallestAngel);
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

    private static boolean hasSufficientAngels(List<BigInteger> angels, int d) {
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
        BigInteger smallest = angels.get(0);
        for (BigInteger angel : angels) {
            if (angel.compareTo(smallest) < 0) {
                smallest = angel;
            }
        }
        return smallest;
    }

    public static List<BigInteger> parseAngels(String input) {
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