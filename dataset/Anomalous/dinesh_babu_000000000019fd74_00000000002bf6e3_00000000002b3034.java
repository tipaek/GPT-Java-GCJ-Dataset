import java.util.Scanner;

public class Solution {
    static boolean match(String s, String k) {
        int l1 = s.length();
        int l2 = k.length();
        int t = l1;
        for (int i = l2 - 1; i >= 0; i--) {
            t--;
            if (k.charAt(i) == '*' || s.charAt(t) == '*') {
                return true;
            } else if (k.charAt(i) == s.charAt(t)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int k = 1; k <= T; k++) {
            int N = sc.nextInt();
            String maxS = "";
            int maxlen = -1;
            String[] arr = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.next();
                if (arr[i].length() > maxlen) {
                    maxlen = arr[i].length();
                    maxS = arr[i];
                }
            }

            boolean isMatch = true;
            for (int j = 0; j < N; j++) {
                if (!match(arr[j], maxS)) {
                    isMatch = false;
                    System.out.println("Case #" + k + ": *");
                    break;
                }
            }

            if (isMatch) {
                System.out.println("Case #" + k + ": " + maxS.substring(1));
            }
        }
        sc.close();
    }
}