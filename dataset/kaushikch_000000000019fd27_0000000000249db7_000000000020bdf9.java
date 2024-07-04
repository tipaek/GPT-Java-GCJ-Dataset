import java.util.*;
class activity implements Comparable<activity>
    {
        int start;
        int end;
        activity(int s,int e)
        {
            start=s;
            end=e;
        }
        public int compareTo(activity a)
        {
            return this.start-a.start;
        }
    }
class Solution
{
    
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int c=0;
        while(t-->0)
        {
            c++;
            int n=sc.nextInt();
            activity a[]=new activity[n];
            for(int i=0;i<n;i++)
            {
               a[i]=new activity(sc.nextInt(),sc.nextInt());
            }
			Arrays.sort(a);
			int j=0;
			String p="";
			int c1=0;
			int flag=0;
		  for(int i=0;i<a.length;i++)
		  {
		  	if(j<=a[i].start)
			{
				p=p+"J";
				j=a[i].end;
			}
			else if(c1<=a[i].start)
			{
				p=p+"C";
				c1=a[i].end;
			}
			else
			{
				flag=1;
				break;
			}
		  }
		  if(flag==0)
		  {
		  	System.out.println("Case #"+c+": "+p);
		  }
		  else
		  {
		  	System.out.println("Case #"+c+": "+"IMPOSSIBLE");
		  }
		}
    }
}