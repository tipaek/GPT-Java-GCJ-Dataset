import java.io.*;
import java.util.*;

public class Solution {
    
    static final int deep = 12;
    static int targetX, targetY;
    
    public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			
			// READ----------------------------------------------------
		    targetX = s.nextInt();
		    targetY = s.nextInt();
		    
		    // SOLVE----------------------------------------------------
            char[] sol = resolve(0, 0, 0, new char[deep]);
		    
		    String res = "IMPOSSIBLE";
		    if(sol!=null)
		        res = (new String(sol)).trim();
		    
			System.out.println("Case #"+tc+": "+res);
		}

		// CLOSE----------------------------------------------------
		s.close();
	}

    private static char[] resolve(int X, int Y, int it, char[] r) {
        
        if(X==targetX && Y==targetY)
            return r;
        
        if(it>=deep)
            return null;
        
        char[] r1;
        char[] res;
        
       if(X!=targetX) {
            r1 = r.clone();
            r1[it]='E';
            res = resolve(X + (1 << it), Y, it+1, r1);
            if(res!=null)
                return res;
            
            r1 = r.clone();
            r1[it]='W';
            res = resolve(X - (1 << it), Y, it+1, r1);
            if(res!=null)
                return res;
        }
        
       if(Y!=targetY) {
            r1 = r.clone();
            r1[it]='N';
            res = resolve(X, Y + (1 << it), it+1, r1);
            if(res!=null)
                return res;
            
            r1 = r.clone();
            r1[it]='S';
            res = resolve(X, Y - (1 << it), it+1, r1);
            if(res!=null)
                return res;
        }
        
        return null;
    }
}