import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int testcase = 0;

		while(testcase < t) {
			testcase++;
			int n = sc.nextInt();
			StringBuilder parentString = new StringBuilder();
			Set<StartEnd> cameronTaskSet = new HashSet<StartEnd>();
			Set<StartEnd> lanisterTaskSet = new HashSet<StartEnd>();
			boolean impossible = false;
			for(int i=0; i<n; i++) {
				if(cameronTaskSet.isEmpty()) {
					int start = sc.nextInt();
					int end = sc.nextInt();

					cameronTaskSet.add(new StartEnd(start, end));
					parentString.append('C');
					continue;
				}
				
				if(lanisterTaskSet.isEmpty()) {
					int start = sc.nextInt();
					int end = sc.nextInt();
					
					lanisterTaskSet.add(new StartEnd(start, end));
					parentString.append('J');
					continue;
				}
				
				int start = sc.nextInt();
				int end = sc.nextInt();
				StartEnd startEnd = new StartEnd(start, end);

				if(!isBusy(cameronTaskSet, startEnd)) {
					cameronTaskSet.add(startEnd);
					parentString.append('C');
				}else if(!isBusy(lanisterTaskSet, startEnd)) {
					lanisterTaskSet.add(startEnd);
					parentString.append('J');
				}else {
					System.out.println("Case #"+testcase+": IMPOSSIBLE");
					impossible = true;
					break;
				}
			}
			
			if(!impossible)
			System.out.println("Case #"+testcase+": "+parentString.toString());
		}

		sc.close();
	}
	
	private static boolean isBusy(Set<StartEnd> taskSet, StartEnd startEnd) {
		boolean busy = false;
		for (Iterator<StartEnd> iterator = taskSet.iterator(); iterator.hasNext();) {
			StartEnd camStartEnd = iterator.next();
			
			if((startEnd.getStart() >= camStartEnd.getEnd())
					|| (startEnd.getEnd() <= camStartEnd.getStart())) {
				continue;
			}else {
				busy = true;
				break;
			}
		}
		return busy;
	}

	public static class StartEnd {
		private int start;
		private int end;
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
		
		public StartEnd(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
