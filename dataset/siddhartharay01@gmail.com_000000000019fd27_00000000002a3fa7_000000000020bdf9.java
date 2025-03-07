import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.plaf.ActionMapUIResource;

 public class Solution {
	 
	private class Activity implements Comparable<Activity>{
		int start;
		int end;
		int ind;
		public Activity(int a, int b, int i)
		{
			start=a;
			end=b;
			ind = i;
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
		//Map<Integer, Character> actual = new LinkedHashMap<Integer,Character>(); 
		char []actual = new char[N];
		Activity []actArray = new Activity[N];
	     for(int i=0;i<N;i++)
	     {
	    	 Activity a = S.new Activity(Integer.parseInt(reader.next()), Integer.parseInt(reader.next()),i);
	    	 actArray[i] = a;
	    	 //actual.put(a.hashCode(), 'x');
	    	 actual[i] = 'x';
	     }
	     
	     Arrays.sort(actArray);
	     
	     ScheduleTask(actArray,N, t+1, actual);
	     
     }
     //long endT = System.currentTimeMillis();
     //System.out.println(endT-startTime);
      
	}

	private static void ScheduleTask(Activity[] actArray, int n, int t, char[] actual) {
		// TODO Auto-generated method stub
		char []schedule = new char[n];
		for(int i=0;i<n;i++)
			schedule[i] = 'x';
		
		schedule[0]= 'C';
		int i=0;
		int m=1;
			for(int j=i+1;j<n;)
			{
				if(actArray[j].start >= actArray[i].end)
				{
					if(j==m)
						m++;
					schedule[j] = 'C';
					i = j;
					j= i+1;
					continue;
				}
				j++;
			}
			if(m<n)
			{
				schedule[m] = 'J';
				for(int l=m+1;l<n;)
				{
					if(schedule[l]=='x')
					{
						if(actArray[l].start >= actArray[m].end)
						{
							schedule[l] = 'J';
							m=l;
							l=m+1;
							continue;
						}
					}
					l++;
				}
			}
			
			for(int k=0; k<n;k++)
			{
				actual[actArray[k].ind] = schedule[k];
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
				
				output += actual[k];
			}
		
		System.out.println("Case #" + t + ": " + output);
	}

}
