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
		int t = in.nextInt(); // Test Cases
		for (int i = 1; i <= t; ++i) {
			int n = in.nextInt(); // Num activities
			StringBuffer resultCase = new StringBuffer();
			
			Map<String, List<Integer>> mapActividades = new HashMap<String, List<Integer>>();
			//Inicializamos el mapa
			mapActividades.put("C", new ArrayList<Integer>());
			mapActividades.put("J", new ArrayList<Integer>());
			
			if (n >= 2) {
			
				for (int o = 0; o < n; o++) {
					int s = in.nextInt(); // Begin mins after midnight
					int e = in.nextInt(); // End mins after midnight
					
					boolean asignado = false;
					boolean error = false;
					if (e > 1440 || s > 1440) {
						error = true;
					} else {
						
						// Comprobamos si alguno esta libre a esa hora
						for (Map.Entry<String, List<Integer>> entry : mapActividades.entrySet()) {
							List<Integer> listaPeriodos = entry.getValue();
							boolean overlap = false;
							
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
								mapActividades.get(entry.getKey()).add(s);
								mapActividades.get(entry.getKey()).add(e);
								
								resultCase.append(entry.getKey());
								break;
							}
						}
					}
					
					if (!asignado || error) {
						resultCase = new StringBuffer().append("IMPOSSIBLE");
					}
				}
			}
			
			System.out.flush();
			System.out.println("Case #" + i + ": " + resultCase.toString());
		}
	}
	
}

