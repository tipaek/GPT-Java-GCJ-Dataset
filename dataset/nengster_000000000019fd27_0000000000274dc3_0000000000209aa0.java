import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
	int N;
	int K;
	public Solution(int n, int k) {
		N = n;
		K = k;
	}

	void printResult(int caseNo) {
		int trace = K/N;		
		if (K%N != 0 || trace>N) {
			System.out.println("Case #" + caseNo + ": IMPOSSIBLE" );			
			return;		
		}
		System.out.println("Case #" + caseNo + ": POSSIBLE" );

		for(int i=0; i<N; i++) {
			int j=0;
			int start = trace-i;
			int number = start>0 ?	start : start+N;
			for(; number<=N;number++) {
				if(number!=trace || i==j) {
					System.out.print(number+" ");
				}
				j++;
			}
			number=1;
			for(; j<N;number++) {
				if(number!=trace || i==j) {
					System.out.print(number+" ");
				}
				j++;				
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in); 
        int TS = in.nextInt();
        ArrayList<Solution> solution = new ArrayList<Solution>();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.add(new Solution(in.nextInt(), in.nextInt()));
        }
        in.close();
        for (int ts = 0; ts < TS; ts++ ) {
        	solution.get(ts).printResult(ts+1);
        }

	}

}
