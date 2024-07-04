package codejam2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class QR5 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(in.nextLine());

		for(int i = 0; i < totalTestCases; i++) {
			
			String firstLine = in.nextLine();
			int N = Integer.parseInt(firstLine.split(" ")[0]);
			int K = Integer.parseInt(firstLine.split(" ")[1]);
			
			HashMap<Integer, ArrayList<Integer>> lines = new HashMap<Integer, ArrayList<Integer>>();
			
			for(int j = 0; j < N; j++) {
				
				ArrayList<Integer> line = new ArrayList<Integer>();
				lines.put(j, line);
				
				for(int k = 0; k < N; k++) {
					if(k + 1 + j == N) {
						lines.get(j).add(N);
					} else {
						lines.get(j).add((k + 1 + j) % N);
					}
				}
			}
			
			ArrayList<ArrayList<Integer>> allTraces = getCombinations(N, N);
			ArrayList<ArrayList<Integer>> possibleTraces = getPossibleTraces(allTraces, K);
			printCombinations(allTraces);
			printCombinations(possibleTraces);
			//printMatrix(lines);
			
			checkPossibleTraces(possibleTraces, lines, N);
			
			System.out.println("Case #" + (i+1) + ": ");
		}
		
		in.close();
	}
	
	public static void printMatrix(HashMap<Integer, ArrayList<Integer>> lines) {
		for(int i : lines.keySet()) {
			String line = "";
			for(int j : lines.get(i)) {
				line += j + " ";
			}
			line.trim();
			System.out.println(line);
		}
	}
	
	public static void printCombinations(ArrayList<ArrayList<Integer>> lines) {
		for(ArrayList<Integer> temp : lines) {
			String line = "";
			for(int j : temp) {
				line += j + " ";
			}
			line.trim();
			System.out.println(line);
		}
	}
	
	public static ArrayList<ArrayList<Integer>> getCombinations(int length, int N){
		
		if(length == 0) {
			ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
			ArrayList<Integer> temp = new ArrayList<Integer>();
			output.add(temp);
			return output;
		} else {
			ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
			ArrayList<ArrayList<Integer>> lines = getCombinations(length - 1, N);
			
			for(ArrayList<Integer> temp : lines) {
				
				for(int i = 1; i <= N; i++) {
					
					ArrayList<Integer> cloned = new ArrayList<Integer>();
					
					for(Integer j : temp) {
						cloned.add(j);
					}
					
					cloned.add(i);
					output.add(cloned);
				}
			}
			
			return output;
		}
	}
	
	public static ArrayList<ArrayList<Integer>> getPossibleTraces(ArrayList<ArrayList<Integer>> allTraces, int trace){
		
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		
		for(ArrayList<Integer> temp : allTraces) {
			int sum = 0;
			for(int i : temp) {
				sum += i;
			}
			
			if(sum == trace) {
				output.add(temp);
			}
		}
		
		return output;
	}
	
	public static ArrayList<Integer> checkPossibleTraces(ArrayList<ArrayList<Integer>> possibleTraces, HashMap<Integer, ArrayList<Integer>> lines, int N){
		for(ArrayList<Integer> possibleTrace : possibleTraces) {
			HashSet<Integer> usedIndexes = new HashSet<Integer>();
			int matrixIndex = 0;
			
			for(int i = 0; i < possibleTrace.size(); i++) {
				for(int index : lines.keySet()) {
					if(!usedIndexes.contains(index)) {
						
						if(lines.get(index).get(matrixIndex) == possibleTrace.get(matrixIndex)) {
							usedIndexes.add(index);
							matrixIndex++;
						}
					}
				}
			}
			
			if(matrixIndex == N - 1) {
				return possibleTrace;
			}
		}
		
		return null;
	}
		
}
