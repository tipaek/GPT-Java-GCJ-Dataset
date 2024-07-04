import java.io.*;
import java.util.*;

class Solution {
	static int U;
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        int q;
        HashMap<String,Integer> testHash = new HashMap<String,Integer>();
        String current;
        String currentChar;
        String[] input;
        boolean done = false;
        String zero = "";
        String answer = "";
        int[][] toSort;
        String[] lettersUsed;
        int p;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	U = Integer.parseInt(st.nextToken());
        	testHash = new HashMap<String,Integer>();
        	input = new String[10000];
        	lettersUsed = new String[9];
        	p = 0;
        	
        	for (int j = 0; j < 10000; j++) {
        		st = new StringTokenizer(f.readLine());
        		q = Integer.parseInt(st.nextToken());
        		input[j] = st.nextToken();
        		currentChar = Character.toString(input[j].charAt(0));
        		if (testHash.containsKey(currentChar)) {
        			testHash.put(currentChar, testHash.get(currentChar)+1);
        		} else {
        			testHash.put(currentChar, 1);
        			lettersUsed[p] = currentChar;
        			p++;
        			//System.out.println("New one! "+currentChar);
        		}
        		
        	}
        	
        	int k = 0;
        	done = false;
        	while (k < 10000 && !done) {
        		current = input[k];
        		for (int l = 1; l < current.length(); l++) {
        			if (!testHash.containsKey(Character.toString(current.charAt(l)))) {
        				done = true;
        				zero = Character.toString(current.charAt(l));
        			}
        		}
        		k++;
        	}
        	
        	answer+=zero;
        	
        	toSort = new int[p][2];
        	for (int m = 0; m < p; m++) {
        		toSort[m][0] = testHash.get(lettersUsed[m]);
        		toSort[m][1] = m;
        		//System.out.println(toSort[m]);
        	}
        	
        	//Sort toSort:
        	Arrays.sort(toSort, (a,b) -> (a[0] - b[0]));
        	
        	for (int m = p-1; m >= 0; m--) {
        		answer += lettersUsed[toSort[m][1]];
        	}
        	
        	System.out.println("Case #"+(i+1)+": "+answer);
        }
    }
}