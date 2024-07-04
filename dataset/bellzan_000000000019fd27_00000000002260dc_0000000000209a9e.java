import java.util.*;
import java.io.*;

public class Solution {
    public static BufferedReader f;
    public static StringTokenizer st;
    //public static PrintWriter out;
    public static String readIn;
    public static int checkCounter = 0;
    public static int B;
    public static int[] currentBits;
    public static int checkBit(int bitNum) throws IOException {
    	int toReturn;
    	System.out.println(bitNum);
    	System.out.flush();
    	st = new StringTokenizer(f.readLine());
    	readIn = st.nextToken();
    	try {
    		toReturn = Integer.parseInt(readIn);
    	}
    	catch (java.lang.NumberFormatException ex){
    		toReturn = -1;
    		//out.println(bitNum);
    	}
    	checkCounter++;
    	/*for (int q = 1; q < B+1; q++) {
    		System.out.print(currentBits[q]);
    	}
    	System.out.println();*/
    	//out.println(checkCounter);
    	return toReturn;
    };
    public static void main (String[] args) throws IOException {
    	f = new BufferedReader(new InputStreamReader (System.in));
    	//out = new PrintWriter(new BufferedWriter(new FileWriter("esab.out")));
        st = new StringTokenizer(f.readLine());
        int T = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        String verdict;
        
        String toSend;
        String finalAnswer;
        boolean foundBothTypes;
        int type1Tester;
        int type2Tester;
        boolean foundAll;
        int[] bitTypes;
        int extra;
        for (int i = 0; i < T; i++) {
        	checkCounter = 0;
        	foundBothTypes = false;
        	foundAll = false;
        	type1Tester = -1;
        	type2Tester = -1;
        	currentBits = new int[B+1];
        	for (int k = 0; k < B+1; k++) {
        		currentBits[k] = -1;
        	}
            bitTypes = new int[B+1];
            
        	//First set of 10:
            currentBits[1] = checkBit(1);
            if (currentBits[1] == -1) {
            	//out.println("#1");
            	//out.close();
            	return;
            }
            currentBits[B] = checkBit(B);
            if (currentBits[B] == -1) {
            	//out.println("#2");
            	//out.close();
            	return;
            }
        	if (currentBits[1] == currentBits[B]) {
        		bitTypes[1] = 1;
        		bitTypes[B] = 1;
        		type1Tester = 1;
        	} else {
        		bitTypes[1] = 2;
        		bitTypes[B] = 2;
        		type2Tester = 1;
        	}
        	
        	//Bad if k too big for B?
        	for (int k = 2; k < 6; k++) {
        		currentBits[k] = checkBit(k);
                if (currentBits[k] == -1) {
                	//out.println("#3");
                	//out.close();
                	return;
                }
        		/*if (k > B || k < 1) {
        			out.println(k+" "+B);
        			out.close();
        			return;
        		}*/
            	
                currentBits[(B-k+1)] = checkBit((B-k+1));
                if (currentBits[(B-k+1)] == -1) {
                	//out.println("#4");
                	//out.close();
                	return;
                }
            	
            	if (currentBits[k] == currentBits[B-k+1]) {
            		bitTypes[k] = 1;
            		bitTypes[B-k+1] = 1;
            		if (type1Tester == -1) {
            			type1Tester = k;
            			foundBothTypes = true;
            			//out.println("Yeah!");
            		}
            	} else {
            		bitTypes[k] = 2;
            		bitTypes[B-k+1] = 2;
            		if (type2Tester == -1) {
            			type2Tester = k;
            			foundBothTypes = true;
            			//out.println("Yeah!");
            		}
            	}
        	}
        	if (B < 11) {
        		foundAll = true;
        	}
        	
        	int j = 1;
        	int newType1Tester;
        	int newType2Tester;
        	boolean needExtra = false;
        	while (j < 15 && !foundAll) {//each loop is one set of ten
        		//Change anything applicable
        		if (type1Tester != -1) {
        			newType1Tester = checkBit(type1Tester);
                    if (currentBits[type1Tester] == -1) {
                    	//out.println("#5");
                    	//out.close();
                    	return;
                    }
                    if (checkCounter % 10 != 1) {
                    	//out.println("Oh, no!");
                    }
        			
        			if (currentBits[type1Tester] == newType1Tester) {
        				//All type 1s stay the same:
        				//Do nothing
        			} else {
        				//All type 1s change:
        				for (int k = 1; k <= B; k++) {
        					if (bitTypes[k] == 1) {
        						currentBits[k] = currentBits[k] ^ 1;//xor
        					}
        				}
        			}
        		}
        		if (type2Tester != -1) {
        			newType2Tester = checkBit(type2Tester);
                    if (currentBits[type2Tester] == -1) {
                    	//out.println("#6");
                    	//out.close();
                    	return;
                    }
        			if (currentBits[type2Tester] == newType2Tester) {
        				//All type 2s stay the same:
        				//Do nothing
        			} else {
        				//All type 2s change:
        				for (int k = 1; k <= B; k++) {
        					if (bitTypes[k] == 2) {
        						currentBits[k] = currentBits[k] ^ 1;//xor
        					}
        				}
        			}
        		}
        		if (foundBothTypes) {
        			needExtra = false;
        		} else {
        			needExtra = true;
        		}
        		
        		//Find new bits:
        		int l = j*4 + 2;
        		while (l < j*4 + 6 && !foundAll) {
        			if (l > B/2) {
        				foundAll = true;
        			} else {
        				currentBits[l] = checkBit(l);
                        if (currentBits[l] == -1) {
                        	//out.println("#7");
                        	//out.close();
                        	return;
                        }
                    	
                        currentBits[(B-l+1)] = checkBit((B-l+1));
                        if (currentBits[(B-l+1)] == -1) {
                        	//out.println("#8");
                        	//out.close();
                        	return;
                        }
                    	
                    	if (currentBits[l] == currentBits[B-l+1]) {
                    		bitTypes[l] = 1;
                    		bitTypes[B-l+1] = 1;
                    		if (type1Tester == -1) {
                    			type1Tester = l;
                    			foundBothTypes = true;
                    			//out.println("Yeah!");
                    		}
                    	} else {
                    		bitTypes[l] = 2;
                    		bitTypes[B-l+1] = 2;
                    		if (type2Tester == -1) {
                    			type2Tester = l;
                    			foundBothTypes = true;
                    			//out.println("Yeah!");
                    		}
                    	}
        			}
        			l++;
        		}
        		
        		//Do an extra if necessary
        		if (needExtra) {
        			extra = checkBit(1);
                    if (extra == -1) {
                    	//out.println("#9");
                    	//out.close();
                    	return;
                    }
        		}
        		
        		j++;
        	}
            	
            finalAnswer = "";
            for (int p = 1; p <= B; p++) {
            	finalAnswer += ""+currentBits[p];
            }
            System.out.println(finalAnswer);
            //out.println(finalAnswer);
            System.out.flush();
            
            st = new StringTokenizer(f.readLine());
            verdict = st.nextToken();
     
            if (verdict.equals("N")) {
            	//out.close();
            	return;
            }
        }
        //out.close();
    }
}