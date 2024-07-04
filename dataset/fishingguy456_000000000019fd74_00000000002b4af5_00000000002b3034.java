import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Solution sup = new Solution();
		int hello = sc.nextInt();
		for(int ooo = 0; ooo < hello; ooo++) {
			int n = sc.nextInt();
			word[] s = new word[n];
			for(int i = 0; i < n; i++) {
				String s1 = sc.next();
				s[i] = sup.new word(s1, s1.length());
			}Arrays.sort(s);
			boolean flag = true;
			String s4 = s[n-1].s;
			if(s4.substring(0, 1).equals("*")) {
				s4 = s4.substring(1);
			}			
			p:
			for(int i = 0; i < n-1; i++) {
				String s2 = s[i].s;
				String s3 = s[i+1].s;
				if(s2.substring(0, 1).equals("*")) {
					s2 = s2.substring(1);
				}if(s3.substring(0, 1).equals("*")) {
					s3 = s3.substring(1);
				}if(!s3.substring(s3.length()-s2.length()).equals(s2)) {
					flag = false;
					break p;
				}
			}if(flag)System.out.println("Case #"+(ooo+1)+": "+s4);
			else {
				System.out.println("Case #"+(ooo+1)+": *");
			}
		}
	}class word implements Comparable<word>{
		String s;
		int l;
		public word(String S, int L) {
			s = S;
			l = L;
		}
		@Override
		public int compareTo(word o) {
			// TODO Auto-generated method stub
			return this.l-o.l;
		}
	}

}
