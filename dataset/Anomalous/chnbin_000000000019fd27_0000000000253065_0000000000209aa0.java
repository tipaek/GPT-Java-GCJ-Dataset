import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();

        for (int t = 1; t <= testCases; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            String result = isPossible(n, k) ? "POSSIBLE" : "IMPOSSIBLE";

            System.out.println("Case #" + t + ": " + result);

            if (result.equals("IMPOSSIBLE")) {
                break;
            }

            printMatrix(n, k);
        }
        scanner.close();
    }

    private static boolean isPossible(int n, int k) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            sums.add(i * n);
        }
        if (n % 2 != 0) {
            sums.add((1 + n) * n / 2);
        }
        return sums.contains(k);
    }

    private static void printMatrix(int n, int k) {
        String permutation = generatePermutation(n);
        int diag = k / n;
        int start = (n - diag) % n;

        for (int i = 0; i < n; i++) {
            String reversed = reverseK(permutation.toCharArray(), start);
            for (int j = 0; j < reversed.length(); j++) {
                if (j == reversed.length() - 1) {
                    System.out.println(reversed.charAt(j));
                } else {
                    System.out.print(reversed.charAt(j) + " ");
                }
            }
            start = (start + 1) % n;
        }
    }

    private static String generatePermutation(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            str.append(i);
        }
        return str.toString();
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    private static String reverseK(char[] arr, int k) {
        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k);
        reverse(arr, k + 1, arr.length - 1);
        return new String(arr);
    }
}