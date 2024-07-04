import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    static Scanner scanner;

    static class comparable implements Comparator<Activity>{



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
    		
    		
    
        for (int t = 1; t <= tests; ++t)
        {
    		
        		String res = new String();
        	
        		int n = scanner.nextInt();
        		Activity[] m = new Activity[n];
        		
        		for (int i = 0; i < n; i++){
        			int s = scanner.nextInt();
        			int e = scanner.nextInt();
        			Activity curr = new Activity(i, s, e);
        			m[i] = curr;
        			
        		}
        		
        		Arrays.sort(m, new comparable());
        		

            		
            		
        		for (int i = 2; i < n; i++){

        			Activity aa = m[i-2];
        			Activity bb = m[i-1];
        			Activity cc = m[i];
              	if(!isPosible(aa, bb) && !isPosible(bb, cc) && !isPosible(aa, cc)) {
            			res = imposible;
            		}
        		}
        		

        		if(res == imposible) {
        			System.out.println("Case #" + t +": " + res);
        		}else {
        			
	        		char[] r = new char[n];
	        		Activity curr = m[0];
	        		char currChar = 'C';
	        		r[curr.i] = currChar;
	        		
	        				
	        		for (int i = 1; i < n; i++){
	        			Activity activity = m[i];
	        			
		
	        			if(isPosible(curr, activity)) {
	        				r[activity.i] = currChar;
	        				
	        			}else { 
	        				if(currChar == 'C') {
	        					currChar ='J';
	        				}else {
	        					currChar ='C';
	        				}
	        				r[activity.i] = currChar;
	        			
	        			}
	        			curr = activity;
	        			
	        		}
	        		
	        		res = String.valueOf(r);
	        		System.out.println("Case #" + t +": " + res);
        		}
        }
    }


	private static boolean isPosible(Activity a, Activity b) {
		if(!(a.e <= b.s || a.s >= b.e)) {
			return false;
		}
	
		return true;
	}

	
}
