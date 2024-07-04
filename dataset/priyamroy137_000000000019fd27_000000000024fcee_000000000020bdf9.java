//package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	private int start;
	private int end;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int N = sc.nextInt();
			List<Solution> setJ = new ArrayList<>();
			List<Solution> setC = new ArrayList<>();
			String ss = "";
			boolean isImpossible = false;

			for (int i = 0; i < N; i++) {
				Solution sol = new Solution();
				sol.setStart(sc.nextInt());
				sol.setEnd(sc.nextInt());
				boolean J = setJ.stream().anyMatch(item -> {
					if (sol.getStart() >= item.getStart() && sol.getEnd() <= item.getEnd()) {
						return true;
					}
					if (sol.getStart() >= item.getStart() && sol.getStart() < item.getEnd()
							&& sol.getEnd() >= item.getEnd()) {
						return true;
					}
					if (sol.getStart() <= item.getStart() && sol.getEnd() > item.getStart()
							&& sol.getEnd() <= item.getEnd()) {
						return true;
					}
					if (sol.getStart() <= item.getStart() && sol.getEnd() >= item.getEnd()) {
						return true;
					}
					return false;
				});
				if (!J) {
					setJ.add(sol);
					if (!isImpossible) {
						ss += "J";
					}
				} else {
					boolean C = setC.stream().anyMatch(item -> {
						if (sol.getStart() >= item.getStart() && sol.getEnd() <= item.getEnd()) {
							return true;
						}
						if (sol.getStart() >= item.getStart() && sol.getStart() < item.getEnd()
								&& sol.getEnd() >= item.getEnd()) {
							return true;
						}
						if (sol.getStart() <= item.getStart() && sol.getEnd() > item.getStart()
								&& sol.getEnd() <= item.getEnd()) {
							return true;
						}
						if (sol.getStart() <= item.getStart() && sol.getEnd() >= item.getEnd()) {
							return true;
						}
						return false;
					});
					if (!C) {
						setC.add(sol);
						if (!isImpossible) {
							ss += "C";
						}
					} else {
						ss = "IMPOSSIBLE";
						isImpossible = true;
					}

				}

			}
			System.out.println("Case #" + t + ": " + ss);

		}
		sc.close();
	}

}
