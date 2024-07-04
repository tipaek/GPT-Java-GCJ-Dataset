
import java.util.*;

public class Solution {
	static Scanner CONSOLE = new Scanner(System.in);
	static class flag{
		boolean[] up;
		boolean repeated=false;
		flag(int n){
			up = new boolean[n+1];
			Arrays.fill(up, false);
		}

	}
	static String getTest() {
		int N = CONSOLE.nextInt();
		flag[] col = new flag[N];
		flag[] row = new flag[N];
		for (int i=0;i<N;i++) {
			col[i]= new flag(N);
			row[i]= new flag(N);
		}
		int trace=0;
		int row_count=0, col_count=0;
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				int data=CONSOLE.nextInt();
				if (i==j) trace+=data;
				if (row[i].up[data]) {
					row[i].repeated=true;
					if (row[i].repeated)
						row_count++;
				}else row[i].up[data]=true;
				if (col[j].up[data]) {
					col[j].repeated=true;
					if (col[j].repeated)
						col_count++;
				}else col[j].up[data]=true;
			}
		}
		return (""+trace+' '+row_count+' '+col_count);
	}
	static void printResult(String[] result) {
		int index=1;
		for (String s:result) {
			System.out.printf("Case #%d: %s\n", index, s);
			index++;
		}
	}
	public static void main(String[]args) {
		int test = CONSOLE.nextInt();
		String[] result = new String[test];
		for (int i=0;i<test;i++) {
			result[i] = getTest();
		}
		printResult(result);
	}
}
