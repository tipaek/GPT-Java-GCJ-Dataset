package maze;
import java.util.Scanner;
import java.io.*;
class Solution {
	public static String M[][];
	public static String out;
		static Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	public static void main(String[] args) {
		    int T = Integer.valueOf(input.nextLine());
		    String out = "";
		    for (int i = 1; i <= T; ++i) {
		    	int N =Integer.valueOf(input.nextLine());
		    	M = new String[N][N];
		    	for (int j = 0; j < N; j++) {
		    		String in[] = new String[N];
		    		in = input.nextLine().split(" ");	    		
		    		addRow(j,in);
		    	}
		    	out += solve(i)+"\n";
		    }
		    System.out.println(out);
	}
	public static void addRow(int i,String in[]){
			for (int j = 0; j < M.length; j++) {
				M[j][i] = in[j];
			}
	}
	public static String solve(int num) {
		int trace = 0;
		int colCount = 0;
		int rowCount = 0;
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				if(i == j)
					trace+=Integer.valueOf(M[i][j]);	
			}
		}	
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				for (int j2 = 0; j2 < M.length; j2++) {
					if(M[i][j].equals(M[i][j2]) && j != j2) {
						colCount++;
						j = M.length;
						j2 = M.length;
					}
				}
			}
		}
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M.length; j++) {
				for (int j2 = 0; j2 < M.length; j2++) {
					if(M[j][i].equals(M[j2][i]) && j != j2) {
						rowCount++;
						j = M.length;
						j2 = M.length;
					}
				}
			}
		}
			
		return "Case #"+num+": "+trace+" "+rowCount+" "+colCount;
	}

}
