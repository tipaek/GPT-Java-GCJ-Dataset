import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {

		//BufferedReader bf = new BufferedReader(new FileReader("p.txt"));
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int casos = Integer.parseInt(bf.readLine());
		
		for (int i = 0; i < casos; i++) {
			
			String[] S = bf.readLine().split("");
			Stack<String> ST = new Stack<String>();
			StringBuilder SP = new StringBuilder();
			int open = 0;
			
			ST.push(S[0]);
			for (int k = 0; k < Integer.parseInt(S[0]); k++) SP.append("(");
			SP.append(S[0]);
			open = Integer.parseInt(S[0]);
			
			
			for (int j = 1; j < S.length; j++) {
				
				ST.push(S[j]);
				int next = 0;
				int v1 = Integer.parseInt(S[j]);
				int v2 = Integer.parseInt(S[j-1]);
				
				if(v1 > v2) {
					next = v1-v2;
					for (int k = 0; k < next; k++) {
						SP.append("(");
						open++;
					}
					SP.append(S[j]);
				}else if (v1 < v2){
					ST.pop();
					for (int k = 0; k < v2 - v1; k++) {
						SP.append(")");
						open--;
					}
					SP.append(S[j]);
				}else {
					SP.append(S[j]);
				}
			}
			
			for (int j = 0; j < open ; j++) SP.append(")");
			
			System.out.println("Case #"+(i+1)+": "+SP);
		}

	}

}
