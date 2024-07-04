import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;

class Pair {
	
	public int start;
	
	public int end;
	
	int id;
	
	Pair() {
		
	}
	
	Pair(int start, int end, int id) {
		this.start = start;
		this.end = end;
		this.id = id;
	}
}

class SortbyStart implements Comparator<Pair> { 
	
    public int compare(Pair a, Pair b) { 
        return a.start - b.start; 
    } 
} 


public class Solution {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int testNo = scanner.nextInt();
		
		for (int i = 1; i <= testNo; i++) {
			int n = scanner.nextInt();
			ArrayList<Pair> list = new ArrayList<Pair>();
			
			for (int j = 0; j < n; j++) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				list.add(new Pair(start, end, j));
			}
			
			Collections.sort(list, new SortbyStart());
			
			int jmEndTime = 0;
			int caEndTime = 0;
			boolean isImpossible = false;
			HashMap<Integer, String> hash =  new HashMap<Integer, String>();
			
			for(int j = 0; j < n; j++) {
				Pair p = list.get(j);
				if (jmEndTime <= p.start) {
					hash.put(p.id, "J");
					jmEndTime = p.end;
				} else if (caEndTime <= p.start) {
					hash.put(p.id, "C");
					caEndTime = p.end;
				} else {
					isImpossible = true;
					break;
				}
			}
			
			if (isImpossible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				String ans = "";
				for (int j = 0; j < n; j++) {
					ans += hash.get(j);
				}
				System.out.println("Case #" + i + ": " + ans);
			}
		}
	}

}
