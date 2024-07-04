import java.util.*;

class TimeStamp
{
	int start ;
	int end ;
	int index;
	public TimeStamp(int i , int j , int k)
	{
		start = i;
		end = j; 
		index = k;
	}
}
public class Solution {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int z = 0 ; z < t ; z++ )
		{
			int n = sc.nextInt();
			ArrayList<TimeStamp> list = new ArrayList<TimeStamp>();
			TimeStamp ts ;
			for(int i = 0 ; i < n ; i++ )
			{
				ts = new TimeStamp(sc.nextInt(), sc.nextInt(), (i));
				list.add(ts);
			}
			Collections.sort( list , new Comparator<TimeStamp>(){
				public int compare(TimeStamp ts1 , TimeStamp ts2)
				{
					return (ts1.start - ts2.start) ;
				}
			});
			int c_end = 0;
			int j_end = 0;
			char [] ans = new char[n];
			boolean flag = true;
			for(int i = 0 ; i< list.size() ; i++)
			{
				int start = list.get(i).start;
				int end = list.get(i).end;
				int idx = list.get(i).index;
				
				 if (start < c_end && start < j_end)
				 {
					 System.out.println("Case #" + (z+1) + ": IMPOSSIBLE");
					 flag = false;
					 break;
				 }
		         if(start >= c_end)
		         {
		           ans[idx] = 'C';
		           c_end = end ;
		         }
		         else
		         {
		        	 ans[idx] = 'J';
		            j_end = end ;
				 }
				
			}
			if(flag)
			{
				for(int i = 0 ; i < n ; i++ )
				{
					System.out.print(ans[i]);
				}
				System.out.println();
			}
			
		    
		    
		}
		sc.close();
	}

}