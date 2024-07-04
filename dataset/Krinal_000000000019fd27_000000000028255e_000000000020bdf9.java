import java.util.*;
import static java.lang.System.out;

class Solution
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
	
		for(int t=1;t<=test;t++)
		{
			int n= sc.nextInt();
			 Activity[] arr=new Activity[n];
			for(int i=0;i<n;i++)
			{
				arr[i]=new Activity(sc.nextInt(),sc.nextInt(),i);
			}
			Arrays.sort(arr,new Comparator<Activity>(){
				public int compare(Activity a,Activity b){
					int t=0;
					if(a.start>b.start)t=1;
					else if(a.start<b.start)t=-1;
					else t=0;
					return t;
			}});
			
			List<Activity> l1 = new ArrayList<>();
			List<Activity> l2 = new ArrayList<>();
			l1.add(arr[0]);
			boolean flag=false;	
			
			//for(Activity a: arr)out.println(a);
			for(int i=1;i<n;i++)
			{
				if(arr[i].start >= l1.get(l1.size()-1).end)
					l1.add(arr[i]);
				else if(l2.size()==0)l2.add(arr[i]);
				else if(l2.size()>=1 && arr[i].start>=l2.get(l2.size()-1).end)
					l2.add(arr[i]);
				else {flag=true; break;}
				}
			//out.println(l1);
			//out.println(l2);		
			if(flag){out.println("Case #"+t+": IMPOSSIBLE");continue;}
		
			char ans[] = new char[n];
			for(Activity ac : l1)
				ans[ac.index]='C';
			for(Activity ac : l2)
				ans[ac.index]='J';
			
		out.println("Case #"+t+": "+new String(ans));
		}
	}
}
class Activity 
{
	 int start;
	 int end;
	 int index;
	public Activity(int start,int end,int index){this.start=start; this.end=end;this.index=index;}
   public String toString(){
	   return start+" "+end;
   }
    
	}