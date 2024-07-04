import java.io.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        String S;
        String newS;
        int sLength;
        int maxVal;
        int currentNum;
        boolean inGroup = false;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	S = st.nextToken();
        	newS = new String("");
        	sLength = S.length();
        	maxVal = 0;
        	currentNum = 0;
        	
        	//Find largest value
        	for (int j = 0; j < sLength; j++) {
        		//currentNum = Integer.parseInt(S.substring(j,j+1));
        		currentNum = Character.getNumericValue(S.charAt(j));
        		if (currentNum > maxVal) {
        			maxVal = currentNum;
        		}
        	}
        	
        	for (int j = maxVal; j > 0; j--) {
        		newS = new String("");
        		inGroup = false;
        		for (int k = 0; k < sLength; k++) {
        			if (S.charAt(k) != '(' && S.charAt(k) != ')') {
        				currentNum = Character.getNumericValue(S.charAt(k));
            			if (!inGroup && currentNum >= j) {
            				inGroup = true;
            				newS += '(';
            			}
            			if (inGroup && currentNum < j) {
            				inGroup = false;
            				newS += ')';
            			}
        			}
        			newS += S.charAt(k);
        		}
        		if (inGroup) {
        			newS += ')';
        		}
        		S = newS;
        		sLength = S.length();
        		//System.out.println(newS);
        	}
        	
        	if (maxVal == 0) {
        		newS = S;
        	}
        	
        	System.out.println("Case #"+(i+1)+": "+newS);
        }
        f.close();
    }
}