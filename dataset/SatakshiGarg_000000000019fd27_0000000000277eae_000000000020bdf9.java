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
		    int n=Integer.parseInt(in.readLine());
		    int i;
		    int s[]=new int[n];
		    int e[]=new int[n];
		    for(i=0;i<n;i++)
		    {
		        String str=in.readLine();
		        String line[]=str.trim().split(" ");
		        s[i]=Integer.parseInt(line[0]);
		        e[i]=Integer.parseInt(line[1]);
		    }
		    char res[]=new char[n];
		    res[0]='C';
		    res[1]='J';
		    int startC=s[0];
		    int endC=e[0];
		    int endJ=e[1];
		    int startJ=s[1];
		    int ans=1;
		    for(i=2;i<n;i++)
		    {
		        if(s[i]>=endJ || e[i]<=startJ)
		        {
		        res[i]='J';
		        endJ=Math.max(e[i],endJ);
		        startJ=Math.min(s[i],startJ);
		        }
		        else if(s[i]>=endC || e[i]<=startC)
		        {
		        res[i]='C';
		        endC=Math.max(e[i],endC);
		        startC=Math.min(s[i],startC);
		        }
		        else
		        ans=0;
		    }
		    if(ans!=0)
		    {
		    for(i=0;i<n;i++)
		    System.out.print("Case #"+z+": "+res[i]);
		    System.out.println("");
		    }
		    else
		    System.out.println("Case #"+z+": "+"IMPOSSIBLE");
		}
	}
}
