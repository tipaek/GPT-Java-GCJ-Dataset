import java.util.Scanner;

public class Solution {



	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();
		scann.nextLine();

		Solution s = new Solution();
		for(int usease = 0; usease< T;usease++) {

			String line = scann.nextLine();
			
			String min = "0";
			
			
			

			System.out.println(String.format("Case #%s: %s",usease+1,printNest(line,min)));			

		}

		
	}
	public static String printNest(String line,String min) {
		StringBuilder sb = new StringBuilder();
		
		if(line.length()==1 || allCharactersSame(line)) {
			int currentValue = Integer.parseInt(line.substring(0, 1));
			int minValue = Integer.parseInt(min);
			sb.append(line);
			for(int i = 0;i<currentValue-minValue;i++) {
				sb.append(")");
				sb.insert(0, "(");
			}
		}
		else {
			String currentMine = min;
			String[] arr = line.split(currentMine);
			while(arr.length ==1 && arr[0].length()==line.length()) {
				currentMine = String.valueOf(Integer.valueOf(currentMine)+1);
				arr = line.split(currentMine);
			}
			
			for(String subline : arr) {
				if(!subline.isEmpty()) sb.append(printNest(subline,currentMine)).append(currentMine);
			}
			if(!line.endsWith(currentMine)) {
				sb.deleteCharAt(sb.length()-1);
			}
			if(line.startsWith(currentMine)) {
				sb.append(currentMine);
			}
			int currentValue = Integer.parseInt(currentMine);
			int minValue = Integer.parseInt(min);
			for(int i = 0;i<currentValue-minValue;i++) {
				sb.append(")");
				sb.insert(0, "(");
			}
			
			
			
		}
		
		
		return sb.toString();
		
	}

	static boolean allCharactersSame(String s) 
	{ 
	    int n = s.length(); 
	    for (int i = 1; i < n; i++) 
	        if (s.charAt(i) != s.charAt(0)) 
	            return false; 
	          
	    return true; 
	} 

}


