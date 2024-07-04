import java.io.*;
import java.util.*;
public class Solution{
    private static class Pair implements Comparable<Pair>
    {
        int start;
        int end;
        
        Pair(int a, int b)
        {
            this.start=a;
            this.end=b;
        }
        
        public int compareTo(Pair other)
        {
            if(this.start!=other.start)
            {
                return this.start-other.start;
            }
            return this.end-other.end;
        }
    }
	public static void main(String[]args) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		for(int t=0;t<tc;t++)
		{
    		int n=sc.nextInt();
    		
    		Pair[]A=new Pair[n];
    		
    		for(int i=0;i<n;i++)
    		{
    		    A[i]=new Pair(sc.nextInt(),sc.nextInt());
    		}
    		
    		int[]starting=new int[n];
    		int[]ending=new int[n];
    		
    		for(int i=0;i<n;i++)
    		{
    		    starting[i]=A[i].start;
    		    ending[i]=A[i].end;
    		}
    		Arrays.sort(starting);
    		Arrays.sort(ending);
    		
    		int total=0;
    		
    		int i=0;
    		int j=0;
    		
    		String ans="";
    		while(i<n && j<n)
    		{
    		    if(starting[i]<ending[j])
    		    {
    		        total++;
    		        i++;
    		    }
    		    else if(ending[j]<starting[i])
    		    {
    		        total--;
    		        j++;
    		        
    		    }
    		    else
    		    {
    		        i++;
    		        j++;
    		    }
    		    if(total==3)
    		    {
    		        ans="IMPOSSIBLE";
    		        break;
    		    }
    		}
    		Arrays.sort(A);
    		
    		if(!ans.equals("IMPOSSIBLE")){
    		ans=ans+"CJ";
    		
    		int cend=A[0].end;
    		int jend=A[1].end;
    		
    		i=2;
    		while(i<n)
    		{
    		    if(A[i].start>=cend)
    		    {
    		        cend=A[i].end;
    		        ans=ans+"C";
    		    }
    		    else
    		    {
    		        jend=A[i].end;
    		        ans=ans+"J";
    		    }
    		    i++;
    		}
    		}
    		System.out.println("Case #"+(t+1)+": "+ans);
    	}
    }
}