import java.io.*;
import java.util.*;

public class Solution
{
    static int r;
    static int s;
    
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=scan.nextInt();
        for(int tCount=1;tCount<=t;tCount++)
        {
            r=scan.nextInt();
            s=scan.nextInt();
            
            System.out.println("Case #"+tCount+": "+((r-1)*(s-1)));
            
            int groupB=r*s-r-1;
            for(int groupA=r;groupA>1;groupA--)
            {
                for(int i=0;i<s-1;i++)
                {
                    System.out.println(groupA+" "+groupB);
                    groupB--;
                }
            }
        }
    }
}
