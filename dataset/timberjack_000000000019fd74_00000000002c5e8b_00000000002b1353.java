import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			int N=scanner.nextInt();
			System.out.println("Case #"+(t+1)+":");
			if(N<=4)for(int i=1;i<=N;i++) {
				System.out.println(i+" 1");
			}
			else {
				System.out.println("1 1");
				if(N==1000) {
					System.out.println("2 1");
					System.out.println("3 1");
					System.out.println("4 1");
					System.out.println("5 2");
					for(int i=5;i<499;i++) {
						System.out.println(i+" 1");
					}
					System.out.println((N/2-1)+" 2");
					
				}
				else if(N==999) {
					System.out.println("2 1");
					System.out.println("3 1");
					System.out.println("4 2");
					for(int i=4;i<N/2;i++) {
						System.out.println(i+" 1");
					}
					System.out.println("499 2");
					
				}
				else if(N==998) {
					System.out.println("2 1");
					System.out.println("3 1");
					System.out.println("4 1");
					System.out.println("5 2");
					for(int i=5;i<498;i++) {
						System.out.println(i+" 1");
					}
					System.out.println((N/2-1)+" 2");
					
				}
				else if(N==997) {
					System.out.println("2 1");
					System.out.println("3 1");
					System.out.println("4 2");
					for(int i=4;i<N/2;i++) {
						System.out.println(i+" 1");
					}
					System.out.println("498 2");
					
				}
				else if(N%2==0) {
					System.out.println("2 2");
					for(int i=2;i<=N/2;i++) {
						System.out.println(i+" 1");
					}
					System.out.println(N/2+" 2");
				}
				else {
					for(int i=2;i<=N/2+1;i++) {
						System.out.println(i+" 1");
					}
					System.out.println((N/2+1)+" 2");
				}
			}
			
			
		}
	}

}
