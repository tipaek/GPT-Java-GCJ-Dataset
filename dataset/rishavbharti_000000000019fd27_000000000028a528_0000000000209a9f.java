import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<=t;i++)
        {
            String s=sc.nextLine();
            String ans="";
            int l=s.length();
            for(int j=0;j<l;j++)
            {
                if(s.charAt(j)=='1')
                {
                    ans+="(1";
                    if(j+1<l)
                    {
                        int k=j+1;
                        while(s.charAt(k)=='1')
                        {
                            ans+='1';
                            k++;
                            j++;
                        }
                    }
                    ans+=')';
                }
                else if(s.charAt(j)=='0')
                {
                    ans+="0";
                }
            }
            if(ans!="")
            {
                System.out.println("Case #"+(i)+": "+ans);
            }
        }
	}
}