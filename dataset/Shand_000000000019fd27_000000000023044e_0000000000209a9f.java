import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        int tests;
        Scanner s = new Scanner(System.in);
        tests = s.nextInt();

        for(int t=0;t<tests;t++) {
            String input = s.next();
            int open = 0;
            String result = new String("");
            for(int i = 0;i<input.length();i++) {
                int digit = Integer.parseInt(Character.toString(input.charAt(i)));
                int diff=0;
                if(digit>open)
                    for (int k = 0; k < digit - open; k++)
                        result += "(";
                else if(digit<open)
                    for (int k = 0; k < open - digit; k++)
                        result += ")";
                open = digit;
                result+=input.charAt(i);
            }

            for(int k=0;k<open;k++)
                result+=")";

            System.out.println("Case #"+(t+1)+": "+result);
        }
    }
}
