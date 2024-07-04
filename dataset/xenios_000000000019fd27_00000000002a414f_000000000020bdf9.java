import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Steve Mwangi
 * 11:48:25 AM
 * 2020
 */
public class Solution {
	public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(System.in);
        String oneRow = in.nextLine();
    	String[] temp = oneRow.split(" ");
        int t = Integer.parseInt(temp[0]);
        for(int iii = 0; iii < t; iii++){
        	int x = iii+1;
        	oneRow = in.nextLine();
        	temp = oneRow.split(" ");
        	int lines = Integer.parseInt(temp[0]);
        	int start = 0;
        	int end = 0;
        	PriorityQueue<Integer> pQStarts = new PriorityQueue<Integer>();
        	Map<Integer, Integer> timesMap =  new HashMap<Integer, Integer>();
        	for(int i =0; i < lines; i++) {
        		oneRow = in.nextLine();
            	temp = oneRow.split(" ");
            	start = Integer.parseInt(temp[0]);
            	end = Integer.parseInt(temp[1]);
            	if(start != 0 && end !=0) {
            		pQStarts.add(start);
            	}
            	timesMap.put(start, end);
        	}
        	String result = processTimes(pQStarts, timesMap, lines);
        	System.out.println("Case #" + x + ": " + result);
    	}
    }
	
	public static String processTimes(PriorityQueue<Integer> pQStarts, Map<Integer, Integer> timesMap, int lines) {
		int start = pQStarts.poll();
    	int end = timesMap.get(start);
    	int previousS = -1;
    	int previousE = -1;
    	int ppS = -1;
    	int ppE = -1;
    	String result = "C";
    	String next = "";
    	int track = 0;
		while(pQStarts.size() > 0) {
			if(start == end) {
				track++;
				ppS = previousS;
		    	ppE = previousE;
		    	previousS = start;
		    	previousE = end;
				start = pQStarts.poll();
		    	end = timesMap.get(start);
	    		continue;
	    	}
	    	if(start > end) {
	    		return "IMPOSSIBLE";
	    	}
	    	next = Character.toString(result.charAt(result.length()-1));
	    	if(start < previousE && previousE > 0) {
    			if(next.equals("C")) {
    				next = "J";
    			} else {
    				next = "C";
    			}
    		} else if(previousE < 1) {
    			next ="";
    		}
	    	result = result.concat(next);
	    	ppS = previousS;
	    	ppE = previousE;
	    	previousS = start;
	    	previousE = end;
	    	start = pQStarts.poll();
	    	end = timesMap.get(start);
	    	if(ppS != -1 && ppE != -1) {
	    		if(ppE > previousS && previousE > start && ppE > start) {
	    			return "IMPOSSIBLE";
	    		}
	    	}
		}
		if(start != end) {
			next = Character.toString(result.charAt(result.length()-1));
	    	if(start < previousE) {
				if(next.equals("C")) {
					next = "J";
				} else {
					next = "C";
				}
			}
	    	result = result.concat(next);
		}
		if(track != 0) {
			result = result.substring(0, result.length()-3);
		}
		return result;
	}
}
