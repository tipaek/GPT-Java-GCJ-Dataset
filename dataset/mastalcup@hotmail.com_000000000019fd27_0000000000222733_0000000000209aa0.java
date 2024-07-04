import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args){
		try(Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)))){
			int t = Integer.parseInt(in.nextLine());
		    for (int i = 1; i <= t; ++i) {
		    	String[] line = in.nextLine().split(" ");
				int n = Integer.parseInt(line[0]);
				int targetDiagonalSum = Integer.parseInt(line[1]);
				
				System.out.println("Case #" + i + ": " + findAnswer(targetDiagonalSum, n));
		    }
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private static String findAnswer(int targetDiagonalSum, int n){
		int nSquared = (int) Math.pow((double)n, 2) ;
		if(targetDiagonalSum > nSquared
				|| targetDiagonalSum < n
				|| targetDiagonalSum == (n + 1)
				|| targetDiagonalSum == (nSquared - 1) ){
			return "IMPOSSIBLE";
		}
		else if(n == 2 || n == 3){
			if(targetDiagonalSum % n != 0){
				return "IMPOSSIBLE";
			}
		}
		else if(n > 3){
			if(targetDiagonalSum == (n + 1)){
				return "IMPOSSIBLE";
			}
		}
		
		return "POSSIBLE";
	}
}
