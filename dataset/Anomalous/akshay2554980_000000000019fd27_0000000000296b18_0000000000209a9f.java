import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; ++j) {
            String s = sc.next();
            int l = s.length();
            char[] ans = new char[2 * l + 2]; // Adjusted size to avoid overflow
            char[] arr = s.toCharArray();
            int i = 0;

            for (int f = 0; f < l; ++f) {
                if (l == 1) {
                    ans[i++] = arr[0] == '0' ? '0' : '1';
                    continue;
                }
                if (arr[f] == '1' && f == 0) {
                    ans[i++] = '(';
                    ans[i++] = '1';
                    if (arr[f + 1] == '0') {
                        ans[i++] = ')';
                    }
                    continue;
                }
                if (f == l - 1) {
                    if (arr[f] == '1') {
                        if (arr[f - 1] == '0') {
                            ans[i++] = '(';
                        }
                        ans[i++] = '1';
                        ans[i++] = ')';
                    } else {
                        ans[i++] = '0';
                    }
                    continue;
                }
                if (arr[f] == '0') {
                    ans[i++] = '0';
                    continue;
                }
                if (arr[f] == '1') {
                    if (arr[f - 1] != '1') {
                        ans[i++] = '(';
                    }
                    ans[i++] = '1';
                    if (arr[f + 1] != '1') {
                        ans[i++] = ')';
                    }
                }
            }

            String result = new String(ans, 0, i); // Create string from valid portion of char array
            System.out.println("Case #" + (j + 1) + ": " + result);
        }
        sc.close();
    }
}