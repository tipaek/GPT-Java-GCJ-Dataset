import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        in.nextLine();
        for (int id = 1; id <= t; id++) {
            solution(in, id);
        }
    }

    private static void solution(Scanner in, int id) {
        long left = in.nextLong();
        long right = in.nextLong();

        //First, get them approximately equal
        long diff = Math.abs(left - right);
        long i = (long) Math.floor(0.5d * (Math.sqrt(8L * diff + 1L) - 1));
        if (left >= right) {
            left -= (i * (i + 1)) / 2;
        } else {
            right -= (i * (i + 1)) / 2;
        }

        //Then, do the rest
        i++;
        while (left >= i || right >= i) {
            if (left >= right) {
                left -= i;
            } else {
                right -= i;
            }
            i++;
        }
        i--;

        System.out.println("Case #" + id + ": " + i + " " + left + " " + right);
    }

    // Function to return the sum of
// all odd natural numbers
    static long sumOdd(long n)
    {
        long terms = (n + 1) / 2;
        long sum = terms * terms;
        return sum;
    }

    // Function to return the sum
// of all odd numbers in range L and R
    static long sumOddInRange(long l, long r)
    {
        return sumOdd(r) - sumOdd(l - 1);
    }

    // Function to return the sum of
// all natural numbers
    static long sumNatural(long n)
    {
        long sum = (n * (n + 1));
        return sum;
    }

    // Function to return sum
// of even numbers in range L and R
    static long sumEvenInRange(long l, long r)
    {
        return sumNatural(r/2) - sumNatural((l-1) / 2);
    }
}