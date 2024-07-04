//package main;

import java.util.Scanner;
import java.util.TreeSet;

public class Solution implements Comparable {

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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	private int start;
	private int end;
	private String person;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int t = 1; t <= test; t++) {
			int N = sc.nextInt();
			TreeSet<Solution> setJ = new TreeSet<>();
			TreeSet<Solution> setC = new TreeSet<>();
			String ss = "";
			boolean isImpossible=false;;
			for (int i = 0; i < N; i++) {
				Solution sol = new Solution();
				sol.setStart(sc.nextInt());
				sol.setEnd(sc.nextInt());
				boolean J=setJ.stream().anyMatch(item -> {
					if(sol.getStart()==item.getStart()) {
						return true;
					}
					if(sol.getStart()>item.getStart()&&sol.getStart()<item.getEnd()) {
						return true;
					}
					if(sol.getEnd()>item.getStart()&&sol.getEnd()<=item.getEnd()) {
						return true;
					}
					if(sol.getStart()<item.getStart()&&sol.getEnd()>=item.getEnd()) {
						return true;
					}
					return false;
				});
				if(!J) {
					sol.setPerson("J");
					setJ.add(sol);
					if(!isImpossible) {
						ss+="J";
					}
				}
				else {
					boolean C=setC.stream().anyMatch(item -> {
						if(sol.getStart()==item.getStart()) {
							return true;
						}
						if(sol.getStart()>item.getStart()&&sol.getStart()<item.getEnd()) {
							return true;
						}
						if(sol.getEnd()>item.getStart()&&sol.getEnd()<=item.getEnd()) {
							return true;
						}
						if(sol.getStart()<item.getStart()&&sol.getEnd()>=item.getEnd()) {
							return true;
						}
						return false;
					});
					if(!C) {
						sol.setPerson("C");
						setC.add(sol);
						if(!isImpossible) {
							ss+="C";
						}
					}
					else {
						ss="IMPOSSIBLE";
						isImpossible=true;
					}
					
				}
				
			}
			System.out.println("Case #" + t + ": " + ss);

		}
		sc.close();
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Solution sol = (Solution) o;
		return this.start - sol.start;
	}

}
