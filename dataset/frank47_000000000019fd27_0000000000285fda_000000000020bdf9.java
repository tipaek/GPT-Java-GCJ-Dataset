import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int testcase = 0;

		while(testcase < t) {
			testcase++;
			int n = sc.nextInt();
			char[] parentString = new char[n];
			Set<StartEnd> cameronTaskSet = new HashSet<StartEnd>();
			Set<StartEnd> lanisterTaskSet = new HashSet<StartEnd>();
			boolean impossible = false;
			Map<StartEnd, String> taskMap = new HashMap<StartEnd, String>();
			List<StartEnd> taskList = new ArrayList<StartEnd>();
			
			for(int i=0; i<n; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				StartEnd startEnd = new StartEnd(start, end);

				taskMap.put(startEnd, String.valueOf(i));
				int findPos = findPos(taskList, startEnd);
				if(findPos == -1) {
					taskList.add(startEnd);
				}else {
					taskList.add(findPos, startEnd);
				}
			}
			
			for (StartEnd startEnd : taskList) {
				if(!isBusy(cameronTaskSet, startEnd)) {
					cameronTaskSet.add(startEnd);
					taskMap.replace(startEnd, taskMap.get(startEnd)+"C");
				}else if(!isBusy(lanisterTaskSet, startEnd)) {
					lanisterTaskSet.add(startEnd);
					taskMap.replace(startEnd, taskMap.get(startEnd)+"J");
				}else {
					System.out.println("Case #"+testcase+": IMPOSSIBLE");
					impossible = true;
					break;
				}
			}
			
			if(!impossible) {
				preparePrintString(taskMap, parentString, testcase);
			}
		}

		sc.close();
	}
	
	private static void preparePrintString(Map<StartEnd, String> taskMap, char[] parentString, int testcase) {
		Collection<String> values = taskMap.values();
		for (Iterator<String> iterator = values.iterator(); iterator.hasNext();) {
			String string = iterator.next();
			
			parentString[Integer.valueOf(String.valueOf(string.charAt(0)))] = string.charAt(1);
		}
		System.out.println("Case #"+testcase+": "+String.copyValueOf(parentString));
	}

	private static int findPos(List<StartEnd> taskList, StartEnd startEnd) {
		if(taskList.isEmpty()) {
			return 0;
		}
		
		if(startEnd.getStart()<taskList.get(0).getStart()) {
			return 0;
		}

		if(startEnd.getStart()>taskList.get(taskList.size() - 1).getStart()) {
			return -1;
		}
		
		for(int i=0; i<(taskList.size() - 1); i++) {
			if(startEnd.getStart()>taskList.get(i).getStart() && startEnd.getStart()<taskList.get(i+1).getStart()) {
				return i+1;
			}else if(startEnd.getStart()==taskList.get(i).getStart()) {
				if(startEnd.getEnd()<=taskList.get(i).getEnd()) {
					return i;
				}else {
					return i+1;
				}
			}else if(startEnd.getStart()==taskList.get(i+1).getStart()) {
				if(startEnd.getEnd()<=taskList.get(i+1).getEnd()) {
					return i+1;
				}else {
					return i+2;
				}
			}
		}
		
		return -1;
	}

	private static boolean isBusy(Set<StartEnd> taskSet, StartEnd startEnd) {
		if(taskSet.isEmpty()) {
			return false;
		}
		for (Iterator<StartEnd> iterator = taskSet.iterator(); iterator.hasNext();) {
			StartEnd camStartEnd = iterator.next();
			
			if((startEnd.getStart() >= camStartEnd.getEnd())
					|| (startEnd.getEnd() <= camStartEnd.getStart())) {
				continue;
			}else {
				return true;
			}
		}
		return false;
	}

	public static class StartEnd {
		private Integer index = null;
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
		public Integer getIndex() {
			return index;
		}
		public void setIndex(Integer index) {
			this.index = index;
		}
	}
}
