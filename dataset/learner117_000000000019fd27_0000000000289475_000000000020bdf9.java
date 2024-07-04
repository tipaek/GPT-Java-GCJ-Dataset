import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Pair {
	
	public int start;
	
	public int end;
	
	Pair() {
		
	}
	
	Pair(int start, int end) {
		this.start = start;
		this.end = end;
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
			String ans = "";
			
			for (int j = 0; j < n; j++) {
				int start = scanner.nextInt();
				int end = scanner.nextInt();
				list.add(new Pair(start, end));	
			}
			
			Collections.sort(list, new SortbyStart());
			
			int jmEndTime = -1;
			int caEndTime = -1;
			boolean isImpossible = false;
			for(int j = 0; j < n; j++) {
				Pair p = list.get(j);
				if (jmEndTime <= p.start) {
					ans += "J";
					jmEndTime = p.end;
				} else if (caEndTime <= p.start) {
					ans += "C";
					caEndTime = p.end;
				} else {
					isImpossible = true;
					break;
				}
			}
			
			if (isImpossible) {
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			} else {
				System.out.println("Case #" + i + ": " + ans);
			}
		}
	}

}
