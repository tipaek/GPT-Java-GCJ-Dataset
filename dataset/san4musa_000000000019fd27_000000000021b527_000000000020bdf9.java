import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNo = -1;
	int eachCase = 1;
	String num = null;
	StringBuffer output = new StringBuffer();
	Integer N = null;
	while (sc.hasNext()) {
	    if (caseNo == -1) {
		caseNo = Integer.parseInt(sc.nextLine().trim());
		continue;
	    } else if (N == null) {
		num = sc.nextLine();
		N = Integer.parseInt(num.trim());
	    }
	    int C_min_S=-1, C_max_E=-1, J_min_S=-1, J_max_E=-1;
	    int inputS, inputE;
	    String result = "";
	    boolean dontTakeInput = false;
	    for (int i = 0; i < N; i++) {
		sc.hasNext();
		num = sc.nextLine().trim();
		if (dontTakeInput)
		    continue;
		inputS = Integer.parseInt(num.split(" ")[0]);
		inputE = Integer.parseInt(num.split(" ")[1]);
		if (i == 0) {
		    C_min_S = inputS;
		    C_max_E = inputE;
		    result += "C";
		    continue;
		}
		if (inputE <= C_min_S) {
		    C_min_S = inputS;
		    result += "C";
		} else if (inputS >= C_max_E) {
		    C_max_E = inputE;
		    result += "C";
		} else if (inputE <= J_min_S) {
		    J_min_S = inputS;
		    result += "J";
		} else if (inputS >= J_max_E) {
		    J_max_E = inputE;
		    result += "J";
		    if (J_min_S == -1) {
			J_min_S = inputS;
		    }
		} else {
		    result = "IMPOSSIBLE";
		    dontTakeInput = true;
		}

	    }


	    output.append("Case #" + eachCase + ": " + result);
	    eachCase++;
	    if (eachCase > caseNo)
		break;
	    output.append("\n");
	    N = null;
	}
	System.out.println(output.toString());
	sc.close();
    }

}
