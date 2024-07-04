import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in))); 
		int T = in.nextInt();

		for (int t=0; t<T; t++) {
			String S = in.next();
			String res = "";
			int cur = 0;
			for (int i=0; i<S.length(); i++) {
				int next = Integer.parseInt(S.substring(i,i+1));
				if (cur < next)
					for (int j=0; j<next-cur; j++)
						res += "(";
				if (cur > next)
					for (int j=0; j<cur-next; j++)
						res += ")";
				res += next;
				cur = next;
			}
			for (int j=0; j<cur; j++)
				res += ")";			
			System.out.println("Case #"+(t+1)+": "+res);
		}
		in.close();
	}
}
