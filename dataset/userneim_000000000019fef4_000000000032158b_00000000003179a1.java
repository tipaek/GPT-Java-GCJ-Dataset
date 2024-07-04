import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		outerLoop: for (int i = 1; i <= t; i++) {
			int U = in.nextInt();
			HashMap<Character, Integer> map = new HashMap<>();
			int[] numOcc = new int[10];
			char[] solution = new char[10];
			int solvedPos = 0;
			List<HashSet<Character>> arr = new ArrayList<HashSet<Character>>();
			HashSet<Character> set = new HashSet<>();
			for(int j = 0; j < 10; j++) {
				arr.add(new HashSet<Character>());
			}
			while(solvedPos < 9) {
				for(int j = 1; j <= 10000; j++) {
					String m1 = in.nextInt() + "";
					String r1 = in.next();
					char m = m1.charAt(0);
					char r= r1.charAt(0);
					if(set.size() < 10) {
						for(char e: r1.toCharArray())
							set.add(e);
					}
					if(m == '-')
						continue;
					if(m1.length() == r1.length()) {
						if(m == '1' && solution[1] != r) {
							numOcc[1] = 1;
							solution[1] = r;
							solvedPos++;
						}
						if(!map.containsKey(r)) {
							map.put(r, m - '0');
							numOcc[m - '0']++;
							arr.get(m - '0').add(r);
						}
						else if (map.get(r) > m - '0') {
							numOcc[map.get(r)]--;
							arr.get(map.get(r)).remove(r);
							map.put(r, m - '0');
							numOcc[m - '0']++;
							arr.get(m - '0').add(r);
						}
						int sum = numOcc[0];
						for(int k = 1; k < 10; k++) {
							if(sum == j && numOcc[k] == 1) {
								solution[k] = arr.get(k).iterator().next();
								numOcc[k]--;
								arr.get(k).remove(solution[k]);
								solvedPos++;
								System.out.println(Arrays.toString(solution));
							}
							sum+= numOcc[k];
						}
					}
				}
				in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
				in.nextInt(); in.nextInt();
			}
			for(char e: solution)
				set.remove(e);
			System.out.println("Case #" + i + ": " + set.iterator().next() + new String(solution).substring(1));
		}
	}
}