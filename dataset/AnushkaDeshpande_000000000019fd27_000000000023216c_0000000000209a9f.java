import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[])throws IOException
    {
        InputStreamReader read = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(read);
        Scanner sc = new Scanner(System.in);

        int testCases = Integer.parseInt(in.readLine());
        for(int q=0;q<testCases;q++)
        {
            String s = in.readLine();
            int len = s.length();
            String sNew = "";
            int brackets = 0;
            for(int i=0;i<len;i++)
            {
                int temp = Character.getNumericValue(s.charAt(i));
                if(temp > brackets)
                {
                    for(int j=0;j<(temp-brackets);j++) {
                        sNew = sNew + "(";
                    }
                    brackets += (temp-brackets);
                }

                if(temp < brackets)
                {
                    for(int j = 0; j<(brackets-temp);j++) {
                        sNew = sNew + ")";
                    }
                    brackets -= (brackets-temp);
                }
                sNew = sNew + s.charAt(i);
            }
            while(brackets!=0)
            {
                sNew = sNew + ")";
                brackets--;
            }
            System.out.println("Case #"+(q+1)+": "+sNew);
        }
    }
}