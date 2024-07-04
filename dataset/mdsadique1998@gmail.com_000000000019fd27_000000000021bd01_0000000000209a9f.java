import java.util.Collections;
import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int a = 1;
		while(a<=t) {
			String s = scn.next();
			String str = "";
			boolean stats = false;
			for(int i = 0;i<s.length();i++) {
				int val, val2;
				val = (int)s.charAt(i)-48;
				if(i == 0) {
					str  += String.join("", Collections.nCopies(val, "("))+val;
				}
				else {
					val2 = (int)s.charAt(i-1)-48;
					if(val == val2) {
						str  += val;
					}else if(val<val2) {
						str  += String.join("", Collections.nCopies(val2-val, ")"))+val;
						stats = false;
					}else if(val>val2) {
						str  += String.join("", Collections.nCopies(val-val2, "("))+val;
						stats = false;
					}
				}
				if(i==s.length()-1) {	
					str  += String.join("", Collections.nCopies(val, ")"));
				}
			}
			System.out.println("Case #"+a+": "+str);
			a++;
		}

	}

}