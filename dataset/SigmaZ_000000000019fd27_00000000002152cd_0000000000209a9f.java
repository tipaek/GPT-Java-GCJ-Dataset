import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int ts = 0; ts < tc; ts++) {
			String str = in.next();
			System.out.print("Case #" + (ts + 1) + ": ");
			int t = 0;
			for(int i = 0; i < str.length(); i++) {
				int s = str.charAt(i) - '0', l = Math.abs(s - t);
				char ch = s > t ? '(' : ')';
				while(l-- > 0)
					System.out.print(ch);
				System.out.print(s);
				t = s;
			}
			while(t-- > 0)
				System.out.print(")");
			System.out.println();
		}
		in.close();

	}

}
