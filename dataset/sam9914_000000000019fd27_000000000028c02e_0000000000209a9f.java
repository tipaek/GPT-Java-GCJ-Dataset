import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int T = scn.nextInt();
		int t = 1;
		StringBuilder y;
		boolean alt = false;
		while (t <= T) {
			String s = scn.next();
			y=new StringBuilder();
			int k=0;
			for (int i = 0; i < s.length(); i++) {
				alt = !alt;
				while (i < s.length()-1 && s.charAt(i) == s.charAt(i + 1)) {
					y.append(s.charAt(i));
					i++;
				}
				y.append(s.charAt(i));
				if (i == s.length()-1) {
					/*if (y.charAt(i)==y.charAt(i-1)) {
						
					} else {
						y.insert(k,'(');
						y.append(')');
						k=k+i;
					}*/
				} else {
					y.insert(k,'(');
					y.append(')');
					k=k+y.length();
				}
			}
			System.out.println("Case #" + t + ": " + y.toString());
			t++;
		}

	}

}
