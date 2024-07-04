import java.math.BigInteger;
import java.util.*;

public class Solution {

    private static Map<List<Integer>, Integer> cache = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = in.nextInt();
            System.out.println("Case #" + t + ":");
            if (n <= 40) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(i + " 1");
                }
            } else {
                BigInteger b = BigInteger.valueOf(n - 40);
                boolean isLeft = true;
//                int acc = 0;
                for (int row = 1; row <= 40 + b.bitCount(); row++) {
                    boolean includeRow = b.testBit(row - 1);
                    if (includeRow) {
                        if (isLeft) {
                            for (int i = 1; i <= row; i++) {
                                System.out.println(row + " " + i/* + " " + c(row - 1, i - 1)*/);
//                                acc += c(row - 1, i - 1);
                            }
                        } else {
                            for (int i = row; i >= 1; i--) {
                                System.out.println(row + " " + i/* + " " + c(row - 1, i - 1)*/);
//                                acc += c(row - 1, i - 1);
                            }
                        }
                        isLeft = !isLeft;
                    } else {
                        if (isLeft) {
//                            acc += c(row - 1, 0);
                            System.out.println(row + " 1"/* + " " + c(row - 1, 0)*/);
                        } else {
                            System.out.println(row + " " + row/* + " " + c(row - 1, row - 1)*/);
//                            acc += c(row - 1, row - 1);
                        }
                    }
                }
//                System.out.println("=" + acc);
            }
        }
    }

    private static int c(int r, int c) {
        List<Integer> key = Arrays.asList(r, c);
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        int result;
        if (c == 0 || c == r) {
            result = 1;
        } else {
            result = c(r - 1, c - 1) + c(r - 1, c);
        }
        cache.put(key, result);
        return  result;

    }
}
