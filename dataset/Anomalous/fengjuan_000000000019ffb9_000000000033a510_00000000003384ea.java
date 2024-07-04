import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        
        for (int testCase = 1; testCase <= testCases; ++testCase) {
            long left = scanner.nextLong();
            long right = scanner.nextLong();
            long steps = 0;
            
            if (left > right) {
                steps = calculateSteps(left - right);
                left -= calculateSum(steps);
            } else if (left < right) {
                steps = calculateSteps(right - left);
                right -= calculateSum(steps);
            }
            
            if (left >= right) {
                long a = calculateLeftSteps(left, steps);
                long b = calculateRightSteps(right, steps);
                left -= calculateLeftSum(a, steps);
                right -= calculateRightSum(b, steps);
                steps += a + b;
            } else {
                long a = calculateLeftSteps(right, steps);
                long b = calculateRightSteps(left, steps);
                left -= calculateRightSum(b, steps);
                right -= calculateLeftSum(a, steps);
                steps += a + b;
            }
            
            System.out.println("Case #" + testCase + ": " + steps + " " + left + " " + right);
        }
    }

    private static long calculateSteps(long difference) {
        long low = 0, high = 1;
        
        while (calculateSum(high) <= difference) {
            high *= 2;
        }
        
        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (calculateSum(mid) <= difference) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }

    private static long calculateSum(long n) {
        return n % 2 == 0 ? n / 2 * (n + 1) : (n + 1) / 2 * n;
    }

    private static long calculateLeftSteps(long n, long k) {
        long low = 0, high = 1;
        
        while (calculateLeftSum(high, k) <= n) {
            high *= 2;
        }
        
        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (calculateLeftSum(mid, k) <= n) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }

    private static long calculateLeftSum(long n, long k) {
        return k * n + n * n;
    }

    private static long calculateRightSteps(long n, long k) {
        long low = 0, high = 1;
        
        while (calculateRightSum(high, k) <= n) {
            high *= 2;
        }
        
        while (low < high) {
            long mid = (low + high + 1) / 2;
            if (calculateRightSum(mid, k) <= n) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        
        return low;
    }

    private static long calculateRightSum(long n, long k) {
        return (k + 1) * n + n * n;
    }
}