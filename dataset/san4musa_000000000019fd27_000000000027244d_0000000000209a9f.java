import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int caseNo = -1;
	int eachCase = 1;
	String num = null;
	StringBuffer output = new StringBuffer();

	while (sc.hasNext()) {
	    if (caseNo == -1) {
		caseNo = Integer.parseInt(sc.nextLine().trim());
		continue;
	    } 
	    num = sc.nextLine();
	    String result = "";
	    int in = -1;
	    String strIn = "";
	    int prevIn = -1;
	    for (int i = 0; i < num.length(); i++) {
		strIn = String.valueOf(num.charAt(i));
		in = Integer.parseInt(strIn);
		strIn = getModifiedStr(in, prevIn, false);
		result += strIn;
		prevIn = in;
	    }
	    if (in != 0) {
		strIn = getModifiedStr(in, prevIn, true);
		result += strIn;
	    }
	    output.append("Case #" + eachCase + ": " + result);
	    eachCase++;
	    if (eachCase > caseNo)
		break;
	    output.append("\n");
	}
	System.out.println(output.toString());
	sc.close();
    }

    private static String getModifiedStr(int in, int prevIn, boolean last) {	
	String ret = "";
	if(last) {
	    for (int i = 0; i < in; i++) {
		ret += ")";
	    }
	    return ret;
	}
	if (prevIn == -1 || prevIn == 0) {
	    for (int i = 0; i < in; i++) {
		ret += "(";
	    }
	} else if (prevIn > in) {
	    for (int i = 0; i < prevIn - in; i++) {
		ret += ")";
	    }
	} else if (prevIn < in) {
	    for (int i = 0; i < in - prevIn; i++) {
		ret += "(";
	    }
	}
	ret += in;
	return ret;
    }

}
