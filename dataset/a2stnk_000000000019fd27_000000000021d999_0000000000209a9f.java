import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			System.out.printf("Case #%d: ", i+1);
			solve(sc);
		}
		
		sc.close();
	}
	
	static void solve(Scanner sc) {
		
		char[] s = sc.next().toCharArray();
		
		StringBuilder ans = new StringBuilder();
		int depth = 0;
		for(int i=0; i<s.length; i++) {
			int next = s[i]-'0';
			if(next > depth) {
				for(int j=0; j<next-depth; j++) {
					ans.append("(");
				}
			}
			if(next < depth) {
				for(int j=0; j<depth-next; j++) {
					ans.append(")");
				}
			}
			ans.append(s[i]);
			depth = next;
		}
		if(0 < depth) {
			for(int j=0; j<depth; j++) {
				ans.append(")");
			}
		}
		
		System.out.println(new String(ans));
	}

}
