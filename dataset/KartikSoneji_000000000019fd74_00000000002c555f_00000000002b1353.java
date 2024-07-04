import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n;
		for(int t = 0, cases = sc.nextInt(); t < cases; t++){
			n = sc.nextInt();
			
			System.out.println("Case #" + (t + 1) + ":");
			
			for(int i = 0; i < n; i++){
				output(i + 1, 1);
				if(n > 2 && i == 1){
					output(i + 1, 2);
					n -= 2;
				}
			}
		}
		
		sc.close();
	}
	
	private static void output(int i, int j){
		System.out.println(i + " " + j);
	}
}