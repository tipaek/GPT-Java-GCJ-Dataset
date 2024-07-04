import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			final int T = in.nextInt(), A = in.nextInt(), B = in.nextInt();
			for (int t = T; t > 0; t--) {
			    int k=0;
				bela: for (int i = -5; i < 6; i++) {
				    for (int j = -5; j < 6; j++) {
    					System.out.println(i + " " + j);
    					System.out.flush();
    					if (in.next().equals("CENTER")) {
    					    k=1;
    					    break bela;
    					}
				    }
				    if(k==0) {
				        System.out.println("xxxx");
				        in.next();
				        return;
				    }
				}
			}
		}
	}

}
