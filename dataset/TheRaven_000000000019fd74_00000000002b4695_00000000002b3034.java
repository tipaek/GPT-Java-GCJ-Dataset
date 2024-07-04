import java.util.*;
public class Solution {
	public static void main (String [] arg) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int ii = 1; ii<=T; ++ii) {
			//Something
			ArrayList<String> LeftA = new ArrayList<String>();
			ArrayList<String> RightA = new ArrayList<String>();
			StringBuilder middleS = new StringBuilder(2500);
			int N = sc.nextInt();
			for (int i = 0; i < N; ++i) {
				String s = sc.next();
				StringBuilder Left = new StringBuilder(50);
				StringBuilder Right = new StringBuilder(50);
				StringBuilder Middle = new StringBuilder(50);
				int j1 = 0; int j2 = 0;
				for (j1 = 0; j1<s.length() && s.charAt(j1) != '*'; ++j1) Left = Left.append(s.charAt(j1));
				for (j2 = s.length()-1; j2>=0 && s.charAt(j2) != '*'; --j2) Right = Right.append(s.charAt(j2));
				for (; j1<j2; j1++) if (s.charAt(j1) != '*') Middle = Middle.append(s.charAt(j1));
			//	System.err.println(s);
			//	System.err.println("Adding L " + Left.toString());
			//	System.err.println("Adding R " + Right.toString());
				LeftA.add(Left.toString());
				RightA.add(Right.toString());
				middleS = middleS.append(Middle.toString());
			}
			StringBuilder Lans = matches(LeftA);
			StringBuilder Rans = matches(RightA);
			String ans = middleS.toString();

			if (Lans == null || Rans == null) {
				ans = "*";
			} else {
				ans = Lans.toString() + ans + Rans.reverse().toString();
			}
			System.out.printf("Case #%d: %s\n",ii,ans);
		}
	}
	public static StringBuilder matches(ArrayList<String> A) {
		int len = 0;
		for (String s : A) if (s.length() > len) len = s.length();
		StringBuilder ans = new StringBuilder(len);
		for (int i = 0; i<len; ++i) {
			char c = 0;
			for (String s : A) {
				if (s.length() > i) {
					if (c != 0 && c != s.charAt(i)) return null;
					c = s.charAt(i);
				}
			}
			if (c != 0) ans = ans.append(c);
		}
		return ans;
	}
}
