import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		solve();
	}

	private static void solve() {
		Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

		int t = sc.nextInt();
		for (int i2 = 1; i2 <= t; i2++) {
			int u = sc.nextInt();
			long qq[] = new long[10000];
			String ee[] = new String[10000];
			for (int i = 0; i < 10000; i++) {
				long q = sc.nextLong();
				String e = sc.next();
				qq[i] = q;
				ee[i] = e;
			}
			System.out.println("Case #" + i2 + ": " + solution(u, qq, ee));
		}

		sc.close();
	}

	private static String solution(int u, long[] qq, String[] ee) {
		//System.out.println(u);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ee.length; i++) {
			String e = ee[i];
			for (int j = 0; j < e.length(); j++) {
				String x = ""+e.charAt(j);
				if (map.containsKey(x)) {
					map.put(x, map.get(x)+1);
				} else {
					map.put(x, 1);
				}
			}
		}
		HashMap<Integer, String> rmap = new HashMap<Integer, String>();
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			rmap.put(entry.getValue(), entry.getKey());
		}
		
		ArrayList<Integer> values = new ArrayList<Integer>(map.values());
		Collections.sort(values);
		Collections.reverse(values);
		
		String result = rmap.get(values.get(9));
		for (int i = 0; i < 9; i++) {
			int v = values.get(i);
			String d = rmap.get(v);
			result += d;
		}
		
		//System.out.println(result);
		return result;
		
		

		
		/*
		HashMap<Integer, String> resolved = new HashMap<Integer, String>();  
		int found = 0;
		
		HashSet<String> allBefore = new HashSet<String>();
		
		for (int j = 1; j < 100; j++) {
			int d = j;
			HashSet<String> uniq = new HashSet<String>();
			for (int i = 0; i < ee.length; i++) {
				if (qq[i] == d) {
					uniq.add(ee[i]);
				}
			}
			
			HashSet<String> rem = new HashSet<String>(uniq);
			rem.removeAll(allBefore);
			if ((rem.size() == 1)) {
				String sol = new ArrayList<String>(rem).get(0);
				resolved.put(d, sol);
				if (d < 10) {
					found++;
				}
				
				if (sol.length() > 0) {
					for (int i = 0; i < sol.length(); i++) {
						String x  = ""+sol.charAt(i);
						String dd = ""+d;
						if (!resolved.values().contains(x)) {
							resolved.put(dd.charAt(i)-'0', x);
							found++;
						}
					}
				}
				
			}
			allBefore.addAll(uniq);
			
			if (found == 10) {
				break;
			}
			
			//System.out.println(d + " " + uniq);
			//System.out.println(resolved);
		}
		
		String rr = "";
		for (int i = 0; i < 10; i++) {
			rr+= resolved.get(i);
		}
		
		
		return rr;
		*/
	}



}
