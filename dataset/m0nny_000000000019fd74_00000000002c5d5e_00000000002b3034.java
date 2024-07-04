import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws Exception{
		try {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = sc.nextInt();
		for(int i = 1; i <= t; i++){
			int n = sc.nextInt();
			String rBeginning = ""; String rEnd = ""; String rMiddle = "";
			String res = "";
			boolean valid = true;
			for(int j = 0; j < n; j++) {
				String s = sc.next();
				String b = ""; String m = ""; String e = "";
				int aCount = 0;
				for(int k = 0; k < s.length(); k++) {
					if(s.charAt(k) == '*') aCount++;
				}
				int aIndex = 0;
				for(int k = 0 ; k < s.length(); k++) {
					char c = s.charAt(k);
					if(c == '*') {
						aIndex++;
						continue;
					}
					if(aIndex == 0) b += c;
					else if(aIndex == aCount ) e += c;
					else m += c;
				}
				rMiddle += m;
				if(b.length() > rBeginning.length()) {
					if(evaluateB(b, rBeginning)) rBeginning = b;
					else	valid = false;
				}
				else {
					if(!evaluateB(rBeginning, b)) valid = false;
				}
				if(e.length() > rEnd.length()) {
					if(evaluateS(e, rEnd)) rEnd = e;
					else	valid = false;
				}
				else {
					if(!evaluateS(rEnd, e)) valid = false;
				}
				if(!valid) break;
			}
			if(!valid) res = "*";
			else res += rBeginning + rMiddle +rEnd;
			System.out.println("Case #" + i + ": " + res);
		}
		}
		catch(Exception x){
		}
	}
	static boolean evaluateB(String large, String small) {
		for(int i = 0; i < small.length(); i++) {
			if(large.charAt(i) != small.charAt(i)) return false;
		}
		return true;
	}
	static boolean evaluateS(String large, String small) {
		int diff = large.length()-small.length();
		for(int i = 0; i < small.length(); i++) {
			if(large.charAt(diff+i) != small.charAt(i)) return false;
		}
		return true;
	}
}

