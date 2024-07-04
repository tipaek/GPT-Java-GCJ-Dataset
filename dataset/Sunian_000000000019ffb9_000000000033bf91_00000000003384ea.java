import java.util.Scanner;

/**
 * Created by Sun on 4/3/2020.
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < T; i++) {
            String[] input = scan.nextLine().split(" ");
            long left = Long.parseLong(input[0]);
            long right = Long.parseLong(input[1]);
            handle(left, right, i + 1);
        }
    }

    private static void handle(long left, long right, long caseNum) {
        long i = 1;
        if (left > right) {
            long initial = triNumLessEqual(left - right);
            long sum = triSum(initial);
            left -= sum;
            i = initial + 1;
        } else if (right > left) {
            long initial = triNumLessEqual(right - left);
            long sum = triSum(initial);
            right -= sum;
            i = initial + 1;
        }
        Stack leftStack, rightStack;
        if (right > left) {
            rightStack = new Stack(right, i);
            leftStack = new Stack(left, i + 1);
        } else {
            leftStack = new Stack(left, i);
            rightStack = new Stack(right, i + 1);
        }
        leftStack.take(i - 1);
        rightStack.take(i - 1);
        left = leftStack.size;
        right = rightStack.size;
        i = Math.max(leftStack.i, rightStack.i);
        System.out.printf("Case #%d: %d %d %d\n", caseNum, i, left, right);
    }

    static class Stack {
        long size;
        long i;

        public Stack(long size, long i) {
            this.size = size;
            this.i = i;
        }

        void take(long initial) {
            if (i > size) {
                i = initial;
                return;
            }
            if (i % 2 == 0) {
                takeEven();
            } else {
                takeOdd();
            }
        }

        void takeEven() {
            if (i > 2) {
                size += evenTriSum(i - 2);
            }
            i = evenTriNumLessEqual(size);
            size -= evenTriSum(i);
        }

        void takeOdd() {
            if (i > 1) {
                size += oddTriSum(i - 2);
            }
            i = oddTriNumLessEqual(size);
            size -= oddTriSum(i);
        }
    }

    private static long triSum(long n) {
        return (n * n + n) / 2;
    }

    private static long triNumLessEqual(long threshold) {
        double ans = (Math.sqrt(8 * threshold + 1) - 1) / 2;
        return (long) ans;
    }

    private static long oddTriSum(long n) {
        long x = (n + 1) / 2;
        return x * x;
    }

    private static long evenTriSum(long n) {
        long x = (n) / 2;
        return x * x + x;
    }

    private static long oddTriNumLessEqual(long n) {
        long x = (long) Math.sqrt(n);
        return x * 2 - 1;
    }

    private static long evenTriNumLessEqual(long n) {
        long x = (long) Math.sqrt(n);
        x *= 2;
        if (evenTriSum(x) <= n) {
            return x;
        }
        return x - 2;
    }

}
