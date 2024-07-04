import java.util.*;
class activity
    {
        int start;
        int end;
        activity(int s,int e)
        {
            start=s;
            end=e;
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
		String p="";
		ArrayList<Integer> js=new ArrayList<>();
		ArrayList<Integer> je=new ArrayList<>();
		ArrayList<Integer> cs=new ArrayList<>();
		ArrayList<Integer> ce=new ArrayList<>();
		js.add(a[0].start);
		je.add(a[0].end);
		p=p+"J";
		int flag=0;
		  for(int i=1;i<a.length;i++)
		  {
		    flag=0;
		  	 for(int j=0;j<js.size();j++)
			 {
			 	if((js.get(j)>a[i].start && js.get(j)>=a[i].end) || (je.get(j)<=a[i].start && je.get(j)<a[i].end))
				{
				  continue;
				}
				else
				{
					flag=1;
					break;
				}
			 }
			 if(flag==0)
			 {
			 	js.add(a[i].start);
			  je.add(a[i].end);
					p=p+"J";
			 }
			 else
			 {
			 if(cs.size()==0)
			 {
			 	cs.add(a[i].start);
			     ce.add(a[i].end);
					p=p+"C";
			 }
			 else
			 {
			 	 for(int j=0;j<cs.size();j++)
			     {
			 	if((cs.get(j)>a[i].start && cs.get(j)>=a[i].end) || (ce.get(j)<=a[i].start && ce.get(j)<a[i].end))
				{
				  continue;
				}
				else
				{
					flag=2;
					break;
				}
			    }
				if(flag==1)
				{
					cs.add(a[i].start);
			     ce.add(a[i].end);
					p=p+"C";
				}
			 }
			 }
		  }
		  if(flag!=2)
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