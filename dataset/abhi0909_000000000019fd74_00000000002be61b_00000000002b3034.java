import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int print = 1;
		while(t -- > 0) {
			
			int n = sc.nextInt();
			
			String str[] = new String[n];
			
			for(int i=0; i<str.length; i++) {
				
				str[i] = sc.next();
			}
			
			//Case 1:
			if(str[0].charAt(0) == '*') {
					
				String ans = "";
				boolean flag = true;
				
				//Find the minimum length String
				
				String minimum = str[0];
				for(int i=1; i<n; i++) {
					
					if(str[i].length() < minimum.length()) {
						minimum = str[i];
					}
				}
				//System.out.println("minimum: " + minimum);
				
				//Find if minimum available in all the substring
				for(int i=0; i<n; i++) {
					
					int start1 = minimum.length()-1;
					int start2 = str[i].length()-1;
					
					while(start1 != 0 && start2 != 0) {
						
						
						if(minimum.charAt(start1) == '*') {
							break;
						}
						
						if(minimum.charAt(start1) != str[i].charAt(start2)) {
							flag = false;
							break;
						}
						start1--;
						start2--;
					}
					
					if(!flag) {
						break;
					}
				}
				
				if(flag) {
					
					int index = 0;
					for(int i=1; i<n; i++) {
						if(str[index].length() < str[i].length()) {
							index = i;
						}
					}
					
					System.out.println("CASE #"+print+": "+str[index].substring(1));
					
				}else {
					System.out.println("CASE #"+print+": *");
				}
				print++;
			}
		}
	}
}
