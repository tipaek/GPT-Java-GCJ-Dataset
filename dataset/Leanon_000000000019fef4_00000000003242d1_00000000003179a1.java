import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner c= new Scanner(System.in);
		int t= c.nextInt();
		int cnt=0;
		while (t>0) {
			int u = c.nextInt();
			boolean f=true;
			HashMap<Integer,HashSet<Character>> map = new HashMap<Integer,HashSet<Character>>();
			HashSet<Character> alphabet =new HashSet<Character>();
			for (int i=0;i<10;i++) {
				map.put(i,new HashSet<Character>());
			}
			for (int i=0;i<10000;i++) {
				long q =c.nextLong();
				if (q==-1) {
					f=false;
					break;
				}
				String d =c.nextLine().substring(1);
				for (int j=0;j<d.length();j++) {
					alphabet.add(d.charAt(j));
				}
				int t1=1;
				while (q>=10) {
					q/=10;
					t1++;
				}
				if (d.length()==t1) {
					map.get((int)q).add(d.charAt(0));
				}
			}
			if (f) {
			Character[] mapping = new Character[10];
			
			int debug=1;
			HashSet<Character> used = new HashSet<Character>();
			
			for (Character c1:map.get(9)) {
				alphabet.remove(c1);
			}
			mapping[0]=(Character) alphabet.toArray()[0];
			used.add(mapping[0]);
			t--;cnt++;
			System.out.print("Case #"+cnt+": ");
			while (debug<=9) {
				
				for (Character c1: map.get(debug)) {
					if (!used.contains(c1)) {
						mapping[debug]=c1;debug++;
						used.add(c1);break;
					}
				}
			}
			for (int i=0;i<10;i++) {
				System.out.print(mapping[i]);
			}
			System.out.println();
			}
			else {
				Character[] mapping = new Character[10];
				HashSet<Character> alphabet1 =new HashSet<Character>();
				alphabet1.add(c.nextLine().charAt(1));
				for (int i=0;i<10000-1;i++) {
					int q =c.nextInt();
					String d=c.nextLine().substring(1);
					for (Character c1:d.toCharArray()) {
						alphabet.add(c1);
					}
					alphabet1.add(d.charAt(0));
					
				}
				for (Character c1:alphabet) {
					if (!alphabet1.contains(c1)) {
						mapping[0]=c1;alphabet.remove(c1);break;
					}
				}
				int t1=1;
				for (Character c1:alphabet) {
					mapping[t1]=c1;t1++;
				}
				t--;cnt++;
				System.out.print("Case #"+cnt+": ");
				for (int i=0;i<10;i++) {
					System.out.print(mapping[i]);
				}
				System.out.println();
			}
			
		}
	}

}
