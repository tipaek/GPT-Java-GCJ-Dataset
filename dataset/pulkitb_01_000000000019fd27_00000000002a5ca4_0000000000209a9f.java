import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

class Solution
{
    public static void main(String[] args) throws NumberFormatException, IOException
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tt = 0; tt < t; tt++)
        {
            String s = br.readLine();
            int n = s.length();
            int brc=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int vl = s.charAt(i)-48;
                if(vl==brc)
                {
                    sb.append(s.charAt(i));
                }
                else if(vl>brc)
                {
                    int diff = vl-brc;
                    sb.append(generateOpenbrces(diff)).append(s.charAt(i));
                    brc = brc+diff;
                }
                else
                {
                    int diff = brc-vl;
                    sb.append(generateClosebrces(diff)).append(s.charAt(i));
                    brc=brc-diff;
                }
            }
            if(brc>0) 
            {
                sb.append(generateClosebrces(brc));
            }
            System.out.println("Case #" + tt + ": "  + sb.toString());

        }
        System.exit(0);
    }

    public static String generateOpenbrces(int n)
    {
         return String.join("", Collections.nCopies(n, "("));
    }
    public static String generateClosebrces(int n)
    {
         return String.join("", Collections.nCopies(n, ")"));
    }


}