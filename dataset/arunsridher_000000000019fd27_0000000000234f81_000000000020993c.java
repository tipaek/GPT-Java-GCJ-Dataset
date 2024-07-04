import java.util.Scanner;
class Vestigium {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//read number of test cases
		int T = sc.nextInt();
		
		//process each test case
		for(int n = 1; n <= T; n++) {
			
			//read matrix 
			int size = sc.nextInt();
			int[][] mat = new int[size][size];
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < size; j++) {
					mat[i][j] = sc.nextInt();
				}
			}
			
			//find k
			int k = 0;
			for(int i = 0; i < size; i++) {
				k += mat[i][i];
			}
			
			//find r
			int r = 0;
			for(int i = 0; i < size; i++) {
				int[] hash = new int[size+1];
				for(int j = 0; j < size; j++) {
					hash[mat[i][j]]++;
					if(hash[mat[i][j]] > 1) {
						r++;
						break;
					}
				}
			}
			
			//find c
			int c = 0;
			for(int i = 0; i < size; i++) {
				int[] hash = new int[size+1];
				for(int j = 0; j < size; j++) {
					hash[mat[j][i]]++;
					if(hash[mat[j][i]] > 1) {
						c++;
						break;
					}
				}
			}
			System.out.format("Case # %d: %d %d %d", n,k,r,c);
		}
		
		sc.close();
	}
}






