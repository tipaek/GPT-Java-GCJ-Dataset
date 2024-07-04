import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int T = in.nextInt();		
		for (int casNumero = 1; casNumero <= T; casNumero++) {
			StringBuilder resultat = new StringBuilder();
			resultat.append("Case #");
			resultat.append(casNumero);
			resultat.append(": ");
			
			int cases = in.nextInt();
			long k = 0;
			Integer[][] matrix = new Integer[cases][cases];
			for (int i = 0; i < cases; i++) {
				for (int j = 0; j < cases; j++) {					
					matrix[i][j] = in.nextInt();
					if (i == j) {
						k += matrix[i][j];
					}
				}
			}
			
			int r = 0;
			int c = 0;	
			
			for (int i = 0; i < cases; i++) {
				Set<Integer> row = new HashSet<Integer>(Arrays.asList(matrix[i]));
				if (row.size() < cases) {
					r++;
				}
				
				List<Integer> columnList = new ArrayList<Integer>();
				for (int j = 0; j < cases; j++) {
					columnList.add(matrix[j][i]);
				}
				Set<Integer> column = new HashSet<Integer>(columnList);
				if (column.size() < cases) {
					c++;
				}
			}
			
			resultat.append(k);
			resultat.append(" ");
			resultat.append(r);
			resultat.append(" ");
			resultat.append(c);
			
			writer.print(resultat.toString());
			writer.println();
		}
		in.close();
		writer.close();
	}
}
