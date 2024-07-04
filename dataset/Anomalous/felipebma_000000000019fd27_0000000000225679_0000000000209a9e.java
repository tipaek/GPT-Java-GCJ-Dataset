import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);
    private static int left, right;

    public static void main(String[] args) {
        int nCases = scanner.nextInt();
        int b = scanner.nextInt();

        for (int i = 0; i < nCases; i++) {
            solve(i, b);
            scanner.next();  // Consume the response between cases
        }
    }

    private static void solve(int nCase, int size) {
        int[] ans = new int[size];
        Integer[] equals = new Integer[2];
        Integer[] different = new Integer[2];

        left = 0;
        right = size - 1;

        // Initial queries
        for (int i = 0; i < 5; i++) {
            ans[left] = ask(left);
            left++;
        }
        for (int i = 0; i < 5; i++) {
            ans[right] = ask(right);
            if (ans[size - 1 - right] == ans[right]) {
                equals[0] = size - 1 - right;
                equals[1] = right;
            } else {
                different[0] = size - 1 - right;
                different[1] = right;
            }
            right--;
        }

        // Process remaining queries
        while (right >= left) {
            if (equals[0] != null && different[0] != null) {
                handleBoth(ans, equals, different);
            } else if (equals[0] != null) {
                handleEquals(ans, equals, different);
            } else {
                handleDifferent(ans, equals, different);
            }
        }

        // Print the result
        StringBuilder result = new StringBuilder();
        for (int value : ans) {
            result.append(value);
        }
        System.out.println(result.toString());
    }

    private static int ask(int pos) {
        System.out.println(pos + 1);
        return scanner.nextInt();
    }

    private static void handleBoth(int[] ans, Integer[] equals, Integer[] different) {
        int askE = ask(equals[0]);
        int askD = ask(different[0]);

        if (askE == ans[equals[0]] && askD != ans[different[0]]) {
            reverseArray(ans);
        } else if (askE != ans[equals[0]] && askD == ans[different[0]]) {
            reverseArray(ans);
            invertArray(ans);
        } else if (askE != ans[equals[0]]) {
            invertArray(ans);
        }

        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
        }
        left += 4;
        right -= 4;
    }

    private static void handleEquals(int[] ans, Integer[] equals, Integer[] different) {
        if (ask(equals[0]) != ans[equals[0]]) {
            invertArray(ans);
            ask(equals[0]);
        }

        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
            if (ans[left + i] != ans[right - i]) {
                different[0] = left + i;
                different[1] = right - i;
            }
        }
        left += 4;
        right -= 4;
    }

    private static void handleDifferent(int[] ans, Integer[] equals, Integer[] different) {
        if (ask(different[0]) != ans[different[0]]) {
            invertArray(ans);
            ask(different[0]);
        }

        for (int i = 0; i < 4; i++) {
            ans[left + i] = ask(left + i);
            ans[right - i] = ask(right - i);
            if (ans[left + i] == ans[right - i]) {
                equals[0] = left + i;
                equals[1] = right - i;
            }
        }
        left += 4;
        right -= 4;
    }

    private static void reverseArray(int[] ans) {
        for (int i = 0; i < ans.length / 2; i++) {
            swap(ans, i, ans.length - 1 - i);
        }
        int temp = left;
        left = ans.length - 1 - right;
        right = ans.length - 1 - temp;
    }

    private static void swap(int[] ans, int a, int b) {
        int temp = ans[a];
        ans[a] = ans[b];
        ans[b] = temp;
    }

    private static void invertArray(int[] ans) {
        for (int i = 0; i < ans.length; i++) {
            ans[i] = (ans[i] + 1) % 2;
        }
    }
}