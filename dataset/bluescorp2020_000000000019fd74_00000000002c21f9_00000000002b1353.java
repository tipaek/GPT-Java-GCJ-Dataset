import java.util.Scanner;

public class Solution {

	private static void solve(Scanner scanner){
		int n=scanner.nextInt();
		if(n<=500){
			for(int i=1;i<=n;i++){
				System.out.println(i+" 1");
			}
		}
		else{
			System.out.print("1 1\n2 1\n3 2\n3 1\n");
			for(int i=1;i<=496;i++){
				System.out.println(i+" 1");
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t=scanner.nextInt();
		for(int k=1;k<=t;k++){
			System.out.println("Case #"+k+": ");
			solve(scanner);
		}
		scanner.close();
	}
}
