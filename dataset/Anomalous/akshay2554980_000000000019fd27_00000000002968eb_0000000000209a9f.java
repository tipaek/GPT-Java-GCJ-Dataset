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
                    if (arr[f] == '0') {
                        ans[i++] = '0';
                    } else if (arr[f - 1] == '0') {
                        ans[i++] = '(';
                        ans[i++] = '1';
                        ans[i++] = ')';
                    } else {
                        ans[i++] = '1';
                        ans[i++] = ')';
                    }
                    continue;
                }
                
                if (arr[f] == '0') {
                    ans[i++] = '0';
                } else if (arr[f] == '1') {
                    if (arr[f - 1] != '1') {
                        ans[i++] = '(';
                    }
                    ans[i++] = '1';
                    if (arr[f + 1] != '1') {
                        ans[i++] = ')';
                    }
                }
            }
            
            String result = new String(ans, 0, i);
            System.out.println("#" + (j + 1) + ": " + result);
        }
    }
}