import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            String[] arr = new String[N];
            int maxLength = 0;
            String longestString = "";
            String result = "";

            for (int i = 0; i < N; i++) {
                arr[i] = scanner.next();
                if (arr[i].length() > maxLength) {
                    longestString = arr[i];
                    maxLength = arr[i].length();
                }
            }

            for (int i = 0; i < N; i++) {
                String substring = arr[i].substring(1);
                if (substring.indexOf(longestString.substring(1)) == 1) {
                    if (arr[i].charAt(arr[i].length() - 1) != longestString.charAt(arr[i].length() - 1)) {
                        result = "*";
                        break;
                    }
                } else {
                    result = "*";
                    break;
                }
            }

            if (!result.equals("*")) {
                System.out.println("Case #" + t + ": " + result);
            } else {
                System.out.println("Case #" + t + ": *");
            }
        }
    }
}