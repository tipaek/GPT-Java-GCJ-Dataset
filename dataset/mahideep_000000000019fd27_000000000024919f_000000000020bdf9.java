

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String args[]) {
		
		Scanner sc=new Scanner(System.in);
		
		int testCaseCount = Integer.parseInt(sc.nextLine());

		for(int k=0;k<testCaseCount;k++) {
			
			int N = Integer.parseInt(sc.nextLine());
		//	int arr[][] = new int[N][N];

	        Interval arr[]=new Interval[N]; 

			for (int l = 0; l < N; ++l) {

				String r = sc.nextLine();

				String row[] = r.split("\\s+");

				 arr[l]=new Interval(Integer.parseInt(row[0]),Integer.parseInt(row[1])); 

			}
			
			//System.out.println(Arrays.deepToString(arr));
			
			// sort interval on basing on end time.
	        Interval[] originalArray = arr.clone();

			Arrays.sort(arr, Interval::compareThem);

			Map<Interval,String> map=new HashMap<>();
			
			 List<Interval> set = new ArrayList<>(); 
			  
		        for (Interval t : arr) { 
		            set.add(t); 
		        } 
			
			//System.out.println(Arrays.deepToString(arr));
			
			
			
			int currentMeetingNumber=0;
			for(int i=0;i<arr.length;i++) {
				if(i==0) {
					//System.out.println("Meeting for C "+arr[currentMeetingNumber].toString());
					set.remove(arr[currentMeetingNumber]);
					map.put(arr[currentMeetingNumber], "C");
				}
				
				if(arr[currentMeetingNumber].getEnd()<=arr[i].getStart()) {
					currentMeetingNumber=i;
					set.remove(arr[i]);
					map.put(arr[i], "C");

					//System.out.println("Meeting for C "+arr[currentMeetingNumber].toString());

				}
			}
			
			//System.out.println("Map fr C"+map);
		//	System.out.println(set);
			Interval[] arrJ = new Interval[set.size()]; 
	        arrJ = set.toArray(arrJ); 
	        
			int currentMeetingNumberForJ=0;
			
			for(int i=0;i<arrJ.length;i++) {
				if(i==0) {
					//System.out.println("Meeting for J "+arrJ[currentMeetingNumberForJ].toString());
					set.remove(arrJ[currentMeetingNumberForJ]);
					map.put(arrJ[currentMeetingNumberForJ], "J");
				}
				
				if(arrJ[currentMeetingNumberForJ].getEnd()<=arrJ[i].getStart()) {
					currentMeetingNumberForJ=i;
					set.remove(arrJ[i]);
					map.put(arrJ[i], "J");

					//System.out.println("Meeting for J "+arrJ[currentMeetingNumberForJ].toString());

				}
			}
			//System.out.println("Final set"+set);
			
			if(set.isEmpty())
			
			{
				//System.out.println("Map  "+map);

			
			//System.out.println(Arrays.deepToString(arr));

		System.out.print("Case #"+(k+1)+": ");
			Arrays.stream(originalArray).forEach(f->{
				
				System.out.print(map.get(f));
				
			});
		}
			else
				System.out.println("Case #"+(k+1)+": IMPOSSIBLE");
	}
		sc.close();
		
	}
	
}

class Interval 
{ 
     Integer start,end; 
    Interval(int start, int end) 
    { 
    	
        this.start=start; 
        this.end=end; 
    }
	@Override
	public String toString() {
		return "Interval [start=" + start + ", end=" + end + "]";
	} 
    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Interval other = (Interval) obj;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		return true;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getEnd() {
		return end;
	}
	public void setEnd(Integer end) {
		this.end = end;
	}
	public static int compareThem(Interval a, Interval b) {
	    return a.getEnd().compareTo(b.getEnd());
	}
} 
