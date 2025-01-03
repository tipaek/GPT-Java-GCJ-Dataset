import java.util.*;
public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=1; i<=t; i++) {
			int u = sc.nextInt();
			int[] freq = new int[26];
			HashSet<Character> set = new HashSet(); 
			for(int j=0 ;j<10000; j++) {
				long q = sc.nextLong();
				String s = sc.next();
				char c = s.charAt(0);
				for(char cc : s.toCharArray()) {
					set.add(cc);
				}
				freq[c-'a']++;
			}
			ArrayList<Character> ans = new ArrayList();
			int[] tmp = freq.clone();
			Arrays.sort(tmp);
			for(int x: tmp) {
				if(x>0) {
					for(int j=0; j<26; j++) {
						if(freq[j] == x) {
							char c = (char) ('a'+j);
							ans.add(c);
						}
					}
				}
			}
			for(char c: ans) {
				set.remove(c);
			}
			char c = set.iterator().next();
			ans.add(0, c);
			String s = "";
			for(char cc: ans) {
				s += cc;
			}
			System.out.println("Case #"+i+": "+s);
		}
	}
}
