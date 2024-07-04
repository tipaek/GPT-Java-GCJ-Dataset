import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException 
	{
		InputStreamReader read = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(read);
		int t1=Integer.parseInt(in.readLine());
		for(int i=1;i<=t1;i++)
		{
		    String s=in.readLine();
		    int l=s.length();
		    String s1="";
		    for(int j=0;j<=l-1;j++)
		    {
		        if(j==0)
		        {
		            for(int p=0;p<Character.getNumericValue(s.charAt(j));p++)
		            {
		                s1+="(";
		            }
		            s1=s1+s.charAt(j);
		        }
		        if(j==l-1)
		        {
		            break;
		        }
		        //if(l>1)
		        //{
		            if(Character.getNumericValue(s.charAt(j+1))<Character.getNumericValue(s.charAt(j)))
		            {
		                for(int p=0;p<Character.getNumericValue(s.charAt(j))-Character.getNumericValue(s.charAt(j+1));p++)
		                {
		                    s1+=")";
		                }
		                s1+=s.charAt(j+1);
		            }
		            else if(Character.getNumericValue(s.charAt(j+1))>Character.getNumericValue(s.charAt(j)))
		            {
		                for(int p=0;p<Character.getNumericValue(s.charAt(j+1))-Character.getNumericValue(s.charAt(j));p++)
		                {
		                    s1+="(";
		                }
		                s1+=s.charAt(j+1);
		            }
		            else
		            {
		                s1+=s.charAt(j+1);
		            }
		        }
		    //}
		    for(int p=0;p<Character.getNumericValue(s.charAt(l-1));p++)
		    {
		        s1+=")";
		    }
		    System.out.println("Case #"+i+": "+s1);
		}
	}
}
