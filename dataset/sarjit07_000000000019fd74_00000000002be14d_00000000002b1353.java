import java.util.Scanner;
public class Solution {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		if(in.hasNextInt()){
		    int t = in.nextInt();
		    int x = 0;
			while(t--!=0) {
				if(in.hasNextInt()){
					int n = in.nextInt();
					x= x+1;
					System.out.println("Case #"+x+":");
					if (n >= 1 & n <= 500) {
						for(int i=1;i<=n;i++) {
							System.out.println(i + " " + 1);							
						}
					}
					else if (n == 501) {
						for(int i=1;i<=n;i++) {
							if (i == 2) {
								System.out.println(i + " " + i);	
							}
							System.out.println(i + " " + 1);						
						}
					}
				}
			}
		}
	}
}
