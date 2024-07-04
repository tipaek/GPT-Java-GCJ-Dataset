import java.util.Scanner;

class problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.valueOf(sc.nextLine());
		String result = "";
		
		for(int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			int trace = 0;
			int drows = 0;
			int dcols = 0;
			
			int[][] cols = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				int[] rows = new int[n];
				for(int j = 0; j < n; j++) {
					int curnum = sc.nextInt();
					if(i == j) {
						trace += curnum;
					}
					rows[curnum-1]++;
					cols[j][curnum-1]++;
				}
				
				for(int j = 0; j < n; j++) {
					if(rows[j] > 1) {
						drows++;
						break;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(cols[i][j] > 1) {
						dcols++;
						break;
					}
				}
			}
			
			result += "Case #" + (tc+1) + ": " + trace + " " + drows + " " + dcols + "\n";
		}
		
		System.out.print(result);
		
		sc.close();
	}
}
