import java.util.*;
import java.io.*;
public class Solution {
	static ArrayList<Integer> best;
	
  public static void main(String[] args) {
	Integer[] numbers = {-128, -64,-32,-16,-8,-4,-2,-1,1,2,4,8,16, 32, 64, 128};
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    in.nextLine();
    for(int n = 1; n<=t; n++) {
    	int x = in.nextInt();
    	int y = in.nextInt();
    	int sum = Math.abs(x+y);
    	
    	sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),sum);
    	if(best==null) {
    		System.out.println("Case #"+n+": IMPOSSIBLE");
    	}
    	else {
    		//System.out.println("Final("+Arrays.toString(best.toArray())+")="+sum);
        	String direction = convertToString(Math.abs(x), Math.abs(y),sum);
        	//System.out.println(direction);
        	
        	if(direction.length()==0) {
        		System.out.println("Case #"+n+": IMPOSSIBLE");
        	}
        	else if(x>=0&&y>=0) {
        		System.out.println("Case #"+n+": "+direction);
        	}
        	else if(x>=0&&y<0) {
        		System.out.println("Case #"+n+": "+flipY(direction));
        	}
        	else if(x<0&&y>=0) {
        		System.out.println("Case #"+n+": "+flipX(direction));
        	}
        	else {
        		System.out.println("Case #"+n+": "+flipBoth(direction));
        	}
        	
        	//System.out.println();
    	}
    	
    }
  }
  
  static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
      int s = 0;
      for (int x: partial) s += x;
      if (s == target) {
    	 
    	  if(works(partial,target)){
    		  //System.out.println("Final("+Arrays.toString(partial.toArray())+")="+target);
    		  best = partial;
    	  }
          //System.out.println("sum("+Arrays.toString(partial.toArray())+")="+target);
      }
    	 
      if (s >= target)
           return;
      for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
      }
   }
   static void sum_up(ArrayList<Integer> numbers, int target) {
       sum_up_recursive(numbers,target,new ArrayList<Integer>());
   } 
   
   public static boolean works(ArrayList<Integer> nums,int target) {
	   for(int i = 0; i<nums.size();i++) {
		   if(Math.abs(nums.get(i))!=Math.pow(2, i)) {
			   return false;
			   
		   }
	   }
	   return true;
   }
   public static String convertToString(int x, int y, int target) {
	   Object[] objects = best.toArray(); 
	   Integer[] numbers = new Integer[best.size()];
	   int index =0;
       // Printing array of objects 
       for (Object obj : objects) {
           numbers[index++]=(Integer)obj;
       }
    	   
	   
	   String str = "";
	   ArrayList<Integer> ogBest = new ArrayList<Integer>(best);
	   for(int i = 0;i<ogBest.size();i++) {
		   //y
		   sum_upSecond(new ArrayList<Integer>(Arrays.asList(numbers)),y);
		   //System.out.println("Y("+Arrays.toString(best.toArray())+")="+y);
	    	//String direction = convertToString(x, y,sum);
		   if(best.contains(ogBest.get(i))){
			   if(ogBest.get(i)<0) {
				   str+="S";
			   }
			   else {
				   str+="N";
			   }
		   }
		   //x
		   else{
			   if(ogBest.get(i)<0) {
				 str+="W";
			   }
			   else {
				   str+="E";
			   }
			   
		   }
		   
	   }   
	   return str;
   }
   
   static void sum_up_recursiveSecond(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
	      int s = 0;
	      for (int x: partial) s += x;
	      if (s == target) {
	    	 
	    		  //System.out.println("Final("+Arrays.toString(partial.toArray())+")="+target);
	    		  best = partial;

	          //System.out.println("YUH("+Arrays.toString(partial.toArray())+")="+target);
	      }
	    	 
	      if (s >= target)
	           return;
	      for(int i=0;i<numbers.size();i++) {
	            ArrayList<Integer> remaining = new ArrayList<Integer>();
	            int n = numbers.get(i);
	            for (int j=i+1; j<numbers.size();j++) remaining.add(numbers.get(j));
	            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
	            partial_rec.add(n);
	            sum_up_recursiveSecond(remaining,target,partial_rec);
	      }
	   }
	   static void sum_upSecond(ArrayList<Integer> numbers, int target) {
	       sum_up_recursiveSecond(numbers,target,new ArrayList<Integer>());
	   } 
	   
	public static String flipY(String orig) {
		String flipped = "";
		for(int i = 0;i<orig.length();i++) {
			if(orig.charAt(i)=='S')flipped+="N";
			else if(orig.charAt(i)=='N')flipped+="S";
			else flipped+=orig.charAt(i);
		}
		return flipped;
	}
	
	public static String flipX(String orig) {
		String flipped = "";
		for(int i = 0;i<orig.length();i++) {
			if(orig.charAt(i)=='W')flipped+="E";
			else if(orig.charAt(i)=='E')flipped+="W";
			else flipped+=orig.charAt(i);
		}
		return flipped;
	}
	public static String flipBoth(String orig) {
		String flipped = "";
		for(int i = 0;i<orig.length();i++) {
			if(orig.charAt(i)=='S')flipped+="N";
			else if(orig.charAt(i)=='N')flipped+="S";
			else if(orig.charAt(i)=='W')flipped+="E";
			else if(orig.charAt(i)=='E')flipped+="W";
			else flipped+=orig.charAt(i);
		}
		return flipped;
	}
   
}