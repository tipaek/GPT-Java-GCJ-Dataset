import java.io.*;
import java.util.*;
public class Solution {
	static BufferedReader br;
	public static void main(String[] args) throws IOException{
		br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int asdfasdf=1; asdfasdf<T+1; asdfasdf++) {
			joestar(asdfasdf);
		}
	}
	public static void joestar(int kamamam) throws IOException {
		System.out.print("Case #"+kamamam+": ");
		StringTokenizer st = new StringTokenizer(br.readLine());
		int U = Integer.parseInt(st.nextToken());
		String[][] strings = new String[10000][2];
		for (int i=0; i<10000; i++) {
			st = new StringTokenizer(br.readLine());
			strings[i][0] = st.nextToken();
			strings[i][1] = st.nextToken();
		}
		HashMap<Character, Integer> joe = new HashMap();
		String alph = "QWERTYUIOPASDFGHJKLZXCVBNM";
		HashSet<Character> charset = new HashSet();
		for (int i=0; i<10000; i++) {
			charset.add(strings[i][1].charAt(strings[i][1].length()-1));
			if (strings[i][1].length()==U) {
				char c = strings[i][1].charAt(0);
				if (joe.containsKey(c)) {
					joe.put(c, joe.get(c)+1);
				}
				else {
					joe.put(c, 1);
				}
			}
		}
		ArrayList<Integer> asdf = new ArrayList();	
		for (char c : joe.keySet()) {
			asdf.add(joe.get(c));
		}
		Collections.sort(asdf);
		char[] charorder = new char[10];
		charorder[0]=',';
		for (int i=0; i<9; i++) {
			int currman = asdf.get(i);
			for (char c : joe.keySet()) {
				if (joe.get(c)==currman) {
					charorder[9-i]=c;
				}
			}
		}
		for (char c : charset) {
			boolean oddmanout = true;
			for (int i=0; i<10; i++) {
				if (c==charorder[i]) {
					oddmanout = false;
					break;
				}
			}
			if (oddmanout) {
				charorder[0] = c;
			}
		}
		for (int i=0; i<10; i++) {
			System.out.print(charorder[i]);
		}
		System.out.println();
	}
}
