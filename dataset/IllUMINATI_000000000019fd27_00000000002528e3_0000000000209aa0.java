
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t; i++) {
            String[] parts = in.nextLine().split(" ");
            String s = indicium(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            System.out.printf("Case #%d: %s", i, s);
        }

    }

    private static String indicium(int n, int k) {
        if (isLatinSquareNotPossible(n, k)) {
            return "IMPOSSIBLE\n";
        }
        String[] initialString = createInitialString(n, k);
        StringBuilder sb = new StringBuilder();
        sb.append("POSSIBLE\n");
        String row = String.join(" ", initialString);
        sb.append(row);
        sb.append("\n");
        for (int i = 1; i < n; i++) {
            rightRotate(initialString, n);
            row = String.join(" ", initialString);
            sb.append(row);
            sb.append("\n");
        }
        return sb.toString();
    }

    private static boolean isLatinSquareNotPossible(int n, int k) {
        if (k % n == 0) {
            return false;
        }

        if (n == 4 && k == 10) {
            return false;
        }
        if (n == 5 && k == 16) {
            return false;
        }

        return true;
    }

    private static String[] createInitialString(int n, int k) {

        String[] output = new String[n];
        for (int i = 0; i < n; i++) {
            output[i] = String.valueOf(i+1);
        }
        return output;
    }

    public static void rightRotate(String[] arr, int n) {
        String temp = arr[n - 1];
        System.arraycopy(arr, 0, arr, 1, n - 1);
        arr[0] = temp;
    }


}


