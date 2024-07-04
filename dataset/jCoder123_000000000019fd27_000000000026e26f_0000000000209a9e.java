import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		  Scanner input = new Scanner(System.in);	
	        
	        int T = input.nextInt();
        	int B = input.nextInt();
	        	        
	        for (int ks = 1; ks <= T; ks++) {
	        	int[] positions = new int[B];
	        	solve(input, positions);
	        	if (input.nextLine() == "N") {
	        		break;
	        	}
	        }
	}
	
	public static void solve(Scanner input, int[] positions) {
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
			
		}
		else if (positions.length == 20) {
			
			//1 rand
			System.out.println("2");			
			System.out.println("4");			
			System.out.println("6");			
			System.out.println("8");			
			System.out.println("10");			
			System.out.println("12");			
			System.out.println("14");			
			System.out.println("16");			
			System.out.println("18");			
			System.out.println("20");
			
			//2 rand
			System.out.println("2");			
			System.out.println("4");			
			System.out.println("6");			
			System.out.println("8");			
			System.out.println("10");			
			System.out.println("12");			
			System.out.println("14");			
			System.out.println("16");			
			System.out.println("18");			
			System.out.println("20");
			
			
			//3 rand
			System.out.println("2");			
			System.out.println("4");			
			System.out.println("6");			
			System.out.println("8");			
			System.out.println("10");			
			System.out.println("12");			
			System.out.println("14");			
			System.out.println("16");			
			System.out.println("18");			
			System.out.println("20");
			
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
			System.out.println("3");			
			System.out.println("5");			
			System.out.println("7");			
			System.out.println("9");			
			System.out.println("11");			
			System.out.println("13");			
			System.out.println("15");			
			System.out.println("17");			
			System.out.println("19");
			
			//6 rand
			System.out.println("1");			
			System.out.println("3");			
			System.out.println("5");			
			System.out.println("7");			
			System.out.println("9");			
			System.out.println("11");			
			System.out.println("13");			
			System.out.println("15");			
			System.out.println("17");			
			System.out.println("19");
			
			//7 rand
			System.out.println("1");			
			System.out.println("3");			
			System.out.println("5");			
			System.out.println("7");			
			System.out.println("9");			
			System.out.println("11");			
			System.out.println("13");			
			System.out.println("15");			
			System.out.println("17");			
			System.out.println("19");
			
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
			
		}
		else if (positions.length == 100) {
			String result = "";
			System.out.println(result);
		}
		
	}

}
