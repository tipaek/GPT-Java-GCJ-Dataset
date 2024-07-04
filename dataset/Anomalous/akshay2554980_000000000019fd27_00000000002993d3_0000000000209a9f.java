import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int j = 0; j < t; ++j) {
            String s = sc.next();
            int l = s.length();
            char[] ans = new char[10000];
            char[] arr = s.toCharArray();
            int i = 0;

            for (int f = 0; f < l; ++f) {
                if (l == 1) {
                    if (arr[0] == '0') {
                        ans[i++] = '0';
                    } else {
                        ans[i++] = '(';
                        ans[i++] = '1';
                        ans[i++] = ')';
                    }
                    continue;
                }

                if (arr[f] == '1' && f == 0 && arr[f + 1] == '0') {
                    ans[i++] = '(';
                    ans[i++] = '1';
                    ans[i++] = ')';
                    continue;
                }

                if (arr[f] == '1' && f == 0 && arr[f + 1] == '1') {
                    ans[i++] = '(';
                    ans[i++] = '1';
                    continue;
                }

                if (f == l - 1) {
                    if (arr[f] == '0') {
                        ans[i++] = '0';
                    } else if (arr[f] == '1' && arr[f - 1] == '0') {
                        ans[i++] = '(';
                        ans[i++] = '1';
                        ans[i++] = ')';
                    } else if (arr[f] == '1' && arr[f - 1] == '1') {
                        ans[i++] = '1';
                        ans[i++] = ')';
                    }
                    continue;
                }

                if (arr[f] == '0') {
                    ans[i++] = '0';
                } else if (arr[f] == '1') {
                    if (arr[f - 1] != '1' && arr[f + 1] != '1') {
                        ans[i++] = '(';
                        ans[i++] = '1';
                        ans[i++] = ')';
                    } else if (arr[f - 1] == '1' && arr[f + 1] != '1') {
                        ans[i++] = '1';
                        ans[i++] = ')';
                    } else if (arr[f - 1] == '1' && arr[f + 1] == '1') {
                        ans[i++] = '1';
                    } else if (arr[f - 1] != '1' && arr[f + 1] == '1') {
                        ans[i++] = '(';
                        ans[i++] = '1';
                    }
                }
            }

            String result = new String(ans).trim();
            System.out.println("Case #" + (j + 1) + ": " + result);
        }
        sc.close();
    }
}