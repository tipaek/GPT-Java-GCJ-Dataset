import java.util.Scanner;

public class Solution {


	static Solution sol = new Solution();
	public static void main(String[] args) {
		Scanner scann = new Scanner(System.in);  // Create a Scanner object
		int T = scann.nextInt();
		scann.nextLine();

		for(int usease = 0; usease< T;usease++) {

			String line = scann.nextLine();
			
			String min = "0";
			
			String result =printNest(line,min);
			
			line = line.replace(result.replace("(", "").replace(")", ""), "");

			System.out.println(String.format("Case #%s: %s",usease+1,result));			

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
			String currentMin = min;
			String[] arr = line.split(currentMin);
			while(arr.length ==1 && arr[0].length()==line.length()) {
				currentMin = String.valueOf(Integer.valueOf(currentMin)+1);
				arr = line.split(currentMin);
			}
			
			int currentValue = Integer.parseInt(currentMin);
			int minValue = Integer.parseInt(min);

			for(String result : arr) {
				if(result.isEmpty()) {
					sb.append(currentMin);
				}
				else {
					sb.append(printNest(result,currentMin));
					sb.append(currentMin);//on ajoute un charactere de plit entre chaque groupe, doit être enlvé si pas présent à la fin dans la ligne d'input
				}
			}
			//Issue when line finishe with multiple currentMin
			sb.deleteCharAt(sb.toString().length()-1);
			line = line.replace(sb.toString().replace("(", "").replace(")", ""), "");
			sb.append(line);
			
			
			
//			String[] tmp = line.split(arr[arr.length-1]);
//			sb.append(tmp[tmp.length-1]);
			

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


