import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for (int t=1;t<=T;t++) {
			int n = in.nextInt();
			ArrayList<String> pres = new ArrayList<>();
			ArrayList<String> posts = new ArrayList<>();
			ArrayList<String> others = new ArrayList<>();
			for (int i=0;i<n;i++) {
				String s = in.next();
				
				if (!s.contains("*")) {
					pres.add(s);
					posts.add(s);
				} else {
					String[] ss = s.split("\\*");
					pres.add(ss[0]);
					posts.add(ss[ss.length-1]);
					for (int j=1;j<ss.length-1;j++)
						others.add(ss[j]);
				}
			}
			
			String maxPre = max(pres, true);
			String maxPost = max(posts, false);
			
			
			String ans = "*";
			if (maxPre != null && maxPost != null) {
				ans = maxPre;
				for (String s : others) {
					ans += s;
				}
				ans += maxPost;
			}
			
			
			System.out.printf("Case #%d: %s\n", t, ans);
		}
	}
	static String max(ArrayList<String> list, boolean pre) {
		String max = "";
		for (String s : list) {
			if (s.length() > max.length())
				max = s;
		}
		
		for (String s : list) {
			if (pre) {
				if (!max.startsWith(s))
					return null;
			} else {
				if (!max.endsWith(s))
					return null;
			}
		}
		return max;
	}
}
