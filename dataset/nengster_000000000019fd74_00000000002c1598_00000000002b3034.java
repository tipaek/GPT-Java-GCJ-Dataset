import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	int caseNo;
	int N;
	ArrayList<String> P = new ArrayList<String>();
	public Solution() {

	}

	public Solution(String string) {

	}

	public Solution(Scanner in, int caseNo) {
		this.caseNo = caseNo;
		N = Integer.parseInt(in.nextLine());
		for(int i=0;i<N;i++) {
			P.add(in.nextLine());
		}
	}

	void match1() {
		int longest=0;
		int longIdx=0;
		for(int i=0;i<P.size();i++) {
			String Pi=P.get(i);
			if(Pi.length()>longest) {
				longest = Pi.length();
				longIdx=i;
			}
		}
		String longStr=P.get(longIdx);
		for(int i=0;i<P.size();i++) {
			if(i!=longIdx) {
				String Pi=P.get(i);
				if(!Pi.equals("*") && longStr.indexOf(Pi.substring(1))<0) {
					System.out.print("*");
					return;
				}
			}
		}
		System.out.println(longStr.substring(1));
	}
	

	
	void printCase() {
		System.out.print("Case #" + caseNo + " ");

		match1();
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int TS = Integer.parseInt(in.nextLine());
        ArrayList<Solution> solution = new ArrayList<Solution>();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.add(new Solution(in, ts));
        }
        in.close();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.get(ts).printCase();
        }

	}

}
