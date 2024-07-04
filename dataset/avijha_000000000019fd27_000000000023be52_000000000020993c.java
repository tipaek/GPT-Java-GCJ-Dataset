import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int total_cases = in.nextInt();
		for(int test = 1; test <= total_cases;test++) {
			int n = in.nextInt();
			boolean[][] tracker = new boolean[n+1][n+1];
			boolean[] column_done = new boolean[n+1];
			int row_count = 0;
			int column_count=0;
			int trace = 0;
			for(int i=0;i<n;i++) {
				boolean[] row = new boolean[n+1];
				boolean done = false;
				for(int j=0;j<n;j++) {
					int val = in.nextInt();
					if(i==j)
						trace+=val;
					if(!done) {
						if(row[val]) {
							done=true;
							row_count++;
						}
						else
							row[val]=true;
							
					}
					if(!column_done[j]) {
						if(tracker[j][val]) {
							column_done[j]=true;
							column_count++;
						}
						else
							tracker[j][val]=true;
					}	
				}
			}
			System.out.println("Case #"+test+": "+trace+" "+row_count+" "+column_count);
		}

	}

}
