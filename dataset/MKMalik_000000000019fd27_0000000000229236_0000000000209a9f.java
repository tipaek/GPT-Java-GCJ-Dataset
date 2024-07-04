

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        in.nextLine();
        for (int i=0; i<t; i++) {
            String res = "";
            String s = in.nextLine();
            s = "0" + s;
            s = s + "0";
            for (int j=1; j<s.length(); j++) {
                res += para(s.charAt(j-1), s.charAt(j)) + s.charAt(j);
            }
            System.out.println("Case #"+(i+1)+": "+res.substring(0, res.length()-1));
        }
    }

    public static String para(char c, char d) {
        String res = "";
        int a = Character.getNumericValue(c);
        int b = Character.getNumericValue(d);
        int n = a - b;
        if (n < 0) {
            n *= -1;
            for (int i=0; i<n; i++) {
                res += "(";
            }
        }
        else {
            for (int i=0; i<n; i++) {
                res += ")";
            }
        }
        return res;
    }
}
