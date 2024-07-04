import java.util.*;
import java.io.*;

public class Solution {
	static Map<Integer, Pair> map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for (int tci = 0; tci < tc; tci++) {
			int n = Integer.parseInt(br.readLine());
			map = new TreeMap<Integer, Pair>();
			StringTokenizer st;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				map.put(i, new Pair(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			}
			boolean[] boolC = new boolean[24*60];
			boolean[] boolJ = new boolean[24*60];
			char[] solution = new char[n];
			boolean impossible = false;
			
			List<Pair> list = new ArrayList<Pair>();
			for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
				list.add(entry.getValue());
			}
			Collections.sort(list);
			
//			for (Pair p : list) {
//				System.out.println(p + " " + find(p));
//			}
			
			mainloop:
			for (Pair p : list) {
			    int x = p.x;
			    int y = p.y;
			    boolean CIsFull = false, JIsFull = false;
			    
			    cloop:
			    for (int i = x; i < y; i++) {
			    	if (boolC[i] == true) {
			    		CIsFull = true;
			    		break cloop;
			    	} 
			    }
			    if (!CIsFull) {
			    	Arrays.fill(boolC, x, y, true);
			    	solution[find(p)] = 'C';
			    	continue mainloop;
			    }
			    
			    jloop:
			    for (int i = x; i < y; i++) {
			    	if (boolJ[i] == true) {
			    		JIsFull = true;
			    		break jloop;
			    	} 
			    }
			    if (!JIsFull) {
			    	Arrays.fill(boolJ, x, y, true);
			    	solution[find(p)] = 'J';
			    	continue mainloop;
			    }
			    
			    //only happens when J and C are full
			    impossible = true;
			    break mainloop;
			}
			
			if (impossible) {
				System.out.printf("Case #%d: IMPOSSIBLE\n", tci+1);
			} else {
				String res = "";
				for (char c : solution)
					res += c;
				System.out.printf("Case #%d: %s\n", tci+1, res);
			}
				
		}
		br.close();
	}
	
	public static int find(Pair p) {
		for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
			if (entry.getValue().equals(p)) {
				int i = entry.getKey();
				map.remove(i);
				return i;
			}
		}
		return -1;
	}
}

class Pair implements Comparable<Pair> {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Pair p) {
		return (this.x == p.x && this.y == p.y);
	}
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
	public int compareTo(Pair p) {
		if (this.x == p.x)
			return this.y - p.y;
		return this.x - p.x;
	}
}