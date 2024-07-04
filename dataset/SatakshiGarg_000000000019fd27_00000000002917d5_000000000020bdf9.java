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
		    Vector<Integer> s=new Vector();
		    Vector<Integer> e=new Vector();
		    int temp[]=new int[n];
		    int check[]=new int[n];
		    for(i=0;i<n;i++)
		    {
		        String str=in.readLine();
		        String line[]=str.trim().split(" ");
		        s.add(Integer.parseInt(line[0]));
		        e.add(Integer.parseInt(line[1]));
		        check[i]=Integer.parseInt(line[1]);
		        temp[i]=0;
	
		    }
		    Arrays.sort(check);
		    int ans=1;
		    int startC=1440,endC=0,startJ=1440,endJ=0;
		    char res[]=new char[n];
		    for(i=0;i<n;i++)
		    {
		        int ind=0;
		        for(int j=0;j<e.size();j++)
		        {
		            if(e.get(j)==check[i] && temp[j]!=1)
		            ind=j;
		        }
		        if(s.get(ind)>=endJ || e.get(ind)<=startJ)
		        {
		        res[ind]='J';
		        endJ=Math.max(e.get(ind),endJ);
		        startJ=Math.min(s.get(ind),startJ);
		        temp[ind]=1;
		        }
		        else if(s.get(ind)>=endC || e.get(ind)<=startC)
		        {
		        res[ind]='C';
		        endC=Math.max(e.get(ind),endC);
		        startC=Math.min(s.get(ind),startC);
		        temp[ind]=1;
		        }
		        else
		        {
		        ans=0;
		        break;
		        }
		    }
		    if(ans!=0)
		    {
		    System.out.print("Case #"+z+": ");
		    for(i=0;i<n;i++)
		    System.out.print(res[i]);
		    System.out.println("");
		    }
		    else
		    System.out.println("Case #"+z+": "+"IMPOSSIBLE");
		}
	}
}

