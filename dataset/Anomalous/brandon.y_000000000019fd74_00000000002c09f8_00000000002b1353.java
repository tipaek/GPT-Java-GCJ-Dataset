import java.util.*;
import java.io.*;

public class Solution {

    // Function to calculate binomial coefficient
    static int binom(int n, int k) {
        n -= 1;
        k -= 1;

        int res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        boolean debug = false;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Number of test cases

        for (int i = 1; i <= t; ++i) {
            int targetSum = in.nextInt();
            int currentSum = 0;
            boolean valid = false;
            int n = 1;
            int k = 1;

            System.out.println("Case #" + i + ": ");
            while (currentSum < targetSum) {
                int tempSum = currentSum;

                if (n == 3) {
                    k = 2;
                }
                if (n == 5) {
                    k = 3;
                }

                tempSum += binom(n, k);
                if (tempSum < targetSum) {
                    int nextSum = tempSum + binom(n + 1, k);

                    if (nextSum > targetSum) {
                        k--;
                    } else {
                        valid = true;
                    }
                } else if (tempSum == targetSum) {
                    valid = true;
                } else {
                    k--;
                }

                if (valid) {
                    if (debug) {
                        System.out.println(n + " " + k + " -- " + tempSum);
                    } else {
                        System.out.println(n + " " + k);
                    }
                    currentSum = tempSum;
                    n++;
                }
            }

            if (debug) {
                System.out.println(currentSum);
            }
        }
    }
}