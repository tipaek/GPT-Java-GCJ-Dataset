import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
        
        int t = in.nextInt(); // Read number of test cases

        for (int i = 1; i <= t; ++i) {
            int targetSum = in.nextInt();
            int currentSum = 0;
            int n = 1, k = 1;

            System.out.println("Case #" + i + ":");

            while (currentSum < targetSum) {
                int tempSum = currentSum + binom(n, k);

                if (tempSum < targetSum) {
                    printDebugOrResult(debug, n, k, tempSum);
                    currentSum = tempSum;
                    adjustIndices(n, k);
                    n++;
                } else if (tempSum == targetSum) {
                    printDebugOrResult(debug, n, k, tempSum);
                    currentSum = tempSum;
                } else {
                    k--;
                }
            }
        }
    }

    private static void printDebugOrResult(boolean debug, int n, int k, int tempSum) {
        if (debug) {
            System.out.println(n + " " + k + " -- " + tempSum);
        } else {
            System.out.println(n + " " + k);
        }
    }

    private static void adjustIndices(int n, int k) {
        if (n == 2) {
            k = 2;
        } else if (n == 5) {
            k = 3;
        }
    }
}