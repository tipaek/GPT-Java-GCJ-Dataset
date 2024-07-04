import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
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
		        		int index = Arrays.asList(original).indexOf(interval[n]);
		        		res =res+ans.charAt(index);
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
	  
		        
 //                 int overlaps =  findOverlaps(interval);
 //              System.out.println(overlaps);
              
//		            if(overlaps <= 2 || overlaps%2 ==0){
//
//                            String ans="CJ";
//		            	  for (int p = 2; p < interval.length; p++) {
//		            		 if( interval[p - 1].end < interval[p].start){
//		            			 
//		            			 ans=ans+ans.charAt(ans.length() - 1);
//		            		 }
//		            		 else{
//		            			 if( ans.charAt(ans.length() - 1) =='C'){
//		            				 ans=ans+'J';
//		            			 }
//		            			 else{
//		            				 ans=ans+'C';
//		            			 }
//		            		 }
//
//		  		        }
//		            	
//		            	  
//		            	  System.out.println("Case #" + i + ": "+ ans );
//		            }
//		            else
//		            {
//		            	 System.out.println("Case #" + i + ": IMPOSSIBLE" );
//		            }
//		      
//		      
// 		    }
//		    
//		    
//		  }
//	  
//	  static int findOverlaps(Interval[] interval){
//		  int overlaps =0;
//		  for (int p = 1; p < interval.length; p++) {
//	        	if (interval[p - 1].end > interval[p].start) {
//	        		overlaps++;
//	        	}
//	        }
//		  return overlaps;
//	  }
	

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
