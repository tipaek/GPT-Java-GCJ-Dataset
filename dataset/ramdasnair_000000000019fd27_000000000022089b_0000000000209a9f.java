import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int x = 0; x < t; x++) {
			String s = sc.next();
			
			StringBuilder sDash = new StringBuilder();
			
			int parans = 0;
			for (int i = 0; i < s.length(); i++) {

				Integer num = Integer.valueOf(s.charAt(i) + "");

				int diff = num - parans;
				if (diff < 0) {
					for (int j = diff; j < 0; j++) {
						sDash.append(")");
						parans--;
					}
				}

				for (int j = 0; j < diff; j++) {
					sDash.append('(');
					parans++;
				}

				sDash.append(s.charAt(i));

			}
			
			for(int i=0; i < parans; i++) {
				sDash.append(")");
			}
			parans = 0;
			
			String sOut = sDash.toString();
			
			System.out.println("Case #" + (x+1) + ": " + sOut);
		}
	}
}
