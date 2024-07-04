import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

public class Solution {
    public static void main(String[] args) {
        // Now 2 stacks are +- even and the orders will alternate between stacks
        // every 2 order the order size increases by 2, but the difference in stacksize increases by 1

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            System.out.print(String.format("Case #%d: ", i));
            solve(in);
        }

    }

    public static void solve(Scanner sc) {
        long L = sc.nextLong();
        long R = sc.nextLong();

        long diff = Math.abs(L - R);
        long customers = binarySearch((i) -> diff >= sumFirstNCustomers(i));

        if (L >= R) {
            L -= sumFirstNCustomers(customers);
        } else {
            R -= sumFirstNCustomers(customers);
        }

        // Now 2 stacks are +- even and the orders will alternate between stacks
        // every 2 order the order size increases by 2, but the difference in stacksize increases by 1
        long[] resLeft;
        long[] resRight;
        if (L >= R) {
            resLeft = maxAlternatingCustomers(L, customers + 1);
             resRight = maxAlternatingCustomers(R, customers + 2);
        } else {
            resLeft = maxAlternatingCustomers(L, customers + 2);
            resRight = maxAlternatingCustomers(R, customers + 1);
        }

        customers += resLeft[1] + resRight[1];
        System.out.println(
                String.format("%s %s %s", customers, resLeft[0], resRight[0])
        );


    }


    public static long[] maxAlternatingCustomers(Long stack, long start) {
        if (stack < start) {
            return new long[]{stack, 0L};
        }
        Function<Long, Long> pancakes;
        if (start == 0) {
            pancakes = (i) -> 2 * sumFirstNCustomers(i);
        } else {
            pancakes = (i) -> 2 * sumFirstNCustomers(i) + i * (start - 2);
        }

        long customers = binarySearch(
                (c) -> stack >= pancakes.apply(c)
        );

        return new long[]{
                stack - pancakes.apply(customers), customers
        };

    }

    public static long sumFirstNCustomers(long N) {
        return (N) * (N + 1) / 2;
    }

    public static long binarySearch(Function<Long, Boolean> predictor) {
        long high = 1;
        while (predictor.apply(high)) {
            high *= 2;
        }

        if (high == 1) {
            return 0;
        }

        long low = high / 2;

        while (high - low > 1) {
            long middle = (high + low) / 2;
            if (predictor.apply(middle)) {
                low = middle;
            } else {
                high = middle;
            }
        }

        return low;
    }

}
  