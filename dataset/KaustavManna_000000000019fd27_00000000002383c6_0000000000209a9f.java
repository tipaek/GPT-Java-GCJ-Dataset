import java.util.Scanner;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        for(int i = 1; i <= n; i++)
        {
            String string = in.next();
            String result = "";
            int len = string.length();
            int openp = 0;

            for(int j = 0; j < len; j++)
            {
                int digit = Integer.parseInt(string.substring(j, j+1));
                int opening = digit - openp;
                int closing = openp - digit;

                for(int k = 1; k <= opening; k++)
                {
                    result = result + "(";
                    openp++;
                }

                for(int l = 1; l <= closing; l++)
                {
                    result = result + ")";
                    openp --;
                }

                result = result + digit;
            }

            while(openp != 0)
            {
                result = result + ")";
                openp--;
            }

            System.out.println("Case #" + i + ": " + result);
        }
    }
}
