import java.util.*;

public class Solution {
	static class Parent {
		LinkedList<Integer> scheduleStart;
		LinkedList<Integer> scheduleEnd;
		int len;
		Parent() {
			scheduleStart = new LinkedList<>();
			scheduleEnd = new LinkedList<>();
			len = 0;
		}
		
		// true if added, false if busy
		boolean add(int start, int end) {
			if(len == 0 || end<=scheduleStart.get(0)) {
				len++;
				scheduleStart.addFirst(start);
				scheduleEnd.addFirst(end);
				return true;
			}
			int i=0;
			while(i<len-1) {
				if(start < scheduleEnd.get(i)) break;
				else if(start>=scheduleEnd.get(i) && end<=scheduleStart.get(i+1)) {
					len++;
					scheduleStart.add(i+1, start);
					scheduleEnd.add(i+1, end);
					return true;
				}
				i++;
			}
			if(i==len-1 && start>=scheduleEnd.get(i)) {
				len++;
				scheduleStart.addLast(start);
				scheduleEnd.addLast(end);
				return true;
			}
			return false;
		}
	}
	
	public static String plan(int n, ArrayList<Integer> taskStart, ArrayList<Integer> taskEnd) {
		String res = "";
		Parent j = new Parent();
		Parent c = new Parent();

		for(int i=0; i<n; i++) {
			if(taskEnd.get(i) < taskStart.get(i)) {
				return "IMPOSSIBLE";
			}
			if(j.add(taskStart.get(i), taskEnd.get(i))) {
				res += 'C';
			}
			else if(c.add(taskStart.get(i), taskEnd.get(i))) {
				res += 'J';
			}
			else return "IMPOSSIBLE";
			// System.out.println(res);
		}
		return res;
	}

	public static void main(String[] args) {
		int t, n, start, end;
		ArrayList<Integer> taskStart = new ArrayList<>();
		ArrayList<Integer> taskEnd = new ArrayList<>();		
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		for(int c=1; c<=t; c++) {
			n = scan.nextInt();
			for(int i=0; i<n; i++) {
				start = scan.nextInt();
				end = scan.nextInt();
				taskStart.add(start);
				taskEnd.add(end);
			}
			System.out.println("Case #"+c+": "+plan(n, taskStart, taskEnd));
			taskStart.clear();
			taskEnd.clear();
		}
	}
}