import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        solve();
    }

    private static void solve() {
        Scanner input = new Scanner(System.in);
        int numberT = input.nextInt();

        for (int caseNum = 1; caseNum <= numberT; caseNum++) {
            int numN = input.nextInt();
            int numK = input.nextInt();
            String[] answer = solver(numN, numK);
            System.out.println("Case #"+caseNum+": " + answer[0]);
            if (answer[0].equals("POSSIBLE")) {
            	for (int i = 0; i < numN; i++) {
                    System.out.println(answer[i + 1]);
            	}
            }
        }
    }

    private static String[] solver(int numN, int numK) {
    	int[][] resultInts = new int[numN][numN];
    	String[] results = new String[numN + 1];

    	int div = numK / numN;
    	int rem = numK % numN;
    	int remK = numK % 2;
    	int remN = numN % 2;

    	if (remN == 0) {
        	if (remK != 0) {
        		results[0] = "IMPOSSIBLE";
        		return results;
        	}
    	} else {
        	if (rem != 0) {
        		results[0] = "IMPOSSIBLE";
        		return results;
        	}
    	}

    	results[0] = "POSSIBLE";

    	if (rem == 0) {
    		int start = div;
        	for (int i = 0; i < numN; i++) {
        		if (i != 0) {
            		start++;
        		}
        		String ans = "";
        		if (start <= numN) {
            		ans = String.valueOf(start);
        		} else {
        			start = 1;
            		ans = String.valueOf(start);
        		}
    			int plus = start;
        		for (int j = 1; j < numN; j++) {
        			plus--;
        			if (plus <= 0) {
        				plus = numN;
            			ans = ans + " " + String.valueOf(plus);
        			} else {
            			ans = ans + " " + String.valueOf(plus);
        			}
        		}
        		results[i + 1] = ans;
        	}
    	} else {
    		int start = div;
        	for (int i = 0; i < numN; i++) {
        		if (i == 0) {
            		String ans = "";
            		if (start <= numN) {
                		ans = String.valueOf(start);
            		} else {
            			start = 1;
                		ans = String.valueOf(start);
            		}
        			int plus = start;
            		for (int j = 1; j < numN; j++) {
            			plus++;
            			if (plus <= numN) {
                			ans = ans + " " + String.valueOf(plus);
            			} else {
            				plus = 1;
                			ans = ans + " " + String.valueOf(plus);
            			}
            		}
            		results[i + 1] = ans;
        		} else if (i == 1) {
        			String[] preAns = results[1].split(" ");
        			String ans = preAns[1] + " " + preAns[0] + " " + preAns[3] + " " + preAns[2];
            		results[i + 1] = ans;
        		} else if (i == 2) {
        			String[] preAns = results[1].split(" ");
        			String ans = preAns[2] + " " + preAns[3] + " " + preAns[1] + " " + preAns[0];
            		results[i + 1] = ans;
        		} else if (i == 3) {
        			String[] preAns = results[1].split(" ");
        			String ans = preAns[3] + " " + preAns[2] + " " + preAns[0] + " " + preAns[1];
            		results[i + 1] = ans;
        		}
        	}
    	}
    	return results;
    }
}
