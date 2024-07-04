import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			int N=scanner.nextInt();
			System.out.println("Case #"+(t+1)+":");
			if(N!=501)for(int i=1;i<N;i++) {
				System.out.println(i+" 1");
			}
			else {
				System.out.println("1 1");
				System.out.println("2 1");
				System.out.println("3 2");
				System.out.println("3 1");
				for(int i=4;i<500;i++) {
					System.out.println(i+" 1");
				}
			}
			
			
		}
	}

}
