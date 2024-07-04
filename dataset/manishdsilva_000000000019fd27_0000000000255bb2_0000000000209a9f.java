import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution
{

    public static void main(String[] args) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int times = Integer.parseInt(br.readLine());
        for (int t = 0; t < times; t++)
        {
            String s = br.readLine();
            int n = s.length();
            int braces=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int current = s.charAt(i)-48;
                if(current==braces)
                {
                    sb.append(s.charAt(i));
                }
                else if(current>braces)
                {
                    int diff = current-braces;
                    sb.append(generateOpenBraces(diff)).append(s.charAt(i));
                    braces = braces+diff;
                }
                else
                {
                    int diff = braces-current;
                    sb.append(generateCloseBraces(diff)).append(s.charAt(i));
                    braces=braces-diff;
                }
            }
            if(braces>0) 
            {
                sb.append(generateCloseBraces(braces));
            }
            System.out.println(sb.toString());

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