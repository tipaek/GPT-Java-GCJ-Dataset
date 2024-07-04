import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String ag[])
    {
        Scanner sc=new Scanner(System.in);
        int i,j,k,l;
        int T=sc.nextInt();
	    l=1;
	    while(T-->0)
	    {
	        StringBuffer sb=new StringBuffer();
	        int N=sc.nextInt();
	        ArrayList<Pair> A=new ArrayList<>();
	        char[] ch=new char[N];
	        for(i=0;i<N;i++)
	        {
	            int s=sc.nextInt();
	            int f=sc.nextInt();
	            A.add(new Pair(f,s,i));
	        }
	        Collections.sort(A);
	        int count=0;
	        j=0;
	        boolean flag=true;
	        for(i=0;i<A.size();i++)
	        {
	            if(A.get(i).y>=count)
	            {
	                count=A.get(i).x;
	                ch[A.get(i).z]='C';
	            }
	            else if(A.get(i).y>=j)
	            {
	                j=A.get(i).x;
	                ch[A.get(i).z]='J';
	            }
	            else
	            {
	                flag=false;
	                break;
	            }
	        }
	        if(flag==true)
	        {
	            for(i=0;i<N;i++)
	            {
	                sb.append(ch[i]);
	            }
	            System.out.println("Case #"+l+": "+sb);
	        }
	        else
	        {
	            System.out.println("Case #"+l+": IMPOSSIBLE");
	        }
	        l++;
	    }

    }
     static class Pair implements Comparable<Pair>
	 { 
		int x; 
		int y;
		int z;
		public Pair(int a, int b,int c) 
		{	 
			x = a; 
			y = b;
			z = c;
		}
		public int compareTo(Pair P)
		{
		    if(this.y>P.y)
		    return 1;
		    if(this.y<P.y)
		    return -1;
		    if(this.x>P.x)
		    return 1;
		    return -1;
		}
	} 
}
