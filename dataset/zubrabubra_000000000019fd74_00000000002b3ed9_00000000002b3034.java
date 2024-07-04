import java.util.Scanner;
import java.util.Arrays;
//...


class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int it = 0; it < t; it++) {
            int n = in.nextInt();
            in.nextLine();
            String longestSuffix = null;
            boolean can = true;
            for (int i = 0; i < n; i++) {
                String a = in.nextLine();
                //System.out.println("Case X" + a);
                if (longestSuffix == null) {
                    longestSuffix = a;
                } else {
                    if (longestSuffix.length() > a.length()) {
                        //System.out.println("Case X" + longestSuffix + " << " + a);
                        if (!longestSuffix.endsWith(a.substring(1))) {
                            //System.out.println("!!!! XX" + longestSuffix + " << " + a);
                            can = false;
                        }
                    } else {
                        //System.out.println("Case X" + a + " << " + longestSuffix);
                        if (!a.endsWith(longestSuffix.substring(1))) {
                            //System.out.println("!!!! XY" + a + " << " + longestSuffix);
                            can = false;
                        }
                        longestSuffix = a;
                    }
                }
            }
            if (can) {
                System.out.println("Case #" + (it+1) + ": " + longestSuffix.replace('*', 'A'));
            } else {
                System.out.println("Case #" + (it+1) + ": " + '*');
            }
        }
    }
}
