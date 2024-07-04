import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
        	int B = input.nextInt();
	        	        
	        for (int ks = 1; ks <= T; ks++) {
	        	int[] positions = new int[B];
	        	boolean result = solve(input, positions);
	        	if (result == false) {
	        		break;
	        	}
	        }
	}
	
	public static boolean solve(Scanner input, int[] positions) {
		if (positions.length == 10) {
						
			System.out.println("1");
			positions[0] = input.nextInt();
			
			System.out.println("2");
			positions[1] = input.nextInt();
			
			System.out.println("3");
			positions[2] = input.nextInt();
			
			System.out.println("4");
			positions[3] = input.nextInt();
			
			System.out.println("5");
			positions[4] = input.nextInt();
			
			System.out.println("6");
			positions[5] = input.nextInt();
			
			System.out.println("7");
			positions[6] = input.nextInt();
			
			System.out.println("8");
			positions[7] = input.nextInt();
			
			System.out.println("9");
			positions[8] = input.nextInt();
			
			System.out.println("10");
			positions[9] = input.nextInt();
			
			String result = "";
			
			for (int i = 0; i < positions.length; i++) {
				result+= "" + positions[i];
			}
			
			System.out.println(result);
			
			if (input.next().equals("N")) {
				return false;
			}
			
		}
		else if (positions.length == 20) {
			
			//1 rand
			System.out.println("2");	
			int temp = input.nextInt();
			System.out.println("4");
			temp = input.nextInt();
			System.out.println("6");
			temp = input.nextInt();
			System.out.println("8");
			temp = input.nextInt();
			System.out.println("10");	
			temp = input.nextInt();
			System.out.println("12");
			temp = input.nextInt();
			System.out.println("14");	
			temp = input.nextInt();
			System.out.println("16");	
			temp = input.nextInt();
			System.out.println("18");
			temp = input.nextInt();
			System.out.println("20");
			temp = input.nextInt();
			
			//2 rand
			System.out.println("2");
			temp = input.nextInt();
			System.out.println("4");	
			temp = input.nextInt();
			System.out.println("6");
			temp = input.nextInt();
			System.out.println("8");
			temp = input.nextInt();
			System.out.println("10");
			temp = input.nextInt();
			System.out.println("12");
			temp = input.nextInt();
			System.out.println("14");
			temp = input.nextInt();
			System.out.println("16");
			temp = input.nextInt();
			System.out.println("18");
			temp = input.nextInt();
			System.out.println("20");
			temp = input.nextInt();
			
			
			//3 rand
			System.out.println("2");
			temp = input.nextInt();
			System.out.println("4");	
			temp = input.nextInt();
			System.out.println("6");
			temp = input.nextInt();
			System.out.println("8");
			temp = input.nextInt();
			System.out.println("10");
			temp = input.nextInt();
			System.out.println("12");
			temp = input.nextInt();
			System.out.println("14");
			temp = input.nextInt();
			System.out.println("16");
			temp = input.nextInt();
			System.out.println("18");
			temp = input.nextInt();
			System.out.println("20");
			temp = input.nextInt();
			
			//4 rand = original
			System.out.println("2");	
			positions[1] = input.nextInt();
			System.out.println("4");
			positions[3] = input.nextInt();
			System.out.println("6");
			positions[5] = input.nextInt();
			System.out.println("8");
			positions[7] = input.nextInt();
			System.out.println("10");
			positions[9] = input.nextInt();
			System.out.println("12");	
			positions[11] = input.nextInt();
			System.out.println("14");	
			positions[13] = input.nextInt();
			System.out.println("16");
			positions[15] = input.nextInt();
			System.out.println("18");
			positions[17] = input.nextInt();
			System.out.println("20");
			positions[19] = input.nextInt();
			
			//5 rand
			System.out.println("1");		
			temp = input.nextInt();
			System.out.println("3");
			temp = input.nextInt();
			System.out.println("5");
			temp = input.nextInt();
			System.out.println("7");
			temp = input.nextInt();
			System.out.println("9");
			temp = input.nextInt();
			System.out.println("11");
			temp = input.nextInt();
			System.out.println("13");
			temp = input.nextInt();
			System.out.println("15");	
			temp = input.nextInt();
			System.out.println("17");	
			temp = input.nextInt();
			System.out.println("19");
			temp = input.nextInt();

			
			//6 rand
			System.out.println("1");		
			temp = input.nextInt();
			System.out.println("3");
			temp = input.nextInt();
			System.out.println("5");
			temp = input.nextInt();
			System.out.println("7");
			temp = input.nextInt();
			System.out.println("9");
			temp = input.nextInt();
			System.out.println("11");
			temp = input.nextInt();
			System.out.println("13");
			temp = input.nextInt();
			System.out.println("15");	
			temp = input.nextInt();
			System.out.println("17");	
			temp = input.nextInt();
			System.out.println("19");
			temp = input.nextInt();

			
			//7 rand
			System.out.println("1");		
			temp = input.nextInt();
			System.out.println("3");
			temp = input.nextInt();
			System.out.println("5");
			temp = input.nextInt();
			System.out.println("7");
			temp = input.nextInt();
			System.out.println("9");
			temp = input.nextInt();
			System.out.println("11");
			temp = input.nextInt();
			System.out.println("13");
			temp = input.nextInt();
			System.out.println("15");	
			temp = input.nextInt();
			System.out.println("17");	
			temp = input.nextInt();
			System.out.println("19");
			temp = input.nextInt();

			
			//8 rand = original
			System.out.println("1");	
			positions[0] = input.nextInt();
			System.out.println("3");	
			positions[2] = input.nextInt();
			System.out.println("5");	
			positions[4] = input.nextInt();
			System.out.println("7");
			positions[6] = input.nextInt();
			System.out.println("9");
			positions[8] = input.nextInt();
			System.out.println("11");
			positions[10] = input.nextInt();
			System.out.println("13");
			positions[12] = input.nextInt();
			System.out.println("15");
			positions[14] = input.nextInt();
			System.out.println("17");
			positions[16] = input.nextInt();
			System.out.println("19");
			positions[18] = input.nextInt();
			
			String result = "";

			for (int i = 0; i < positions.length; i++) {
				result+= "" + positions[i];
			}
			
			System.out.println(result);
			
			if (input.next().equals("N")) {
				return false;
			}
			
		}
		else if (positions.length == 100) {
			String result = "";
			System.out.println(result);
			
			if (input.next().equals("N")) {
				return false;
			}
		}
		return true;
		
	}

}
