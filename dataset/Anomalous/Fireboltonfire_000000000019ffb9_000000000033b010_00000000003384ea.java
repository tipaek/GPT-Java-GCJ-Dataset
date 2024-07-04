import java.util.*;
import java.io.*;
import java.util.function.Function;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int i = 1; i <= testCases; i++) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            System.out.print("Case #" + i + ": ");
            process(left, right);
        }
        scanner.close();
    }
    
    public static void process(long left, long right) {
        long difference = Math.abs(left - right);
        Function<Long, Long> sumFunction = n -> (n * (n + 1)) / 2;
        long initial = binarySearch(0, 2_000_000_000L, difference, sumFunction);
        System.out.println(initial);
        long sumValue = sumFunction.apply(initial);
        
        if (right > left) {
            right -= sumValue;
        } else {
            left -= sumValue;
        }
        
        if (Math.max(left, right) < initial + 1) {
            System.out.println(initial + " " + left + " " + right);
        }
        
        Function<Long, Long> leftFunction = n -> ((initial + n) * n);
        Function<Long, Long> rightFunction = n -> ((initial + 1 + n) * n);
        boolean swapped = false;
        
        if (right > left) {
            long temp = left;
            left = right;
            right = temp;
            swapped = true;
        }
        
        Long leftSteps = binarySearch(0, 2_000_000_000L, left, leftFunction);
        Long rightSteps = binarySearch(0, 2_000_000_000L, right, rightFunction);
        
        if (leftSteps >= rightSteps) {
            leftSteps = Math.min(leftSteps, rightSteps + 1);
        } else {
            rightSteps = leftSteps;
        }
        
        left -= leftFunction.apply(leftSteps);
        right -= rightFunction.apply(rightSteps);
        long totalSteps = initial + leftSteps + rightSteps;
        
        if (swapped) {
            System.out.println(totalSteps + " " + right + " " + left);
        } else {
            System.out.println(totalSteps + " " + left + " " + right);
        }
    }
    
    public static long binarySearch(long left, long right, long target, Function<Long, Long> function) {
        if (left == right) return left;
        long mid = (left + right + 1) / 2;
        long midValue = function.apply(mid);
        
        if (target < midValue) {
            return binarySearch(left, mid - 1, target, function);
        } else {
            return binarySearch(mid, right, target, function);
        }
    }
}