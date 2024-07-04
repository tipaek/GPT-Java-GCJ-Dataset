import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		int T=scanner.nextInt();
		for(int t=0;t<T;t++) {
			int N=scanner.nextInt();
			System.out.println("Case #"+(t+1)+":");
			System.out.println("1 1");
			if(N>1)System.out.println("2 1");
			if(N==501)System.out.println("3 2");
			else if(N>2)System.out.println("3 1");
			for(int i=4;i<=Math.min(N, 500);i++) {
				System.out.println(i+" 1");
			}
		}
	}

}
