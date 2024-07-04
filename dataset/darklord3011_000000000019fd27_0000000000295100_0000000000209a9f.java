import java.util.*;

public class Solution{
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		scan.nextLine();
		for (int l = 0; l < t; l++) {
			String s = scan.nextLine();
			String ans = "";
			String ss[] = s.split("");
			int lcount = 0;
			int rcount = 0;
			for (int i = 0; i < ss.length ; i++) {

				int a = Integer.parseInt(ss[i]);
				if (a - lcount > 0) {
					for (int k = 0; k < (a - lcount); k++) {
						ans = ans + "(";
					}
					lcount = a;
					ans = ans + ss[i];
					
				} else {
					for (int k = 0; k < (lcount - a); k++) {
						ans = ans + ")";
					}
					lcount = a;
					ans = ans + ss[i];
				}

			}
			for(int i=0; i < lcount ;i++) {
				ans = ans + ")";
			}
			System.out.println(ans);
		}

	}


}