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
	    boolean isImpossible = false;
	    for (int i = 0; i < N; i++) {
		boolean newSet = false;
		if (result.charAt(i) == 'X') {
		    result.setCharAt(i, 'J');
		    newSet = true;
		}
		for (int j = 0; j < N; j++) {
		    if (i == j) {
			continue;
		    }
		    if ((E[j] > S[i] && S[j] <= S[i])
			    || (E[i] > S[j] && S[i] <= S[j])
			    || (E[j] > E[i] && S[j] < E[i])
			    || (E[i] > E[j] && S[i] < E[j])
			    || (S[i] <= S[j] && E[i] >= E[j])
			    || (S[j] <= S[i] && E[j] >= E[i])) {
			if (result.charAt(j) == result.charAt(i)) {
			    if (newSet) {
				result.setCharAt(i, 'C');
			    } else {
				isImpossible = true;
			    }
			    break;
			}
		    }
		}

		if (!isImpossible) {
		    for (int j = 0; j < N; j++) {
			if (i == j) {
			    continue;
			}
			if ((E[j] > S[i] && S[j] <= S[i])
				|| (E[i] > S[j] && S[i] <= S[j])
				|| (E[j] > E[i] && S[j] < E[i])
				|| (E[i] > E[j] && S[i] < E[j])
				|| (S[i] <= S[j] && E[i] >= E[j])
				|| (S[j] <= S[i] && E[j] >= E[i])) {
			    if (result.charAt(j) == 'X') {
				if (result.charAt(i) == 'J') {
				    result.setCharAt(j, 'C');
				} else {
				    result.setCharAt(j, 'J');
				}
			    } else {
				if (result.charAt(j) == result.charAt(i)) {
				    isImpossible = true;
				    break;
				}
			    }
			}
		    }
		}
	    }
	    if (isImpossible) {
		result = new StringBuilder("IMPOSSIBLE");
	    }
	    System.out.println("Case #" + cs + ": " + result.toString());
	}
	scan.close();
    }
}