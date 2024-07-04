import java.util.HashSet;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int times = scanner.nextInt(); 
		
		for(int time = 0; time < times; time++) {
			StringBuilder result = new StringBuilder(); 
			int activities = scanner.nextInt();
			int[] act = new int[activities * 2];  
			for(int i = 0; i < activities * 2; i++) {
				act[i] = scanner.nextInt(); 
			}
			
			HashSet<Integer> cset = new HashSet<>(); 
			HashSet<Integer> jset = new HashSet<>(); 
			String previous = "C"; 
			for(int i = 0; i < act.length - 1; i += 2) {
				if(i == 0) {
					result.append("C"); 
					for(int add = act[i] + 1; add < act[i + 1]; add++)
						cset.add(add); 
				}
				else if(cset.contains(act[i]) && jset.contains(act[i])) {
					result = new StringBuilder("IMPOSSIBLE"); 
					break; 
				}
				else if(previous == "C") {
					if(!cset.contains(act[i]) && !cset.contains(act[i + 1])) {
						result.append("C"); 
						for(int add = act[i] + 1; add < act[i + 1]; add++)
							cset.add(add);
					}
					else {
						result.append("J");
						previous = "J";
						for(int add = act[i] + 1; add < act[i + 1]; add++)
							jset.add(add);
					}
				}
				else if(previous == "J") {
					if(!jset.contains(act[i]) && !jset.contains(act[i + 1])) {
						result.append("J");
						for(int add = act[i] + 1; add < act[i + 1]; add++)
							jset.add(add);	
					}
					else {
						result.append("C"); 
						previous = "C"; 
						for(int add = act[i] + 1; add < act[i + 1]; add++)
							cset.add(add);
					}
				}
			}
			
			
			System.out.println("Case #" + (time + 1) + ": " + result.toString());
		}
	}
}
