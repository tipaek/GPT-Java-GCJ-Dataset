
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	
	static class Activity{
		int start;
		int end;
		public Activity(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		public Activity(String start, String end) {
			this.start = Integer.parseInt(start);
			this.end = Integer.parseInt(end);
		}
		@Override
		public String toString() {
			return start+" "+end;
		}
	}
	
	public static boolean hasBand(ArrayList<Activity> person,Activity curr) {
		boolean hasBand = true;
		for(int i=0;i<person.size();++i) {
			Activity a = person.get(i);
			if(curr.start>a.start && curr.start<a.end) {
				hasBand = false;
				break;
			}
			else if(curr.start<a.start && curr.end>a.start) {
				hasBand = false;
				break;
			}
		}
		if(hasBand) {
			person.add(curr);
		}
		return hasBand;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		int c = 1;
		StringBuffer output = new StringBuffer();
		while(c<=t) {
			int act = Integer.parseInt(sc.nextLine());
			StringBuffer s = new StringBuffer();
			ArrayList<Activity> input = new ArrayList<Parenting.Activity>(act);
			ArrayList<Activity> jAct = new ArrayList<Parenting.Activity>(act);
			ArrayList<Activity> cAct = new ArrayList<Parenting.Activity>(act);
			for(int i=0;i<act;++i) {
				String[] inp = sc.nextLine().split(" ");
				input.add(new Activity(inp[0], inp[1]));
			}
			for(int i=0;i<act;++i) {
				Activity curr = input.get(i);
				if(hasBand(jAct, curr)) {
					s.append("J");
				}
				else if(hasBand(cAct,curr)) {
					s.append("C");
				}
				else {
					s = new StringBuffer("IMPOSSIBLE");
					break;
				}
			}
			output.append("Case #"+c+": "+s.toString()+"\n");
			++c;
		}
		System.out.print(output);
		sc.close();
	}

}
