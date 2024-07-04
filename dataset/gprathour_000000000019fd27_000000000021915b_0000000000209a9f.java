import java.util.Scanner;

public class Solution {

	private static String cal(String s) {
		if(s.isEmpty()) {
			return "";
		}
		int index = s.indexOf("0");
		String sub = "";
		if(index == 0) {
			return "0" + cal(s.substring(1));
		} else if(index > 0) {
			sub = s.substring(0, index);
		} else {
			sub = s;
		}
		String gen = "";
		char chArr[] = sub.toCharArray();
		int count = 0;
		int firstCh = Integer.parseInt(chArr[0] + "");
		
		while(count < firstCh) {
			gen += "(";
			count++;
		}
		gen += firstCh;
		
		for(int i=1; i<chArr.length; i++) {
			int n = Integer.parseInt(chArr[i] + "");
			int prev = Integer.parseInt(chArr[i - 1] + "");
			if(n == prev) {
				gen += n;
				continue;
			} else if (n > prev) {
				while(count < n) {
					gen += "(";
					count++;
				}
				gen += n;
			} else {
				while(count > n) {
					gen += ")";
					count--;
				}
				gen += n;
			}
		}
		
		while(count > 0) {
			gen += ")";
			count--;
		}
		
		if(index == -1) {
			return gen;
		} else {
			return gen + "0" + cal(s.substring(index + 1));	
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 1; i <= T; i++) {
			String s = sc.next();
			System.out.println("Case #"+i+": "+cal(s));
		}
	}
}