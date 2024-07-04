import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static Scanner scanner;

    static class Activity{
    		public Activity(int s2, int e2) {
			s = s2;
    			e = e2;
    		}
		public int s;
    		public int e;
    }
    
    public static void main(String[] args)
    {
        scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        String imposible = "IMPOSSIBLE";
    		String res = new String();
    		ArrayList<Activity> c = new ArrayList<Activity>();
    		ArrayList<Activity> j = new ArrayList<Activity>();
    		
        for (int t = 1; t <= tests; ++t)
        {
        		c.clear();
        		j.clear();
        		res = "";
        	
        		int n = scanner.nextInt();
        		

        		for (int i = 0; i < n; i++){
        			int s = scanner.nextInt();
        			int e = scanner.nextInt();
        			Activity curr = new Activity(s, e);
        			
	        		if(res != imposible) {
	        				
	        			
	        			
	        			if(isPosible(curr, c)) {
	        				c.add(curr);
	        				res = res + "C";
	        				continue;
	        			}else if(isPosible(curr, j)) {
	        				j.add(curr);
	        				res = res + "J";
	        				continue;
	        			}else {
	        				res = imposible;
	        				continue;
	        				//break;
	        			}
        			}
        		}
        		
        
        		System.out.println("Case #" + t +": " + res);
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

}
