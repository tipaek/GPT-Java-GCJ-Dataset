import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class Sort implements Comparator<Solution> 
{ 
    
    public int compare(Solution a, Solution b) 
    { 
        return a.start-b.start; 
    } 
} 

public class Solution {
	
	public int start;
	public int last;
	public int idx;
	
	
	
	public Solution(int start, int last, int idx) {
		super();
		this.start = start;
		this.last = last;
		this.idx = idx;
	}

	

	public static void main(String[] args) {
		int T;
		Scanner scn=new Scanner(System.in);
		T=scn.nextInt();
		for(int t=1;t<=T;t++)
		{
			int n,s,l;
			n=scn.nextInt();
			Solution[] object=new Solution[n];
			for(int i=0;i<n;i++)
			{
				s=scn.nextInt();
				l=scn.nextInt();
				object[i]=new Solution(s,l,i);
			}
			char ans[]=new char[n];
			int cc=0,jc=0;
			Arrays.sort(object,new Sort());
			cc=object[0].last;
			ans[object[0].idx]='C';
			boolean flag=true;
			for(int i=1;i<n;i++)
			{
				if(object[i].start>=cc)
	            {
					cc=object[i].last;
					ans[object[i].idx]= 'C';
	            }

	            else if(object[i].start>=jc)
	            {
	                jc=object[i].last;
	                ans[object[i].idx] ='J';
	            }
	            else
	            {
	                flag=false;
	                break;
	            }
			}
			if(flag)
			System.out.println("Case #"+t+": "+String.valueOf(ans));
		       
		    else
		    	System.out.println("Case #"+t+": "+"IMPOSSIBLE");
		        
		}
		scn.close();
	}

}
