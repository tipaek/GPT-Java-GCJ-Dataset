import java.util.*;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));  
    int t = in.nextInt();
    String[] arr = new String[t];
    for(int w = 0;w<t;w++) {
    	int u = in.nextInt();
    	List<Integer> start = new ArrayList<>();
    	List<Integer> end = new ArrayList<>();
    	for(int q = 0;q<u;q++) {
    		start.add(in.nextInt());
    		end.add(in.nextInt());
    	}

		String res = "";
		String[] rest = new String[u];
    	for(int c = 0;c<u;c++) {
    		res="";
        	List<Integer> cStart = new ArrayList<>();
        	List<Integer> cEnd = new ArrayList<>();
        	List<Integer> jStart = new ArrayList<>();
        	List<Integer> jEnd = new ArrayList<>();
    	for(int i = c;i<u+c;i++) {
	    		int st = start.get(i%u);
	    		int ed = end.get(i%u);
	    		boolean cdone = true;
	    		boolean jdone = true;
	
	    		for(int a = 0;a<cStart.size()&&cdone;a++) {
	    			if((ed>cStart.get(a))&&st<cEnd.get(a)) {
	    				cdone = false;
	    			}
	    		}
	    		if(cdone) {
	    			cStart.add(st);
	    			cEnd.add(ed);
	    			rest[i%u]="C";
	    			continue;
	    		}
	    		for(int a = 0;a<jStart.size()&&jdone;a++) {
	    			if((ed>jStart.get(a))&&st<jEnd.get(a)) {
	    				jdone = false;
	    			}
	    		}
				if(jdone) {
	    			jStart.add(st);
	    			jEnd.add(ed);
					rest[i%u]="J";
	    			continue;
				}
	    		if(!cdone && !jdone) {
	    			res = "IMPOSSIBLE";
	    			break;
	    		}
	   	}
    	if(!res.equals("IMPOSSIBLE"))
    		break;
    	}
    	if(res.isEmpty())
    	for(String s:rest)
        	res+=s;
    	arr[w] = "Case #"+(w+1)+": "+res;
    }
    in.close();
    for(String s:arr)
    	System.out.println(s);
  }
}