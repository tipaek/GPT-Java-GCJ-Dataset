import java.util.*;
public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		for(int dabbers = 0; dabbers < p; dabbers++) {
			int n = sc.nextInt();
			System.out.println("Case #"+(dabbers+1)+":");
			if(n<=500) {
				for(int i = 1; i <= n; i++) {
					System.out.println(i+" "+1);
				}
			}else {
				System.out.println("1 1\n2 1\n3 2\n3 1");
				for(int i = 4; i <= n; i++) {
					System.out.println(i+" "+1);
				}
			}
		}
	}

}
