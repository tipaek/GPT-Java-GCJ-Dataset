import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Solution {
	static String ans = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int test=1; test<=t; test++) {
			int n = sc.nextInt();
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> J = new ArrayList<ArrayList<Integer>>();
			for(int i=0; i<n; i++) {
				ArrayList<Integer> li = new ArrayList<Integer>();
				li.add(sc.nextInt());
				li.add(sc.nextInt());
				list.add(li);
			}
			
			for (ArrayList<Integer> job : list) {
				if(C.size() == 0) {
					C.add(job);
					continue;
				} 
				for (ArrayList<Integer> c : C) {
					if((job.get(0) <c.get(0) && job.get(1) < c.get(0) ) || job.get(0) >= c.get(1)  ) {
						C.add(job);
						break;
					} else {
						if(J.size() == 0) {
							J.add(job);
							break;
						}
						for (ArrayList<Integer> j : J) {
							if((job.get(0) <j.get(0) && job.get(1) < j.get(0) ) || job.get(0) >= j.get(1) ) {
								J.add(job);
								break;
							} 
						}
					}
				}
			}
			
			
			if(C.size() + J.size() != list.size() ) {
				System.out.println("Case #" + test + ": IMPOSSIBLE" );
			} else {
				System.out.print("Case #" + test + ": " );
				for (ArrayList<Integer> arrayList : list) {
					if(C.contains(arrayList)) {
						System.out.print("C");
					} else {
						System.out.print("J");
					}
				}
			}
		}
	}
}
