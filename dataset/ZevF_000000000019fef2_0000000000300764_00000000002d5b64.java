import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String[]args)
    {
        Scanner scan=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t=scan.nextInt();
        for(int tCount=1;tCount<=t;tCount++)
        {
            int r=scan.nextInt();
            int s=scan.nextInt();
            int []ranks=new int[r*s];
            for(int i=0;i<s;i++)
                for(int j=0;j<r;j++)
                    ranks[i*r+j]=j+1;
            
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
