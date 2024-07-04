import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	StringBuilder S = new StringBuilder("");
	public Solution(String inStr) {
		int pOpen = 0;
		for(int i=0; i<inStr.length(); i++) {
			int number = Character.getNumericValue(inStr.charAt(i));
			while(pOpen<number) {
				S.append('(');
				pOpen++;
			}
			while(pOpen>number) {
				S.append(')');
				pOpen--;
			}
			S.append(number);
		}
		while(pOpen>0) {
			S.append(')');
			pOpen--;
		}
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int TS = Integer.parseInt(in.nextLine());
        ArrayList<Solution> solution = new ArrayList<Solution>();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.add(new Solution(in.nextLine()));
        }
        in.close();
        for (int ts = 0; ts < TS; ts++ ) {
        	System.out.println("Case #" + (ts+1) + ": " + solution.get(ts).S);
        }

	}
}
