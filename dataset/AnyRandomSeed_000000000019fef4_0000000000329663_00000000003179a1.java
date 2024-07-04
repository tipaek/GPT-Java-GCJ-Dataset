import java.io.*;
import java.util.*;

public class Solution{
		private static boolean testMode = false;
		
		public static void main(String[] args) {
			if (testMode)
				try {
					System.setIn(new FileInputStream(
							System.getProperty("user.dir")+"/src/"+"sample.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			Scanner sc = new Scanner(new BufferedReader(
					new InputStreamReader(System.in)));
			int t = sc.nextInt();
			for (int i=1; i<=t; i++) {
				Solution inst = new Solution();
				int u = sc.nextInt();
				String[] r = new String[10000];
				for (int j=0; j<10000; j++) {
					sc.nextLong();
					r[j] = sc.nextLine().trim();
				}
				System.out.println("Case #"+i+": "+inst.solve(r, u));
			}
			sc.close();
		}
		
		private String solve(String[] r, int u) {
			HashMap<Character, Long> map = new HashMap<>();
			for (int i=0; i<r.length; i++) {
				if (u==16 && r[i].length()<16) continue;
				map.put(r[i].charAt(0), map.getOrDefault(r[i].charAt(0), 0l)+1);
			}
			boolean isBreak = false;
			for (int i=0; i<r.length; i++) {
				for (int j=0; j<r[i].length(); j++) {
					if (!map.containsKey(r[i].charAt(j))) {map.put(r[i].charAt(j), 0l); isBreak=true; break;}
				}
			}
			char[] res = new char[10];
			long min = Long.MAX_VALUE;
			for (Map.Entry<Character, Long> e : map.entrySet()) {
				if (e.getValue()<min) {
					min = e.getValue();
					res[0] = e.getKey();
				}
			}
			map.remove(res[0]);
			for (int i=9; i>=1; i--) {
				min = Long.MAX_VALUE;
				for (Map.Entry<Character, Long> e : map.entrySet()) {
					if (e.getValue()<min) {
						min = e.getValue();
						res[i] = e.getKey();
					}
				}
				map.remove(res[i]);
			}
			return String.valueOf(res);
		}
	}