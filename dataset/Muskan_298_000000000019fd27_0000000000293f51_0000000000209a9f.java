import java.util.*;
import java.lang.*;
import java.io.*;


public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        
        
        for(int u=1;u<=t;u++)
        {
            int last=0;
            String faltu;
            if(u==1)
            faltu=sc.nextLine();
            String str=sc.nextLine();
            String output="";
            int m=str.length(); 
            char ch[]=str.toCharArray();
            int i=0;
            for(i=0;i<str.length();i++)
            {
                if(output.length()==0)
                {
                int j=Character.getNumericValue(ch[i]);
                while(j>0)
                {
                    output+="(";
                    j--;
                }
                output+=ch[i];
                last=Character.getNumericValue(ch[i]);
                }
                else
                {
                    if(ch[i]<ch[i-1])
                    {
                        int k=Character.getNumericValue(ch[i-1])-Character.getNumericValue(ch[i]);
                        while(k>0)
                        {
                            output+=")";
                            k--;
                        }
                        output+=ch[i];
                        last=Character.getNumericValue(ch[i]);
                    }
                    else
                    {
                        int p=Character.getNumericValue(ch[i])-Character.getNumericValue(ch[i-1]);
                        while(p>0)
                        {
                            output+="(";
                            p--;
                        }
                        output+=ch[i];
                        last=Character.getNumericValue(ch[i]);
                        
                    }
                }
            }
            
            while(last>0)
            {
                output+=")";
                last--;
            }
            System.out.println("Case #"+u+": "+output);
            
        }
	}
}
