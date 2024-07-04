import java.util.*;
import java.io.*;
import java.lang.*;

public class Solution{
    static boolean m1(ArrayList<Int> li,int n)
    {
        char ans[]= new char[n];
			int jf=0,cf=0;
			boolean isPos=true;
			for(int i=0;i<n;i++)
			{
				Int it = li.get(i);
				
				if(it.start>=jf)
				{
					ans[it.index]='J';
					jf=it.end;
				}
				else if(it.start>=cf)
				{
					ans[it.index]='C';
					cf=it.end;
				}
				else
				{
					isPos=false;
					break;
				}
			}
			return isPos;
    }
    static char[] m2(ArrayList<Int> li,int n)
    {
        char ans[]= new char[n];
			int jf=0,cf=0;
			boolean isPos=true;
			for(int i=0;i<n;i++)
			{
				Int it = li.get(i);
				
				if(it.start>=jf)
				{
					ans[it.index]='J';
					jf=it.end;
				}
				else if(it.start>=cf)
				{
					ans[it.index]='C';
					cf=it.end;
				}
				else
				{
					isPos=false;
					break;
				}
			}
			return ans;
    }
    public static void main(String[] args)
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int z=1;z<=t;z++)
        {
        	int n=in.nextInt();
			ArrayList<Int> li = new ArrayList<>();
			for(int i=0;i<n;++i)
			{				
				int start=in.nextInt();
				int end=in.nextInt();
				li.add(new Int(start,end,i));
			}
			Collections.sort(li,new SBS());
			char ans[]=m2(li,n);
			boolean isPos=m1(li,n);

			
			if(isPos){
				System.out.println("Case #"+z+": "+String.valueOf(ans));
			} 
			else {
				System.out.println("Case #"+z+": "+"IMPOSSIBLE");
			}
        }
    }
}
class Int
{
	int start,end,index;
	Int(int start, int end, int index)
	{
		this.start=start;
		this.end=end;
		this.index=index;
	}
}

class SBS implements Comparator<Int>
{
	public int compare(Int i1, Int i2)
	{
		return i1.start-i2.start;
	}
}