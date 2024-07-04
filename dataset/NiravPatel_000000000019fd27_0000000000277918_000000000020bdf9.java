import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
		int n, start, end;
		String str, strArr[];
		ArrayList<Integer> CTask;
		ArrayList<Integer> JTask;
		boolean isAssigned;
		StringBuilder out;
		HashMap<String, String> tempMap;
		ArrayList<Integer> sortedList, mainlist;
		for (int i = 1; i <= t; ++i) {
			n = in.nextInt();
			in.nextLine();
			isAssigned = false;
			out = new StringBuilder();
			CTask = new ArrayList<>();
			JTask = new ArrayList<>();
			tempMap = new HashMap<>();
			sortedList = new ArrayList<>();
			mainlist = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				strArr = in.nextLine().split(" ");
				start = Integer.parseInt(strArr[0]);
				end = Integer.parseInt(strArr[1]);
				mainlist.add(start);
				mainlist.add(end);
				if(sortedList.size()== 0) {
					sortedList.add(start);
					sortedList.add(end);
				} else {
					boolean isIns = false;
					for (int j2 = 2; j2 < sortedList.size(); j2+=2) {
						if(start< sortedList.get(j2)) {
							sortedList.add(j2,end);
							sortedList.add(j2,start);
							isIns = true;
							break;
						} else if(start==sortedList.get(j2) && end<sortedList.get(j2+1)) {
							sortedList.add(j2,end);
							sortedList.add(j2,start);
							isIns = true;
							break;
						}
					}
					if(!isIns) {
						sortedList.add(start);
						sortedList.add(end);
					}
				}
			}
			for (int j = 0; j < sortedList.size(); j+=2) {
				start = sortedList.get(j);
				end = sortedList.get(j+1);
				isAssigned = AssignTask(start, end, CTask,"C", tempMap);
				if(!isAssigned) {
					isAssigned = AssignTask(start, end, JTask, "J", tempMap);
				}
				if(!isAssigned) {
					out = new StringBuilder();
					out.append("IMPOSSIBLE");
					break;
				}
			}
			if(out.toString().equals("")) {
				for (int j = 0; j < mainlist.size(); j+=2) {
					start = mainlist.get(j);
					end = mainlist.get(j+1);
					out.append(tempMap.get(start+" "+end).charAt(0));
					if(tempMap.get(start+" "+end).length()>1) {
						tempMap.put(start+" "+end,tempMap.get(start+" "+end).substring(1));
					}
				}
			}
			System.out.println("Case #" + i + ": " + out.toString());
		}
	}

	private static boolean AssignTask(int start, int end,
			ArrayList<Integer> CTask, String str1, HashMap<String, String> tempMap) {
		boolean isAssigned = false;;
		if (CTask.size()==0) {
			isAssigned = true;
			CTask.add(start);
			CTask.add(end);
		} else {
			for(int k=0; k<CTask.size();k+=2) {
				if(k-1<0) {
					if (end <= CTask.get(k)) {
						isAssigned = true;
						CTask.add(k, end);
						CTask.add(k, start);
						break;
					}
				} else {
					if (end <= CTask.get(k) && start >= CTask.get(k-1)) {
						isAssigned = true;
						CTask.add(k, end);
						CTask.add(k, start);
					}
				}
			}
			if(!isAssigned) {
				if(start >= CTask.get(CTask.size()-1)) {
					isAssigned = true;
					CTask.add(start);
					CTask.add(end);
				}
			}
		}
		if(isAssigned) {
			if(tempMap.get(start+" "+end) == null)
				tempMap.put(start+" "+end,str1);
			else 
				tempMap.put(start+" "+end,tempMap.get(start+" "+end)+str1);
			
		}
		return isAssigned;
	}
}