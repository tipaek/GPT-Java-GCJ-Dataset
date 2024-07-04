import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int caseCount = in.nextInt();
		in.nextLine();

		for(int c = 1; c <= caseCount; c++) {
			String line = in.nextLine();
						
			List<Character> digits = line.chars()
					.boxed()
					.map(x -> Character.valueOf((char) x.intValue()))
					.collect(Collectors.toList());
						
			int largest = -1;
			
			for(char digit : digits) {
				if (digit - 48 > largest) {
					largest = (int) digit - 48;
				}
			}
			
			for(int i = 1; i <= largest; i++) {				
				for(int j = 0; j < digits.size(); j++) {
					
					if(digits.get(j) - 48 >= i) {
						digits.add(j, Character.valueOf('('));
						
						//j += 1;
						while(j < digits.size()) {
							if(j == digits.size() - 1) {
								digits.add(j + 1, Character.valueOf(')'));
								j++;
								break;
							}
							if(Character.isDigit(digits.get(j)) && digits.get(j) - 48 < i) {
								digits.add(j, Character.valueOf(')'));
								j++;
								break;
							}
							j++;
						}
					}
				}
				
			}
			
			System.out.println("Case #" + c + ": "+ digits.stream().map(String::valueOf).collect(Collectors.joining()));
		}
	}
}
