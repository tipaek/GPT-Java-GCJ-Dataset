import java.util.*;

public class Solution {
	
//	public static int pancake(long a[],int d) {
//		HashMap<Long,Integer> m = new HashMap<>();
//		for(long i : a) 
//		{
//			if(m.containsKey(i)) {
//				if(d == 2) return 0;
//				m.put(i, m.get(i)+1);
//				if(d == 3 && m.get(i) == 3) return 0;
//			}
//			else m.put(i, 1);
//		}
//		
//		if(d == 2) return 1;
//		for(long key : m.keySet()) {
//			for(long k : m.keySet()) {
//				if(k == 2*key)
//					return 1;
//			}
//			if(m.get(key) == 2)
//			{
//				for(long k : m.keySet()) 
//					if(k > key) return 1;
//			}
//		}
//		return 2;
//	}
//	
//	public static int cuts(long a[], int d) {
//		HashMap<Long,Integer> m = new HashMap<>();
//		for(long i : a) 
//		{
//			if(m.containsKey(i)) {
//				m.put(i, m.get(i)+1);
//				if(d == m.get(i)) return 0;
//			}
//			else m.put(i, 1);
//		}
//		
//	}
//	public static void main(String[] args) {
//		Scanner scn = new Scanner(System.in);
//		int t = scn.nextInt();
//		for(int qq=1;qq<=t;qq++) {
//			int n = scn.nextInt(), d = scn.nextInt();
//			long a[] = new long[n];
//			
//			for(int i=0;i<n;i++) {
//				a[i] = scn.nextLong();
//				
//			}
//			System.out.println("Case #" + qq + ": " + pancake(a,d));
//		}
//	}
//}

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
			long u = scn.nextInt();
//			HashMap<Character,HashSet<Integer>> m = new HashMap<>();
			HashMap<Character,Integer> max = new HashMap<>();
			HashSet<Character> all = new HashSet<>();
			for(int i=0;i<10000;i++) {
				long no = scn.nextLong();
				String nn = new String("" + no);//.length();
				int l = nn.length();
				String str = scn.next();
				if(no < 10 || l == str.length()) {
					int n = nn.charAt(0) - 48;
					char ch = str.charAt(0);
					if(!all.contains(ch)) all.add(ch);
					if(max.containsKey(ch)) max.put(ch, Math.min(n, max.get(ch)));
					else max.put(ch, n);
				}
				if(all.size() < 10) {
					for(int j=0;j<str.length();j++)
						if(!all.contains(str.charAt(j))) all.add(str.charAt(j));
				}
			}
			ArrayList<Pair> d = new ArrayList<>();
			for(char k : max.keySet()) {
				d.add(new Pair(k, max.get(k)));
			}
			d.add(new Pair(zero(all,max.keySet()), 0));
			Collections.sort(d);
			StringBuilder ans = new StringBuilder();
			
			for(Pair dd : d) {
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
