import java.util.Scanner;

class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int caseNo = 1;
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			boolean foundSolution = false;
			for(int i = 1; i<=n; i++) {
				if(n*i == k) {
					foundSolution = true;
					System.out.println("Case #" + caseNo++ + ": POSSIBLE");
					break;
				}
			}
			if(n>2 && !foundSolution && (n*(n+1))/2 == k){
				foundSolution = true;
				System.out.println("Case #" + caseNo++ + ": POSSIBLE");
			}
			if(!foundSolution) {
				System.out.println("Case #" + caseNo++ + ": IMPOSSIBLE");
			}
			
		}
	}

}