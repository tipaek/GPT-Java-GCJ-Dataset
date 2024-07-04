import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static class P implements Comparable<P>{
		char c;
		int v;
		public P(char c , int v) {
			this.c = c;
			this.v = v;
		}
		@Override
		public int compareTo(P o) {
			return o.v - v;
		}
	}
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("sample.in.txt"));
		int T = sc.nextInt();
		for(int cn = 1 ; cn <= T ; ++cn){
			int U = sc.nextInt();
			Map<Character, Integer> counter = new HashMap<Character, Integer>();
			Set<Character> seenChars = new HashSet<Character>();
			for(int ln = 0 ; ln < 10000 ; ++ln){
				int Q = sc.nextInt();
				String R = sc.next();
				if(R.length() == U){
					char c = R.charAt(0);
					if(!counter.containsKey(c)){
						counter.put(c, 0);
					}
					for(char rc : R.toCharArray()){
						seenChars.add(rc);
					}
					int v = counter.get(c);
					counter.put(c, v + 1);
				}
			}
			StringBuilder ret = new StringBuilder();
			List<P> lst = new ArrayList<P>();
			for(char c : seenChars){
				if(! counter.containsKey(c)){
					ret.append(c);
				}else{
					lst.add(new P(c , counter.get(c)));					
				}
			}
			Collections.sort(lst);
			for(P p : lst){
				ret.append(p.c);
			}
//			System.out.println(counter);
			System.out.printf("Case #%d: %s\n" , cn , ret.toString());
		}
	}
}
