import java.util.*;

public class Solution {

	public static int ans(int x,int y,char c[]) {
		if(Math.abs(x) > c.length) return -1;
//		if(Math.abs(y) > c.length) return -1;
//		if(Math.abs(x) == c.length && y == 0) return c.length;
		
		int min = c.length*3;
		int t = 0;
		for(int i=0;i<c.length;i++)
		{
			if(c[i] == 'N') y++; 
			else if(c[i] == 'S') y--;
			else if(c[i] == 'E') x++; 
			else x--;
			
			if(Math.abs(x) + Math.abs(y) <= i + 1) 
				min = Math.min(min, i + 1);
		}
		return min == c.length*3 ? -1 : min;
	}
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int qq=1;qq<=t;qq++) {
			int u = scn.nextInt();
			char c[] = new char[10];
			HashMap<Character,HashSet<Integer>> m = new HashMap<>();
			HashMap<Character,Integer> max = new HashMap<>();
			HashSet<Character> all = new HashSet<>();
			for(int i=0;i<10000;i++) {
				int no = scn.nextInt();
				String nn = new String("" + no);//.length();
				int l = nn.length();
				String str = scn.next();
				if(no < 10 || l == str.length()) {
					int n = nn.charAt(0) - 48;
					char ch = str.charAt(0);
					if(!all.contains(ch)) all.add(ch);
					if(max.containsKey(ch)) max.put(ch, Math.min(n, max.get(ch)));
					else max.put(ch, n);
					if(!m.containsKey(ch)) {
						HashSet<Integer> set = new HashSet<>();
						for(int v=n;v>=0;v--) set.add(v);
						m.put(ch, set);
					}
					else {
						HashSet<Integer> set = new HashSet<>();
//						for(int v=n+1;v<=9;v++) if(set.contains(v)) set.remove(v);
//						for(int v=n;v>=0;v--) set.add(v);
						for(int v=0;v<=max.get(ch);v++) set.add(v);
						m.put(ch, set);
					}
				}
				if(all.size() < 10) {
					for(int j=0;j<str.length();j++)
						if(!all.contains(str.charAt(j))) all.add(str.charAt(j));
				}
			}
//			for(char ch : m.keySet()) {
//				System.out.println(ch + " - " + m.get(ch));
//			}
//			System.out.println(max);
//			System.out.println(all);
			ArrayList<Pair> d = new ArrayList<>();
			for(char k : max.keySet()) {
				d.add(new Pair(k, max.get(k)));
			}
			d.add(new Pair(zero(all,m.keySet()), 0));
			Collections.sort(d);
			StringBuilder ans = new StringBuilder();
			
//			for(int i=0;i<d.size();i++) {
			for(Pair dd : d) {
//				System.out.println(dd.c + " " + dd.n);
				ans.append(dd.c);
			}
			System.out.println("Case #" + qq + ": " + ans);
		}
	}
	
	public static char zero(HashSet<Character> all, Set<Character> set) {
		for(char ch : all) 
			if(!set.contains(ch)) return ch;
		return ' ';
	}
	static class Pair implements Comparable<Pair> {
		int n; char c;
		Pair(char a,int b) {
			n = b;
			c = a;
		}
		public int compareTo(Pair o) {
			return Integer.compare(n, o.n);
		}
	}

}
