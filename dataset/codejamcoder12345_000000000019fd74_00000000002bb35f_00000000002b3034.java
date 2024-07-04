import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int t = in.nextInt();
	for (int caseNum = 1; caseNum <= t; caseNum++) {
	    int n = in.nextInt();
	    String[] patterns = new String[n];
	    for (int lineNum = 0; lineNum < n; lineNum++) {
		patterns[lineNum] = in.next();
	    }
	    int bNum = 0;
	    int bInd = -1;
	    int eNum = 0;
	    int eInd = -1;
	    for (int i = 0; i < n; i++) {
		int loc = patterns[i].indexOf('*');
		if (loc > bNum) {
		    bNum = loc;
		    bInd = i;
		}
		int len = patterns[i].length();
		if (len - loc - 1 > eNum) {
		    eNum = len - loc - 1;
		    eInd = i;
		}
	    }
	    // Case 1: * is always at the start
	    if (bInd == -1) {
		String result = patterns[eInd].substring(1);
		// DEBUG
		// System.out.println(result);
		boolean valid = true;
		for (int i = 0; i < n; i++) {
		    if (i == eInd)
			continue;
		    String rest = patterns[i].substring(1);
		    if (!result.startsWith(rest, result.length() - rest.length())) {
			valid = false;
		    }
		}
		if (valid) {
		    System.out.println("Case #" + String.valueOf(caseNum) + ": " + result);
		}
		else {
		    System.out.println("Case #" + String.valueOf(caseNum) + ": *");
		}
	    }
	    // Case 2: * is always at the end
	    else if (eInd == -1) {
		String result = patterns[bInd].substring(0, bNum);
		// DEBUG
		// System.out.println(result);
		boolean valid = true;
		for (int i = 0; i < n; i++) {
		    if (i == bInd)
			continue;
		    String rest = patterns[i].substring(0, patterns[i].length() - 1);
		    if (!result.startsWith(rest)) {
			valid = false;
		    }
		}
		if (valid) {
		    System.out.println("Case #" + String.valueOf(caseNum) + ": " + result);
		}
		else {
		    System.out.println("Case #" + String.valueOf(caseNum) + ": *");
		}
	    }
	    // Case 3: * in the middle of at least some strings
	    else {
		String result = patterns[bInd].substring(0, bNum) + patterns[eInd].substring(patterns[eInd].length() - eNum);
		// DEBUG
		// System.out.println(result);
		boolean valid = true;
		for (int i = 0; i < n; i++) {
		    int loc = patterns[i].indexOf('*');
		    String begin = patterns[i].substring(0, loc);
		    String end = patterns[i].substring(loc + 1);
		    if (!result.startsWith(begin)) {
			// DEBUG
			// System.out.println(String.valueOf(i) + " fails first test");
			valid = false;
		    }
		    if (!result.startsWith(end, result.length() - end.length())) {
			// DEBUG
			// System.out.println(String.valueOf(i) + " fails second test");
			valid = false;
		    }
		}
		if (valid) {
		    System.out.println("Case #" + String.valueOf(caseNum) + ": " + result);
		}
		else {
		    System.out.println("Case #" + String.valueOf(caseNum) + ": *");
		}
	    }
	}
    }
}
