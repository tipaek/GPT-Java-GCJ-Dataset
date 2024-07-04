import java.util.Scanner;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int testCases = in.nextInt();
		for(int i = 0; i < testCases; i++) {
			int intervals = in.nextInt();
			
			ArrayList<ArrayList<Integer>> x = new ArrayList<ArrayList<Integer>>();
			for(int j = 0; j < intervals; j++) {
				int start = in.nextInt();
				int end = in.nextInt();
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(start);
				temp.add(end);
				temp.add(j);
				x.add(temp);
			}
			
			Collections.sort(x, new Comparator<ArrayList<Integer>>() {
				public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2) {
					return l1.get(0) - l2.get(0);
				}
			});
			
			ArrayList<ArrayList<Integer>> p1 = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> p2 = new ArrayList<ArrayList<Integer>>();
			
			boolean valid = true;
			int[] assignment = new int[intervals];
			
			for(int j = 0; j < x.size(); j++) {
				ArrayList<Integer> cur = x.get(j);
				int person = 0;
				
				for(ArrayList<Integer> p1i: p1) {
					if(! (p1i.get(0) >= cur.get(1) || cur.get(0) >= p1i.get(1))) {
						person = 1;
						break;
					}
				}
				
				if(person == 1) {
					for(ArrayList<Integer> p2i: p2) {
						if(! (p2i.get(0) >= cur.get(1) || cur.get(0) >= p2i.get(1))) {
							person = 2;
							break;
						}
					}
				}
				
				
				
				if(person == 2)
					valid = false;
				else if(person == 0) {
					assignment[cur.get(2)] = 0;
					p1.add(cur);
				}
				else {
					assignment[cur.get(2)] = 1; 
					p2.add(cur);
				}
				
			}
			
			String ans = "";
			if(!valid) {
				System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
			}
			else {
				for(int j = 0; j < intervals; j++) {
					if(assignment[j] == 0)
						ans += "C";
					else
						ans += "J";
				}
				System.out.println("Case #" + (i + 1) + ": " + ans);
			}
			
		}
	}

}
