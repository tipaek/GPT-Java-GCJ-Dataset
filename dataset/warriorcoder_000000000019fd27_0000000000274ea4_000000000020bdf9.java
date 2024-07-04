import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
		     
		        Arrays.sort(interval, new Sortbytime()); 
		       
                  int overlaps =  findOverlaps(interval);
               
              
		            if(overlaps==0 || overlaps==1 || overlaps%2 ==1){

                            String ans="CJ";
		            	  for (int p = 2; p < interval.length; p++) {
		            		 if( interval[p - 1].end < interval[p].start){
		            			 
		            			 ans=ans+ans.charAt(ans.length() - 1);
		            		 }
		            		 else{
		            			 if( ans.charAt(ans.length() - 1) =='C'){
		            				 ans=ans+'J';
		            			 }
		            			 else{
		            				 ans=ans+'C';
		            			 }
		            		 }

		  		        }
		            	
		            	  System.out.println("Case #" + i + ": "+ ans );
		            }
		            else
		            {
		            	System.out.println("Case #" + i + ": "+ "IMPOSSIBLE" );
		            }
		      
		      
 		    }
		    
		    
		  }
	  
	  static int findOverlaps(Interval[] interval){
		  int overlaps =0;
		  for (int p = 1; p < interval.length; p++) {
	        	if (interval[p - 1].end > interval[p].start) {
	        		overlaps++;
	        	}
	        }
		  return overlaps;
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
