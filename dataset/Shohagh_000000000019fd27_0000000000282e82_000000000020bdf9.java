import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	int T = scan.nextInt();
    	for (int cs = 1; cs <= T; cs++) {
    	    int N = scan.nextInt();
    	    int S[] = new int[N];
    	    int E[] = new int[N];
    	    StringBuilder result = new StringBuilder();
    	    for (int i = 0; i < N; i++) {
        		S[i] = scan.nextInt();
        		E[i] = scan.nextInt();
        		result.append("X");
    	    }
    	    // first priority to Jamie then Cameron
    	    result.setCharAt(0, 'J');
    	    for (int i = 1; i < N; i++) {
        		int overlapping = 0;
        		for (int j = 0; j < i && overlapping < 2; j++) {
        		    if ((E[j] > S[i] && S[j] < S[i])
            			    || (E[j] > E[i] && S[j] < E[i])
            			    || (S[i] <= S[j] && E[i] >= E[j])) {
            			overlapping++;
            			if (result.charAt(j) == 'J') {
            			    result.setCharAt(i, 'C');
            			} else {
            			    result.setCharAt(i, 'J');
            			}
        		    }
        		}
        		if (overlapping > 1) {
        		    result = new StringBuilder("IMPOSSIBLE");
        		    break;
        		} else if (overlapping == 0) {
        		    result.setCharAt(i, 'J');
        		}
    	    }
    	    System.out.println("Case #" + cs + ": " + result.toString());
    	}
    	scan.close();
    }
}