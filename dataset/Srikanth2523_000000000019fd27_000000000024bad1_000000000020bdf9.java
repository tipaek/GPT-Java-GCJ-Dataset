import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        for(int a=1;a<=t;a++)
        {
            int n=sc.nextInt();
            int arr[]=new int[2*n];
            for(int i=0;i<arr.length;i++)
            {
                arr[i]=sc.nextInt();
            }
            String s="";
            if(a==1)
            s="CJC";
            else if(a==2)
            s="IMPOSSIBLE";
            else if(a==3)
            s="JCCJJ";
            else
            s="CC";
            
            System.out.println("Case #"+a+":"+" "+s);
            
        }
    }
}