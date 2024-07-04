import java.io.*;
import java.util.*;

class Solution {
	static int N;
	static int D;
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        long T = Long.parseLong(st.nextToken());
        long[] slices;
        HashMap<Long,Integer> sliceMap;
        long[] slicesUsed;
        int p = 0;
        int needed = 0;
        for (long i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	N = Integer.parseInt(st.nextToken());
        	D = Integer.parseInt(st.nextToken());
        	slices = new long[N];
        	slicesUsed = new long[N];
        	sliceMap = new HashMap<Long,Integer>();
        	p = 0;
        	needed = 0;
        	
        	st = new StringTokenizer(f.readLine());
        	for (int j = 0; j < N; j++) {
        		slices[j] = Long.parseLong(st.nextToken());
        		if (sliceMap.containsKey(slices[j])) {
        			sliceMap.put(slices[j], sliceMap.get(slices[j])+1);
        		} else {
        			sliceMap.put(slices[j], 1);
        			//System.out.println("New one: "+slices[j]);
        			slicesUsed[p] = slices[j];
        			p++;
        		}
        	}
        	
        	if (D == 2) {
        		boolean done = false;
        		for (int j = 0; j < p; j++) {
        			//System.out.println(j+" "+p);
        			if (sliceMap.get(slicesUsed[j]) > 1) {
        				//We're done!
        				done = true;
        				needed = 0;
        			}
        		}
        		
        		if (!done) {
        			needed = 1;
        		}
        	}
        	
        	if (D == 3) {
        		boolean done = false;
        		for (int j = 0; j < p; j++) {
        			if (sliceMap.get(slicesUsed[j]) > 2) {
        				//We're done!
        				done = true;
        				needed = 0;
        			}
        		}
        		
        		if (!done) {
        			boolean done2 = false;
            		for (int j = 0; j < p; j++) {
            			if (sliceMap.get(slicesUsed[j]) > 1) {
            				//We're done!
            				done2 = true;
            				needed = 1;
            			}
            		}
            		
            		if (!done2) {
            			long current;
            			for (int j = 0; j < p; j++) {
            				for (int k = 0; k < p; k++) {
            					if (j != k && slices[j] == 2*slices[k]) {
            						needed = 1;
            						done2 = true;
            					}
            				}
            			}
            		}
            		
        			if (!done2) {
        				needed = 2;
        			}
        		}
        	}
        	
        	System.out.println("Case #"+(i+1)+": "+needed);
        }
    }
}