import java.io.*;
import java.util.*;

public class Solution {
    
    static int deep;
    static int targetX, targetY;
    
    public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		
		// TEST CASES----------------------------------------------------
		int TC = s.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
		    deep = 9;
		    
			// READ----------------------------------------------------
		    targetX = s.nextInt();
		    targetY = s.nextInt();
		    
		    // SOLVE----------------------------------------------------
		    char[] letters = {'E', 'W', 'N', 'S'};
		    int[] st = new int[deep+3];
		    st[0] = 0;
		    st[1] = 0;
            List<int[]> p = new ArrayList<int[]>();
            p.add(st);
            int it = -1;
            boolean found = false;
            int[] solution = null;
		    while(!found && it<deep) {
		        it++;
		        List<int[]> newP = new ArrayList<int[]>();
		        
		        for(int[] t : p) {
		            int[] r = t.clone();
		            r[it+2]=1; // mov E
		            r[0] += (1 << it);
		            if(r[0]==targetX && r[1]==targetY) {
		                solution = r;
		                found = true;
		                break;
		            }
		            newP.add(r);
		            
		            r = t.clone();
                    r[it+2]=2; // mov W
                    r[0] -= (1 << it);
                    if(r[0]==targetX && r[1]==targetY) {
                        solution = r;
                        found = true;
                        break;
                    }
                    newP.add(r);
		            
                    r = t.clone();
                    r[it+2]=3; // mov N
                    r[1] += (1 << it);
                    if(r[0]==targetX && r[1]==targetY) {
                        solution = r;
                        found = true;
                        break;
                    }
                    newP.add(r);
                    
                    r = t.clone();
                    r[it+2]=4; // mov S
                    r[1] -= (1 << it);
                    if(r[0]==targetX && r[1]==targetY) {
                        solution = r;
                        found = true;
                        break;
                    }
                    newP.add(r);
		        }
		        
		        p = newP;
		    }
		    
		    String res = "IMPOSSIBLE";
		    if(solution!=null) {
		        StringBuffer sb = new StringBuffer();
		        for (int i = 2; i < solution.length; i++) {
                    if(solution[i]>0)
                        sb.append(letters[solution[i]-1]);
                    else
                        break;
                }
		        res = sb.toString();
		    }
		        
		    
			System.out.println("Case #"+tc+": "+res);
		}

		// CLOSE----------------------------------------------------
		s.close();
	}
}