import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); //Test cases
		
		boolean rowCheck = false;
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt(); // Size Matrix to explore
			
			long trace = 0; // Trace matrix
			int r = 0; // Number rows repetead values
			int c = 0; // Number colums repetead values
			
			Map<Integer, List<Integer>> columns = new HashMap<Integer, List<Integer>>();
			List<Integer> columnChecks = new ArrayList<Integer>();
			
			for (int o = 0; o<n; o++) {
				// o - row
				List<Integer> row = new ArrayList<Integer>();
				rowCheck = false;
				
				List<Integer> listaNumeros = new ArrayList<Integer>();
				for (int a = 0; a<n; a++) {
					listaNumeros.add(in.nextInt());
				}
				for (int u = 0; u < listaNumeros.size(); u++) {
					if (o == 0) {
						columns.put(u, new ArrayList<Integer>());
					}
					if (!rowCheck && row.contains(listaNumeros.get(u))) {
						r++;
						rowCheck = true;
					} else {
						if (!rowCheck) {
							row.add(listaNumeros.get(u));
						}
					}
					
					if (o > 0 && !columnChecks.contains(u)) {
						// Comprobamos si la columna tiene valores repetidos con los datos actuales
						if (columns.get(u).contains(listaNumeros.get(u))) {
							c++;
							columnChecks.add(u);
						} else {
							columns.get(u).add(listaNumeros.get(u));
						}
					} else {
						columns.get(u).add(listaNumeros.get(u));
					}
					
					if (o == u) {
						trace += listaNumeros.get(u);
					}
				}
				
			}
			System.out.println("Case #" + i + ": " + trace 
					+ " " + r + " " + c);
			
		}
	}
	
}

