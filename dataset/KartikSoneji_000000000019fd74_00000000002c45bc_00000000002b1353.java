import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n;
		for(int t = 0, cases = sc.nextInt(); t < cases; t++){
			n = sc.nextInt();
			
			System.out.println("Case #" + (t + 1) + ":");
			
			if(n == 1){
				output(1, 1);
				continue;
			}
			
			int rows = (int) (Math.log(n)/Math.log(2));
			n -= (1 << rows) - 1;
			
			int p = rows % 2;
			for(int i = 0; i < rows; i++, p = 1 - p)
				for(int j = 0; j <= i; j++)
					output((i + 1), (((p == 0)?j:(i - j)) + 1));
			if(n == 0)
				continue;
			
			rows++;
			output(rows, 1);
			n--;
			
			while(n > rows + 1){
				n -= rows - 1;
				output(rows, 2);
				rows++;
			}
			rows++;
			
			for(int i = 0; i < n; i++)
				output((rows + i), 1);
		}
		
		sc.close();
	}
	
	private static void output(int i, int j){
		System.out.println(i + " " + j);
	}
}