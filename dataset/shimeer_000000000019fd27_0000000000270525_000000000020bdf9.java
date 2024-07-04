import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.ForegroundAction;

public class Solution {
	static String ans = "";
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
					ans += "C";
					continue;
				} 
			
				int checkForC = 0;
				for(ArrayList<Integer> c : C) {
					if((job.get(0) < c.get(0) && job.get(1) <= c.get(0) ) || job.get(0) >= c.get(1)) {
						checkForC = 1;
					} else {
						checkForC = 0;
						break;
					}
				}
				
				if(checkForC == 1) {
					C.add(job);
					ans += "C";
				} else {
					if(J.size() == 0) {
						J.add(job);
						ans += "J";
						continue;
					}
					int checkForJ = 0;
					for(ArrayList<Integer> j : J) {
						if((job.get(0) < j.get(0) && job.get(1) <= j.get(0) ) || job.get(0) >= j.get(1)) {
							checkForJ = 1;
						} else {
							checkForJ = 0;
							break;
						}
					}
					if(checkForJ == 1) {
						J.add(job);
						ans += "J";
					}
				}
				
			}

			if(C.size() + J.size() != list.size()) {
				System.out.println("Case #" + test + ": IMPOSSIBLE");
				ans = "";
			} else {
				System.out.println("Case #" + test + ": " + ans);
				ans = "";
			}
		}
	}
}
