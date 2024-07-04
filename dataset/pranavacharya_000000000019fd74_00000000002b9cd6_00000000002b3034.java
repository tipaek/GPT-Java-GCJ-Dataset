import java.util.Scanner;

public class Solution {

    public void patternMatching(int caseno, String[] strarr) {
        String ans = "";
        for (String str : strarr) {
            String[] split = str.split("\\*");
            for (String s : split) {
                if (s.contains(ans)) {
                    ans = s;
                } else if (ans.contains(s)) {
                    continue;
                } else {
                    System.out.format("Case #%d: %s", caseno, "*");
                    System.out.println();
                    return;
                }
            }
        }
        System.out.format("Case #%d: %s", caseno, ans);
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Solution pm = new Solution();
        int testcases = sc.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            pm.patternMatching(t, arr);
        }

    }
}
