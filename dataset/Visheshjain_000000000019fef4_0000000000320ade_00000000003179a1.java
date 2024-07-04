
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = s.nextInt();
		int cas = 1;
		while (t-- > 0) {
			int u1 = s.nextInt();
			String[] m = new String[10000];
			String[] q = new String[10000];

			for (int i = 0; i < 10000; i++) {
				m[i] = s.next();
				q[i] = s.next();
			}

			HashMap<Character, Integer> u = find(q , m);
			char zero = zero(q, u);
			u.put(zero, 0);

			 u = find2(q , m , zero , u);
			String ans ="";
			
			HashMap<Integer, Character> help = new HashMap<Integer, Character>();
			
			for(char key  : u.keySet()) {
				help.put(u.get(key), key);
			}
			//System.out.println(help);
			//System.out.println(u);
			for(int i = 0 ; i <=9 ;i++) {
					ans+=help.get(i);
			}
			
			System.out.println("Case #" + cas + ": "+ans);
			cas++;
		}
	}

	private static HashMap<Character, Integer> find(String[] q , String[]m ) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < q.length; i++) {
			for (char ch : q[i].toCharArray()) {
				if (!map.containsKey(ch)) {
					map.put(ch, Integer.MAX_VALUE);	
				}
			}
			int max = m[i].charAt(0) - '0';

			if(map.get(q[i].charAt(0)) > max && q[i].length()==m[i].length() ) {
				map.put(q[i].charAt(0) , max);
			}
		}
		return map;
	}
	private static HashMap<Character, Integer> find2(String[] q , String[]m , char zero ,HashMap<Character, Integer> map) {
		for (int i = 0; i < q.length; i++) {
			char[] chars = q[i].toCharArray();
			char[] num = m[i].toCharArray();
			if(chars.length ==num.length && num[0]=='1' ) {
				int j = 1;
				while(j<num.length && num[j]=='0' ) {
					j++;
				}
				if(j<num.length ) {
					int max = num[j] - '0';

					if(map.get(chars[j]) > max ) {
						map.put(chars[j] , max);
					}
				}
			}
		}
		return map;
	}
	private static char zero(String[] q, HashMap<Character, Integer> map) {
		HashSet<Character> s = new HashSet<Character>(map.keySet());
		for (int i = 0; i < q.length; i++) {
			if (s.contains(q[i].charAt(0))) {
				s.remove(q[i].charAt(0));
			}
		}
		if (s.size() == 1) {
			for (char ch : s) {
				return ch;
			}
		}
		return 'A';
	}
}


//HashMap<Integer, HashSet<Character>> temp = new HashMap<Integer, HashSet<Character>>();
//for(int i = 1 ; i<=9 ;i++) {
//	HashSet<Character> h = new HashSet<Character>(u.keySet());
//	h.remove(zero);
//	temp.put(i, h);
//}
//
//for (int i = 0; i < q.length; i++) {
//	char[] chars = q[i].toCharArray();
//	char[] num = m[i].toCharArray();
//	int max = num[0] - '0';
//	for (int j = max + 1; j <= 9; j++) {
//		if(temp.get(j).contains(chars[0]))
//		temp.get(j).remove(chars[0]);
//	}
//	if (max == 1) {
//		int j = 1;
//		while (j < num.length && num[j] == '0') {
//			j++;
//		}
//		if (j < num.length) {
//			int max2 = num[j] - '0';
//			for (int j1 = max2 + 1; j1 <= 9; j1++) {
//				temp.get(j1).remove(chars[0]);
//			}
//		}
//	}
//}