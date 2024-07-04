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
        } /*else if (d == 2) {
            System.out.println(testcase + "1");
        }*/ else {
            int s = -1;
            while (angels.size() > 0) {
                BigInteger smallest = findSmallest(angels);
                int ss = findCuts(smallest, new ArrayList<>(angels), d);
                if (ss != -1 && (s == -1 || ss < s)) {
                    s = ss;
                }
                for (Iterator<BigInteger> it = angels.iterator(); it.hasNext(); ) {
                    BigInteger i = it.next();
                    if (i.compareTo(smallest) == 0) it.remove();
                }
            }
            System.out.println(testcase + s);
        }
    }

    private static int findCuts(BigInteger b, List<BigInteger> integer, int d) {
        int c = 0;
        for (Iterator<BigInteger> it = integer.iterator(); it.hasNext(); ) {
            BigInteger j = it.next();
            if (j.compareTo(b) == 0) {
                d--;
                if (d == 0) return c;
                it.remove();
            }
        }
        BigInteger max = new BigInteger("360000000000");
        BigInteger g;
        a:
        for (int a = 2; (g = b.multiply(new BigInteger(String.valueOf(a)))).compareTo(max) < 0; a++) {
            if (d < a) {
                break a;
            }
            for (Iterator<BigInteger> it = integer.iterator(); it.hasNext(); ) {
                BigInteger j = it.next();
                if (j.compareTo(g) == 0) {
                    c += a - 1;
                    d -= a;
                    if (d == 0) return c;
                    it.remove();
                    if (d < a) {
                        break a;
                    }
                }
            }
        }

        for (BigInteger j : integer) {
            if (j.compareTo(b) > 0) {
                BigInteger h = j.divide(b);
                if (h.compareTo(new BigInteger(String.valueOf(d))) >= 0) {
                    c += d;
                    return c;
                } else {
                    d -= h.intValue();
                    c += h.intValue();
                }
            }
        }

        return -1;
    }

    private static boolean hasEnough(List<BigInteger> integer, int d) {
        while (integer.size() >= d) {
            BigInteger first = integer.get(0);
            int a = d - 1;
            for (int i = 1; i < integer.size(); i++) {
                if (integer.get(i).compareTo(first) == 0) {
                    a--;
                    if (a == 0) return true;
                }
            }
            integer.remove(0);
        }
        return false;
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

    public static void printPath(String testcase, int moves) {
        System.out.println(testcase + moves);
    }

    public static List<BigInteger> parseAngels(String m) {
        List<BigInteger> angels = new ArrayList<>();
        BigInteger remaining = new BigInteger("360000000000");
        for (String a : m.split(" ")) {
            BigInteger b = new BigInteger(a);
            angels.add(b);
            remaining = remaining.subtract(b);
        }
        if (remaining.intValue() != 0) angels.add(remaining);
        return angels;
    }

}
