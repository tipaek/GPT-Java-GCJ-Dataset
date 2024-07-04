import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

 public class Solution {
	 
	private class Activity implements Comparable<Activity>{
		int start;
		int end;
		public Activity(int a, int b)
		{
			start=a;
			end=b;
		}
		
		public int compareTo(Activity act) {
			
			int compareQuantity = ((Activity) act).end; 
			//ascending order
			return this.end - compareQuantity;
					
		}	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long startTime = System.currentTimeMillis();
		int T = 0,N = 0;
		Scanner reader =  
                new Scanner(new InputStreamReader(System.in)); 
      
     String name = reader.next();
	T = Integer.parseInt(name);
	Solution S = new Solution();
     for(int t=0;t<T;t++)
     {
//	     reader =  
//	             new Scanner(new InputStreamReader(System.in)); 
	     String name1 = reader.next();
		N = Integer.parseInt(name1);
	     
		Activity []actArray = new Activity[N];
	     for(int i=0;i<N;i++)
	     {
	    	 Activity a = S.new Activity(Integer.parseInt(reader.next()), Integer.parseInt(reader.next()));
	    	 actArray[i] = a;
	     }
	     
	     Arrays.sort(actArray);
	     
	     ScheduleTask(actArray,N, t+1);
	     
     }
     //long endT = System.currentTimeMillis();
     //System.out.println(endT-startTime);
      
	}

	private static void ScheduleTask(Activity[] actArray, int n, int t) {
		// TODO Auto-generated method stub
		char []schedule = new char[n];
		for(int i=0;i<n;i++)
			schedule[i] = 'x';
		
		schedule[0]= 'J';
		int i=0;
		int m=1;
			for(int j=i+1;j<n;)
			{
				if(actArray[j].start >= actArray[i].end)
				{
					if(j==m)
						m++;
					schedule[j] = 'J';
					i = j;
					j= i+1;
					continue;
				}
				j++;
			}
			if(m<n)
			{
				schedule[m] = 'C';
				for(int l=m+1;l<n;)
				{
					if(schedule[l]=='x')
					{
						if(actArray[l].start >= actArray[m].end)
						{
							schedule[l] = 'C';
							m=l;
							l=m+1;
							continue;
						}
					}
					l++;
				}
			}
			
			String output = "";
			
			for(int k=0; k<n;k++)
			{
				if(schedule[k] == 'x')
				{
					output = "";
					output = "IMPOSSIBLE";
					break;
				}
				
				output += schedule[k];
			}
		
		System.out.println("Case #" + t + ": " + output);
	}

}
