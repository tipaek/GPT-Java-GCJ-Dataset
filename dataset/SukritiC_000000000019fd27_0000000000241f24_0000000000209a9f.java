

import java.util.*;

class Solution {

    public String conc(int n, String s) {
        if (n == 0) {
            return s;
        }
        return ("(" + conc(n - 1, s) + ")");
    }

    public String conc1(int n, String s) {
        if (n == 0) {
            return s;
        }
        return ("(" + conc1(n - 1, s));
    }

    //public String brace()
    public static void main(String as[]) {
        Scanner sc = new Scanner(System.in);
        Solution obj = new Solution();
        int t = sc.nextInt();
        String s = "";
        String t2 = "", t1 = "", fs = "";
        int x=0,y=0;
        for (int i = 0; i < t; i++) {
            s = sc.next();
            int d = Integer.parseInt(s);
            if (d == 0) {
                System.out.println("Case #" + (i + 1) + ": " + s);
            } else {
                int temp = 0;
                for (int j = 0; j < s.length(); j++) {
                    
                    t2 = t2 + s.charAt(j);
                    if (j != s.length() - 1) {
                        t1 = t1 + s.charAt(j + 1);
                        y = Integer.parseInt(t1);
                    }
                    x = Integer.parseInt(t2);                    
                    if (x < y) {
                        fs += obj.conc(x, t2);
                    } else if (x == y) {
                        int k = j + 2;
                        t2 = t2 + t1;
                        while (k < s.length()) {
                            t1 = "";
                            t1 = t1 + s.charAt(k);
                            int z = Integer.parseInt(t1);
                            if (x == z) {
                                t2 = t2 + t1;
                                k++;
                            } else {
                                break;
                            }
                        }
                        fs += obj.conc(x, t2);
                        if (k > j + 2 && k != s.length()) {
                            j = k - 1;
                        } else if (k > j + 2 && k == s.length()) {
                            j = s.length() - 1;
                        }
                    } else if (x > y) {
                        if (y == 0) {
                            fs += obj.conc(x, t2);
                        }
                    }
                    t2 = "";
                    t1 = "";
                    x=0;
                    y=0;
                }
                System.out.println("Case #" + (i + 1) + ": " + fs);
            }
            fs = "";

        }
    }
}
