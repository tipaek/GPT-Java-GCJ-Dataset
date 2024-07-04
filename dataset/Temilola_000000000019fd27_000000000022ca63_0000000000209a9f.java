import java.util.Scanner;

import static java.lang.Math.abs;

public class Solution {
    public static void main(String []args) {
        Scanner in = new Scanner(System.in);
        int diff, i, testCases = in.nextInt();
        String str;

        in.nextLine();
        for(int testCase = 0; testCase < testCases; testCase++){
            str = in.nextLine();
            diff = -(str.charAt(0) - '0');
            str = append("",str,parenthesis(diff));
            i = abs(diff);
            while (i < str.length()-1) {
                diff = (str.charAt(i)-'0')-(str.charAt(i+1)-'0');
                str = append(str.substring(0,i+1),str.substring(i+1),parenthesis(diff));
                i = i+abs(diff)+1;
            }

            diff = (str.charAt(i) - '0');
            str = append(str,"",parenthesis(diff));
            System.out.println("Case #"+(testCase+1)+": "+str);
        }
    }

    private static String append(String pre, String post, String par){
        return pre+par+post;
    }

    private static String parenthesis(int diff) {
        if (diff == 0) {
            return "";
        } else if (diff > 0) {
            return stringMultiply(")", diff);
        } else {
            return stringMultiply("(", abs(diff));
        }
    }

    public static String stringMultiply(String s, int n){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            sb.append(s);
        }
        return sb.toString();
    }
}
