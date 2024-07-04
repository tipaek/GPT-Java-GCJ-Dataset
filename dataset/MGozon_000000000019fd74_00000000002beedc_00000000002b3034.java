import java.util.Scanner;
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for (int t = 1; t <= tc; t++) {
			int n = in.nextInt();
			String[] pat = new String[n];
			for (int i = 0; i < n; i++) pat[i] = in.next();
			StringBuilder front = new StringBuilder();
			StringBuilder back = new StringBuilder();
			StringBuilder mid = new StringBuilder();
			int index = 0;
			boolean[] ast = new boolean[n];
			int acount = 0;
			boolean imp = false;
			wloop:
			while (acount < n) {
				//System.out.println(acount + " " + index);
				for (int i = 0; i < n; i++) {
					if (ast[i] == false) {
						if (pat[i].charAt(index) == '*')
						{ 
							ast[i] = true;
							acount++;
						} else {
							if (front.length() != index+1) front.append(pat[i].charAt(index));
							else if (front.charAt(index) != pat[i].charAt(index)) { imp = true; break wloop; }
						}
					}
					
				}
				index++;
			}
			index = 0;
			ast = new boolean[n];
			acount = 0;
			wloop2:
			while (acount < n) {
				//System.out.println(acount + " " + index);
				for (int i = 0; i < n; i++) {
					if (ast[i] == false) {
						if (pat[i].charAt(pat[i].length()-1-index) == '*') {
							ast[i] = true;
							acount++;
						} else {
							if (back.length() != index+1) back.append(pat[i].charAt(pat[i].length()-1-index));
							else if (back.charAt(index) != pat[i].charAt(pat[i].length()-1-index)) { imp = true; break wloop2; }
						}
					}
				}
				index++;
			}
			
			for (int i = 0; i < n; i++) {
				String rem = pat[i].substring(pat[i].indexOf('*')+1);
				while (rem.indexOf('*') != -1) { mid.append(rem.substring(0, rem.indexOf('*'))); rem = rem.substring(rem.indexOf('*')+1); }
			}
			
			if (imp) System.out.println("Case #" + t + ": *");
			else System.out.println("Case #" + t + ": " + front.toString() + mid.toString() + back.reverse().toString());
		}
	}
}
