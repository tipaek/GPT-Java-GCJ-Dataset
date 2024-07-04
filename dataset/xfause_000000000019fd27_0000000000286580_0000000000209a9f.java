import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution
{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(input.readLine());
        for (int c = 0; c < cases; c++)
        {
            String str = input.readLine();
            int n = str.length();
            int num=0;
            StringBuilder new_str = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = str.charAt(i)-48;
                if(val==num)
                {
                    new_str.append(str.charAt(i));
                }
                else if(val>num)
                {
                    int diff = val-num;
                    new_str.append(generateOpenBraces(diff)).append(str.charAt(i));
                    num+=diff;
                }
                else
                {
                    int diff = num-val;
                    new_str.append(generateCloseBraces(diff)).append(str.charAt(i));
                    num-=diff;
                }
            }
            if(num>0) 
            {
                new_str.append(generateCloseBraces(num));
            }
            System.out.println(new_str.toString());

        }
        System.exit(0);
    }
    public static String generateOpenBraces(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }
    public static String generateCloseBraces(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }
}