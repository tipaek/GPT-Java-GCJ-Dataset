import java.util.*;

class Solution {
	
	public static String par(String s, int l) {
		int open =0;
		String update = "";
		for (int i=0; i<l;i++) {
			int x= Character.getNumericValue(s.charAt(i));
			if (x == open) {
				update = update + Character.toString(s.charAt(i));
			}
			else if (x < open) {
				for (int j=0; j<(open-x);j++) {
					update = update + ")";
				}
				update = update + Character.toString(s.charAt(i));
				open = x;
			}
			else if (x> open) {
				for (int j=0; j<(x-open);j++) {
					update = update + "(";
				}
				update = update + Character.toString(s.charAt(i));
				open =x;
			}
		}
		if (open !=0) {
			for (int j=0; j<(open);j++) {
				update = update + ")";
			}
		}
		return update;
	}
	
	public static void main(String[] args) {
		Scanner m = new Scanner(System.in);
		int n=m.nextInt();
		for (int i=0; i<n;i++) {
			String s = m.next();
			System.out.println("Case #" + (i+1) + ": " + par(s,s.length()));
		}
	}

}
