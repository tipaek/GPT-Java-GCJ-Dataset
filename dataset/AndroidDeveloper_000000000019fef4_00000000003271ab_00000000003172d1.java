import java.io.File;
import java.util.*;

public class Solution {
	
	public static void main(String... args) {
		Scanner scanner = new Scanner(System.in);
    	int tests = scanner.nextInt();
    	
        for (int test = 0; test < tests; ++test) {
        	int nSlices = scanner.nextInt();
        	int nDinners = scanner.nextInt();
        	
        	long [] slices = new long[nSlices];
        	for (int i = 0; i < nSlices; i++) {
        		slices[i] = scanner.nextLong();
        	}
        	
        	int nCuts = 0;
        	
        	if (nDinners <= 1) {
        		System.out.println(String.format("Case #%d: 0", test + 1));
        		continue;
        	}
        	
        	if (nSlices == 1) {
        		nCuts = nDinners - 1;
        		System.out.println(String.format("Case #%d: %d", test + 1, nCuts));
        		continue;
        	}
        	
        	HashMap<Long, Integer> hmSlices = new HashMap<Long, Integer>();
        	Integer p;
        	Long sum = 0l;
    		for (Long piece : slices) {
    			sum += piece;
    			p = hmSlices.get(piece);
    			hmSlices.put(piece, p == null ? 1 : p + 1);
    		} 

    		boolean findFlag = false;
    		for (Map.Entry<Long, Integer> entry : hmSlices.entrySet()) {
    			if (entry.getValue() == nDinners) {
    				findFlag = true;
            		break;
    			}
    		}
    		
    		if (findFlag) {
    			System.out.println(String.format("Case #%d: 0", test + 1));
    			continue;
    		}

    		
    		if (nSlices < nDinners) {
    			Long neededSize = sum / nDinners;
    			Integer nExists = hmSlices.get(neededSize);
    			if (nExists != null) {
    				nCuts = nDinners - 1 - nExists; 
    			} else {
    				nCuts = nDinners - 1;
    			}
    			System.out.println(String.format("Case #%d: %d", test + 1, nCuts));
    			continue;
    		}
    		
   		
    		if (nSlices >= nDinners) {
	    		int maxExisted = 0;
	    		for (Map.Entry<Long, Integer> entry : hmSlices.entrySet()) {
	    			if (entry.getValue() > maxExisted) {
	    				maxExisted = entry.getValue();
	    			}
	    		}
	    		
	    		nCuts = nDinners - maxExisted;
	    		System.out.println(String.format("Case #%d: %d", test + 1, nCuts));
	    		continue;
    		}
        	
        }
	}

}