import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int tests = in.nextInt();
		for(int test=1; test<=tests; test++) {
			int tasks_no = in.nextInt();
			int[][] tasks = new int [tasks_no][3];
			for (int i=0; i<tasks_no; i++) {
				tasks[i][0] = in.nextInt();
				tasks[i][1] = in.nextInt();
				tasks[i][2] = i;
			}
			int[][] tasks_sorted = new int [tasks_no][3];
			for (int i=0; i<tasks_no; i++) {
				int min=tasks[i][0];
				int min_i=i;
				for (int j=0; j<tasks_no; j++) {
					if (tasks[j][0] < min) {
						min=tasks[j][0];
						min_i=j;
					}
				}
				tasks_sorted[i][0]=tasks[min_i][0];
				tasks_sorted[i][1]=tasks[min_i][1];
				tasks_sorted[i][2]=min_i;
				tasks[min_i][0]=9999;
			}
			print(test, tasks_sorted);
		}
	}
	
	private static void print(int test, int[][] input) {
		String result = "";
		int c_finish=0;
		int j_finish=0;
		String[] person = new String[input.length];
		for(int i=0; i<input.length; i++) {
			if (input[i][0] >= c_finish) {
				person[i]="C";
				c_finish=input[i][1];
			} else if (input[i][0] >= j_finish) {
				person[i]="J";
				j_finish=input[i][1];
			} else {
				result="IMPOSSIBLE";
				break;
			}
		}
		if (result=="IMPOSSIBLE") {
			result="Case #"+test+": "+result;
			System.out.println(result);
			return;
		}
		for (int i=0; i<input.length;i++) {
			for (int j=0; j<input.length;j++) {
				if(input[j][2]==i) {
					result+=person[j];
					break;
				}
			}
		}
		result="Case #"+test+": "+result;
		System.out.println(result);
	}

}
