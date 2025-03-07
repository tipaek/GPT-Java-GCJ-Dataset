import java.io.*;
import java.util.*;

class Data
{
    int s,e,index;
    Data(int s,int e,int i)
    {
        this.s=s;
        this.e=e;
		this.index=i;
    }
}

class SortByEnd implements Comparator<Data> 
{ 
    public int compare(Data a, Data b) 
    { 
        return a.e-b.e;
    } 
}

class Solution
{
	
	public static String solve(ArrayList<Data> a,int t)
	{
		char cr[]=new char[a.size()];
		int j[]=new int[3];
		int c[]=new int[3];
		String s="Case #"+t+": ";
		Arrays.fill(j,0);
		Arrays.fill(c,0);
		
		for(int i=0;i<a.size();i++)
		{
				int start=a.get(i).s;
				int end=a.get(i).e;
				int index=a.get(i).index;
				if(j[1]<=start)
					j[2]=0;
				if(c[1]<=start)
					c[2]=0;
				if(c[2]==1 && j[2]==1)
					return s+"IMPOSSIBLE";
				if(c[2]==0)
				{
					c[0]=start;
					c[1]=end;
					c[2]=1;
					cr[index]='C';
				}
				else
				if(j[2]==0)
				{
					j[0]=start;
					j[1]=end;
					j[2]=1;
					cr[index]='J';
				}
				
		}
		
		return s+(new String(cr));
		
	}
	
    public static void main(String agrs[]) throws Exception
    {
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int T=Integer.parseInt(br.readLine());
            for(int t=1;t<=T;t++)
            {
                int n=Integer.parseInt(br.readLine());
                ArrayList<Data> a = new ArrayList<Data>();
                for(int i=0;i<n;i++)
                {
                    String s[]=br.readLine().split(" ");
                    a.add(new Data(Integer.parseInt(s[0]),Integer.parseInt(s[1]),i));
                }
                Collections.sort(a,new SortByEnd());
				System.out.println(solve(a,t));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}