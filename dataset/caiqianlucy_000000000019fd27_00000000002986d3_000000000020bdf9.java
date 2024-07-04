import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) {
		//System.out.println("Please Provide input: ");
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = Integer.valueOf(in.nextLine());
        for (int k = 1; k <= t; k++) {
        	int n = Integer.valueOf(in.nextLine());
        	//System.out.println(n);
        	List<int[]> c = new ArrayList();
        	List<int[]> j = new ArrayList();
        	StringBuilder res = new StringBuilder();
        	for (int i = 0; i < n; i++) {
        		String[] cur = in.nextLine().split("\\s");
        		int start = Integer.parseInt(cur[0]);
        		int end = Integer.parseInt(cur[1]);
        		//System.out.println(start + " " + end);
        		int[] time = new int[] {start, end};
        		if (canInsert(c, time)) {
        			//System.out.println("C true");
        			res.append('C');
        		} else {
        			if (!canInsert(j, time)) {
            			res = new StringBuilder("IMPOSSIBLE");
            			//System.out.println(res.toString());
            			break;
            		} else {
            			//System.out.println("J true");
            			res.append('J');
            		}
        		}		
        	}
        	//System.out.print("//t");
        	System.out.println("Case #" + k + ": " + res.toString());
        }
	}
	public static boolean canInsert(List<int[]> list, int[] cur) {
		if (list.size() == 0) {
			list.add(new int[] {cur[0], cur[1]});
			return true;
		}
		int start = cur[0], end = cur[1];
		for (int i = 0; i < list.size(); i++) {
			int[] next = list.get(i);
			if (start < next[0]) {
				if (end < next[0]) {
					list.add(i, new int[] {start, end});
					return true;
				} else {
					if (end == next[0]) {
						list.remove(i);
						list.add(i, new int[]{start, next[1]});
						return true;			
					} else {
						return false;
					}
				}
			} else {
				if (start < next[1]) {
					return false;
				}
			}
		}
	    int[] last = list.get(list.size()-1);
	    if (last[1] == start) {
	    	list.remove(list.size()-1);  
	    	list.add(list.size(), new int[]{last[0], end});
	    	return true;
	    } 
	    list.add(list.size(), new int[]{start, end});
		return true;
	}
}