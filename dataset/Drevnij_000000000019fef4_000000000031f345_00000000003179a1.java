
import java.util.*;
import java.io.*;

public class Solution {
	  public static void main(String[] args) {
		    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		    
		    int t = in.nextInt();  
		    for (int xx = 1; xx <= t; xx++) {
		    	int u = in.nextInt();  
		    	
		    	Map<Character, Integer> map = new HashMap<>();
		    	int[] count = new int[10];
		    	
		    	int cur=0;
		    	for (int i=0; i<10000; i++) {
		    		long m = in.nextLong();
		    		String s = in.next();
		    		for (int j=0; j<s.length(); j++) {
		    			char c = s.charAt(j);
		    			int index=cur;
		    			if (map.containsKey(c)) index = map.get(c);
		    			else {
		    				map.put(c, cur);
		    				cur++;
		    			}
		    			count[index]++;
		    		}
		    	}
		    	
		    	Map<Integer,Character> charCount = new HashMap<>();
		    	List<Integer> counts = new ArrayList<>();
		    	for (Map.Entry<Character, Integer> e : map.entrySet()) {
		    		charCount.put(count[e.getValue()],e.getKey());
		    		counts.add(count[e.getValue()]);
		    	}
		    	Collections.sort(counts);
		    	
		    	
		    	String result = ""+charCount.get(counts.get(0));
		    	for (int i=9; i>0; i--) result = result+charCount.get(counts.get(i));
		    	
		    	System.out.println("Case #"+ xx+": "+result);

		    }
		}
	  

	  

}