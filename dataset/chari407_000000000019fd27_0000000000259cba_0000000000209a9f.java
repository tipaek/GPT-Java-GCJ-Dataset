import java.util.Scanner;

public class Solution {

    private static Character getLeftParenthesis()
    {
        return '(';
    }

    private static Character getRightParenthesis()
    {
        return ')';
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int test = 1; test <= t; test++) {

            String s = sc.nextLine();
            int len = s.length();

            StringBuilder answer = new StringBuilder();
            int open = 0;
            for(int i=0;i<len;i++)
            {
                int digit = Character.getNumericValue(s.charAt(i));
                int bracketsNeeded = digit - open;

                if(bracketsNeeded < 0)
                {
                    bracketsNeeded = Math.abs(bracketsNeeded);
                    while(bracketsNeeded-- >0)
                    {
                        answer.append(getRightParenthesis());
                    }
                }
                else
                {
                    while(bracketsNeeded-- >0)
                    {
                        answer.append(getLeftParenthesis());
                    }
                }
                answer.append(digit);
                open = digit;
            }
            while(open-- > 0)
            {
                answer.append(getRightParenthesis());
            }
            System.out.printf("Case #%d: %s\n", test, answer.toString());
        }
    }
}
