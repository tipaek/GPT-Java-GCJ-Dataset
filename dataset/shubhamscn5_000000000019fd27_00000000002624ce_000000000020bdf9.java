import java.io.*;
import java.util.*;
public class Solution
{
	static class compareEnd implements Comparator<obj>
	{
		public int compare(obj a,obj b)
		{
			return a.y-b.y;
		}
	}
	static class compareIndex implements Comparator<obj>
	{
		public int compare(obj a,obj b)
		{
			return a.index-b.index;
		}
	}
	static class obj
	{
		int x;
		int y;
		int index;
		String person;
		obj(int x,int y,int index)
		{
			this.x=x;
			this.y=y;
			this.index=index;
		}
	}

    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cases=1;
        while(t-->0)
        {
            int n=sc.nextInt();
            obj schedule[]=new obj[n];
            int schIndex=0;
            PriorityQueue<obj> pq1=new PriorityQueue<obj>(1,new compareEnd());
            PriorityQueue<obj> pq2=new PriorityQueue<obj>(1,new compareEnd());
            PriorityQueue<obj> pq3=new PriorityQueue<obj>(1,new compareIndex());
            boolean validate=true;
            for(int i=0;i<n;i++)
            {
            	int x=sc.nextInt();
            	int y=sc.nextInt();
            	pq1.add(new obj(x,y,i));
            }
            while(pq1.size()!=0)
            {
            	obj temp=pq1.poll();
            	while(pq1.size()!=0 && pq1.peek().x<temp.y)
            	{
            		pq2.add(pq1.poll());
            	}
            	temp.person="C";
            	schedule[schIndex]=temp;
            	schIndex+=1;
            }
            while(pq2.size()!=0)
            {
            	obj temp=pq2.poll();
            	if(pq2.size()!=0 && pq2.peek().x<temp.y)
            	{
            		validate=false;
            		break;
            	}
            	temp.person="J";
            	schedule[schIndex]=temp;
            	schIndex+=1;
            }
            String ans="";
            if(validate==true)
            {
            	Arrays.sort(schedule,new compareIndex());

            	for(int i=0;i<n;i++)
            	{
            		ans=ans+schedule[i].person;
            	}
            	System.out.println("Case #"+cases+": "+ans);
            }
            else
            {
            	System.out.println("Case #"+cases+": "+"IMPOSSIBLE");
            }
            cases+=1;

        }
    }
}