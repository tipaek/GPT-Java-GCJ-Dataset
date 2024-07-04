import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
    // function to sort hashmap by values 
    public static HashMap<Integer, Integer> sortAscending(HashMap<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

    public static HashMap<Integer, Integer> sortDescending(HashMap<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return -(o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

    public static void main(String[] args) {
    	Scanner inp = new Scanner(System.in);
	    int cases = inp.nextInt();
	    for (int i = 0; i < cases; i++) {
			int N = inp.nextInt();
			
	        HashMap<Integer, Integer> activities = new HashMap<Integer, Integer>();
	        
	        int times[] = new int[1440];
	        int start[] = new int[1000];
	        int end[] = new int[1000];
	        char parent[] = new char[1000];
	        
	        for (int n = 0; n < N; n++) {
	        	int t1 = inp.nextInt();
	        	int t2 = inp.nextInt();
	        	start[n] = t1;
	        	end[n] = t2;
	        	activities.put(n, t1);
	        	for (int t = t1; t < t2; t++) {
	        		times[t]++;
	        	}
	        }
	        
	        boolean possible = true;
	        for (int t = 0; t < 1440; t++) {
	        	if (times[t] > 2) {
	        		possible = false;
	        		break;
	        	}
	        }
        	if (!possible) {
	 	    	System.out.println("Case #" + (i+1) + ": " + "IMPOSSIBLE");
        	} else {
        		activities = sortAscending(activities);
        		int lastActivity = -1;
        		for (Map.Entry<Integer, Integer> en : activities.entrySet()) {
	    			int activity = en.getKey();
	    			int time = en.getValue();
	    			if (time >= lastActivity) {
	    				parent[activity] = 'C';
	    				lastActivity = end[activity];
	    			}
    			}
	 	    	System.out.print("Case #" + (i+1) + ": " );
    			for (int p = 0; p < N; p++) {
    				if (parent[p] != 'C') {
    					parent[p] = 'J';
    				}
    				System.out.print(parent[p]);
				}
    			System.out.println();
        	}
	    }
        inp.close();
    }
}
