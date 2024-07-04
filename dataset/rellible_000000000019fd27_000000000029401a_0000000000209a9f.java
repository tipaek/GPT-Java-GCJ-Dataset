import java.io.*;
import java.util.*;

class NestingDepths
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bfr.readLine());
        for (int x = 0; x < t; x++)
        {
            String s = bfr.readLine();
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
            System.out.println(strb.toString());

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