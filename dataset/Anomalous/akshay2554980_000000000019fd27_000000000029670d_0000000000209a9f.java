import java.util.Scanner;

class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int j = 0; j < t; ++j) {
            String s = sc.next();
            int l = s.length();
            StringBuilder ans = new StringBuilder();
            char[] arr = s.toCharArray();

            for (int f = 0; f < l; ++f) {
                if (l == 1) {
                    ans.append(arr[0] == '0' ? "0" : "1");
                    continue;
                }

                if (arr[f] == '1' && f == 0) {
                    ans.append('(').append('1');
                    if (arr[f + 1] == '0') ans.append(')');
                    continue;
                }

                if (f == l - 1) {
                    if (arr[f] == '0') {
                        ans.append('0');
                    } else {
                        if (arr[f - 1] == '0') ans.append('(');
                        ans.append('1').append(')');
                    }
                    continue;
                }

                if (arr[f] == '0') {
                    ans.append('0');
                } else {
                    if (arr[f - 1] != '1') ans.append('(');
                    ans.append('1');
                    if (arr[f + 1] != '1') ans.append(')');
                }
            }

            System.out.println("#" + j + ": " + ans.toString());
        }
        sc.close();
    }
}