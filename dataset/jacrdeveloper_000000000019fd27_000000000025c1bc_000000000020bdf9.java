
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Test Cases
		boolean useC = true;
		for (int i = 1; i <= t; ++i) {
			
			int n = in.nextInt(); // Num activities
			StringBuffer resultCase = new StringBuffer();
			
			List<Integer> camActivities = new ArrayList<Integer>();
			List<Integer> jaiActivities = new ArrayList<Integer>();
			
			if (n >= 2) {
			
				for (int o = 0; o < n; o++) {
					int s = in.nextInt(); // Begin mins after midnight
					int e = in.nextInt(); // End mins after midnight
					
					boolean asignado = false;
					boolean error = false;
					if (e > 1440 || s > 1440) {
						error = true;
					} else {
						
						if (useC) {
							asignado = asignarTarea(camActivities, s, e, resultCase, true);
							if (!asignado) {
								asignado = asignarTarea(jaiActivities, s, e, resultCase, false);
							}
						} else {
							asignado = asignarTarea(jaiActivities, s, e, resultCase, false);
							if (!asignado) {
								asignado = asignarTarea(camActivities, s, e, resultCase, true);
							}
						}
						
					}
					
					if (!asignado || error) {
						resultCase = new StringBuffer().append("IMPOSSIBLE");
					}
				}
			}
			
			if (!resultCase.toString().equals("IMPOSSIBLE")) {
				useC = !useC;
			}
			
			System.out.println("Case #" + i + ": " + resultCase.toString());
			System.out.flush();
			
		}
	}
	
	private static boolean asignarTarea(List<Integer> listaPeriodos, int s, int e, StringBuffer resultBuffer,
			boolean isC) {
		
		// Comprobamos si alguno esta libre a esa hora
		boolean overlap = false;
		boolean asignado = false;	
		
		if (listaPeriodos.isEmpty()) {
			asignado = true;
		} else {
			for (int u = 0; u < listaPeriodos.size(); u+=2) {
				if (listaPeriodos.get(u) < e && s < listaPeriodos.get(u+1)) {
					overlap = true;
					break;
				}
			}
			if (!overlap) {
				asignado = true;

			}
		}

		if (asignado) {
			listaPeriodos.add(s);
			listaPeriodos.add(e);
			if (isC) {
				resultBuffer.append("C");
			} else {
				resultBuffer.append("J");
			}
		}
		
		return asignado;
	}
}

