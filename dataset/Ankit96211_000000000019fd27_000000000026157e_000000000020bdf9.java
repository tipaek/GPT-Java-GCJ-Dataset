import java.util.*;
class Activity
{
int start,end,index;
String par="";
}
 class Solution {
static void sort(Activity[] act)
{
	for(int i=0;i<act.length;i++)
	{
		for(int j=0;j<act.length;j++)
		{
			if(act[i].start<act[j].start)
			{
				Activity tmp=act[i];
				act[i]=act[j];
				act[j]=tmp;
			}
		}
	}
}
	public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int t=sc.nextInt();
		for(int p=0;p<t;p++)
		{
			int n=sc.nextInt();
			
			int cend=0,jend=0;
			Activity[] act=new Activity[n];
			for(int i=0;i<n;i++)
			{act[i]=new Activity();
				act[i].start=sc.nextInt();
				act[i].end=sc.nextInt();
				act[i].index=i;
			}
			
		sort(act);
		boolean flag=false;
		for(int i=0;i<n;i++)
		{
		if ((act[i].start < cend) && (act[i].start < jend))
            flag=true;
		
		else if (act[i].start >= cend)
        {
			act[i].par="C";
            cend = act[i].end;
        }
        else
        {
            
        	act[i].par="J";
            	jend = act[i].end;
	    }
		}
		for(int i=0;i<act.length;i++)
		{
			for(int j=0;j<act.length;j++)
			{
				if(act[i].index<act[j].index)
				{
					Activity tmp=act[i];
					act[i]=act[j];
					act[j]=tmp;
				}
			}
		}
		if(flag)
		{
			System.out.println("Case #"+(p+1)+": IMPOSSIBLE");
		}
		else
		{
		String s="";
		for(int i=0;i<n;i++)
		{
			s=s+act[i].par;
		}
		System.out.println("Case #"+(p+1)+": "+s);
		}
	}
		
}
}