import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class Solution {
	
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		    for (int i = 1; i <= t; ++i) {
		    	int N = in.nextInt();
		    	Interval[] interval = new Interval[N];
		     for (int k=0;k<N;k++) {
		               
		    	  interval[k]=   new Interval(in.nextInt(),in.nextInt()) ;
		              
		                	
			     }
		        Interval[] original = new Interval[N];
		        for(int r=0;r<interval.length;r++){
		        	original[r]=interval[r];
		        }
		        Arrays.sort(interval, new Sortbytime()); 
		        Map< String,Interval> hm = new HashMap< String,Interval>(); 
		        hm.put("C", interval[0]);
		        String ans="C";
		        if(interval.length>1){
		        	hm.put("J", interval[1]);
		        	ans=ans+"J";
		        }
		        boolean impossible =false;
		        for (int p = 2; p < interval.length; p++) {
		        	boolean overlap = checkOverlap(interval,p);
		        	String currentLetter = ""+ans.charAt(ans.length() - 1);
		        	if(overlap){
		        		boolean isAvailable = checkAvailability(interval,diff(currentLetter),hm, p);
		        		if(!isAvailable){
		        		
		        			impossible = true;
		        		}
		        		else{
		        			hm.put(diff(currentLetter), interval[p]);
		        			ans = ans+diff(currentLetter);
		        		}
		        	}
		        	else{
		        		ans = ans+currentLetter;
		        	}
		        }
		        if(impossible){
		        	System.out.println("Case #" + i + ": IMPOSSIBLE" );
		        }
		        else{
		        	String res="";
		        	for(int n=0;n<original.length;n++){
		        		int index = Arrays.asList(interval).indexOf(original[n]);
		        		
		        		List<Interval> originalList = new LinkedList<>(Arrays.asList(original));
		        		List<Interval> sortedList = new LinkedList<>(Arrays.asList(interval));

		        		
		        		originalList.remove(n);
		        		sortedList.remove(index);

		        		res =res+ans.charAt(index);
		        		ans.replace(""+ans.charAt(index), "");
		        	}
		        	System.out.println("Case #" + i + ": "+ res );
		        }
        	  

		    }}
	  
	  
	  
	  
	  static boolean checkOverlap(Interval[] interval,int currentPosition){
	  boolean isOverlap =false;
	 
        	if (interval[currentPosition - 1].end > interval[currentPosition].start) {
        		isOverlap =true;
        	}
       
	  return isOverlap;
  }
	  
	  static boolean checkAvailability(Interval[] interval,String currentLetter, Map< String,Interval> hm,int currentPosition){
	  boolean isAvailable =true;
	  Interval in =hm.get(currentLetter);
        	if (in.end > interval[currentPosition].start) {
        		isAvailable =false;
        	}
       
	  return isAvailable;
  }
	  
	  static String diff(String currentLetter){
	 
        	if (currentLetter.charAt(0) == 'C') {
        		return "J";
        	}
        	
        	else return "C";
  }

}

 class Interval  
{  
    int start;  
    int end; 
    public Interval(int start, int end)  
    { 
        this.start = start; 
        this.end = end; 
    }  
};

 class Sortbytime implements Comparator<Interval> 
{ 

    public int compare(Interval a, Interval b) 
    { 
        return a.start - b.start; 
    } 
}
