import java.io.*;
import java.util.*;

class Solution
{

    public static void main(String[] args)
    {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    	int t = in.nextInt();
       // int t = Integer.parseInt(br.readLine());
        for (int tt = 1; tt <= t; tt++)
        {
            String s = in.next();
            int n = s.length();
            int brac=0;
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                int val = s.charAt(i)-48;
                if(val==brac)
                {
                    sb.append(s.charAt(i));
                }
                else if(val>brac)
                {
                    int diff = val-brac;
                    sb.append(generateOpenBraces(diff)).append(s.charAt(i));
                    brac = brac+diff;
                }
                else
                {
                    int diff = brac-val;
                    sb.append(generateCloseBraces(diff)).append(s.charAt(i));
                    brac=brac-diff;
                }
            }
            if(brac>0) 
            {
                sb.append(generateCloseBraces(brac));
            }
            System.out.println("Case #" + tt + ": " + sb.toString());

        }
       // System.exit(0);
    }

    public static String generateOpenBraces(int n)
    {
    	String string = "";
    	for(int i=0;i<n;i++) {
    		string += "(";
    	}
    	return string;
    }
    public static String generateCloseBraces(int n)
    {
    	String string = "";
    	for(int i=0;i<n;i++) {
    		string += ")";
    	}
    	return string;
    }


}
