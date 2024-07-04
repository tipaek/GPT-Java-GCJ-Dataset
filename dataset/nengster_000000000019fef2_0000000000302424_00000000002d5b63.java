import java.util.Scanner;

public class Solution {
	final int wallX = 1000000000;
	final int wallY = 1000000000;
	int T;
	int A;
	int B;
	int R;
	int X;
	int Y;

	static Scanner in = new Scanner(System.in);
	
	void readline_int_list(){
		T = in.nextInt();
		A = in.nextInt();
		B = in.nextInt();		
	}
	
	String readline_string() {

		return in.nextLine();
	}
	
	void printLine() {
		System.out.println(X + " " + Y);
	}

	String bullEyes1() {
		for (X=-5 ; X <=5; X++) {
			for (Y=-5; Y <=5; Y++) {
				printLine();
				String response = readline_string();
				if (response.equals("CENTER") || response.equals("WRONG")) {
					return response;
				}
			}
		}
		return "IMPOSSIBLE";
	}

	void bullEyes2() {
		int i = 0; // vertical move;
		int j = 0; // horizontal move;		
	}
	void bullEyes() {
		readline_int_list();
		for (int t = 0; t < T; t ++) {
			String result = bullEyes1();
			if(result.contentEquals("WRONG")) {
				return;
			}
		}
	}
	
	public static void main(String[] args) {

        Solution solution = new Solution();
        solution.bullEyes();

	}

}
