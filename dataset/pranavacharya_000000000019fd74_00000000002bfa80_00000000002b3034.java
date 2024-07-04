import java.util.Scanner;

public class Solution {

    public void patternMatching(int caseno, String[] strarr) {
        String before = "";
        String after = "";
        for (String str : strarr) {
            int index = str.indexOf('*');
            if (str.substring(0, index).startsWith(before)) {
                before = str.substring(0, index);
            } else if (before.startsWith(str.substring(0, index))) {
            } else {
                System.out.format("Case #%d: %s", caseno, "*");
                System.out.println();
                return;
            }
            if (str.substring(index + 1).endsWith(after)) {
                after = str.substring(index + 1);
            } else if (after.endsWith(str.substring(index + 1))) {
            } else {
                System.out.format("Case #%d: %s", caseno, "*");
                System.out.println();
                return;
            }
        }
        if (before.contains(after)) {
            after = "";
        }
        if (after.contains(before)) {
            before = "";
        }
        System.out.format("Case #%d: %s", caseno, before + after);
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
