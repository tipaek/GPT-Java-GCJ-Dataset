import java.io.*;
import java.util.*;
public class Solution
{
	public static void main(String[] args)throws IOException {
		InputStreamReader read=new InputStreamReader(System.in);
		BufferedReader in=new BufferedReader(read);
		int t=Integer.parseInt(in.readLine());
		for(int z=1;z<=t;z++)
		{
		    String s=in.readLine();
		    int i,j;
		    i=0;
		    String str="";
		    while(i<s.length())
		    {
		        if(s.charAt(i)=='1')
		        {
		            str=str+"(1";
		            if(i!=(s.length()-1) && s.charAt(i+1)=='1')
		            {
		                while(s.charAt(i+1)=='1')
		                {
		                    str=str+"1";
		                    i++;
		                }
		                str+=")";
		            }
		            else
		            {
		                str=str+")";
		            }
		        }
		        else
		        str=str+"0";
		        i++;
		    }
	
		    System.out.println("Case #"+z+": "+str);
		}
	}
}
