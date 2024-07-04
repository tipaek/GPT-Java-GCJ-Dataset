import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int k=0; k<t; k++) {
            String a = sc.next();
            System.out.println("Case #" + (k+1) + ": " + addParentheses(a));
        }

    }

    private static String addParentheses(String s) {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            int x = parseInt(s.charAt(i) + "");
            if(i==0) {
                for(int j=x; j>0; j--) {
                    builder.append("(");
                }
                builder.append(x);
            } else {
                int y = parseInt(s.charAt(i-1) + "");
                if(x > y) {
                    int z = x-y;
                    for(int j=z; j>0; j--) {
                        builder.append("(");
                    }
                    builder.append(x);
                } else if(y > x) {
                    int z = y-x;
                    for(int j=z; j>0; j--) {
                        builder.append(")");
                    }
                    builder.append(x);
                } else {
                    builder.append(x);
                }
            }
            if(i==s.length()-1) {
                for(int j=x; j>0; j--) {
                    builder.append(")");
                }
            }
        }

        return builder.toString();
    }

}
