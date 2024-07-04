import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	
	public String solve(String[] input) {
		List<StringBuilder> in = new ArrayList<>();
		for(String s : input) in.add(new StringBuilder(s));
		
		StringBuilder prefix = new StringBuilder(""); 
		StringBuilder postfix = new StringBuilder("");
		
		boolean done = false;
		
		while(!done) {
			//System.out.println(in);
			done = true;
			
			char target = '*';
			for(int i = 0; i < in.size(); i++) {
				if(in.get(i).length() > 0) {
					done = false;
					
					char cur = in.get(i).charAt(0);
					if(cur == '*') continue;
					if(target == '*') {
						target = cur;
						in.get(i).deleteCharAt(0);
					}
					else if(target != cur) return "*";
					else in.get(i).deleteCharAt(0);
				}
			}
			
			if(target != '*') {
				prefix.append(target);
				continue;
			}
			
			for(int i = 0; i < in.size(); i++) {
				if(in.get(i).length() > 0) {
					done = false;
					
					char cur = in.get(i).charAt(in.get(i).length() - 1);
					if(cur == '*') continue;
					if(target == '*') {
						target = cur;
						in.get(i).deleteCharAt(in.get(i).length() - 1);
					}
					else if(target != cur) return "*";
					else in.get(i).deleteCharAt(in.get(i).length() - 1);
				}
			}
			
			if(target != '*') {
				postfix.append(target);
				continue;
			}
			
			for(int i = 0; i < in.size(); i++) {
				if(in.get(i).length() > 0) {
					done = false;
					in.get(i).deleteCharAt(0);
					break;
				}
			}
		}
		return prefix.toString() + postfix.reverse().toString();
		
	}
	
	public static void mainX(String[] args) {
		Solution Q = new Solution();
		System.out.println(Q.solve(new String[] {"*YZ", "*XYZ"}));	
		System.out.println(Q.solve(new String[] {"*CONUTS", "*COCONUTS", "*OCONUTS", "*CONUTS", "*S"}));
		
		System.out.println(Q.solve(new String[] {"H*O", "HELLO*", "*HELLO", "HE*"}));
		System.out.println(Q.solve(new String[] {"CO*DE", "J*AM"}));
		System.out.println(Q.solve(new String[] {"CODE*", "*JAM"}));
		
		System.out.println(Q.solve(new String[] {"A*C*E", "*B*D*"}));
		System.out.println(Q.solve(new String[] {"A*C*E", "*B*D"}));
		
		System.out.println(Q.solve(new String[] {"**Q**", "*A*"}));
		
		String[] in = new String[50];
		for(int i = 0; i < 50; i++) {
			in[i] = "****************************************************************************************************";
		}
		in[45] = "*****************************************************A**********************************************";
		System.out.println(Q.solve(in));
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {
		Solution Q = new Solution();
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
		in.nextLine();
		for (int i = 1; i <= t; ++i) {
			int N = in.nextInt();
			String[] input = new String[N];
			in.nextLine();
			for(int j = 0; j < N; j++) {
				input[j] = in.nextLine();
			}
			String output = Q.solve(input);
			System.out.println("Case #" + i + ": " + output);
			System.out.flush();
		}
	}

}
