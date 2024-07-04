import java.math.BigInteger;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int amount = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < amount; i++) {
            String[] info = scanner.nextLine().split(" ", 2);
            int n = Integer.parseInt(info[0]);
            int d = Integer.parseInt(info[1]);

            List<BigInteger> angels = parseAngels(scanner.nextLine());
            solve("Case #" + (i + 1) + ": ", d, angels);
        }
    }

    public static void solve(String testcase, int d, List<BigInteger> angels) {
        if (hasEnough(new ArrayList<>(angels), d)) {
            System.out.println(testcase + "0");
        } else if (d == 2 || hasTwoSimilarAndOneBigger(new ArrayList<>(angels)) || hasOneDoubleTheSize(new ArrayList<>(angels))) {
            System.out.println(testcase + "1");
        } else {
            System.out.println(testcase + "2");
        }
    }

    private static boolean hasOneDoubleTheSize(List<BigInteger> angels) {
        while (!angels.isEmpty()) {
            BigInteger smallest = findSmallest(angels);
            BigInteger doubleSize = smallest.multiply(BigInteger.valueOf(2));
            for (Iterator<BigInteger> it = angels.iterator(); it.hasNext(); ) {
                BigInteger current = it.next();
                if (current.equals(smallest)) {
                    it.remove();
                } else if (current.equals(doubleSize)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasTwoSimilarAndOneBigger(List<BigInteger> angels) {
        while (!angels.isEmpty()) {
            BigInteger smallest = findSmallest(angels);
            int countSimilar = 0, countBigger = 0;
            for (Iterator<BigInteger> it = angels.iterator(); it.hasNext(); ) {
                BigInteger current = it.next();
                if (current.equals(smallest)) {
                    it.remove();
                    countSimilar++;
                } else if (current.compareTo(smallest) > 0) {
                    countBigger++;
                }
                if (countSimilar >= 2 && countBigger >= 1) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean hasEnough(List<BigInteger> angels, int d) {
        while (angels.size() >= d) {
            BigInteger first = angels.get(0);
            int remaining = d - 1;
            for (int i = 1; i < angels.size(); i++) {
                if (angels.get(i).equals(first)) {
                    remaining--;
                    if (remaining == 0) {
                        return true;
                    }
                }
            }
            angels.remove(0);
        }
        return false;
    }

    private static BigInteger findSmallest(List<BigInteger> angels) {
        return Collections.min(angels);
    }

    public static List<BigInteger> parseAngels(String input) {
        List<BigInteger> angels = new ArrayList<>();
        BigInteger remaining = new BigInteger("360000000000");
        for (String part : input.split(" ")) {
            BigInteger value = new BigInteger(part);
            angels.add(value);
            remaining = remaining.subtract(value);
        }
        if (!remaining.equals(BigInteger.ZERO)) {
            angels.add(remaining);
        }
        return angels;
    }
}