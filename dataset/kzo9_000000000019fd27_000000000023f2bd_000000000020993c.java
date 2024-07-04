import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		new Solver().run();
	}

}

class Solver{
	Scanner sc;

	public void run() {
		sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		
		for(int i=0; i<x; i++) {
			int n = sc.nextInt();
			int[] [] square = new int[n][n];
			
			int trace = 0;
			int r = 0,c = 0;
			
			for(int k=0; k<n; k++) {
				Set<Integer> linkedHashSet = new LinkedHashSet<Integer>();
				
				for(int j=0; j<n; j++) {
					square[k][j] = sc.nextInt();
					
					if(k==j) trace += square[k][j];
					
					linkedHashSet.add(square[k][j]);
				}
				
				if(n != linkedHashSet.size()) r++;
			}
			
			for(int k=0;k<n;k++) {
				Set<Integer> linkSet = new LinkedHashSet<Integer>();
				
				for(int j=0;j<n; j++) {
					linkSet.add(square[j][k]);
				}
				if(n != linkSet.size()) c++;
			}
			
			System.out.println("Case #"+ (i+1) + ": " + trace + " " + r + " " + c);
		}
		
	}
	
}
