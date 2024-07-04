import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {



    static Scanner scanner;

    public String addChar(String str, char ch, int position) {
        return str.substring(0, position) + ch + str.substring(position);
    }
    
    static class Activity{
    		public Activity(int s2, int e2) {
			// TODO Auto-generated constructor stub
    			s = s2;
    			e = e2;
    		}
		public int s;
    		public int e;
    }
    
    public static void main(String[] args)
    {
//        try {scanner = new Scanner(new File("list.in.txt"));} catch (FileNotFoundException e) {return;}
        scanner = new Scanner(System.in);

        int tests = scanner.nextInt();
        String imposible = "IMPOSSIBLE";
    		String res = new String();
        for (int t = 1; t <= tests; ++t)
        {

        		res = "";
        	
        		int n = scanner.nextInt();
        		
        		ArrayList c = new ArrayList<Activity>();
        		ArrayList j = new ArrayList<Activity>();
        		
        		int currS = 0, currE = 0;
        		for (int i = 0; i < n; i++){
        			int s = scanner.nextInt();
        			int e = scanner.nextInt();
        			Activity curr = new Activity(s, e);
        			
        			if(isPosible(curr, c)) {
        				c.add(curr);
        				res = res + "C";
        				
        			}else if(isPosible(curr, j)) {
        				j.add(curr);
        				res = res + "J";
        			}else {
        				res = imposible;
        				break;
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
