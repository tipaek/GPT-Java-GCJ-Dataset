import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    private static Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public static void main(String[] args) {
        int k = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < k; i++) {
            solve(i + 1);
        }
    }

    private static void solve(int caseN) {
        String line = scanner.nextLine();
        int[] arr = new int[line.length()];
        for (int i = 0; i < line.length(); i++) {
            arr[i] = line.charAt(i) - '0';
        }
        StringBuilder sb = new StringBuilder();
        int opened = 0;
        for (int i = 0; i < arr.length; i++) {
            if (opened < arr[i]) {
                for (int j = 0; j < arr[i] - opened; j++) {
                    sb.append('(');
                }
            } else {
                for (int j = 0; j < opened - arr[i]; j++) {
                    sb.append(')');
                }
            }
            opened = arr[i];
            sb.append(arr[i]);
        }
        for (int i = 0; i < opened; i++) {
            sb.append(')');
        }
        System.out.println("Case #" + caseN + ": " + sb.toString());
    }
}