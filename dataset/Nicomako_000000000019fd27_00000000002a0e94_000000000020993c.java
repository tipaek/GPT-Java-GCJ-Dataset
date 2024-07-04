
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws  IOException {
		
		BufferedReader in  = new BufferedReader (new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter (new OutputStreamWriter (System.out));
		int n = Integer.parseInt(in.readLine());
		for (int i = 1; i <= n; i++) {
			int tamMatriz = Integer.parseInt(in.readLine());
			int matriz [] [] = new int [tamMatriz][tamMatriz];
			long count = 0;
			long countR = 0;
			long countC = 0;
			for (int j = 0; j < matriz.length; j++) {
				StringTokenizer toks = new StringTokenizer (in.readLine());
				for (int k = 0; k < matriz[j].length; k++) {
					matriz [j][k] = Integer.parseInt(toks.nextToken());	
				}
			}
			for (int j = 0; j < matriz.length; j++) {
				HashSet<Integer> repetidosR = new HashSet<Integer>();
				HashSet<Integer> repetidosC = new HashSet<Integer>();
				for (int k = 0; k < matriz.length; k++) {
					repetidosR.add(matriz[j][k]);
					repetidosC.add(matriz[k][j]);
					if(k == j )
						count += matriz[j][k]; 
				}
				if(repetidosR.size() < tamMatriz)
					countR++;
				if(repetidosC.size() < tamMatriz)
					countC++;
			}
			out.printf("Case #%d: %d %d %d\n", i, count, countR, countC);
		}
		out.close();
	}

}
