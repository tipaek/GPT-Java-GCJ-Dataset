import java.io.*;
import java.util.*;
class Solution
{
	static String brackets[][]=new String[2][10];
	static
	{
		brackets[0][0]="";
		brackets[1][0]="";
		for(int i=1;i<10;i++)
		{
			brackets[0][i]=brackets[0][i-1]+"(";
			brackets[1][i]=brackets[1][i-1]+")";
		}
	}
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cases=1;
        while(t-->0)
        {
            String str[]=sc.next().split("");
            int min=10;
            int len=str.length;
            int i=0;
            String ans="";
            int iter=0;
            while(i<len)
            {
            	String temp="";
            	min=10;
            	while(i!=len && Integer.parseInt(str[i])!=0)
            	{
            		if(Integer.parseInt(str[i])<min)
            		{
            			min=Integer.parseInt(str[i]);
            		}
            		i++;
            	}
            	while(iter<i)
            	{
            		String check=str[iter];
            		String numS="";
            		while(iter<i && Integer.parseInt(check)==Integer.parseInt(str[iter]))
            		{
            			numS=numS+check;
            			iter+=1;
            		}
            		temp=temp+brackets[0][Integer.parseInt(check)-min]+numS+brackets[1][Integer.parseInt(check)-min];
            	}
            	if(min==10)
            		min=0;
            	ans=ans+brackets[0][min]+temp+brackets[1][min];
            	if(i!=len)
            		ans=ans+str[i];
            	i+=1;
            	iter=i;
            }
            System.out.println("Case #"+cases+": "+ans);
            cases+=1;
            
        }
    }
}