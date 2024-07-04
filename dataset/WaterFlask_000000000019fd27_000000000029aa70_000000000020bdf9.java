import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        
        for(int i = 1; i <= cases; ++i) {
        	StringBuilder r = new StringBuilder();
            int tasks = in.nextInt();
            List<int[]> csec = new ArrayList<>();
            List<int[]> jsec = new ArrayList<>();
            boolean impossible = false;
            boolean ret = false;
            for(int t = 0; t < tasks; ++t) {
    			int start = in.nextInt();
    			int end = in.nextInt();
    			if(impossible) {
    				continue;
    			}
    			else if(t == 0) {
    				csec.add(new int[] {start, end});
    				r.append('C');
    			}
    			else {
    				ret = true;
    				for(int k = 0; k < csec.size(); ++k) {
    					if(isOverlap(start, end, csec.get(k)[0], csec.get(k)[1])) {
    						ret = false;
    						break;
    					}
    				}
    				if(ret) {
    					csec.add(new int[] {start, end});
    					r.append('C');
    					continue;
    				}
    				ret = true;
    				for(int k = 0; k < jsec.size(); ++k) {
    					if(isOverlap(start, end, jsec.get(k)[0], jsec.get(k)[1])) {
    						ret = false;
    						break;
    					}
    				}
    				if(ret) {
    					jsec.add(new int[] {start, end});
    					r.append('J');
    				}
    				else {
    					r = new StringBuilder("IMPOSSIBLE");
    					impossible = true;
    				}
    			}
    		}
            System.out.print("Case #" + i + ":");
            System.out.println(r.toString());
        }
        in.close();
	}

	public static boolean isOverlap(int s1, int e1, int s2, int e2) {
		if(s1 <= s2 && e1 > s2) {
			return true;
		}
		if(s1 < e2 && e1 >= e2) {
			return true;
		}
		if(s1 >= s2 && e1 <= e2) {
			return true;
		}
		return false;
	}
}