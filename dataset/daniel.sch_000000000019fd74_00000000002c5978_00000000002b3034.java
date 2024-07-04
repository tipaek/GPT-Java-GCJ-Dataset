import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Solution {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numberInstances;
		try {
			numberInstances = Integer.parseInt(br.readLine());
		    for (int i = 1; i <= numberInstances; ++i) {
		    	boolean impossible = false;
		    	StringBuilder sb= new StringBuilder();
		    	String[] arguments = br.readLine().split(" ");
		    	int number = Integer.parseInt(arguments[0]);
		    	char[][] allPatterns = new char[number][];
		    	int[] currentLeft = new int[number];
		    	int[] currentRight = new int[number];
		    	
		    	for (int j = 1; j<=number; j++) {
		    		allPatterns[j-1] = br.readLine().toCharArray();
		    		currentRight[j-1] = allPatterns[j-1].length-1;
		    	}
		    	//search from left
		    	boolean done = false;
		    	while (! done) {
		    		done = true;
		    		for (int j=0; j<number; j++) {
		    			if (allPatterns[j][currentLeft[j]]!='*') {
		    				done = false;
		    				char added = allPatterns[j][currentLeft[j]];
		    				sb.append(allPatterns[j][currentLeft[j]]);
		    				for (int k=0; k<number; k++) {
		    					if (allPatterns[k][currentLeft[k]]!='*' && allPatterns[k][currentLeft[k]]!=added) {
		    						impossible = true;
		    						break;
		    					}
		    					if (allPatterns[k][currentLeft[k]]!='*') {
		    						currentLeft[k] ++;
		    					}
		    				}
		    				break;
		    			}
		    		}
		    		if (impossible) break;
		    	}
		    	
		    	//System.out.println("rigth!!");
		    	
		    	//search from right
		    	done = false;
		    	StringBuilder tailOfString = new StringBuilder();
		    	while (! done) {
		    		done = true;
		    		for (int j=0; j<number; j++) {
		    			if (allPatterns[j][currentRight[j]]!='*') {
		    				done = false;
		    				char added = allPatterns[j][currentRight[j]];
		    				tailOfString.insert(0, allPatterns[j][currentRight[j]]);
		    				for (int k=0; k<number; k++) {
		    					if (allPatterns[k][currentRight[k]]!='*' && allPatterns[k][currentRight[k]]!=added) {
		    						impossible = true;
		    						break;
		    					}
		    					if (allPatterns[k][currentRight[k]]!='*') {
		    						currentRight[k] --;
		    					}
		    				}
		    				break;
		    			}
		    		}
		    		if (impossible) break;
		    	}
		    	
		    	
		    	//add middle parts
		    	for (int j=0; j< number; j++) {
		    		while (currentLeft[j]!= currentRight[j]) {
		    			if (allPatterns[j][currentLeft[j]] == '*') {
		    				currentLeft[j] ++;
		    			}
		    			else {
		    				sb.append(allPatterns[j][currentLeft[j]]);
		    					currentLeft[j] ++;
		    			}
		    		}
		    	}
		    	
		    	//System.out.println(java.util.Arrays.toString(allPatterns[0]));
		    	if (impossible) System.out.println("Case #" + i + ": *");
		    	else System.out.println("Case #" + i + ": " + sb.toString() + tailOfString.toString());

		    }
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
	
}
