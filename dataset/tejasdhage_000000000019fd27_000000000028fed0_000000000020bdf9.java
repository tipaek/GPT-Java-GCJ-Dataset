import java.util.*;
class CompareTimes implements Comparator<Times>
{
    public int compare(Times t1,Times t2)
    {
        if(t1.startTime<t2.startTime)
        {
            return -1;
        }
        else if(t1.startTime>t2.startTime)
        {
            return 1;
        }
        else
        {
            if(t1.endTime<t2.endTime)
            {
                return -1;
            }
            else if(t1.endTime>t2.endTime)
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}
class Times
{
    int startTime,endTime;
    public Times(int s,int e)
    {
        startTime=s;
        endTime=e;
    }
}
public class Solution {

	public static void main(String[] args) 
	{
	    boolean flag;
	    StringBuffer res;
	    ArrayList<Times> arr;
	    int T,N,i,j,k,s,e;
	    int cStart,cEnd,jStart,jEnd;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
		for(i=0;i<T;i++)
		{
		    N=sc.nextInt();
		    flag=true;
		    arr=new ArrayList<>();
		    res=new StringBuffer();
		    for(j=0;j<N;j++)
		    {
		        s=sc.nextInt();
		        e=sc.nextInt();
		        arr.add(new Times(s,e));
		    }
		    Collections.sort(arr,new CompareTimes());
		    
		    cStart=arr.get(0).startTime;
		    cEnd=arr.get(0).endTime;
		    jStart=0;
		    jEnd=0;
		    res.append('C');
		    for(j=1;j<N;j++)
		    {
		        s=arr.get(j).startTime;
		        e=arr.get(j).endTime;
		        
		        if(s>=cEnd)
		        {
		            cStart=s;
		            cEnd=e;
		            res.append('C');
		        }
		        else if(s>=jEnd)
		        {
		            jStart=s;
		            jEnd=e;
		            res.append('J');
		        }
		        else
		        {
		            flag=false;
		            break;
		        }
		    }
		    if(flag==true)
		        System.out.println("Case #"+(i+1)+": "+res);
		    else    
		        System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
		    
		}
	}

}
