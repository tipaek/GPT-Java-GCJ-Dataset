import java.util.*;
class Solution {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            int n = scan.nextInt();
            int s[] = new int[n];
            int si[] = new int[n];
            int f[] = new int[n];
            int fi[] = new int[n];
            String fans = "";
            for (int i = 0; i < n; i++) {
                s[i] = scan.nextInt();
                si[i] = s[i];
                f[i] = scan.nextInt();
                fi[i] = f[i];
            }
            int temp;
            for (int i = 0; i < n-1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (f[i] > f[j]) {
                        temp = f[i];
                        f[i] = f[j];
                        f[j] = temp;

                        temp = s[i];
                        s[i] = s[j];
                        s[j] = temp;
                    }
                }
            }
            int st = 0, st1 = 0;
            st = 0;
            int q = 0;
            String ans = "C";
            for (int i = 1; i < n; i++) {

                if (s[i] >= f[st]) {
                    st = i;
                    ans += "C";
                } else if (st1 == 0) {
                    st1 = i;
                    ans += "J";
                } else if (s[i] >= f[st1]) {
                    st1 = i;
                    ans += "J";
                } else {
                    q = 1;
                    break;
                }
            }

            if (q == 1) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (si[i] == s[j] && fi[i] == f[j]) {
                            fans += ans.charAt(j);
                        }
                    }
                }
                System.out.println("Case #" + t + ": " + fans);
            }
        }
    }
}