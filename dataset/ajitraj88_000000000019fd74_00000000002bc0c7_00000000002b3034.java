import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k;
        int T=sc.nextInt();
	    k=1;
	    while(T-->0)
	    {
	        int N=sc.nextInt();
	        boolean flag=true;
	        String arr[]=new String[N];
	        int M=0;
	        String t="";
	        for(i=0;i<N;i++)
	        {
	            arr[i]=sc.next();
	            if(M<arr[i].length())
	            {
	                t=arr[i];
	                M=arr[i].length();
	            }
	        }
	        String ans=t.substring(1);
	        HashSet<String>set=new HashSet();
	        for(i=0;i<N;i++)
	        {
	            int len=ans.length()-1;
	            for(j=arr[i].length()-1;j>0;j--)
	            {
	                if(arr[i].charAt(j)!=ans.charAt(len))
	                {
	                    flag=false;
	                    break;
	                }
	                len--;
	            }
	        }
	        if(!flag)
	        System.out.println("Case #"+k+": *");
	        else
	        System.out.println("Case #"+k+": "+ans);
	        k++;
	    }
    }
}