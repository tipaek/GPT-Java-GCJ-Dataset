import java.util.Scanner;

public class Solution {


	public static void main(String[] args) {
		// TODO
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		for (int i=1;i<=t;i++) {
			String s = sc.next();
			StringBuilder sb = new StringBuilder();
			int current = 0;
			for (int j=0;j<s.length();j++) {
				int next = s.charAt(j)-'0';
				if (current < next) {
					for (int k=0;k<next-current;k++) {
						sb.append('(');
					}
				} else if (current > next) {
					for (int k=0;k<current-next;k++) {
						sb.append(')');
					}
				}
				sb.append(s.charAt(j));
				current=next;
			}
			for (int k=0;k<current;k++) {
				sb.append(')');
			}
			System.out.println("Case #"+i+": "+sb);
		}
	}
	

}
