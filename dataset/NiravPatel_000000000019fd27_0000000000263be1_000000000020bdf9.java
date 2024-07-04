import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
		for (int i = 1; i <= t; ++i) {
			n = in.nextInt();
			in.nextLine();
			isAssigned = false;
			out = new StringBuilder();
			CTask = new ArrayList<>();
			JTask = new ArrayList<>();
			for (int j = 0; j < n; ++j) {
				strArr = in.nextLine().split(" ");
				start = Integer.parseInt(strArr[0]);
				end = Integer.parseInt(strArr[1]);
				isAssigned = AssignTask(start, end, CTask, out,"C");
				if(!isAssigned) {
					isAssigned = AssignTask(start, end, JTask, out, "J");
				}
				if(!isAssigned) {
					out = new StringBuilder();
					out.append("IMPOSSIBLE");
					break;
				}
			}
			System.out.println("Case #" + i + ": " + out.toString());
		}
	}

	private static boolean AssignTask(int start, int end,
			ArrayList<Integer> CTask, StringBuilder out, String str1) {
		boolean isAssigned = false;;
		if (CTask.size()==0) {
			isAssigned = true;
			CTask.add(start);
			CTask.add(end);
			out.append(str1);
		} else {
			for(int k=0; k<CTask.size();k+=2) {
				if(k-1<0) {
					if (end <= CTask.get(k)) {
						isAssigned = true;
						CTask.add(k, end);
						CTask.add(k, start);
						out.append(str1);
						break;
					}
				} else {
					if (end <= CTask.get(k) && start >= CTask.get(k-1)) {
						isAssigned = true;
						CTask.add(k, end);
						CTask.add(k, start);
						out.append(str1);
					}
				}
			}
			if(!isAssigned) {
				if(start >= CTask.get(CTask.size()-1)) {
					isAssigned = true;
					CTask.add(start);
					CTask.add(end);
					out.append(str1);
				}
			}
		}
		return isAssigned;
	}
}