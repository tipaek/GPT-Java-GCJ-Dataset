import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class B {
	
	private static class Pair {
		int Q;
		String R;
	}

	private static void allSubset(StringBuilder sb, int i, int l, ArrayList<String> subsets) {
		if (i == l) {
			subsets.add(sb.toString());
			return;			
		}
		
		char ci = sb.charAt(i);
		for(int a=i; a<l; a++) {
			char ca = sb.charAt(a); 
			sb.setCharAt(i,ca);
			sb.setCharAt(a,ci);
			
			allSubset(sb, i+1, l, subsets);
			
			sb.setCharAt(i,ci);
			sb.setCharAt(a,ca);			
		}
	}

	private static void solve(int nr, Scanner sc) {
		int U = sc.nextInt();

		HashSet<Character> subset = new HashSet();
		
		ArrayList<Pair> pairs = new ArrayList<Pair>();
		for(int i=0; i<10000; i++) {
			Pair p = new Pair();
			pairs.add(p);
			p.Q = sc.nextInt();
			p.R = sc.next();
			
			for(int ci=0; ci<p.R.length(); ci++) {
				char c = p.R.charAt(ci);
				subset.add(c);
			}			
		}

		for(int extra=0; extra<20; extra++) {
			if (subset.size() == 10)
				break;
			char ex = (char)('A'+extra);
			subset.add(ex);
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c: subset) {
			sb.append(c);
		}
		
		ArrayList<String> subsets = new ArrayList<String>();
		
		allSubset(sb,0,10,subsets);
		
		/*
		HashSet<String> test = new HashSet<String>();
		test.addAll(subsets);
		System.out.println(subsets.size()+" "+test.size());
		
		for(int i=0; i<subsets.size(); i++)
			System.out.println(subsets.get(i));
		*/
		
		outer:
		for(String D: subsets) {
			for(Pair p: pairs) {
				int value = 0;
				
				// Remove 0
				char first = p.R.charAt(0);
				if (D.indexOf(first) == 0) {
					// System.err.println("Fails first Testing "+ D + " "+p.R + " "+value + " "+p.Q);
					continue outer;
				}

				for(int vs = 0; vs<p.R.length(); vs++) {
					value *= 10;
					value += D.indexOf(p.R.charAt(vs));					
				}

				if (p.Q > 0) {
					if (p.Q < value) {
						// System.err.println("Fails value Testing "+ D + " "+p.R + " "+value + " "+p.Q);
						continue outer;					
					}
				} else {
					// System.err.println("Fails pq Testing "+ D + " "+p.R + " "+value + " "+p.Q);
				}
			}
			System.out.println("Case #"+nr+": "+D);
			return;
		}
		
		System.out.println("Case #"+nr+": IMPOSSIBLE");
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			solve(i+1,sc);
		}
	}
}
