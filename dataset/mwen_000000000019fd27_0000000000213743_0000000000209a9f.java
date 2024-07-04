import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		int inputs = file.nextInt();
		for(int i = 1; i <= inputs; i++) {
			String s = file.next();
			int currP = 0;
			StringBuilder ans = new StringBuilder();
			for(int j = 0; j < s.length(); j++) {
				int num = s.charAt(j)-'0';
				int diff = 0;
				char p = 0;
				if(currP < num) 
					p = '(';
				else if(currP > num) 
					p = ')';
				diff = Math.abs(currP-num);
				for(int h = 0; h < diff; h++) {
					ans.append(p);
				}
				currP = num;
				ans.append(num);
			}
			while(currP-->0) {
				ans.append(')');
			}
			System.out.println("Case #" + i + ": " + ans);
		}
		file.close();
	}

}
