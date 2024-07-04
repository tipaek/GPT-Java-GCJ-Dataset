import java.io.*;
import java.util.*;

public class Solution
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {

        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        for (int x = 1; x <= S; x++)
        {
            String s = sc.next();
            int size = s.length();
            int brace = 0;
            StringBuilder strb = new StringBuilder();
            for(int i = 0; i < size; i++)
            {
                int value = s.charAt(i)-48;
                if(value == brace)
                {
                    strb.append(s.charAt(i));
                }
                else if(value > brace)
                {
                    int dif = value - brace;
                    strb.append(openBraces(dif)).append(s.charAt(i));
                    brace = brace + dif;
                }
                else
                {
                    int dif = brace - value;
                    strb.append(closeBraces(dif)).append(s.charAt(i));
                    brace = brace - dif;
                }
            }
            if(brace > 0) 
            {
                strb.append(closeBraces(brace));
            }
            System.out.println("Case #" + x + ": " + strb.toString());

        }
        System.exit(0);
    }

    private static String openBraces(int b)
    {
         return String.join("", Collections.nCopies(b, "("));
    }
    private static String closeBraces(int b)
    {
         return String.join("", Collections.nCopies(b, ")"));
    }


}