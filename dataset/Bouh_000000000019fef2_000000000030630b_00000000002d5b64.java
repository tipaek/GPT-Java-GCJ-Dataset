import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		String result = solveProblem(in);
		System.out.println(result);
	}

	public static String solveProblem(Scanner scanner) {
		String result = "";
		int t = scanner.nextInt(); 
		for (int i = 1; i <= t; ++i) {
			int R = scanner.nextInt();
			int S = scanner.nextInt();
			result+="Case #" + i + ": " + solveCase(R, S) + "\n";
		}
		result = result.substring(0, result.length() - 1);
		return result;
	}

	public static String solveCase(int R, int S) {
		String result = "";
		int count = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i < S + 1; i++) {
			for (int j = 1; j < R + 1; j++) {
				list.add(j);
			}
		}
		System.err.println(list);
		int placeToCut = getPlaceToCut(list, R, S);
		while (placeToCut != -1) {
			count++;
			List<Integer> subList = list.subList(0, placeToCut);
			int toFind = (placeToCut + S - 1) / S;
			int last = subList.lastIndexOf(toFind);
			int A = last + 1;
			int B = placeToCut - last - 1;
			result = result +  A + " " + B + "\n";
			list = sortList(list, A, B);
			placeToCut = getPlaceToCut(list, R, S);
		}
		result = count + "\n" + result;
		return result;
	}
	
	public static int getPlaceToCut(List<Integer> list, int R, int S) {
		int result = -1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(R * S - 1 - i) != (R - (i/S))) {
				return list.size() - i;
			}
		}
		return result;
	}
	
	public static List<Integer> sortList(List<Integer> list, int A, int B) {
		List<Integer> result = new ArrayList<>();
		result.addAll(list.subList(A, A + B));
		result.addAll(list.subList(0, A));
		result.addAll(list.subList(A + B, list.size()));
		return result;
	}
	
}
