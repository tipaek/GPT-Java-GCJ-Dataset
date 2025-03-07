import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    static Scanner scanner;

    static class ddd implements Comparator<Activity>{



		@Override
		public int compare(Activity o1, Activity o2) {
			int res = Integer.compare(o1.s, o2.s);
			if(res == 0) {
				return Integer.compare(o1.e, o2.e);
			}
			return res;
		}
    	
    }
    
    static class Activity {
    		public Activity(int ii, int s2, int e2) {
			s = s2;
    			e = e2;
    			i = ii;
    		}
		public int s;
    		public int e;
    		public int i;

    }
    
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        String imposible = "IMPOSSIBLE";
    		String res = new String();
    		
    		

    		
        for (int t = 1; t <= tests; ++t)
        {
    		
	    		ArrayList<Activity> c = new ArrayList<Activity>();
	    		ArrayList<Activity> j = new ArrayList<Activity>();
	    		res = "";
        	
        		int n = scanner.nextInt();
        		Activity[] m = new Activity[n];
        		
        		for (int i = 0; i < n; i++){
        			int s = scanner.nextInt();
        			int e = scanner.nextInt();
        			Activity curr = new Activity(i, s, e);
        			m[i] = curr;
        			
        		}
        		
        		Arrays.sort(m, new ddd());
        		
        		
        		if (n > 2) {
        			Activity aa = m[0];
        			Activity bb = m[1];
        			Activity cc = m[2];
            		if(!isPosible(aa, bb) && !isPosible(bb, cc) && !isPosible(aa, cc)) {
            			res = imposible;
            		}
            		
            		
            		for (int i = 3; i < n; i++){
            			if(res == imposible) {
            				break;
            			}
            			aa = bb;
            			bb = cc;
            			cc = m[i];
                  	if(!isPosible(aa, bb) && !isPosible(bb, cc) && !isPosible(aa, cc)) {
                			res = imposible;
                		}
            		}
        		}

        		if(res == imposible) {
        			System.out.println("Case #" + t +": " + res);
        		}else {
        			
        		
	        		
	        		char[] r = new char[n];
	        		
	        		for (int i = 0; i < n; i++){
	        			Activity curr = m[i];
	        			
		        		if(res != imposible) {
		        				
	
		        			if(isPosible(curr, c)) {
		        				c.add(curr);
		        				r[curr.i] = 'C';
		        				continue;
		        			}else if(isPosible(curr, j)) {
		        				j.add(curr);
		        				//res = res + "J";
		        				r[curr.i] = 'J';
		        				continue;
		        			}else {
		        				res = imposible;
		        				continue;
		        				//break;
		        			}
	        			}
	        		}
	        		res = String.valueOf(r);
	        
	        		System.out.println("Case #" + t +": " + res);
        		}
        }
    }

	private static boolean isPosible(Activity curr, ArrayList<Activity> c) {
		for(int i = 0; i < c.size(); i++) {
			if(!(curr.e <= c.get(i).s || curr.s >= c.get(i).e)) {
				return false;
			}
		}
		return true;
	}

	private static boolean isPosible(Activity a, Activity b) {
		if(!(a.e <= b.s || a.s >= b.e)) {
			return false;
		}
	
		return true;
	}

	
}
