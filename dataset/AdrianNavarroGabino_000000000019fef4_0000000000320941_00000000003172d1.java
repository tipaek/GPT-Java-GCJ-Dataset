import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cases = sc.nextInt();
		
		for(int index = 1; index <= cases; index++) {
			int rebanadas = sc.nextInt();
			int comensales = sc.nextInt();
			Map<Long, Integer> tamanyos = new HashMap<Long, Integer>();
			int cortes = comensales - 1;
			boolean found = false;
			
			for(int i = 0; i < rebanadas; i++) {
				Long t = sc.nextLong();
				tamanyos.put(t,tamanyos.containsKey(t) ? tamanyos.get(t) + 1 : 1);
			}
			
			int maxValue = tamanyos.entrySet()
					.stream()
					.max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
					.get().getValue();
			
			if(comensales <= maxValue) {
				cortes = 0;
			}
			else {
				for(int i = 1; i < comensales - 1; i++) {
					int p = i;
					for (Map.Entry<Long, Integer> entry : tamanyos.entrySet()) {
						Long aux = entry.getKey() / p;
						
						if(aux == (entry.getKey() * 1.0 / p) && tamanyos.containsKey(aux)) {
							if(p + 1 + tamanyos.get(aux) >= comensales) {
								cortes = p;
								found = true;
								break;
							}
						}
						else {
							if(p + 1 >= comensales) {
								cortes = p;
								found = true;
								break;
							}
						}
					}
					if(found) {
						break;
					}
				}
			}
			
			System.out.println("Case #" + index + ": " + cortes);
		}
		
		sc.close();
	}

}