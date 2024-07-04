import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {		
		int cases = in.nextInt();
		for(int i=0; i<cases; i++) solveCase(i+1);
		
	}
	
	private static void solveCase(int c) {
		int n = in.nextInt();
		
		Set<Integer>[] lineChecker = new Set[n];
		Set<Integer>[] colChecker = new Set[n];
		
		for(int i=0; i<n; i++) {
			lineChecker[i] = new HashSet<>();
			colChecker[i] = new HashSet<>();
		}
		
		int trace = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int el = in.nextInt();
				lineChecker[i].add(el);
				colChecker[j].add(el);
				if(i == j) trace += el;
			}
		}
		
		int lines = 0;
		int cols = 0;
		for(int i=0; i<n; i++) {
			if(lineChecker[i].size() < n) lines++;
			if(colChecker[i].size() < n) cols++;
		}
		
		System.out.println("Case #" + c + ": " + trace + " " + lines + " " + cols);
	}
}
