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
			int flag = 0; 
			for(int i = 0; i < activities * 2; i++) {
				if(scanner.hasNextInt())
					act[i] = scanner.nextInt();
				else {
					flag = 1;
					break; 
				}
			}
			if(flag == 1) {
				System.out.println("Case #" + (time + 1) + ": " + "IMPOSSIBLE");
				continue; 
			}
			
			HashSet<Integer> cset = new HashSet<>(); 
			HashSet<Integer> jset = new HashSet<>(); 
			String previous = "C"; 
			for(int i = 0; i < act.length - 1; i += 2) {
				if(i == 0) {
					result.append("C"); 
					for(int add = act[i]; add <= act[i + 1]; add++)
						cset.add(add); 
				}
				else if(previous == "C") {
					if(checkIfContained(cset, act[i], act[i + 1])) {
						result.append("C"); 
						for(int add = act[i]; add <= act[i + 1]; add++)
							cset.add(add);
					}
					else if(checkIfContained(jset, act[i], act[i + 1])){
						result.append("J");
						previous = "J";
						for(int add = act[i]; add <= act[i + 1]; add++)
							jset.add(add);
					}
					else {
						result = new StringBuilder("IMPOSSIBLE"); 
						break;
					}
				}
				else if(previous == "J") {
					if(checkIfContained(jset, act[i], act[i + 1])) {
						result.append("J");
						for(int add = act[i]; add <= act[i + 1]; add++)
							jset.add(add);	
					}
					else if(checkIfContained(cset, act[i], act[i + 1])){
						result.append("C"); 
						previous = "C"; 
						for(int add = act[i]; add <= act[i + 1]; add++)
							cset.add(add);
					}
					else {
						result = new StringBuilder("IMPOSSIBLE"); 
						break;
					}
				}
			}
			
			
			System.out.println("Case #" + (time + 1) + ": " + result.toString());
		}
	}
	
	public static boolean checkIfContained(HashSet<Integer> set, int left, int right) {
		for(int i = left + 1; i < right; i++) {
			if(set.contains(i))
				return false; 
		}
		return true; 
	}
}
