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
			
			int n = in.nextInt();
			long k = in.nextLong();
			
			writer.print(resultat.toString());
			if ((k == n + 1) || (k > n * (n - 1) && k < n * n)) {
				writer.print("IMPOSSIBLE");
				writer.println();
			}
			else {
				writer.print("POSSIBLE");
				writer.println();
				int[][] matrix = new int[n][n];
				int value = ((int)k / n);
				if (k % n == 0) {
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (value + j - i <= 0) {
								matrix[i][j] = n + (j - i + value);
							}
							else if (value + j - i > n) {
								matrix[i][j] = (value + j - i) % n;
							}
							else {
								matrix[i][j] = value + j - i;
							}
						}
					}
				}
				else {
					int difference = (int)(k - (n * value));
					int ajust1 = 0;
					int ajust2 = 0;
					if (difference <= ((int)n/2)) {
						ajust1 = n;
						ajust2 = (value * 2) + difference - ajust1;
						if (ajust2 == value) {
							ajust1--;
							ajust2++;
						}
					}
					else {
						value += 1;
						difference = (int)((n * value) - k);
						ajust1 = 1;
						ajust2 = (value * 2) - difference - ajust1;
						while (ajust2 == value || ajust2 > n) {
							ajust1++;
							ajust2--;
						}						
					}
					
					int[] ordre = new int[n];
					ordre[0] = value;
					ordre[1] = ajust1;
					ordre[n - 1] = ajust2;
					int valor = 1;
					for (int i = 2; i < n - 1; i++) {
						while (valor == value || valor == ajust1 || valor == ajust2) {
							valor++;
						}
						ordre[i] = valor;
						valor++;
					}
					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							if (j - i < 0) {
								matrix[i][j] = ordre[n + (j - i)];
							}
							else if (j - i > n) {
								matrix[i][j] = ordre[(1 + j - i) % n];
							}
							else {
								matrix[i][j] = ordre[j - i];
							}
						}
					}
					int[] canvi = Arrays.copyOf(matrix[0], matrix[0].length);
					matrix[0] = matrix[1];
					matrix[1] = canvi;
				}
				
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						writer.print(matrix[i][j]);
						writer.print(" ");
					}
					writer.println();
				}
			}				
		}
		in.close();
		writer.close();
	}
}
