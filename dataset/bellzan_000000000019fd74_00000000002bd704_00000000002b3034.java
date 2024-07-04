import java.io.*;
import java.util.*;

class Solution {
	static int N;
	public static void main(String[] args) throws IOException {
    	BufferedReader f = new BufferedReader(new InputStreamReader (System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        boolean possible;
        String[][] patterns;
        int[][] startStop;
        boolean[] valid;
        String tempTotal;
        ArrayList<String> tempList;
        String temp;
        boolean done;
        ArrayList<String> outputString;
        for (int i = 0; i < T; i++) {
        	st = new StringTokenizer(f.readLine());
        	N = Integer.parseInt(st.nextToken());
        	patterns = new String[N][];
        	startStop = new int[N][2];
        	valid = new boolean[N];
        	for (int j = 0; j < N; j++) {
        		valid[j] = true;
        	}
        	possible = true;
        	outputString = new ArrayList<String>();
        	done = false;
        	
        	for (int j = 0; j < N; j++) {
        		st = new StringTokenizer(f.readLine());
        		tempTotal = st.nextToken();
        		
        		int k = 0;
        		tempList = new ArrayList<String>();
        		while (k < tempTotal.length()) {
        			temp = new String("");
        			while (k < tempTotal.length() && tempTotal.charAt(k) != '*') {
        				temp += tempTotal.charAt(k);
        				k++;
        			}
        			tempList.add(temp);
        			if (k < tempTotal.length()) {
        				tempList.add("*");
        				k++;
        			}
        		}
        		
        		patterns[j] = new String[tempList.size()];
        		for (int l = 0; l < patterns[j].length; l++) {
        			patterns[j][l] = tempList.get(l);
        		}
        		
        		startStop[j][0] = 0;
        		startStop[j][1] = patterns[j].length-1;
        	}
        	
        	for (int j = 0; j < patterns.length; j++) {
        		for (int k = 0; k < patterns[j].length; k++) {
        			//System.out.print(patterns[j][k]+" ");
        		}
        		//System.out.println();
        	}
        	
        	boolean side = false;//false = left. true = right
        	int longestAt = 0;
        	int maxFound = 0;
        	int middle = 0;
        	String current;
        	String maxResult;
        	boolean allNotValid;
        	int forAFewRounds = 0;
        	while (!done && forAFewRounds < 20) {
        		if (!side) {//left
        			//Find longest
        			longestAt = 0;
                	maxFound = 0;
                	
                	allNotValid = true;
                	for (int j = 0; j < N; j++) {
                		if (valid[j]) {
                			current = patterns[j][startStop[j][0]];
                    		if (!current.equals("*") && current.length() > maxFound) {
                    			maxFound = current.length();
                    			longestAt = j;
                    		}
                    		allNotValid = false;
                		}
                	}
                	
                	if (allNotValid) {//Awesome! We're done
                		//System.out.println("We finished!");
                		possible = true;
                		done = true;
                	} else if (maxFound == 0) {//All stars or not valid
                		for (int j = 0; j < N; j++) {
                			startStop[j][0]++;
                			if (startStop[j][0] > startStop[j][1]) {
            					valid[j] = false;
            				}
                		}
                	} else {
                		maxResult = patterns[longestAt][startStop[longestAt][0]];
                		//System.out.println(maxResult);
                		//Check if no problems:
                		for (int j = 0; j < N; j++) {
                    		if (valid[j]) {
                    			current = patterns[j][startStop[j][0]];
                    			if (current.equals("*")) {
                    				//We're just good
                    			} else {
                    				//Check if current is a substring of patterns[longestAt][startStop[longestAt][0]] (from left)
                    				if (maxResult.indexOf(current) != 0) {
                    					done = true;
                            			possible = false;
                            			j = N;
                    				} else {
                    					startStop[j][0]++;
                        				if (startStop[j][0] > startStop[j][1]) {
                        					valid[j] = false;
                        				}
                    				}
                    			}
                    		} else {//definitely problems
                    			done = true;
                    			possible = false;
                    			j = N;
                    		}
                    	}
                		if (possible) {
                			outputString.add(middle, maxResult);
                			middle++;
                		}
                	}
        		} else {//right
        			//Find longest
        			longestAt = 0;
                	maxFound = 0;
                	
                	allNotValid = true;
                	for (int j = 0; j < N; j++) {
                		if (valid[j]) {
                			current = patterns[j][startStop[j][1]];
                    		if (!current.equals("*") && current.length() > maxFound) {
                    			maxFound = current.length();
                    			longestAt = j;
                    		}
                    		allNotValid = false;
                		}
                	}
                	
                	if (allNotValid) {//Awesome! We're done
                		//System.out.println("We finished!");
                		possible = true;
                		done = true;
                	} else if (maxFound == 0) {//All stars
                		//System.out.println("All stars or not valid");
                		for (int j = 0; j < N; j++) {
                			startStop[j][1]--;
                			if (startStop[j][0] > startStop[j][1]) {
            					valid[j] = false;
            				}
                		}
                	} else {
                		maxResult = patterns[longestAt][startStop[longestAt][1]];
                		//System.out.println(maxResult);
                		//Check if no problems:
                		for (int j = 0; j < N; j++) {
                    		if (valid[j]) {
                    			current = patterns[j][startStop[j][1]];
                    			if (current.equals("*")) {
                    				//We're just good
                    			} else {
                    				//Check if current is a substring of patterns[longestAt][startStop[longestAt][0]] (from right)
                    				if (maxResult.lastIndexOf(current) != maxResult.length()-current.length()) {
                    					done = true;
                            			possible = false;
                            			j = N;
                    				} else {
                    					startStop[j][0]--;
                        				if (startStop[j][0] > startStop[j][1]) {
                        					valid[j] = false;
                        				}
                    				}
                    			}
                    		} else {//definitely problems
                    			done = true;
                    			possible = false;
                    			j = N;
                    		}
                    	}
                		if (possible) {
                			outputString.add(middle, maxResult);
                		}
                	}
        		}
        		side = !side;//Switch back and forth
        		forAFewRounds++;
        	}
        	
        	if (possible) {
        		System.out.print("Case #"+(i+1)+": ");
        		for (int j = 0; j < outputString.size(); j++) {
        			System.out.print(outputString.get(j));
        		}
        		System.out.println();
        	} else {
        		System.out.println("Case #"+(i+1)+": *");
        	}
        }
        f.close();
    }
}