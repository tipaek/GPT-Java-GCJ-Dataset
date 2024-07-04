import java.util.Scanner;
class Solution {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			
			int x = sc.nextInt();
			int y=sc.nextInt();
			
			int n=x;
			
			int l=x*(y-1)-1;
			
			System.out.print("Case #");
			System.out.print((i + 1) + ": ");
			System.out.println((x-1)*(y-1));
			while(n!=1)
			{
				for(int j=1;j<=y-1;j++)
				{
					System.out.println(n+" "+l);
					l--;
				}
				n--;
			}
		}
	}
}