import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		for(int i =1 ; i <= t ; i++) {
			long n = 0;
			long l = 0;
			long r = 0;
			long L = scan.nextLong();
			long R = scan.nextLong();
			int j = 1;
			while((j<=L)||(j<=R)) {
				if(L>=R) {
					L-=j;
					j++;
				} else {
					R-=j;
					j++;
				}
			}
			n = j - 1;
			l = L;
			r = R;
			System.out.print("Case #" + i + ": ");
			System.out.println(n + " " + l + " " + r);
		}
	}

}
