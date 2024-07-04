import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	static String[] solution(List<two> timesMap, List<String> order) {
		int C = 0;
		int J = 0;
		Collections.sort(timesMap,new SortbyNum());
		String[] solution = new String[timesMap.size()];
		for (int i = 0; i < timesMap.size(); i++) {
			
			if ( timesMap.get(i).a>= C) {
				C = timesMap.get(i).b;
				solution[order.indexOf(timesMap.get(i).line)] = "C";
				order.set(order.indexOf(timesMap.get(i).line), "-");
				
			} else if (timesMap.get(i).a >= J) {
				J = timesMap.get(i).b;
				solution[order.indexOf(timesMap.get(i).line)] = "J";

			} else {
				return null;
			}
		}
		return solution;
	}

	public static void main(String[] args) {
		int T = Integer.parseInt(in.nextLine());
		List<two> timesList;
		int N = 0;
		String line;

		for (int i = 1; i <= T; i++) {
			N = Integer.parseInt(in.nextLine());
			timesList = new ArrayList<two>();
			List<String> order = new ArrayList<String>();

			for (int j = 0; j < N; j++) {
				line = in.nextLine();	
				String[] lineSplit = line.split("\\s+");
				two two = new two(Integer.parseInt(lineSplit[0]), Integer.parseInt(lineSplit[1]), line);

				timesList.add(two);
				order.add(line);
			}
			
			String[] s = solution(timesList, order);
			int index = 0;

			StringBuilder solution = new StringBuilder();
			if (s == null) {
				solution.append("IMPOSSIBLE");
			} else {
				for (int j = 0; j < s.length; j++) {
					solution.append(s[j]);
				}
			}
			System.out.println("Case #" + i + ": " + solution.toString().trim());

		}

	}
}

class SortbyNum implements Comparator<two> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(two a, two b) 
    { 
        return a.a - b.a; 
    } 
} 

class two {
	two(int a, int b, String line) {
		this.a = a;
		this.b =b;
		this.line=line;
	}
	String line;
	int a;
	int b;
}