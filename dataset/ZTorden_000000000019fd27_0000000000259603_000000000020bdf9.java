import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

	int N;
	int[][] tasks;
	int[][] points;
	StringBuilder result;
	boolean ispossible;
	
	private void readTest() {
		N=scanner.nextInt();
		tasks=new int[N][2];
		points=new int[24*60+1][2];
		for(int i=0;i<N;i++) {
			tasks[i][0]=scanner.nextInt();
			points[tasks[i][0]][0]++;
			points[tasks[i][0]][1]=1;
			tasks[i][1]=scanner.nextInt();
			points[tasks[i][1]][0]--;
			points[tasks[i][1]][1]=1;
		}
	}


	private void calculate() {
		int jobs=0;
		for(int i=0;i<points.length;i++) {
			jobs+=points[i][0];
			if (jobs>2) {
				ispossible=false;
				return;
			}
		}
		ispossible=true;
		result = new StringBuilder();
		for(int i=0;i<N;i++) {
			boolean canCdo = ((points[tasks[i][0]][1]<=2)&&((points[tasks[i][1]][1]==1)||(points[tasks[i][1]][1]==3)));
			if (canCdo)
				for(int j=tasks[i][0]+1;j<tasks[i][1];j++)
					if(points[j][1]>1) {
						canCdo = false;
						break;
					}
			if(!canCdo)
				result.append('J');
			else {
				result.append('C');
				points[tasks[i][0]][1]=3;
				points[tasks[i][1]][1]=2;
				for(int j=tasks[i][0]+1;j<tasks[i][1];j++)
					if(points[j][1]==1)
						points[j][1]=4;
			}
		}
					
	}

	private void printResult(int i) {
		StringBuilder sb = new StringBuilder();
		sb.append("Case #" + i + ": ");
		
		if(ispossible)
			sb.append(result);
		else
			sb.append("IMPOSSIBLE");
		
		System.out.println(sb.toString());
		
	}

	public static void main(String[] args) {
		new Solution().run();
	}

	public void run() {
		int T = scanner.nextInt();
		scanner.nextLine();
		
		for(int i = 1; i <= T; i++) {
			readTest();
			calculate();
			printResult(i);
		}
	}

}
