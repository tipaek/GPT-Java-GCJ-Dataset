import java.util.*;
class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cs = 1; cs <= t; cs++)
        {
            int n = sc.nextInt();
            String[] a = new String[n];
            int max = Integer.MIN_VALUE;
            int p = 0;
            for (int i = 0; i < n; i++) {
                a[i] = sc.next();
                int l = a[i].length();
                if (l > max) {
                    max = l;
                    p = i;
                }
            }

            String ourstring = a[p].substring(1, a[p].length());
            boolean ans = true;

            for (int i = 0; i < n; i++) {

                if (i != p) {
                    ans = true;
                    int l = ourstring.length();
                    l = l - 1;
                    int temp = l;
                    for (int j = a[i].length() - 1; j > 0; j--, l--) {
                        if (ourstring.charAt(l) != a[i].charAt(j)) {
                            ans = false;
                            break;
                        }
                    }
                    if (!ans) {
                        break;
                    }
                } else
                    ans = true;
            }
            if (ans)
                System.out.println("Case #"+cs+":"+" "+ourstring);
            else
                System.out.println("Case #"+cs+":"+" "+"*");

        }
    }
}
