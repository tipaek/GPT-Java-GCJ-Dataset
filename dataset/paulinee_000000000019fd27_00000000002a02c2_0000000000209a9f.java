import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int tt = kb.nextInt();
		for(int t = 0; t < tt; t++) {
			String str = kb.next();
			int level = 0;
			String ans = "";
			for(int i = 0; i < str.length(); i++) {
				int val = str.charAt(i) - '0';
				while(level < val) {
					ans+="(";
					level++;
				}
				while(level > val) {
					ans+=")";
					level--;
				}
				if(level == val) {
					ans+=val;
				}

		//		System.out.println(level);
			}
			while(level > 0) {
				ans+=")";
				level--;
			}
			System.out.println("Case #"+(t+1)+": "+ans);
		}
	}
}
