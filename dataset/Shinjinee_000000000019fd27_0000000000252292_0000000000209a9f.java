import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for (int i=1; i<=t; i++)
        {
            String s=sc.nextLine();
            
            String x="";
            for (int j=1; j<=Character.getNumericValue(s.charAt(0)); j++)
            {
                x=x+"(";
            }
            x=x+s.charAt(0);
    
            for (int j=0; j<s.length()-1; j++)
            {
                int diff=Character.getNumericValue(s.charAt(j+1))-Character.getNumericValue(s.charAt(j));
                if (diff>=0)
                {
                    for (int k=1; k<=diff; k++)
                    {
                        x=x+"(";
                    }
                }
                else
                {
                    for (int k=1; k<=(-diff); k++)
                    {
                        x=x+")";
                    }
                }
                x=x+s.charAt(j+1);
            }
            for (int j=1; j<=Character.getNumericValue(s.charAt(s.length()-1)); j++)
            {
                x=x+")";
            }
            
            System.out.println("Case #"+i+": "+x);
        }
    }
}