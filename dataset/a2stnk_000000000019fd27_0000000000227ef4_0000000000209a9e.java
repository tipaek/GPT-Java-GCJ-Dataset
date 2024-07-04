import java.util.Random;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int B = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			Solver solver = new Solver(sc, B);
//			Solver solver = new TestSolver(sc, B);
			if(!solver.solve()) {
				System.err.println("error");
				break;
			}
		}
		
		sc.close();
	}
	
	static class Solver {
		Scanner sc;
		int B;
		public Solver() {
			sc = new Scanner(System.in);
		}
		public Solver(Scanner sc, int B) {
			this.sc = sc;
			this.B = B;
		}
		
		boolean solve() {
			int[] ans = new int[B];
			int queryNum = 0;
			int equalPos = -1;
			int diffPos = -1;
			for(int i=0; i<B/2; i++) {
				ans[i] = getAt(i);
				ans[B-1-i] = getAt(B-1-i);
				if(equalPos < 0 && ans[i]==ans[B-1-i]) {
					equalPos = i;
				}
				if(diffPos < 0 && ans[i]!=ans[B-1-i]) {
					diffPos = i;
				}
				queryNum += 2;
				if(queryNum % 10 == 0 && i<B/2-1) {
					if(equalPos>=0 && diffPos>=0) {
						int eAfter = getAt(equalPos);
						int dAfter = getAt(diffPos);
						if(eAfter==ans[equalPos]) {
							if(dAfter==ans[diffPos]) {
								;//do nothing
							} else {
								ans = reverse(ans);
							}
						} else {
							if(dAfter==ans[diffPos]) {
								ans = reverse(complement(ans));
							} else {
								ans = complement(ans);
							}
						}
						
					} else if(equalPos>=0) {
						int eAfter = getAt(equalPos);
						getAt(equalPos);//to make queryNum even
						if(eAfter!=ans[equalPos]) {
							ans = complement(ans);
						}
					} else if(diffPos>=0) {
						int dAfter = getAt(diffPos);
						getAt(diffPos);//to make queryNum even
						if(dAfter!=ans[diffPos]) {
							ans = complement(ans);
						}
					} else {
						;//never reach
					}
					queryNum += 2;
				}
			}
			
			return answer(ans);
		}

		int getAt(int x) {
			System.out.println(x+1);
			return sc.nextInt();
		}

		boolean answer(int[] ans) {
			for(int i=0; i<B; i++)
				System.out.print(ans[i]);
			System.out.println();
			return sc.next().equals("Y");
		}
		
		int[] complement(int[] v) {
			int[] ans = new int[v.length];
			for(int i=0; i<v.length; i++)
				ans[i] = 1-v[i];
			return ans;
		}
		int[] reverse(int[] v) {
			int[] ans = new int[v.length];
			for(int i=0; i<v.length; i++)
				ans[i] = v[B-1-i];
			return ans;
		}
	}
	
	static class TestSolver extends Solver {
		int[] bits;
		Random rand;
		int queryNum;
		
		public TestSolver(Scanner sc, int B) {
			this.B = B;
			this.sc = sc;
			bits = new int[B];
			rand = new Random();
			for(int i=0; i<B; i++) {
				bits[i] = rand.nextInt(2);
			}
			queryNum = 0;
		}
		
		@Override
		int getAt(int x) {
			queryNum++;
			if(queryNum>10 && (queryNum%10)==1) {
				if(rand.nextInt(2)==1) {
					bits = complement(bits);
				}
				if(rand.nextInt(2)==1) {
					bits = reverse(bits);
				}
			}
			return bits[x];
		}

		@Override
		boolean answer(int[] ans) {
			System.out.print("expected = ");
			printBits(bits);
			System.out.println();
			System.out.print("query = ");
			printBits(ans);
			System.out.println();
			
			for(int i=0; i<B; i++)
				if(ans[i]!=bits[i]) {
					System.out.println("NG");
					return false;
				}

			System.out.println("OK");
			return true;
		}
		
		void printBits(int[] b) {
			for(int i=0; i<b.length; i++)
				System.out.print(b[i]);
		}
	}
}
