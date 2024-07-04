import java.util.Arrays; 
import java.util.*; 

class Interval 
{ 
	int start,end; 
	
	Interval(int start, int end) 
	{ 
		this.start=start; 
		this.end=end; 
	} 
} 

public class MergeOverlappingIntervals { 
	
	public static String mergeIntervals(Interval arr[]) 
	{ 
		Arrays.sort(arr,new Comparator<Interval>(){ 
			public int compare(Interval i1,Interval i2) 
			{ 
				return i1.start - i2.start; 
			} 
		}); 
	    String s="C";

		for (int i=1; i<arr.length; i++) 
		{ 
		    int flag=0;
			// If this is not first Interval and overlaps 
			// with the previous one 
			if (arr[i-1].end > arr[i].start) 
			{ 
			    s+="J";
			    if(i>1 && i<=arr.length-1  && arr[i-2].end>arr[i].start)
			     {s="IMPOSSIBLE";break;}
				flag=1;
			} 
			else { 
			    
			    flag=0;
			    s+="C";
			}
			
		} 
		return s;
		// Now arr[0..index-1] stores the merged Intervals 

	} 

	// Driver Code 
	public static void main(String args[]) { 
		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		for(int x=0;x<test;x++){
		 int n=sc.nextInt();    
		 Interval arr[]=new Interval[n];
		 for(int i=0;i<n;i++){
		     int i1=sc.nextInt();
		     int i2=sc.nextInt();
		    arr[i]=new Interval(i1,i2);
		     
		 }
		String s=mergeIntervals(arr); 
		System.out.println("Case #"+(x+1)+": "+s);
		}

		 
	} 
} 

