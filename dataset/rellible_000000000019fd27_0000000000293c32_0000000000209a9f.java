import java.io.*;
import java.util.*;

public class Solution
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
                    strb.append(openBraces()).append(s.charAt(i));
                    brace = brace + dif;
                }
                else
                {
                    int dif = brace - value;
                    strb.append(closeBraces()).append(s.charAt(i));
                    brace = brace - dif;
                }
            }
            if(brace > 0) 
            {
                strb.append(closeBraces());
            }
            System.out.println(strb.toString());

        }
        System.exit(0);
    }

    private static String openBraces()
    {
         return "(";
    }
    private static String closeBraces()
    {
         return ")";
    }


}