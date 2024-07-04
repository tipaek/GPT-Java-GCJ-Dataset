import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
 public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc=new Scanner(System.in);
		int t1=sc.nextInt();
		int casee=1;
		while(t1-->0)
		{
		    int n=sc.nextInt();
		    String a[][]=new String[n][2];
		    int p=0;
		    int max1=0,max2=0,pos1=-1,pos2=-1;
		    for(int i=0;i<n;i++)
		    {
		        String s=sc.next();
		        s=" "+s+" ";
		        p=0;
		        a[i][0]="";
		        a[i][1]="";
		        for(int j=0;j<s.length();j++)
		        {
		            if(s.charAt(j)!='*')
		            {
		                a[i][p]=a[i][p]+s.charAt(j);
		            }
		            else
		            {
		                //System.out.println(a[i][p]);
		            p++;
		            }
		        }
		        if(a[i][0].length()>max1)
		        {
		            max1=a[i][0].length();
		            pos1=i;
		        }
		        if(a[i][1].length()>max2)
		        {
		            max2=a[i][1].length();
		            pos2=i;
		        }
		    }
		    String str1=a[pos1][0];
		    String str2=a[pos2][1];
	
		    int fwd=0,bkd=0,coun=0;
		    
		    for(int i=0;i<n;i++)
		    {
		        fwd=0;bkd=0;
		        for(int j=1;j<=str1.length();j++)
		        {
		            String str3=str1.substring(0,j);
		            if(str3.equals(a[i][0]))
		            {
		                fwd=1;
		            }
		        }
		        for(int j=0;j<str2.length();j++)
		        {
		            String str3=str2.substring(j,str2.length());
		            if(str3.equals(a[i][1]))
		            {
		                bkd=1;
		            }
		        }
		        
		        if(fwd==1 && bkd==1)
		        coun++;
		    }
		    if(coun==n)
		    System.out.println("Case #"+casee+": "+str1.substring(1,str1.length())+str2.substring(0,str2.length()-1));
		    else
		    System.out.println("Case #"+casee+": "+"*");
		    casee++;
		    
		}
	}
}