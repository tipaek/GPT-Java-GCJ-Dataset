import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int num=input.nextInt();
		input.nextLine();
		for(int i=1; i<=num; i++) {
			int N=input.nextInt();
			System.out.println("Case #"+i+":");
			System.out.println("1 1");
			N--;
			int r=2,k=1;
			while(N>0) {
				System.out.println(r+" "+k);
				if(r==k) {
					N-=1;
				}else {
					N-=k;
				}
				if(N>=k+1) {
					r++;
					k++;
				}else {
					if(r!=k) {
						k++;
					}else {
						k--;
						r--;
					}
				}
			}
		}
		
		
		input.close();
	}

}
