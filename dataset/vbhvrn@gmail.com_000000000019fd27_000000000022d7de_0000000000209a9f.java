import java.util.Scanner;

/*
8
0000
101
111000
1
312
4
021
221
 */
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t){

            String S = scan.next();
            String result = "";

            char[] chars = S.toCharArray();
            int open = 0;
            for (int i = 0; i < chars.length; i++) {
                int x = chars[i]-'0';
                if(open>0) {
                    for (int j = 0; j < x - open; j++) {
                        result += ")";
                    }
                }
                for (int j = 0; j < x-open; j++) {
                    result+="(";
                }
                for (int j = 0; j < open - x; j++) {
                    result+=")";
                }
                result+=""+x;
                open = x;
            }

            for (int i = 0; i < open; i++) {
                result+=")";
            }

            System.out.println("Case #"+f+": " + result);
        }
    }
}
